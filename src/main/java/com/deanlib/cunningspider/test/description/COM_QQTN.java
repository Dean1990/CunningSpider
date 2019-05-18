package com.deanlib.cunningspider.test.description;

import com.deanlib.cunningspider.description.*;

public class COM_QQTN extends Site {

    public COM_QQTN(){

        setResource(new Page("https://www.qqtn.com/article/article_121388_1.html",new Action(new Key(
                null,
                null,
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_ID,"zoom"),
                        new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),
                                new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"src")).setList(true))
        ))));

//        addCoverHeader("Cookie","Hm_lvt_c87959b92e43d58c8a26e9b…8c8a26e9b70e5a6795=1553161397");
//        addCoverHeader("If-None-Match","\"EE6B17A99F92D62BB7F57F2400BA9C21\"");
        addCoverHeader("TE","Trailers");
        addCoverHeader("Accept","image/webp,*/*");
        addCoverHeader("Cache-Control","max-age=0");
        addCoverHeader("Connection","keep-alive");
        addCoverHeader("Referer","https://www.qqtn.com/article/article_121388_1.html");
        addCoverHeader("User-Agent","Mozilla/5.0 (Macintosh; Intel …) Gecko/20100101 Firefox/65.0");
//        addCoverHeader("If-Modified-Since","Tue, 20 Mar 2018 08:37:07 GMT");
        addCoverHeader("Host","pic.qqtn.com");
        addCoverHeader("Accept-Encoding","gzip, deflate, br");
        addCoverHeader("Accept-Language","zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");

    }
}
