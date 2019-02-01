package com.deanlib.cunningspider.rule;

import com.deanlib.cunningspider.description.*;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class Executor {

    public PageResult excute(Page page, int timeout)throws IOException {
        return excute(page,timeout,null,null);
    }

    public PageResult excute(Page page, int timeout,Map<String,String> linkHeaders,Map<String,String> coverHeaders)throws IOException {
        return excute(page,timeout,linkHeaders,coverHeaders,true);
    }

    private PageResult excute(Page page, int timeout ,Map<String,String> linkHeaders,Map<String,String> coverHeaders
            ,boolean isTop) throws IOException {
        if (page == null)
            throw new NullPointerException("Page is null");

//        System.out.println("Excute url:" + page.getUrl() + "  timeout:" + timeout);
//        Document doc = Jsoup.parse(new URL(page.getUrl()), timeout);
        Connection connect = Jsoup.connect(page.getUrl());
        if (linkHeaders!=null){
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
            find(doc, action.getKey().getKeyLink(), action,Result.VAR_LINK);
        if (page.getNext() != null) {
            if (page.getNext().getUrl() == null && page.getAction().getResults() != null &&
                    page.getAction().getResults().size() > 0)
                page.getNext().setUrl(page.getAction().getResults().get(0).getLink().getUrl());//这种情况只取第一个（多层page时）
            excute(page.getNext(), timeout,linkHeaders,coverHeaders,false);
        } else {
            if (action.getKey().getKeyName() != null)
                find(doc, action.getKey().getKeyName(), action,Result.VAR_NAME);
            if (action.getKey().getKeyCover() != null)
                find(doc, action.getKey().getKeyCover(),action, Result.VAR_COVER);
        }

        if (isTop){
            List<Result> results = page.getLastResults();
            if (results!=null) {

                for (Result result : results) {
                    if (linkHeaders != null) {
                        if (result.getLink() != null) {
                            result.getLink().setHeaders(linkHeaders);
                        }
                    }
                    if (coverHeaders != null) {
                        if (result.getCover() != null) {
                            result.getCover().setHeaders(coverHeaders);
                        }
                    }
                }
                PageResult pageResult = new PageResult();
                pageResult.setResults(results);

                if (page.getNextPageLink()!=null) {
                    String nextPageLink = findRecursion(doc,page.getNextPageLink());
                    if (nextPageLink != null && !"".equals(nextPageLink)) {
                        Url url = new Url(nextPageLink);
                        if (linkHeaders != null)
                            url.setHeaders(linkHeaders);
                        pageResult.setNextPageLink(url);
                    }
                }
                return pageResult;
            }
            return null;
        }

        return null;
    }


    private void find(Element element, KeyElement keyElement, Action action, String var) {

        //在整个 keyElement 链中最多只能有一个 isList;
        if (keyElement.isList()){
            //当前去查找的是列表，然后dispose去处理列表下边的事（后边的keyElement只会按唯一处理）
            //延伸 keyelement 链被这里截获 dispose中使用 findRecursion 继续延伸
            dispose(findElements(element,keyElement),keyElement,action,var);
        }else {
            //不是列表 是查找的一个元素
            //一个元素时不能表示前面的查找都不是list,才能进到这个判断，也就是没有action 的 list 结果生成
            //这里可以一直递归，直到 keyElement.isList() 为真，去走上面的处理方法
            //或者整个keyElement的链中都没有规定 islist = true ，就会走下边的 else 部分
            Element e = findElement(element,keyElement);
            if (keyElement.getKeyElement() != null) {
                //在没有碰到 isList时，一直往里延伸 keyelement 链
                find(e,keyElement.getKeyElement(),action,var);
            } else {
                //如果没有next keyelement
                //找到后就是结果
                createActionResults(action,1);
                String str = getResult(e,keyElement.getResultType(),keyElement.getResultAttrKey());
                updateActionResults(action,0,var,str);
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
        Element e = null;
            switch (keyElement.getFindType()) {
                case KeyElement.FIND_TYPE_ID:
//                    System.out.println("id=" + keyElement.getValue());
                    e = element.getElementById(keyElement.getValue());
                    break;
                case KeyElement.FIND_TYPE_TAG:
//                    System.out.println("tag=" + keyElement.getValue());
                    e = disposeFindElement(element.getElementsByTag(keyElement.getValue()),keyElement);
                    break;
                case KeyElement.FIND_TYPE_CLASS:
//                    System.out.println("class=" + keyElement.getValue());
                    e = disposeFindElement(element.getElementsByClass(keyElement.getValue()),keyElement);
                    break;
                case KeyElement.FIND_TYPE_INDEX:
//                    System.out.println("index=" + keyElement.getValue());
                    e = disposeFindElement(element.getElementsByIndexEquals(Integer.valueOf(keyElement.getValue())),keyElement);
                    break;
                case KeyElement.FIND_TYPE_ATTRIBUTE:
                    if (keyElement.getFindAttrKey() != null) {
//                        System.out.println("attr " + keyElement.getFindAttrKey() + "=" + keyElement.getValue());
                        e = disposeFindElement(element.getElementsByAttributeValueMatching(keyElement.getFindAttrKey()
                                , keyElement.getValue()),keyElement);
                    } else {
                        throw new NullPointerException("attr key is null");
                    }
                    break;
                case KeyElement.FIND_TYPE_TEXT:
//                    System.out.println("text=" + keyElement.getValue());
                    e = disposeFindElement(element.getElementsMatchingOwnText(keyElement.getValue()),keyElement);
                    break;
            }


//        System.out.println("find1 result : " + result);
        return e;
    }

    private Elements findElements(Element element, KeyElement keyElement){
        //        System.out.print("findElement -> ");
        Elements es = null;
        if (keyElement != null) {
            switch (keyElement.getFindType()) {
//                case KeyElement.FIND_TYPE_ID:
////                    System.out.println("id=" + keyElement.getValue());
//                    es = element.getElementById(keyElement.getValue());
//                    break;
                case KeyElement.FIND_TYPE_TAG:
//                    System.out.println("tag=" + keyElement.getValue());
                    es = disposeFindElements(element.getElementsByTag(keyElement.getValue()),keyElement);
                    break;
                case KeyElement.FIND_TYPE_CLASS:
//                    System.out.println("class=" + keyElement.getValue());
                    es = disposeFindElements(element.getElementsByClass(keyElement.getValue()),keyElement);
                    break;
                case KeyElement.FIND_TYPE_INDEX:
//                    System.out.println("index=" + keyElement.getValue());
                    es = disposeFindElements(element.getElementsByIndexEquals(Integer.valueOf(keyElement.getValue())),keyElement);
                    break;
                case KeyElement.FIND_TYPE_ATTRIBUTE:
                    if (keyElement.getFindAttrKey() != null) {
//                        System.out.println("attr " + keyElement.getFindAttrKey() + "=" + keyElement.getValue());
                        es = disposeFindElements(element.getElementsByAttributeValueMatching(keyElement.getFindAttrKey()
                                , keyElement.getValue()),keyElement);
                    } else {
                        throw new NullPointerException("attr key is null");
                    }
                    break;
                case KeyElement.FIND_TYPE_TEXT:
//                    System.out.println("text=" + keyElement.getValue());
                    es = disposeFindElements(element.getElementsMatchingOwnText(keyElement.getValue()),keyElement);
                    break;
            }

        } else {
            throw new NullPointerException("KeyElement is null");
        }
//        System.out.println("find1 result : " + result);
        return es;
    }

    private Element disposeFindElement(Elements elements,KeyElement keyElement){
        if (elements!=null){
            if (keyElement.getStart()<elements.size()){
                return elements.get(keyElement.getStart());
            }
        }
        return null;
    }

    private Elements disposeFindElements(Elements elements,KeyElement keyElement){
        if (elements!=null){
            if (keyElement.getStart()<elements.size()){
                return new Elements(elements.subList(keyElement.getStart()
                        ,keyElement.getEnd()>elements.size()?elements.size():keyElement.getEnd()));
            }
        }
        return null;
    }

    /**
     * 返回结果的单一查找 递归
     * @param element
     * @param keyElement
     * @return
     */
    private String findRecursion(Element element, KeyElement keyElement) {
        if (element == null) {
            throw  new NullPointerException("Element is null");
        }
        if (keyElement == null) {
            throw  new NullPointerException("KeyElement is null");
        }

        Element e = findElement(element,keyElement);
        if (keyElement.getKeyElement()!=null){
            return findRecursion(e,keyElement.getKeyElement());
        }else {
            return getResult(element, keyElement.getResultType(),keyElement.getResultAttrKey());
        }
    }

    /**
     * 生成 Action 内的results ，如果没有的话
     * @param action
     * @param length
     */
    private void createActionResults(Action action,int length){
        if (action.getResults() == null) {
            List<Result> results = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                results.add(new Result());
            }
            action.setResults(results);
        }
    }

    /**
     * 更新 Action 内的results
     * @param action
     * @param position results 的下标
     * @param var results Result对应的变量
     * @see Result#VAR_NAME
     * @see Result#VAR_LINK
     * @see Result#VAR_COVER
     * @param result 查找的结果
     */
    private void updateActionResults(Action action,int position,String var,String result){
        if (action!=null && action.getResults()!=null && action.getResults().size()>position) {
            switch (var) {
                case Result.VAR_NAME:
                    action.getResults().get(position).setName(result);
                    break;
                case Result.VAR_LINK:
                    action.getResults().get(position).setLink(new Url(result));
                    break;
                case Result.VAR_COVER:
                    action.getResults().get(position).setCover(new Url(result));
                    break;
            }
        }
    }

    /**
     * 只处理一个
     * 会生成action results 谨慎使用
     * @param elements
     * @param keyElement
     * @param action
     * @param var
     */
    private void dispose(Elements elements, KeyElement keyElement, Action action, String var) {
        if (elements != null) {
            createActionResults(action,elements.size());
            for (int i = 0; i < elements.size(); i++) {
                String str = null;
                if (keyElement.getKeyElement() != null) {
                    str = findRecursion(elements.get(i), keyElement.getKeyElement());
                } else {
                    str = getResult(elements.get(i), keyElement.getResultType(),keyElement.getResultAttrKey());
                }
                updateActionResults(action,i,var,str);
            }

        }

    }

    private String getResult(Element element, String keyElementResultType,String keyElementResultAttrKey) {
        String result = null;
        switch (keyElementResultType) {
            case KeyElement.RESULT_TYPE_HTML:
                result = element.html();
                break;
            case KeyElement.RESULT_TYPE_TEXT:
                result = element.text();
                break;
            case KeyElement.RESULT_TYPE_VAL:
                result = element.val();
                break;
            case KeyElement.RESULT_TYPE_ATTR:
                if (keyElementResultAttrKey != null)
                    result = element.attr(keyElementResultAttrKey);
                break;
        }
//        System.out.println("find result : " + result);
        return result;
//        if (action.getResults() == null)
//            action.setResults(new ArrayList<>());
//        Result result = null;
//        if (position >= action.getResults().size()) {
//            result = new Result();
//            action.addResult(result);
//        } else {
//            result = action.getResults().get(position);
//            if (result == null) {
//                result = new Result();
//                action.addResult(result);
//            }
//        }


    }

}
