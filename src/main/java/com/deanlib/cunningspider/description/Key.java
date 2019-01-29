package com.deanlib.cunningspider.description;

public class Key {

    KeyElement keyName;
    KeyElement keyLink;
    KeyElement keyCover;

    public Key() {
    }

    public Key(KeyElement keyLink) {
        this.keyLink = keyLink;
    }

    public Key(KeyElement keyName, KeyElement keyLink) {
        this.keyName = keyName;
        this.keyLink = keyLink;
    }

    public Key(KeyElement keyName, KeyElement keyLink, KeyElement keyCover) {
        this.keyName = keyName;
        this.keyLink = keyLink;
        this.keyCover = keyCover;
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

    public KeyElement getKeyCover() {
        return keyCover;
    }

    public void setKeyCover(KeyElement keyCover) {
        this.keyCover = keyCover;
    }
}
