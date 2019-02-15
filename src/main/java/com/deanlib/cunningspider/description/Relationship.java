package com.deanlib.cunningspider.description;

import java.io.Serializable;

/**
 * keyelement的关系描述
 */
public class Relationship implements Serializable {

    public static final String RELATION_SENIOR = "senior";//前辈
    public static final String RELATION_JUNIOR = "junior";//晚辈

    String relation;
    int index;//第几个孩子 第一个为0 ,默认0 当 relation 为 junior 时，该参数有效 支持传负数及倒数

    Relationship relationship;

    public Relationship() {
    }

    public Relationship(String relation) {
        this.relation = relation;
    }

    public String getRelation() {
        return relation;
    }

    public Relationship setRelation(String relation) {
        this.relation = relation;
        return this;
    }

    public int getIndex() {
        return index;
    }

    public Relationship setIndex(int index) {
        this.index = index;
        return this;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public Relationship setRelationship(Relationship relationship) {
        this.relationship = relationship;
        return this;
    }
}
