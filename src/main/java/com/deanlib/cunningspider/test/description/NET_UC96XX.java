package com.deanlib.cunningspider.test.description;

import com.deanlib.cunningspider.description.*;

public class NET_UC96XX extends Site {

    public NET_UC96XX(){
        setList(new Page("https://www.520mm.co/category/zhaifuli/",new Action(new Key(
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"excerpt excerpt-one"),new KeyElement(
                        new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"h2"),new KeyElementResult(KeyElementResult.RESULT_TYPE_TEXT)
                ).setRelationship(new Relationship(Relationship.RELATION_JUNIOR))),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"excerpt excerpt-one"),new KeyElement(
                        new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"h2"),new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"href")
                ).setRelationship(new Relationship(Relationship.RELATION_JUNIOR))),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"excerpt excerpt-one"),new KeyElement(
                        new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"src")
                ))
        ).setList(true))));
        setResource(new Page("https://www.520mm.co/luyilu/2018/1016/892/5/",new Action(new Key(
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"article-content"),new KeyElement(
                        new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"alt")
                ).setList(true)),null,
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"article-content"),new KeyElement(
                        new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"src")
                ).setList(true))
        ))).setNextPageLink(
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"next-page"),
                new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"href")).setRelationship(new Relationship(Relationship.RELATION_JUNIOR))));
        setRelated(new Page("https://www.520mm.co/luyilu/2018/1016/892/5/",new Action(new Key(
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"relates"),new KeyElement(
                        new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"thumb"),new KeyElementResult(KeyElementResult.RESULT_TYPE_TEXT)
                ).setRelationship(new Relationship(Relationship.RELATION_SENIOR)).setList(true)),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"relates"),new KeyElement(
                        new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"thumb"),new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"href")
                ).setRelationship(new Relationship(Relationship.RELATION_SENIOR)).setList(true)),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"relates"),new KeyElement(
                        new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"thumb"),new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"src")
                ).setList(true))
        ))));

        addCoverHeader("Accept","image/webp,*/*");
        addCoverHeader("Connection","keep-alive");
        addCoverHeader("Referer","https://sjd226.com/");
        addCoverHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; …) Gecko/20100101 Firefox/69.0");
        addCoverHeader("Host","www.images.zhaofulipic.com:8819");
        addCoverHeader("Accept-Encoding","gzip, deflate, br");
        addCoverHeader("Accept-Language","zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
    }
}
