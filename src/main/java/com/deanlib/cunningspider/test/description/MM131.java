package com.deanlib.cunningspider.test.description;

import com.deanlib.cunningspider.description.*;

import java.util.ArrayList;
import java.util.List;

public class MM131 extends Site {
    public MM131() {
//        setCatalog(new Page("http://www.mm131.com/",new Action(
//                new Key(new KeyElement(KeyElement.FIND_TYPE_CLASS,"nav",null,
//                new KeyElement(KeyElement.FIND_TYPE_TAG,"a",null,
//                        KeyElement.RESULT_TYPE_TEXT,null)),
//                new KeyElement(KeyElement.FIND_TYPE_CLASS,"nav",null,
//                new KeyElement(KeyElement.FIND_TYPE_TAG,"a",null,
//                        KeyElement.RESULT_TYPE_ATTR,"href"))),1,0)));
//        setList(new Page(new Action(new Key(new KeyElement(KeyElement.FIND_TYPE_CLASS,"list-left public-box",null,
//                new KeyElement(KeyElement.FIND_TYPE_ATTRIBUTE,"_blank","target",
//                        new KeyElement(KeyElement.FIND_TYPE_TAG,"img",null,
//                                KeyElement.RESULT_TYPE_ATTR,"alt")))
//                ,new KeyElement(KeyElement.FIND_TYPE_CLASS,
//                "list-left public-box",null,
//                new KeyElement(KeyElement.FIND_TYPE_ATTRIBUTE,"_blank",
//                        "target",KeyElement.RESULT_TYPE_ATTR,"href"))))));
        setResource(new Page("http://www.mm131.com/xinggan/2478.html",new Action(new Key(new KeyElement(KeyElement.FIND_TYPE_CLASS,"content-pic",null,
                new KeyElement(KeyElement.FIND_TYPE_TAG,"img",null,
                        KeyElement.RESULT_TYPE_ATTR,"alt")),null,
                new KeyElement(KeyElement.FIND_TYPE_CLASS,"content-pic",null,
                new KeyElement(KeyElement.FIND_TYPE_TAG,"img",null,
                        KeyElement.RESULT_TYPE_ATTR,"src"))))).setNextPageLink(new KeyElement(KeyElement.FIND_TYPE_TEXT,
                "下一页",null,KeyElement.RESULT_TYPE_ATTR,"href")));

        setList(new Page("http://www.mm131.com/",new Action(new Key(
                new KeyElement(KeyElement.FIND_TYPE_ATTRIBUTE,
                "http:\\/\\/www\\.mm131\\.com\\/\\w+\\/\\d+\\.html","href"
                        ,KeyElement.RESULT_TYPE_TEXT,null),
                new KeyElement(KeyElement.FIND_TYPE_ATTRIBUTE,
                        "http:\\/\\/www\\.mm131\\.com\\/\\w+\\/\\d+\\.html","href",
                        KeyElement.RESULT_TYPE_ATTR,"href")
                ,new KeyElement(KeyElement.FIND_TYPE_ATTRIBUTE,
                "http:\\/\\/www\\.mm131\\.com\\/\\w+\\/\\d+\\.html","href",
                new KeyElement(KeyElement.FIND_TYPE_TAG,"img",null,
                        KeyElement.RESULT_TYPE_ATTR,"src"))).isList())));
        setRelated(new Page(new Action(new Key(new KeyElement(KeyElement.FIND_TYPE_ID,"opic",null,
                new KeyElement(KeyElement.FIND_TYPE_TAG,"img",null,KeyElement.RESULT_TYPE_ATTR,"alt")),
                new KeyElement(KeyElement.FIND_TYPE_ID,"opic",null,new KeyElement(KeyElement.FIND_TYPE_TAG,"a",null,
                        KeyElement.RESULT_TYPE_ATTR,"href")),new KeyElement(KeyElement.FIND_TYPE_ID,"opic",null,new KeyElement(KeyElement.FIND_TYPE_TAG,"img",null,
                        KeyElement.RESULT_TYPE_ATTR,"src"))))));

        addCoverHeader("Referer","http://www.mm131.com");
        addCoverHeader("Accept", "image/webp,*/*");
        addCoverHeader("Accept-Encoding","gzip, deflate");
        addCoverHeader("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
        addCoverHeader("Connection", "keep-alive");
        addCoverHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0");
        addCoverHeader("Host", "img1.mm131.me");
    }
}
