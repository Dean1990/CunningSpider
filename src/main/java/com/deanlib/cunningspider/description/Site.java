package com.deanlib.cunningspider.description;

import java.util.List;

/**
 * 定义网站的结构，不变
 * 由四部分组成
 * catalog - list - detail - related
 */
public abstract class Site extends Description {

    Page catalog;
    Page list;
    Page detail;
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

    public Page getDetail() {
        return detail;
    }

    public void setDetail(Page detail) {
        this.detail = detail;
    }

    public Page getRelated() {
        return related;
    }

    public void setRelated(Page related) {
        this.related = related;
    }
}
