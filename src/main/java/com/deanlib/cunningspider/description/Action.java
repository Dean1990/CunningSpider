package com.deanlib.cunningspider.description;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Action implements Serializable {

    Key key;
    int start;//半包半闭原则，包括start不包括end 可以为负，反向
    int length;//长度

    @JSONField(serialize = false)
    List<Result> results;

    public Action() {
    }

    public Action(Key key){
        this.key = key;
    }

    public Action(Key key, int start, int length){
        this.key = key;
        this.start = start;
        this.length = length;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    @JSONField(serialize = false)
    public void addResult(Result result){
        if (results == null) results = new ArrayList<>();
        results.add(result);
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }

    @JSONField(serialize = false)
    public List<Result> getEnableResults(){
        if (results!=null) {
            int index = getStart();
            if (index < 0) {
                index = results.size() + index;
            }
            int endIndex = index + getLength();
            if (index < results.size()) {
                return results.subList(index
                        , (endIndex > results.size() || endIndex <= 0) ? results.size() : endIndex);
            } else {
                return results;
            }
        }
        return results;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
