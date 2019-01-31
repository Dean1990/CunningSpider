package com.deanlib.cunningspider.description;

import java.io.Serializable;
import java.util.List;

/**
 * 带页码的结果
 */
public class PageResult implements Serializable {

    List<Result> results;
    Url nextPageLink;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Url getNextPageLink() {
        return nextPageLink;
    }

    public void setNextPageLink(Url nextPageNum) {
        this.nextPageLink = nextPageLink;
    }
}
