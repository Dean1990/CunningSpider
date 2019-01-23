package com.deanlib.cunningspider.description;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * 描述了一个网页中要的Action
 * 对应一个url的
 */
public class Page extends Description{


    Action action;
    Page next;

    public Page(Action action){
        this.action = action;
    }

    public Page(Action action,Page next){
        this.action = action;
        this.next = next;
    }

    public Page(String url, Action action) {
        this.url = url;
        this.action = action;
    }

    public Page(String url, Action action,Page next) {
        this.url = url;
        this.action = action;
        this.next = next;
    }

    /**
     * 取next最里层的action的results
     * @return
     */
    @JSONField(serialize = false)
    public List<Result> getLastResults(){
        if (next != null ){
            return next.getLastResults();
        }
        return action.getResults();
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Page getNext() {
        return next;
    }

    public void setNext(Page next) {
        this.next = next;
    }
}
