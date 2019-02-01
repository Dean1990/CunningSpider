package com.deanlib.cunningspider.description;

import java.io.Serializable;

/**
 * 关键点
 * 这是一个描述
 */
public class KeyElement implements Serializable {

    public static final String FIND_TYPE_ID = "id";
    public static final String FIND_TYPE_TAG = "tag";
    public static final String FIND_TYPE_CLASS = "class";
    public static final String FIND_TYPE_INDEX = "index";
    public static final String FIND_TYPE_ATTRIBUTE = "attribute";
    public static final String FIND_TYPE_TEXT = "text";

    public static final String RESULT_TYPE_HTML = "html";
    public static final String RESULT_TYPE_TEXT = "text";
    public static final String RESULT_TYPE_VAL = "val";
    public static final String RESULT_TYPE_ATTR = "attr";

    String findType;//key的类型
    String value;//关键字，可能是ID，TAG，ClASS 的值等
    String findAttrKey;//正则 只有type = TYPE_ATTRIBUTE 时有用
    String resultType;//查找到的结果的内容类型
    String resultAttrKey;//resultType = RESULT_TYPE_ATTR 时，需要指定要查找的属性
    KeyElement keyElement;//下一步的操作关键点

    boolean isList;//结果是列表
    int start; //开始位置，当找一个元素时，及指定位置，可以传负数，表示反向 -1为倒数第一个，以此类推
    int length;//长度，传<=0的数值表示到list最后

    public KeyElement() {
    }

    public KeyElement(String findType, String value, String findAttrKey, String resultType, String resultAttrKey) {
        this.value = value;
        this.findAttrKey = findAttrKey;
        this.findType = findType;
        this.resultType = resultType;
        this.resultAttrKey = resultAttrKey;
    }

    public KeyElement(String findType, String value, String findAttrKey, KeyElement keyElement) {
        this.findType = findType;
        this.value = value;
        this.findAttrKey = findAttrKey;
        this.keyElement = keyElement;
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

    public KeyElement getKeyElement() {
        return keyElement;
    }

    public void setKeyElement(KeyElement keyElement) {
        this.keyElement = keyElement;
    }

    public int getStart() {
        return start;
    }

    public KeyElement setStart(int start) {
        this.start = start;
        return this;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isList() {
        return isList;
    }

    public KeyElement setList(boolean list) {
        isList = list;
        return this;
    }
}
