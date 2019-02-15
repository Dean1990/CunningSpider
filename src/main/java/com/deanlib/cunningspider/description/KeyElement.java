package com.deanlib.cunningspider.description;

import java.io.Serializable;

/**
 * 关键点
 * 这是一个描述
 */
public class KeyElement implements Serializable {

    KeyElementFind keyElementFind;
    KeyElementResult keyElementResult;
    KeyElement keyElement;//下一步的操作关键点

    boolean isList;//结果是列表
    int start; //开始位置，当找一个元素时，及指定位置，可以传负数，表示反向 -1为倒数第一个，以此类推
    int length;//长度，传<=0的数值表示到list最后

    Relationship relationship;

    public KeyElement() {
    }

    public KeyElement(KeyElementFind keyElementFind,KeyElementResult keyElementResult) {
        this.keyElementFind = keyElementFind;
        this.keyElementResult = keyElementResult;
    }

    public KeyElement(KeyElementFind keyElementFind, KeyElement keyElement) {
        this.keyElementFind = keyElementFind;
        this.keyElement = keyElement;
    }



    public KeyElementFind getKeyElementFind() {
        return keyElementFind;
    }

    public KeyElement setKeyElementFind(KeyElementFind keyElementFind) {
        this.keyElementFind = keyElementFind;
        return this;
    }

    public KeyElementResult getKeyElementResult() {
        return keyElementResult;
    }

    public KeyElement setKeyElementResult(KeyElementResult keyElementResult) {
        this.keyElementResult = keyElementResult;
        return this;
    }

    public KeyElement getKeyElement() {
        return keyElement;
    }

    public void setKeyElement(KeyElement keyElement) {
        this.keyElement = keyElement;
    }

    public int getStart() {
        return start;
    }

    public KeyElement setStart(int start) {
        this.start = start;
        return this;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isList() {
        return isList;
    }

    public KeyElement setList(boolean list) {
        isList = list;
        return this;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public KeyElement setRelationship(Relationship relationship) {
        this.relationship = relationship;
        return this;
    }
}
