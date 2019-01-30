package com.deanlib.cunningspider.description;

public class Result {
    String name;
    Url link;
    Url cover;

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

    @Override
    public String toString() {
        return "Result{" +
                "name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", cover='" + cover + '\'' +
                '}';
    }
}
