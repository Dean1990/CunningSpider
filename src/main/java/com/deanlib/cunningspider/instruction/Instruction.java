package com.deanlib.cunningspider.instruction;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.List;

/**
 * 一条指令
 * 对应一个url的
 */
public class Instruction {

    String name;
    int version;
    String url;
    List<Action> actions;
    String description;

    public Instruction(String name, int version,String description) {
        this.name = name;
        this.version = version;
        this.description = description;
    }

    public Instruction(String name, int version, String url, String description) {
        this.name = name;
        this.version = version;
        this.url = url;
        this.description = description;
    }

    public Instruction(String url, Action action) {
        this.url = url;
        addAction(action);
    }

    public Instruction() {
    }

    @JSONField(serialize = false)
    public void addAction(Action action){
        if (actions == null) actions = new ArrayList<>();
        actions.add(action);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Action> getActions() {
        return actions;
    }

//    public void setActions(List<Action> actions) {
//        this.actions = actions;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
