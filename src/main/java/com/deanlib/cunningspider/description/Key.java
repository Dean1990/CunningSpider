package com.deanlib.cunningspider.description;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * KeyElement 中可以setKeyElement 但是只有最顶层的（及Key下的keyName,keyLink...等）可以产生结果集合（及List）
 * 其下的子KeyElement 均要保证其描述的唯一性，Executor对子KeyElement产生的结果集合只取第一个（及list.get(0)）
 */
public class Key implements Serializable {

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

    @JSONField(serialize = false)
    public Key setList(boolean b) {
        if (keyName != null)
            keyName.setList(b);
        if (keyLink != null)
            keyLink.setList(b);
        if (keyCover != null)
            keyCover.setList(b);
        return this;
    }
}
