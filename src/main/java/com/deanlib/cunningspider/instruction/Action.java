package com.deanlib.cunningspider.instruction;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 行为
 * 关于关键点描述的行为
 */
public class Action {

    int id;
    List<KeyElement> keyElements;

    Action action;//通过链表，指定下一步的动作
    boolean isCatalog;//指定是否是目录

    public Action(int id, KeyElement... keyElements) {
        this.id = id;
        this.keyElements = Arrays.asList(keyElements);
    }

    public Action(int id,Action action,KeyElement... keyElements) {
        this.id = id;
        this.keyElements = Arrays.asList(keyElements);
        this.action = action;
    }

    public Action(int id,Action action,boolean isCatalog, KeyElement... keyElements) {
        this.id = id;
        this.keyElements = Arrays.asList(keyElements);
        this.action = action;
        this.isCatalog = isCatalog;
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
        return keyElement.getResults();
    }

    /**
     * 返回目录级别的数据
     * @return
     */
    @JSONField(serialize = false)
    public List<List<String>> getCatalogResult(){
        if (!isCatalog && action!=null){
            return action.getCatalogResult();
        }
        return getResults();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<KeyElement> getKeyElements() {
        return keyElements;
    }

    public void setKeyElements(List<KeyElement> keyElements) {
        this.keyElements = keyElements;
    }


    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public boolean isCatalog() {
        return isCatalog;
    }

    public void setCatalog(boolean catalog) {
        isCatalog = catalog;
    }
}
