package com.deanlib.cunningspider.description;

import java.io.Serializable;

public class Result implements Serializable {
    String name;
    Url link;
    Url cover;

    Url nextPageNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Url getLink() {
        return link;
    }

    public void setLink(Url link) {
        this.link = link;
    }

    public Url getCover() {
        return cover;
    }

    public void setCover(Url cover) {
        this.cover = cover;
    }

    public Url getNextPageNum() {
        return nextPageNum;
    }

    public void setNextPageNum(Url nextPageNum) {
        this.nextPageNum = nextPageNum;
    }

    @Override
    public String toString() {
        return "Result{" +
                "name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", cover='" + cover + '\'' +
                '}';
    }
}
