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
        return excute(page,timeout,null,null,true);
    }

    private PageResult excute(Page page, int timeout ,Map<String,String> linkHeaders,Map<String,String> coverHeaders
            ,boolean isTop) throws IOException {
        if (page == null)
            throw new NullPointerException("Page is null");

        System.out.println("Excute url:" + page.getUrl() + "  timeout:" + timeout);
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
            find(doc, action.getKey().getKeyLink(), action,1);
        if (page.getNext() != null) {
            if (page.getNext().getUrl() == null && page.getAction().getResults() != null &&
                    page.getAction().getResults().size() > 0)
                page.getNext().setUrl(page.getAction().getResults().get(0).getLink().getUrl());//这种情况只取第一个（多层page时）
            excute(page.getNext(), timeout,linkHeaders,coverHeaders,false);
        } else {
            if (action.getKey().getKeyName() != null)
                find(doc, action.getKey().getKeyName(), action,0);
            if (action.getKey().getKeyCover() != null)
                find(doc, action.getKey().getKeyCover(),action, 2);
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

                if (page.getPageNum()!=null) {
                    Url url = new Url(find1(doc,page.getPageNum()));
                    if (linkHeaders != null)
                        url.setHeaders(linkHeaders);
                    pageResult.setNextPageNum(url);
                }
                return pageResult;
            }
            return null;
        }

        return null;
    }


    private void find(Element element, KeyElement keyElement, Action action, int index) {
        System.out.print("find -> ");
        if (keyElement != null) {
            switch (keyElement.getFindType()) {
                case KeyElement.FIND_TYPE_ID:
                    System.out.println("id=" + keyElement.getValue());
                    dispose(element.getElementById(keyElement.getValue()), keyElement,action, index);
                    break;
                case KeyElement.FIND_TYPE_TAG:
                    System.out.println("tag=" + keyElement.getValue());
                    dispose(element.getElementsByTag(keyElement.getValue()), keyElement,action, index);
                    break;
                case KeyElement.FIND_TYPE_CLASS:
                    System.out.println("class=" + keyElement.getValue());
                    dispose(element.getElementsByClass(keyElement.getValue()), keyElement,action, index);
                    break;
                case KeyElement.FIND_TYPE_INDEX:
                    System.out.println("index=" + keyElement.getValue());
                    dispose(element.getElementsByIndexEquals(Integer.valueOf(keyElement.getValue())), keyElement,action, index);
                    break;
                case KeyElement.FIND_TYPE_ATTRIBUTE:
                    if (keyElement.getFindAttrKey() != null) {
                        System.out.println("attr " + keyElement.getFindAttrKey() + "=" + keyElement.getValue());
                        dispose(element.getElementsByAttributeValueMatching(keyElement.getFindAttrKey()
                                , keyElement.getValue()), keyElement,action, index);
                    } else {
                        System.err.println("attr key is null");
                    }
                    break;
                case KeyElement.FIND_TYPE_TEXT:
                    System.out.println("text=" + keyElement.getValue());
                    dispose(element.getElementsMatchingOwnText(keyElement.getValue()),keyElement,action,index);
                    break;
            }
        } else {
            throw new NullPointerException("KeyElement is null");
        }
//        System.out.println("find result : "+result);
//        return result;
    }

    /**
     * 只要一个
     * 按要求，对keyElement的子keyElement保定唯一描述情况定义的函数
     *
     * @param element
     * @param keyElement
     * @return
     */
    private String find1(Element element, KeyElement keyElement) {
        System.out.print("find1 -> ");
        String result = null;
        if (keyElement != null) {
            switch (keyElement.getFindType()) {
                case KeyElement.FIND_TYPE_ID:
                    System.out.println("id=" + keyElement.getValue());
                    result = find1Recursion(element.getElementById(keyElement.getValue()), keyElement);
                    break;
                case KeyElement.FIND_TYPE_TAG:
                    System.out.println("tag=" + keyElement.getValue());
                    result = find1Recursion(element.getElementsByTag(keyElement.getValue()), keyElement);
                    break;
                case KeyElement.FIND_TYPE_CLASS:
                    System.out.println("class=" + keyElement.getValue());
                    result = find1Recursion(element.getElementsByClass(keyElement.getValue()), keyElement);
                    break;
                case KeyElement.FIND_TYPE_INDEX:
                    System.out.println("index=" + keyElement.getValue());
                    result = find1Recursion(element.getElementsByIndexEquals(Integer.valueOf(keyElement.getValue())), keyElement);
                    break;
                case KeyElement.FIND_TYPE_ATTRIBUTE:
                    if (keyElement.getFindAttrKey() != null) {
                        System.out.println("attr " + keyElement.getFindAttrKey() + "=" + keyElement.getValue());
                        result = find1Recursion(element.getElementsByAttributeValueMatching(keyElement.getFindAttrKey()
                                , keyElement.getValue()), keyElement);
                    } else {
                        System.err.println("attr key is null");
                    }
                    break;
                case KeyElement.FIND_TYPE_TEXT:
                    System.out.println("text=" + keyElement.getValue());
                    result = find1Recursion(element.getElementsMatchingOwnText(keyElement.getValue()),keyElement);
                    break;
            }

        } else {
            throw new NullPointerException("KeyElement is null");
        }
        System.out.println("find1 result : " + result);
        return result;
    }

    private String find1Recursion(Element element, KeyElement keyElement) {
        if (element != null) {
            return setResult(element, keyElement);
        }
        return null;
    }

    private String find1Recursion(Elements elements, KeyElement keyElement) {
        if (elements != null && elements.size() > 0) {
            return find1Recursion(elements.get(0), keyElement);
        }
        return null;
    }

    private void dispose(Element element, KeyElement keyElement, Action action, int index) {
        if (element != null) {
            Elements elements = new Elements(element);
            dispose(elements, keyElement, action, index);
        }
    }

    private void dispose(Elements elements, KeyElement keyElement, Action action, int index) {
        if (elements != null) {
            if (action.getResults() == null) {
                List<Result> results = new ArrayList<>();
                for (int i = 0; i < elements.size(); i++) {
                    results.add(new Result());
                }
                action.setResults(results);
            }
            for (int i = 0; i < elements.size(); i++) {
                String str = null;
                if (keyElement.getKeyElement() != null) {
                    str = find1(elements.get(i), keyElement.getKeyElement());
                } else {
                    str = setResult(elements.get(i), keyElement);
                }
                switch (index) {
                    case 0:
                        action.getResults().get(i).setName(str);
                        break;
                    case 1:
                        action.getResults().get(i).setLink(new Url(str));
                        break;
                    case 2:
                        action.getResults().get(i).setCover(new Url(str));
                        break;
                }
            }

        }

    }

    private String setResult(Element element, KeyElement keyElement) {
        String result = null;
        switch (keyElement.getResultType()) {
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
                if (keyElement.getResultAttrKey() != null)
                    result = element.attr(keyElement.getResultAttrKey());
                break;
        }
        System.out.println("find result : " + result);
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
