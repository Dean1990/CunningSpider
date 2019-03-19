package com.deanlib.cunningspider.test.description;

import com.deanlib.cunningspider.description.*;

public class COM_7160 extends Site {

    public COM_7160(){
        setList(new Page("https://www.7160.com/xiaohua/",new Action(new Key(
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"news_bom-left"),
                        new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"li"),
                                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"a"),
                                        new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"title"))).setList(true)),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"news_bom-left"),
                        new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"li"),
                                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"a"),
                                        new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"href"))).setList(true)),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"news_bom-left"),
                        new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"li"),
                                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),
                                        new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"src"))).setList(true))
        ))));
        setResource(new Page("https://www.7160.com/rentiyishu/59577/",new Action(new Key(
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"picsbox picsboxcenter"),
                        new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),
                                new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"alt"))),
                null,
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"picsbox picsboxcenter"),
                        new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),
                                new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"src")))
        ))).setNextPageLink(new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"itempage"),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TEXT,"下一页"),
                        new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"href")))));

        setRelated(new Page("https://www.7160.com/rentiyishu/59577/",new Action(new Key(
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"jingxuanpic"),
                        new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"a"),
                                new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"title")).setList(true)),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"jingxuanpic"),
                        new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"a"),
                                new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"href")).setList(true)),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"jingxuanpic"),
                        new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),
                                new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"src")).setList(true))
        ))));

        addCoverHeader("Accept","image/webp,*/*");
        addCoverHeader("Cache-Control","max-age=0");
        addCoverHeader("Connection","keep-alive");
        addCoverHeader("Referer","https://www.7160.com");
        addCoverHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; …) Gecko/20100101 Firefox/65.0");
        addCoverHeader("Host","img.gsdlcn.com");
        addCoverHeader("Accept-Encoding","gzip, deflate, br");
        addCoverHeader("Accept-Language","zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
    }
}
