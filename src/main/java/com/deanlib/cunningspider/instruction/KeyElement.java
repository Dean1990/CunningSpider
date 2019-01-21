package com.deanlib.cunningspider.instruction;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

/**
 * 关键点
 * 这是一个描述，把与其无关的东西放到了
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
    KeyElement innerKeyElement;//查找可能是一个集合，下一步的操作关键点

    public KeyElement(@NotNull String findType,@NotNull String value, @Nullable String findAttrKey,@NotNull String resultType,@Nullable String resultAttrKey) {
        this.value = value;
        this.findAttrKey = findAttrKey;
        this.findType = findType;
        this.resultType = resultType;
        this.resultAttrKey = resultAttrKey;
    }

    public KeyElement(String findType, String value, String findAttrKey, KeyElement innerKeyElement) {
        this.findType = findType;
        this.value = value;
        this.findAttrKey = findAttrKey;
        this.innerKeyElement = innerKeyElement;
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

    public KeyElement getInnerKeyElement() {
        return innerKeyElement;
    }

    public void setInnerKeyElement(KeyElement innerKeyElement) {
        this.innerKeyElement = innerKeyElement;
    }
}