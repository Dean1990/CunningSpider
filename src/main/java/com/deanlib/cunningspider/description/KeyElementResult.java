package com.deanlib.cunningspider.description;

import java.io.Serializable;

/**
 * 描述keyelement 的结果属性
 */
public class KeyElementResult implements Serializable {

    public static final String RESULT_TYPE_HTML = "html";
    public static final String RESULT_TYPE_TEXT = "text";
    public static final String RESULT_TYPE_VAL = "val";
    public static final String RESULT_TYPE_ATTR = "attr";

    String resultType;//查找到的结果的内容类型
    String resultAttrKey;//resultType = RESULT_TYPE_ATTR 时，需要指定要查找的属性

    public KeyElementResult() {
    }

    public KeyElementResult(String resultType) {
        this.resultType = resultType;
    }

    public KeyElementResult(String resultType, String resultAttrKey) {
        this.resultType = resultType;
        this.resultAttrKey = resultAttrKey;
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
}
