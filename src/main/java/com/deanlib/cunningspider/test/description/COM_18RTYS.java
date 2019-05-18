package com.deanlib.cunningspider.test.description;

import com.deanlib.cunningspider.description.*;

public class COM_18RTYS extends Site {

    public COM_18RTYS(){
        setList(new Page("http://www.18rtys.com/",new Action(new Key(
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"i_list list_n1"),
                        new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),
                                new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"alt"))).setList(true),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"i_list list_n1"),
                        new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"a"),
                                new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"href"))).setList(true),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"i_list list_n1"),
                        new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),
                                new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"data-original"))).setList(true)
        ))));

        setResource(new Page("http://www.18rtys.com/omrtys/1043.html",new Action(new Key(
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"content_left"),
                        new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"p"),
                        new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),
                                new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"alt")).setList(true))),
                null,
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"content_left"),
                        new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"p"),
                        new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),
                                new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"src")).setList(true)))
        ))));
        setRelated(new Page("http://www.18rtys.com/omrtys/1043.html",new Action(new Key(
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"i_list list_n1"),
                        new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),
                                new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"alt"))).setList(true),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"i_list list_n1"),
                        new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"a"),
                                new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"href"))).setList(true),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"i_list list_n1"),
                        new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),
                                new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"data-original"))).setList(true)
        ))));

//        addCoverHeader("Cookie","Hm_lvt_783b68ea370f805c12b86d3…5c12b86d386ceda3a8=1558161309");
//        addCoverHeader("If-None-Match","5cdf8728-162ac");
        addCoverHeader("Accept","image/webp,*/*");
        addCoverHeader("Cache-Control","max-age=0");
        addCoverHeader("Connection","keep-alive");
        addCoverHeader("Referer","http://www.18rtys.com/omrtys/1040.html");
        addCoverHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; …) Gecko/20100101 Firefox/66.0");
//        addCoverHeader("If-Modified-Since","Sat, 18 May 2019 04:16:40 GMT");
        addCoverHeader("Host","www.18rtys.com");
        addCoverHeader("Accept-Encoding","gzip, deflate");
        addCoverHeader("Accept-Language","zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
    }
}
