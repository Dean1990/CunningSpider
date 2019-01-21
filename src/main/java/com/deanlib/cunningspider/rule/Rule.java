package com.deanlib.cunningspider.rule;

import com.deanlib.cunningspider.instruction.Action;
import com.deanlib.cunningspider.instruction.Instruction;
import com.deanlib.cunningspider.instruction.KeyElement;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.regex.Pattern;

public abstract class Rule {

    public List<Action> excute(Instruction instruction, int timeout) throws IOException {
        if (instruction == null)
            throw new NullPointerException("Instruction is null");
        List<Action> actions = instruction.getActions();
        if (actions == null)
            throw new NullPointerException("Instruction.getActions() is null");

        System.out.println("Excute url:"+instruction.getUrl() + "  timeout:"+timeout);
        Document doc = Jsoup.parse(new URL(instruction.getUrl()),timeout);

        for (Action action : actions) {
            action.setResult(find(doc, action.getKeyElement()));
            if (action.getAction()!=null){
                //下一步操作
                if (Pattern.matches("https?:\\/\\/\\S+",action.getResult())) {
                    excute(new Instruction(action.getResult(),action.getAction()), timeout);
                }else {
                    System.err.println("error url");
                }
            }
        }

        otherExcute(doc.html(),actions);

        return actions;
    }

    private String find(Element element, KeyElement keyElement) {
        System.out.print("find -> ");
        String result = "";
        switch (keyElement.getFindType()) {
            case KeyElement.FIND_TYPE_ID:
                System.out.println("id="+keyElement.getValue());
                result = recursion(element.getElementById(keyElement.getValue()),keyElement);
                break;
            case KeyElement.FIND_TYPE_TAG:
                System.out.println("tag="+keyElement.getValue());
                result = recursion(element.getElementsByTag(keyElement.getValue()),keyElement);
                break;
            case KeyElement.FIND_TYPE_CLASS:
                System.out.println("class="+keyElement.getValue());
                result = recursion(element.getElementsByClass(keyElement.getValue()),keyElement);
                break;
            case KeyElement.FIND_TYPE_INDEX:
                System.out.println("index="+keyElement.getValue());
                result = recursion(element.getElementsByIndexEquals(Integer.valueOf(keyElement.getValue())),keyElement);
                break;
            case KeyElement.FIND_TYPE_ATTRIBUTE:
                if (keyElement.getFindAttrKey() != null) {
                    System.out.println("attr " + keyElement.getFindAttrKey() +"="+keyElement.getValue());
                    result = recursion(element.getElementsByAttributeValueMatching(keyElement.getFindAttrKey(),keyElement.getValue()),keyElement);
                }else {
                    System.err.println("attr key is null");
                }

                break;
        }
        System.out.println("result : " + result);
        return result;
    }

    private String recursion(Element element,KeyElement keyElement){
        if (element!=null) {
            Elements elements = new Elements(element);
            return recursion(elements, keyElement);
        }else return "";
    }

    private String recursion(Elements elements,KeyElement keyElement){
        String result = "";
        if (elements != null && elements.size() > 0) {
            if (keyElement.getInnerKeyElement() != null) {
                result = find(elements.first(), keyElement.getInnerKeyElement());
            } else {
                result = getResult(elements.first(), keyElement);
            }
        }
        return result;
    }

    private String getResult(Element element, KeyElement keyElement) {
        String result = "";
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
        return result;
    }

    public void otherExcute(String html,List<Action> actions){};

}
