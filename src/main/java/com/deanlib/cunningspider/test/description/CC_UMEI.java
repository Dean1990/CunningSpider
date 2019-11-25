package com.deanlib.cunningspider.test.description;

import com.deanlib.cunningspider.description.*;

public class CC_UMEI extends Site {

    public CC_UMEI() {
        setList(new Page("http://www.umei.cc/bizhitupian/meinvbizhi/",new Action(new Key(
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"ListTit"),new KeyElementResult(KeyElementResult.RESULT_TYPE_TEXT)),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"TypeBigPics"),new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"href")),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"TypeBigPics"),new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"src")))
        ).setList(true))));

        setResource(new Page("http://www.umei.cc/p/gaoqing/xiuren_VIP/190593.htm",new Action(new Key(
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_ID,"ArticleId0"),new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"alt"))),
                null,
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_ID,"ArticleId0"),new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"src")))
        ))).setNextPageLink(new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"NewPages"),new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TEXT,"下一页"),new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"href")))));

        setRelated(new Page("http://www.umei.cc/p/gaoqing/xiuren_VIP/190593.htm",new Action(new Key(
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"Pix-box"),new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"title")).setRelationship(new Relationship(Relationship.RELATION_SENIOR)),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"Pix-box"),new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"href")).setRelationship(new Relationship(Relationship.RELATION_SENIOR)),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"Pix-box"),new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"src")))
        ).setList(true))));

        addCoverHeader("Accept","text/html,application/xhtml+xm…plication/xml;q=0.9,*/*;q=0.8");
        addCoverHeader("Upgrade-Insecure-Requests","1");
        addCoverHeader("Connection","keep-alive");
        addCoverHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; …) Gecko/20100101 Firefox/69.0");
        addCoverHeader("Host","i1.zhiaigou.com");
        addCoverHeader("Accept-Encoding","gzip, deflate");
        addCoverHeader("Accept-Language","zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");

    }
}
