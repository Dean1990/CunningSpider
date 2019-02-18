package com.deanlib.cunningspider.description;

import java.io.Serializable;

public class Result implements Serializable {

    public static final String VAR_NAME = "name";
    public static final String VAR_LINK = "link";
    public static final String VAR_COVER = "cover";

    String name;
    Url link;
    Url cover;

    String findPageUrl;//得到该结果的查找页面 ，主要用于反盗链和补齐以相对地址方式链接

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

    public String getFindPageUrl() {
        return findPageUrl;
    }

    public void setFindPageUrl(String findPageUrl) {
        this.findPageUrl = findPageUrl;
    }

    @Override
    public String toString() {
        return "Result{" +
                "name='" + name + '\'' +
                ", link=" + link +
                ", cover=" + cover +
                ", findPageUrl='" + findPageUrl + '\'' +
                '}';
    }
}
