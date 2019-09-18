package com.deanlib.cunningspider.test.description;

import com.deanlib.cunningspider.description.*;

public class COM_MEITULU extends Site {

    public COM_MEITULU(){
        setList(new Page("https://www.meitulu.com/",new Action(new Key(
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"p_title"),
                        new KeyElementResult(KeyElementResult.RESULT_TYPE_TEXT))
                        .setRelationship(new Relationship(Relationship.RELATION_JUNIOR)),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"p_title"),
                        new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"href"))
                        .setRelationship(new Relationship(Relationship.RELATION_JUNIOR)),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"p_title"),
                        new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),
                                new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"src")))
                        .setRelationship(new Relationship(Relationship.RELATION_SENIOR))
        ).setList(true))));
        setResource(new Page("https://www.meitulu.com/item/6713.html",new Action(new Key(
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"content_img"),
                        new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"alt")).setList(true),
                null,
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"content_img"),
                        new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"src")).setList(true)
        ))).setNextPageLink(new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_ID,"pages"),new KeyElement(
                new KeyElementFind(KeyElementFind.FIND_TYPE_TEXT,"下一页"),new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"href")
        ))));
        setRelated(new Page("https://www.meitulu.com/item/6713.html",new Action(new Key(
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"p_title"),
                        new KeyElementResult(KeyElementResult.RESULT_TYPE_TEXT))
                        .setRelationship(new Relationship(Relationship.RELATION_JUNIOR)),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"p_title"),
                        new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"href"))
                        .setRelationship(new Relationship(Relationship.RELATION_JUNIOR)),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"p_title"),
                        new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),
                                new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"src")))
                        .setRelationship(new Relationship(Relationship.RELATION_SENIOR))
        ).setList(true))));

        addCoverHeader("Accept","image/webp,*/*");
        addCoverHeader("Connection","keep-alive");
        addCoverHeader("Referer","https://www.meitulu.com/");
        addCoverHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; …) Gecko/20100101 Firefox/69.0");
        addCoverHeader("Host","mtl.ttsqgs.com");
        addCoverHeader("Accept-Encoding","gzip, deflate, br");
        addCoverHeader("Accept-Language","zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
    }
}
