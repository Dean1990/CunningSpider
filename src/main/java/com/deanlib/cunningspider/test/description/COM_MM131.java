package com.deanlib.cunningspider.test.description;

import com.deanlib.cunningspider.description.*;

import java.util.ArrayList;
import java.util.List;

public class COM_MM131 extends Site {
    public COM_MM131() {
        setResource(new Page("http://www.mm131.com/xinggan/2478.html",new Action(new Key(new KeyElement(
                new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"content-pic"),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),
                        new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"alt"))),null,
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"content-pic"),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),
                        new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"src"))))))
                .setNextPageLink(new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TEXT,
                "下一页"),new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"href"))));

        setList(new Page("http://www.mm131.com/",new Action(new Key(
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_ATTRIBUTE,"href",
                        "http:\\/\\/www\\.mm131\\.com\\/\\w+\\/\\d+\\.html")
                        ,new KeyElementResult(KeyElementResult.RESULT_TYPE_TEXT)),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_ATTRIBUTE,"href",
                        "http:\\/\\/www\\.mm131\\.com\\/\\w+\\/\\d+\\.html"),
                        new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"href")) ,
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_ATTRIBUTE,"href",
                "http:\\/\\/www\\.mm131\\.com\\/\\w+\\/\\d+\\.html"),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),
                        new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"src")))).setList(true))));
        setRelated(new Page("http://www.mm131.com/xinggan/2478.html",new Action(new Key(new KeyElement(
                new KeyElementFind(KeyElementFind.FIND_TYPE_ID,"opic"),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),
                        new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"alt")).setList(true)),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_ID,"opic"),new KeyElement(
                        new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"a"),
                        new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"href")).setList(true)),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_ID,"opic"),
                        new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),
                new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"src")).setList(true))))));

        addCoverHeader("Referer","http://www.mm131.com");
        addCoverHeader("Accept", "image/webp,*/*");
        addCoverHeader("Accept-Encoding","gzip, deflate");
        addCoverHeader("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
        addCoverHeader("Connection", "keep-alive");
        addCoverHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0");
        addCoverHeader("Host", "img1.mm131.me");
    }
}
