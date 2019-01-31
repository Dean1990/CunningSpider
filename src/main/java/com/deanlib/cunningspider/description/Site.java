package com.deanlib.cunningspider.description;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定义网站的结构，不变
 * 由四部分组成
 * catalog - list - resource - related
 * 虽然以上是一个完整的结构，但不需要搞一个完整结构
 * 采用 list - resource - related 的方式，可以随着网站的更新，而自动更新
 * list 描述首页
 */
public class Site extends Description {


    Page catalog;
    Page list;
    Page resource;//详情页的描述只能是一层，不能使用page next，否则结果不可控
    Page related;

    Map<String,String> linkHeaders;
    Map<String,String> coverHeaders;


    public Page getCatalog() {
        return catalog;
    }

    public void setCatalog(Page catalog) {
        this.catalog = catalog;
    }

    public Page getList() {
        return list;
    }

    public void setList(Page list) {
        this.list = list;
    }

    public Page getResource() {
        return resource;
    }

    public void setResource(Page resource) {
        this.resource = resource;
    }

    public Page getRelated() {
        return related;
    }

    public void setRelated(Page related) {
        this.related = related;
    }

    public Map<String,String> getLinkHeaders() {
        return linkHeaders;
    }

    public void setLinkHeaders(Map<String,String> linkHeaders) {
        this.linkHeaders = linkHeaders;
    }

    public void addLinkHeader(String key, String value){
        if (linkHeaders == null)
            linkHeaders = new HashMap<>();
        linkHeaders.put(key,value);
    }

    public Map<String,String> getCoverHeaders() {
        return coverHeaders;
    }

    public void setCoverHeaders(Map<String,String> coverHeaders) {
        this.coverHeaders = coverHeaders;
    }

    public void addCoverHeader(String key, String value){
        if (coverHeaders == null)
            coverHeaders = new HashMap<>();
        coverHeaders.put(key,value);
    }
}
