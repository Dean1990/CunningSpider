package com.deanlib.cunningspider.rule;

import com.deanlib.cunningspider.description.*;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Executor {

    static Logger l;

    public Executor(){
        l = Logger.getLogger("CS Executor");
    }

    public PageResult excute(Page page, int timeout) throws IOException {
        return excute(page, timeout, null, null);
    }

    public PageResult excute(Page page, int timeout, Map<String, String> linkHeaders, Map<String, String> coverHeaders) throws IOException {
        return excute(page, timeout, linkHeaders, coverHeaders, true);
    }

    private PageResult excute(Page page, int timeout, Map<String, String> linkHeaders, Map<String, String> coverHeaders
            , boolean isTop) throws IOException {
        if (page == null)
            throw new NullPointerException("Page is null");

//        System.out.println("Excute url:" + page.getUrl() + "  timeout:" + timeout);
//        Document doc = Jsoup.parse(new URL(page.getUrl()), timeout);
        //解决重定向问题
        String url = page.getUrl();
        l.info("Page url:"+url);
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("accept", "*/*");
        conn.setRequestProperty("connection", "Keep-Alive");
        // 必须设置false，否则会自动redirect到Location的地址
        conn.setInstanceFollowRedirects(false);
        //获取Location地址
        conn.connect();
        int code = conn.getResponseCode();
        if (code == 302){
            url = conn.getHeaderField("Location");
            l.info("Redirect page url:"+url);
        }

        l.info("Jsoup connect url:"+url);
        Connection connect = Jsoup.connect(url);
        if (linkHeaders != null) {
            connect.headers(linkHeaders);
        }
        connect.timeout(timeout);
        Document doc = connect.get();

        Action action = page.getAction();
        if (action == null)
            throw new NullPointerException("Page Action is null");
        if (action.getKey() == null)
            throw new NullPointerException("Page Action key is null");
        if (action.getKey().getKeyLink() != null)
            find(doc, action.getKey().getKeyLink(), page, Result.VAR_LINK);
        if (page.getNext() != null) {
            if (page.getNext().getUrl() == null && page.getAction().getResults() != null &&
                    page.getAction().getResults().size() > 0)
                page.getNext().setUrl(page.getAction().getResults().get(0).getLink().getUrl());//这种情况只取第一个（多层page时）
            excute(page.getNext(), timeout, linkHeaders, coverHeaders, false);
        } else {
            if (action.getKey().getKeyName() != null)
                find(doc, action.getKey().getKeyName(), page, Result.VAR_NAME);
            if (action.getKey().getKeyCover() != null)
                find(doc, action.getKey().getKeyCover(), page, Result.VAR_COVER);
        }

        if (isTop) {//递归回到最顶层
            List<Result> results = page.getLastResults();

            if (results != null) {
                //对Result.link cover 去重
                //linkcover
                List<String> keyTable = new ArrayList<>();
                for (int i = results.size()-1;i>=0;i--){
                    if (results.get(i)!=null) {
                        String key = "";
                        if (results.get(i).getLink()!=null)
                            key += results.get(i).getLink().getUrl();
                        if (results.get(i).getCover()!=null)
                            key += results.get(i).getCover().getUrl();
                        if (!"".equals(key)) {
                            if (keyTable.contains(key)) {
                                results.remove(i);
                            } else {
                                keyTable.add(key);
                            }
                        }else {
                            //如果link 和 cover 的链接都没有
                            //可能有这种需求，所以不能直接删除
                        }
                    }
                }
                //加头信息 补全Url
                for (Result result : results) {
                    if (linkHeaders != null) {
                        if (result.getLink() != null) {
                            result.getLink().setHeaders(linkHeaders);
                            result.getLink().setUrl(repairUrl(result.getLink().getUrl(),result.getFindPageUrl()));
                        }
                    }
                    if (coverHeaders != null) {
                        if (result.getCover() != null) {
                            result.getCover().setHeaders(coverHeaders);
                            result.getCover().setUrl(repairUrl(result.getCover().getUrl(),result.getFindPageUrl()));
                        }
                    }
                    if (result.getLink()!=null && result.getLink().getUrl()!=null)
                        result.getLink().setUrl(repairUrl(result.getLink().getUrl(),result.getFindPageUrl()));
                    if (result.getCover()!=null && result.getCover().getUrl()!=null)
                        result.getCover().setUrl(repairUrl(result.getCover().getUrl(),result.getFindPageUrl()));
                }
                PageResult pageResult = new PageResult();
                pageResult.setResults(results);

                if (page.getNextPageLink() != null) {
                    String nextPageLink = repairUrl(findRecursion(doc, page.getNextPageLink()),page.getUrl());
                    if (nextPageLink != null && !"".equals(nextPageLink)) {
                        Url nplUrl = new Url(nextPageLink);
                        if (linkHeaders != null)
                            nplUrl.setHeaders(linkHeaders);
                        pageResult.setNextPageLink(nplUrl);
                    }
                }
                return pageResult;
            }
            return null;
        }

        return null;
    }

    /**
     * 补全链接
     * 根据Html的规则 /开头的前面只接域名 ，非/开头的前面接当前页上一级目录的url
     * 特殊情况 //开头的 url 为完整 url，//的意思是自适应 http或https协议，故，这种情况不需要做补全
     * @param url 当前页面中找到的url 及要修复的url
     * @param pageUrl 当前页面的url
     * @return
     */
    public static String repairUrl(String url,String pageUrl){
        if (url!=null && !"".equals(url)){
            if (!isHttpURL(url) && pageUrl!=null && !"".equals(pageUrl)) {
                pageUrl = pageUrl.toLowerCase();
                if (url.startsWith("//")) {
                    //不需要补全
                    if (pageUrl.startsWith("https:")){
                        url = "https:" + url;
                    }else {
                        url = "http:" + url;
                    }
                }else if (url.startsWith("/")) {
                    Pattern pattern = Pattern.compile("https?:\\/\\/[\\w\\.:-]+");
                    Matcher matcher = pattern.matcher(pageUrl);
                    if (matcher.find()) {
                        url = matcher.group() + url;
                    }
                } else {
                    int index = pageUrl.lastIndexOf("/");
                    if (index >= 0) {
                        url = pageUrl.substring(0, index) + "/" + url;
                    }
                }
            }
            return url;
        }
        return "";
    }

    /**
     * 验证是否是完整的网址
     *
     * @param url
     * @return
     */
    public static boolean isHttpURL(String url) {

        if (url==null || "".equals(url))
            return false;

        String str = "^(http|ftp|https):\\/\\/[\\S]+$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(url);

        return m.matches();

    }


    private void find(Element element, KeyElement keyElement, Page page, String var) {

        //在整个 keyElement 链中最多只能有一个 isList;
        if (keyElement.isList()) {
            //当前去查找的是列表，然后dispose去处理列表下边的事（后边的keyElement只会按唯一处理）
            //延伸 keyelement 链被这里截获 dispose中使用 findRecursion 继续延伸
            dispose(findElements(element, keyElement), keyElement, page, var);
        } else {
            //不是列表 是查找的一个元素
            //一个元素时不能表示前面的查找都不是list,才能进到这个判断，也就是没有action 的 list 结果生成
            //这里可以一直递归，直到 keyElement.isList() 为真，去走上面的处理方法
            //或者整个keyElement的链中都没有规定 islist = true ，就会走下边的 else 部分
            Element e = findElement(element, keyElement);
            if (keyElement.getKeyElement() != null) {
                //在没有碰到 isList时，一直往里延伸 keyelement 链
                find(e, keyElement.getKeyElement(), page, var);
            } else {
                //如果没有next keyelement
                //找到后就是结果
                createActionResults(page, 1);
                String str = getResult(e, keyElement.getRelationship(), keyElement.getKeyElementResult());
                updateActionResults(page, 0, var, str);
            }
        }
    }

    private Element findElement(Element element, KeyElement keyElement) {
//        System.out.print("findElement -> ");
        if (element == null) {
            throw new NullPointerException("Element is null");
        }
        if (keyElement == null) {
            throw new NullPointerException("KeyElement is null");
        }
        if (keyElement.getKeyElementFind() == null) {
            throw new NullPointerException("KeyElementFind is null");
        }
        Element e = null;
        switch (keyElement.getKeyElementFind().getFindType()) {
            case KeyElementFind.FIND_TYPE_ID:
//                    System.out.println("id=" + keyElement.getValue());
                e = disposeRelationship(element.getElementById(keyElement.getKeyElementFind().getValue()),keyElement.getRelationship());
                break;
            case KeyElementFind.FIND_TYPE_TAG:
//                    System.out.println("tag=" + keyElement.getValue());
                e = disposeFindElement(element.getElementsByTag(keyElement.getKeyElementFind().getValue()), keyElement);
                break;
            case KeyElementFind.FIND_TYPE_CLASS:
//                    System.out.println("class=" + keyElement.getValue());
                e = disposeFindElement(element.getElementsByClass(keyElement.getKeyElementFind().getValue()), keyElement);
                break;
            case KeyElementFind.FIND_TYPE_INDEX:
//                    System.out.println("index=" + keyElement.getValue());
                int index = Integer.valueOf(keyElement.getKeyElementFind().getValue());
                if (index < 0)
                    index = element.childNodeSize() + index;
                e = disposeFindElement(element.getElementsByIndexEquals(index), keyElement);
                break;
            case KeyElementFind.FIND_TYPE_ATTRIBUTE:
                if (keyElement.getKeyElementFind().getFindAttrKey() != null) {
//                        System.out.println("attr " + keyElement.getFindAttrKey() + "=" + keyElement.getValue());
                    e = disposeFindElement(element.getElementsByAttributeValueMatching(keyElement.getKeyElementFind().getFindAttrKey()
                            , keyElement.getKeyElementFind().getValue()), keyElement);
                } else {
                    throw new NullPointerException("attr key is null");
                }
                break;
            case KeyElementFind.FIND_TYPE_TEXT:
//                    System.out.println("text=" + keyElement.getValue());
                e = disposeFindElement(element.getElementsMatchingOwnText(keyElement.getKeyElementFind().getValue()), keyElement);
                break;
        }


//        System.out.println("find1 result : " + result);
        return e;
    }

    private Elements findElements(Element element, KeyElement keyElement) {
        //        System.out.print("findElement -> ");
        if (element == null) {
            throw new NullPointerException("Element is null");
        }
        if (keyElement == null) {
            throw new NullPointerException("KeyElement is null");
        }
        if (keyElement.getKeyElementFind() == null) {
            throw new NullPointerException("KeyElementFind is null");
        }

        Elements es = null;
        switch (keyElement.getKeyElementFind().getFindType()) {
            case KeyElementFind.FIND_TYPE_TAG:
//                    System.out.println("tag=" + keyElement.getValue());
                es = disposeFindElements(element.getElementsByTag(keyElement.getKeyElementFind().getValue()), keyElement);
                break;
            case KeyElementFind.FIND_TYPE_CLASS:
//                    System.out.println("class=" + keyElement.getValue());
                es = disposeFindElements(element.getElementsByClass(keyElement.getKeyElementFind().getValue()), keyElement);
                break;
            case KeyElementFind.FIND_TYPE_INDEX:
                int index = Integer.valueOf(keyElement.getKeyElementFind().getValue());
                if (index < 0)
                    index = element.childNodeSize() + index;
                es = disposeFindElements(element.getElementsByIndexEquals(index), keyElement);
                break;
            case KeyElementFind.FIND_TYPE_ATTRIBUTE:
                if (keyElement.getKeyElementFind().getFindAttrKey() != null) {
//                        System.out.println("attr " + keyElement.getFindAttrKey() + "=" + keyElement.getValue());
                    es = disposeFindElements(element.getElementsByAttributeValueMatching(keyElement.getKeyElementFind().getFindAttrKey()
                            , keyElement.getKeyElementFind().getValue()), keyElement);
                } else {
                    throw new NullPointerException("attr key is null");
                }
                break;
            case KeyElementFind.FIND_TYPE_TEXT:
//                    System.out.println("text=" + keyElement.getValue());
                es = disposeFindElements(element.getElementsMatchingOwnText(keyElement.getKeyElementFind().getValue()), keyElement);
                break;
        }

//        System.out.println("find1 result : " + result);
        return es;
    }

    /**
     * 处理 Relationship 相关
     * @param element
     * @param relationship
     * @return
     */
    private Element disposeRelationship(Element element,Relationship relationship){
        if (relationship != null) {
            switch (relationship.getRelation()) {
                case Relationship.RELATION_SENIOR:
                    element = element.parent();
                    break;
                case Relationship.RELATION_JUNIOR:
                    int index = relationship.getIndex();
                    if (index < 0)
                        index = element.childNodeSize() + index;
                    if (index < element.childNodeSize() && index >= 0)
                        element = element.child(relationship.getIndex());
                    break;
            }
        }
        return element;
    }

    private Element disposeFindElement(Elements elements, KeyElement keyElement) {
        if (elements != null) {
            if (keyElement.getStart() < elements.size()) {
                int index = keyElement.getStart();
                if (index < 0) {
                    index = elements.size() + index;
                }
                if (index < elements.size() && index >= 0)
                    return disposeRelationship(elements.get(index),keyElement.getRelationship());
                else
                    return null;
            }
        }
        return null;
    }

    private Elements disposeFindElements(Elements elements, KeyElement keyElement) {
        if (elements != null) {
            int index = keyElement.getStart();
            if (index < 0) {
                index = elements.size() + index;
            }
            int endIndex = index + keyElement.getLength();
            if (index < elements.size() && index >= 0) {
                Elements es = new Elements();
                List<Element> list = elements.subList(index, (endIndex > elements.size() || endIndex <= 0) ? elements.size() : endIndex);
                if (keyElement.getRelationship()!=null){
                    for (Element e : list){
                        es.add(disposeRelationship(e,keyElement.getRelationship()));
                    }
                }else {
                    es.addAll(list);
                }

                return es;
            } else {
                return null;
            }
        }
        return null;
    }

    /**
     * 返回结果的单一查找 递归
     *
     * @param element
     * @param keyElement
     * @return
     */
    private String findRecursion(Element element, KeyElement keyElement) {
        if (element == null) {
            throw new NullPointerException("Element is null");
        }
        if (keyElement == null) {
            throw new NullPointerException("KeyElement is null");
        }

        Element e = findElement(element, keyElement);
        if (e != null) {
            if (keyElement.getKeyElement() != null) {
                return findRecursion(e, keyElement.getKeyElement());
            } else {
                return getResult(e, keyElement.getRelationship(), keyElement.getKeyElementResult());
            }
        }
        return null;
    }

    /**
     * 生成 Action 内的results ，如果没有的话
     *
     * @param page
     * @param length
     */
    private void createActionResults(Page page, int length) {
        if (page!=null && page.getAction()!= null && page.getAction().getResults() == null) {
            List<Result> results = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                results.add(new Result());
            }
            page.getAction().setResults(results);
        }
    }

    /**
     * 更新 Action 内的results
     *
     * @param page
     * @param position results 的下标
     * @param var      results Result对应的变量
     * @param result   查找的结果
     * @see Result#VAR_NAME
     * @see Result#VAR_LINK
     * @see Result#VAR_COVER
     */
    private void updateActionResults(Page page, int position, String var, String result) {
        if (page != null && page.getAction() != null && page.getAction().getResults() != null
                && page.getAction().getResults().size() > position) {
            switch (var) {
                case Result.VAR_NAME:
                    page.getAction().getResults().get(position).setName(result);
                    break;
                case Result.VAR_LINK:
                    page.getAction().getResults().get(position).setLink(new Url(result));
                    page.getAction().getResults().get(position).setFindPageUrl(page.getUrl());
                    break;
                case Result.VAR_COVER:
                    page.getAction().getResults().get(position).setCover(new Url(result));
                    page.getAction().getResults().get(position).setFindPageUrl(page.getUrl());
                    break;
            }
        }
    }

    /**
     * 只处理一个
     * 会生成action results 谨慎使用
     *
     * @param elements
     * @param keyElement
     * @param page
     * @param var
     */
    private void dispose(Elements elements, KeyElement keyElement, Page page, String var) {
        if (elements != null) {
            createActionResults(page, elements.size());
            for (int i = 0; i < elements.size(); i++) {
                String str = null;
                if (keyElement.getKeyElement() != null) {
                    str = findRecursion(elements.get(i), keyElement.getKeyElement());
                } else {
                    str = getResult(elements.get(i), keyElement.getRelationship(), keyElement.getKeyElementResult());
                }
                updateActionResults(page, i, var, str);
            }

        }

    }

    private String getResult(Element element, Relationship relationship, KeyElementResult keyElementResult) {
        if (keyElementResult == null){
            throw new NullPointerException("KeyElementResult is null");
        }
        String result = null;
//        if (relationship != null) {
//            switch (relationship.getRelation()) {
//                case Relationship.RELATION_SENIOR:
//                    element = element.parent();
//                    break;
//                case Relationship.RELATION_JUNIOR:
//                    int index = relationship.getIndex();
//                    if (index < 0)
//                        index = element.childNodeSize() + index;
//                    if (index < element.childNodeSize() && index >= 0)
//                        element = element.child(relationship.getIndex());
//                    break;
//            }
//            result = getResult(element, relationship.getRelationship(), keyElementResult);
//        } else {
            switch (keyElementResult.getResultType()) {
                case KeyElementResult.RESULT_TYPE_HTML:
                    result = element.html();
                    break;
                case KeyElementResult.RESULT_TYPE_TEXT:
                    result = element.text();
                    break;
                case KeyElementResult.RESULT_TYPE_VAL:
                    result = element.val();
                    break;
                case KeyElementResult.RESULT_TYPE_ATTR:
                    if (keyElementResult.getResultAttrKey() != null)
                        result = element.attr(keyElementResult.getResultAttrKey());
                    break;
//            }
        }
//        System.out.println("find result : " + result);
        return result;


    }

}
