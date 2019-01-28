package com.deanlib.cunningspider.description;

import java.util.List;

/**
 * 定义网站的结构，不变
 * 由四部分组成
 * catalog - list - resource - related
 * 虽然以上是一个完整的结构，但不需要搞一个完整结构
 * 采用 list - resource - related 的方式，可以随着网站的更新，而自动更新
 * list 描述首页
 */
public abstract class Site extends Description {


    Page catalog;
    Page list;
    Page resource;
    Page related;


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
}
