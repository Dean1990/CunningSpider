package com.deanlib.cunningspider.description;

public class Key {

    KeyElement keyName;
    KeyElement keyLink;

    public Key() {
    }

    public Key(KeyElement keyLink) {
        this.keyLink = keyLink;
    }

    public Key(KeyElement keyName, KeyElement keyLink) {
        this.keyName = keyName;
        this.keyLink = keyLink;
    }

    public KeyElement getKeyName() {
        return keyName;
    }

    public void setKeyName(KeyElement keyName) {
        this.keyName = keyName;
    }

    public KeyElement getKeyLink() {
        return keyLink;
    }

    public void setKeyLink(KeyElement keyLink) {
        this.keyLink = keyLink;
    }
}
