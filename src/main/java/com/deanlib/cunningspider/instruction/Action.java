package com.deanlib.cunningspider.instruction;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 行为
 * 关于关键点描述的行为
 */
public class Action {

    int id;
    KeyElement keyElement;
    @JSONField(serialize = false)
    String result;
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

    public Action() {
    }

    /**
     * 由于链表的存在，可以取最内层的结果
     * @return
     */
    @JSONField(serialize = false)
    public String getLastResult(){
        if (action!=null){
            return action.getLastResult();
        }
        return result;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
