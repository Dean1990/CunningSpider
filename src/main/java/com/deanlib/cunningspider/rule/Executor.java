package com.deanlib.cunningspider.rule;

import com.deanlib.cunningspider.description.Action;
import com.deanlib.cunningspider.description.Page;
import com.deanlib.cunningspider.description.KeyElement;
import com.deanlib.cunningspider.description.Result;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Executor {

    public List<Result> excute(Page page, int timeout) throws IOException {
        if (page == null)
            throw new NullPointerException("Page is null");

        System.out.println("Excute url:" + page.getUrl() + "  timeout:" + timeout);
        Document doc = Jsoup.parse(new URL(page.getUrl()), timeout);

        Action action = page.getAction();
        if (action == null)
            throw new NullPointerException("Page Action is null");
        if (action.getKey() == null)
            throw new NullPointerException("Page Action key is null");
        if (action.getKey().getKeyLink() != null)
            find(doc, action.getKey().getKeyLink(), action, 1);
        if (page.getNext() != null) {
            if (page.getNext().getUrl() == null && page.getAction().getResults() != null &&
                    page.getAction().getResults().size() > 0)
                page.getNext().setUrl(page.getAction().getResults().get(0).getLink());//这种情况只取第一个（多层page时）
            excute(page.getNext(), timeout);
        } else {
            if (action.getKey().getKeyName() != null)
                find(doc, action.getKey().getKeyName(), action, 0);
            if (action.getKey().getKeyCover() != null)
                find(doc,action.getKey().getKeyCover(),action,2);
        }


//        if (!action.isCatalog() && action.getAction()!=null && action.getResults()!=null){
//            //下一步操作
//            for (List<String> list : action.getResults()) {
//                if (list!=null && list.size()>0 && Pattern.matches("https?:\\/\\/\\S+", list.get(0))) {
//                    excute(new Page(list.get(0), action.getAction()), timeout);
//                } else {
//                    System.err.println("error url");
//                }
//            }
//        }

        return page.getLastResults();
    }


    private void find(Element element, KeyElement keyElement, Action action, int index) {
        System.out.print("find -> ");
        if (keyElement != null) {

            switch (keyElement.getFindType()) {
                case KeyElement.FIND_TYPE_ID:
                    System.out.println("id=" + keyElement.getValue());
                    recursion(element.getElementById(keyElement.getValue()), keyElement, action, index);
                    break;
                case KeyElement.FIND_TYPE_TAG:
                    System.out.println("tag=" + keyElement.getValue());
                    recursion(element.getElementsByTag(keyElement.getValue()), keyElement, action, index);
                    break;
                case KeyElement.FIND_TYPE_CLASS:
                    System.out.println("class=" + keyElement.getValue());
                    recursion(element.getElementsByClass(keyElement.getValue()), keyElement, action, index);
                    break;
                case KeyElement.FIND_TYPE_INDEX:
                    System.out.println("index=" + keyElement.getValue());
                    recursion(element.getElementsByIndexEquals(Integer.valueOf(keyElement.getValue())), keyElement, action, index);
                    break;
                case KeyElement.FIND_TYPE_ATTRIBUTE:
                    if (keyElement.getFindAttrKey() != null) {
                        System.out.println("attr " + keyElement.getFindAttrKey() + "=" + keyElement.getValue());
                        recursion(element.getElementsByAttributeValueMatching(keyElement.getFindAttrKey()
                                , keyElement.getValue()), keyElement, action, index);
                    } else {
                        System.err.println("attr key is null");
                    }

                    break;
            }

        } else {
            throw new NullPointerException("KeyElement is null");
        }
//        System.out.println("find result : "+result);
//        return result;
    }

    private void recursion(Element element, KeyElement keyElement, Action action, int index) {
        if (element != null) {
            Elements elements = new Elements(element);
            recursion(elements, keyElement, action, index);
        }
    }

    private void recursion(Elements elements, KeyElement keyElement, Action action, int index) {
        if (elements != null) {
            if (keyElement.getKeyElement() != null) {
                for (Element element : elements) {
                    find(element, keyElement.getKeyElement(), action, index);
                }
            } else {
                for (int i = 0; i < elements.size(); i++) {
                    setResult(elements.get(i), keyElement, action, i, index);
                }
            }

        }
    }

    private void setResult(Element element, KeyElement keyElement, Action action, int position, int index) {
        String str = null;
        switch (keyElement.getResultType()) {
            case KeyElement.RESULT_TYPE_HTML:
                str = element.html();
                break;
            case KeyElement.RESULT_TYPE_TEXT:
                str = element.text();
                break;
            case KeyElement.RESULT_TYPE_VAL:
                str = element.val();
                break;
            case KeyElement.RESULT_TYPE_ATTR:
                if (keyElement.getResultAttrKey() != null)
                    str = element.attr(keyElement.getResultAttrKey());
                break;
        }
        System.out.println("find result : " + str);

        if (action.getResults() == null)
            action.setResults(new ArrayList<>());

        Result result = null;
        if (position >= action.getResults().size()) {
            result = new Result();
            action.addResult(result);
        } else {
            result = action.getResults().get(position);
            if (result == null) {
                result = new Result();
                action.addResult(result);
            }
        }
        switch (index){
            case 0:
                result.setName(str);
                break;
            case 1:
                result.setLink(str);
                break;
            case 2:
                result.setCover(str);
                break;
        }

    }

}
