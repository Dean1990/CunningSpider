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
            find(doc, action.getKeyElements());
            if (!action.isCatalog() && action.getAction()!=null && action.getResults()!=null){
                //下一步操作
                for (List<String> list : action.getResults()) {
                    if (list!=null && list.size()>0 && Pattern.matches("https?:\\/\\/\\S+", list.get(0))) {
                        excute(new Instruction(list.get(0), action.getAction()), timeout);
                    } else {
                        System.err.println("error url");
                    }
                }
            }
        }

        otherExcute(doc.html(),actions);

        return actions;
    }

    private void find(Element element, List<KeyElement> keyElements) {
        System.out.print("find -> ");
        if (keyElements!=null) {
            for (int i = 0;i<keyElements.size();i++) {
                KeyElement keyElement = keyElements.get(i);
                switch (keyElement.getFindType()) {
                    case KeyElement.FIND_TYPE_ID:
                        System.out.println("id=" + keyElement.getValue());
                        recursion(element.getElementById(keyElement.getValue()), keyElement);
                        break;
                    case KeyElement.FIND_TYPE_TAG:
                        System.out.println("tag=" + keyElement.getValue());
                        recursion(element.getElementsByTag(keyElement.getValue()), keyElement);
                        break;
                    case KeyElement.FIND_TYPE_CLASS:
                        System.out.println("class=" + keyElement.getValue());
                        recursion(element.getElementsByClass(keyElement.getValue()), keyElement);
                        break;
                    case KeyElement.FIND_TYPE_INDEX:
                        System.out.println("index=" + keyElement.getValue());
                        recursion(element.getElementsByIndexEquals(Integer.valueOf(keyElement.getValue())), keyElement);
                        break;
                    case KeyElement.FIND_TYPE_ATTRIBUTE:
                        if (keyElement.getFindAttrKey() != null) {
                            System.out.println("attr " + keyElement.getFindAttrKey() + "=" + keyElement.getValue());
                            recursion(element.getElementsByAttributeValueMatching(keyElement.getFindAttrKey(), keyElement.getValue()), keyElement);
                        } else {
                            System.err.println("attr key is null");
                        }

                        break;
                }
            }
        }
    }

    private void recursion(Element element,KeyElement keyElement){
        if (element!=null) {
            Elements elements = new Elements(element);
            recursion(elements, keyElement);
        }
    }

    private void recursion(Elements elements,KeyElement keyElement){
        if (elements != null ) {
            for (Element element : elements) {
                if (keyElement.getKeyElements() != null) {
                    find(element, keyElement.getKeyElements());
                } else {
                    setResult(element,keyElement);
                }
            }
        }
    }

    private void setResult(Element element, KeyElement keyElement) {
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
        System.out.println("result : " + result);
        action.addResult(keIndex,result);
    }

    public void otherExcute(String html,List<Action> actions){};

}
