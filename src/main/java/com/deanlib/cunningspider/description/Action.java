package com.deanlib.cunningspider.description;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Action implements Serializable {

    Key key;
    int startResult;//半包半闭原则，包括start不包括end
    int endResult;//end 小于等于start的时，表示取值到列表最后

    @JSONField(serialize = false)
    List<Result> results;

    public Action() {
    }

    public Action(Key key){
        this.key = key;
    }

    public Action(Key key, int startResult, int endResult){
        this.key = key;
        this.startResult = startResult;
        this.endResult = endResult;
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
