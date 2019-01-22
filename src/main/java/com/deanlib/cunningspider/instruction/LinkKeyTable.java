package com.deanlib.cunningspider.instruction;

import java.util.List;

/**
 * 正则链接与keyElement对应表
 */
public class LinkKeyTable {

    String linkRegEx;
    List<KeyElement> keyElements;

    public String getLinkRegEx() {
        return linkRegEx;
    }

    public void setLinkRegEx(String linkRegEx) {
        this.linkRegEx = linkRegEx;
    }

    public List<KeyElement> getKeyElements() {
        return keyElements;
    }

    public void setKeyElements(List<KeyElement> keyElements) {
        this.keyElements = keyElements;
    }
}
