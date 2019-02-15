package com.deanlib.cunningspider.description;

import java.io.Serializable;

/**
 * 描述keyelement 的查找属性
 */
public class KeyElementFind implements Serializable {

    public static final String FIND_TYPE_ID = "id";
    public static final String FIND_TYPE_TAG = "tag";
    public static final String FIND_TYPE_CLASS = "class";
    public static final String FIND_TYPE_INDEX = "index";
    public static final String FIND_TYPE_ATTRIBUTE = "attribute";
    public static final String FIND_TYPE_TEXT = "text";

    String findType;//key的类型
    String value;//关键字，可能是ID，TAG，ClASS 的值等
    String findAttrKey;//正则 只有type = TYPE_ATTRIBUTE 时有用

    public KeyElementFind() {
    }

    public KeyElementFind(String findType, String value) {
        this.findType = findType;
        this.value = value;
    }

    public KeyElementFind(String findType, String findAttrKey, String value) {
        this.findType = findType;
        this.value = value;
        this.findAttrKey = findAttrKey;
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
}
