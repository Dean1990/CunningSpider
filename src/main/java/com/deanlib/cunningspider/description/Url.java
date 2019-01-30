package com.deanlib.cunningspider.description;

import java.util.Map;

public class Url {

    String url;
    Map<String,String> headers;

    public Url(String url, Map<String, String> headers) {
        this.url = url;
        this.headers = headers;
    }

    public Url(String url) {
        this.url = url;
    }

    public Url() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    @Override
    public String toString() {
        return "Url{" +
                "url='" + url + '\'' +
                ", headers=" + headers +
                '}';
    }
}
