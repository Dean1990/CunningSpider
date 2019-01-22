package com.deanlib.cunningspider.instruction;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 关键点
 * 这是一个描述
 * @see Action
 */
public class KeyElement {

    public static final String FIND_TYPE_ID = "id";
    public static final String FIND_TYPE_TAG = "tag";
    public static final String FIND_TYPE_CLASS = "class";
    public static final String FIND_TYPE_INDEX = "index";
    public static final String FIND_TYPE_ATTRIBUTE = "attribute";

    public static final String RESULT_TYPE_HTML = "html";
    public static final String RESULT_TYPE_TEXT = "text";
    public static final String RESULT_TYPE_VAL = "val";
    public static final String RESULT_TYPE_ATTR = "attr";

    String findType;//key的类型
    String value;//关键字，可能是ID，TAG，ClASS 的值等
    String findAttrKey;//正则 只有type = TYPE_ATTRIBUTE 时有用
    String resultType;//查找到的结果的内容类型
    String resultAttrKey;//resultType = RESULT_TYPE_ATTR 时，需要指定要查找的属性
    List<KeyElement> keyElements;//查找可能是一个集合，下一步的操作关键点
    @JSONField(serialize = true)
    List<String> results;
    int startResult;//半包半闭原则，包括start不包括end
    int endResult;//end 小于等于start的时，表示取值到列表最后

    public KeyElement(String findType,String value,String findAttrKey,String resultType,String resultAttrKey) {
        this.value = value;
        this.findAttrKey = findAttrKey;
        this.findType = findType;
        this.resultType = resultType;
        this.resultAttrKey = resultAttrKey;
    }

    public KeyElement(String findType, String value, String findAttrKey, KeyElement... keyElements) {
        this.findType = findType;
        this.value = value;
        this.findAttrKey = findAttrKey;
        this.keyElements = Arrays.asList(keyElements);
    }

    public KeyElement() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFindAttrKey() {
        return findAttrKey;
    }

    public void setFindAttrKey(String findAttrKey) {
        this.findAttrKey = findAttrKey;
    }

    public String getFindType() {
        return findType;
    }

    public void setFindType(String findType) {
        this.findType = findType;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getResultAttrKey() {
        return resultAttrKey;
    }

    public void setResultAttrKey(String resultAttrKey) {
        this.resultAttrKey = resultAttrKey;
    }

    public List<KeyElement> getKeyElements() {
        return keyElements;
    }

    public void setKeyElements(List<KeyElement> keyElements) {
        this.keyElements = keyElements;
    }

    @JSONField(serialize = false)
    public void addResult(String result){
        if (results == null) results = new ArrayList<>();
        results.add(result);
    }

    public List<String> getResults() {
        if (results!=null && startResult>=0){
            return results.subList(startResult,endResult<= startResult?results.size():(endResult>results.size()?results.size():endResult));
        }
        return results;
    }

    public int getStartResult() {
        return startResult;
    }

    public void setStartResult(int startResult) {
        this.startResult = startResult;
    }

    public int getEndResult() {
        return endResult;
    }

    public void setEndResult(int endResult) {
        this.endResult = endResult;
    }
}
