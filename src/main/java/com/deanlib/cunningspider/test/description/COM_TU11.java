package com.deanlib.cunningspider.test.description;

import com.deanlib.cunningspider.description.*;

public class COM_TU11 extends Site {

    public COM_TU11(){
        setList(new Page("http://www.tu11.com/shenghuomeinvzipai/",new Action(new Key(
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"biaoti center-block text-center"),new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"title")),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"biaoti center-block text-center"),new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"href")),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"img-responsive picheng"),new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"src"))
        ).setList(true))));

        setResource(new Page("http://www.tu11.com/shenghuomeinvzipai/2017/7955.html",new Action(new Key(
                null,null,
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"nry"),new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"src")).setList(true))
        ))).setNextPageLink(new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"list-inline text-center nryfy"),new KeyElement(
                new KeyElementFind(KeyElementFind.FIND_TYPE_TEXT,"下一页"),new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"href")
        ))));

        setRelated(new Page("http://www.tu11.com/shenghuomeinvzipai/2017/7955.html",new Action(new Key(
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"picbox1"),new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"spb shupic1"),new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"title")).setList(true)),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"picbox1"),new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"href")).setRelationship(new Relationship(Relationship.RELATION_SENIOR)).setList(true)),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"picbox1"),new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"src")).setList(true))
        ))));

        addCoverHeader("Accept","image/webp,*/*");
        addCoverHeader("Cache-Control","max-age=0");
        addCoverHeader("Connection","keep-alive");
        addCoverHeader("Referer","http://www.tu11.com/shenghuomeinvzipai/2018/10861_18.html");
        addCoverHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; …) Gecko/20100101 Firefox/67.0");
        addCoverHeader("Host","img15.haotuwu.com:8080");
        addCoverHeader("Accept-Encoding","gzip, deflate");
        addCoverHeader("Accept-Language","zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
    }
}
