package com.deanlib.cunningspider.description;

public class Result {
    String name;
    String link;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Result{" +
                "name='" + name + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
