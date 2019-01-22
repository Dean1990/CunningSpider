package com.deanlib.cunningspider.instruction;

import java.util.List;

/**
 * 结果
 */
public class Result {

    public static final String TYPE_TEXT = "text";
    public static final String TYPE_IMG = "img";
    public static final String TYPE_LINK = "link";

    List<String> results;
    int startResult;//半包半闭原则，包括start不包括end
    int endResult;//end 小于等于start的时，表示取值到列表最后
    String type;

    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
