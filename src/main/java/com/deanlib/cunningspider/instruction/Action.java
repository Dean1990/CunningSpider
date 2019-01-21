package com.deanlib.cunningspider.instruction;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.List;

/**
 * 行为
 * 关于关键点描述的行为
 */
public class Action {

    int id;
    KeyElement keyElement;
    @JSONField(serialize = false)
    List<String> results;
    int startResult;//半包半闭原则，包括start不包括end
    int endResult;//end 小于等于start的时，表示取值到列表最后
    Action action;//通过链表，指定下一步的动作

    public Action(int id, KeyElement keyElement) {
        this.id = id;
        this.keyElement = keyElement;
    }

    public Action(int id, KeyElement keyElement,Action action) {
        this.id = id;
        this.keyElement = keyElement;
        this.action = action;
    }

    public Action(int id, KeyElement keyElement, int startResult, int endResult) {
        this.id = id;
        this.keyElement = keyElement;
        this.startResult = startResult;
        this.endResult = endResult;
    }

    public Action(int id, KeyElement keyElement, int startResult, int endResult, Action action) {
        this.id = id;
        this.keyElement = keyElement;
        this.startResult = startResult;
        this.endResult = endResult;
        this.action = action;
    }

    public Action() {
    }

    /**
     * 由于链表的存在，可以取最内层的结果
     * @return
     */
    @JSONField(serialize = false)
    public List<String> getLastResult(){
        if (action!=null){
            return action.getLastResult();
        }
        return getResults();
    }

    @JSONField(serialize = false)
    public void addResult(String result){
        if (results == null) results = new ArrayList<>();
        results.add(result);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public KeyElement getKeyElement() {
        return keyElement;
    }

    public void setKeyElement(KeyElement keyElement) {
        this.keyElement = keyElement;
    }

    public List<String> getResults() {
        if (results!=null && startResult>=0){
            return results.subList(startResult,endResult<= startResult?results.size():(endResult>results.size()?results.size():endResult));
        }
        return results;
    }

//    public void setResults(List<String> results) {
//        this.results = results;
//    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
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
