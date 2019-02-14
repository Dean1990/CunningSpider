package com.deanlib.cunningspider.test.description;

import com.deanlib.cunningspider.description.*;

public class MZITU extends Site {

    public MZITU(){
        setList(new Page("https://www.mzitu.com",new Action(new Key(
                new KeyElement(KeyElement.FIND_TYPE_CLASS,"postlist",null,new KeyElement(KeyElement.FIND_TYPE_ATTRIBUTE,"https:\\/\\/i\\.meizitu\\.net\\/thumbs\\/.+\\.jpg",
                        "data-original",KeyElement.RESULT_TYPE_ATTR,"alt").setList(true)),
                new KeyElement(KeyElement.FIND_TYPE_CLASS,"postlist",null,new KeyElement(KeyElement.FIND_TYPE_TAG,
                        "li",null,new KeyElement(KeyElement.FIND_TYPE_TAG,"a",null,KeyElement.RESULT_TYPE_ATTR,"href")).setList(true)),
                new KeyElement(KeyElement.FIND_TYPE_CLASS,"postlist",null,new KeyElement(KeyElement.FIND_TYPE_ATTRIBUTE,"https:\\/\\/i\\.meizitu\\.net\\/thumbs\\/.+\\.jpg",
                        "data-original",KeyElement.RESULT_TYPE_ATTR,"data-original").setList(true))
        ))));

        setResource(new Page("https://www.mzitu.com/167298/44",new Action(new Key(
                new KeyElement(KeyElement.FIND_TYPE_CLASS,"main-image",null,new KeyElement(KeyElement.FIND_TYPE_TAG,
                        "img",null,KeyElement.RESULT_TYPE_ATTR, "alt")),
                null,
                new KeyElement(KeyElement.FIND_TYPE_CLASS,"main-image",null,new KeyElement(KeyElement.FIND_TYPE_TAG,
                        "img",null,KeyElement.RESULT_TYPE_ATTR, "src"))
        ))).setNextPageLink(new KeyElement(KeyElement.FIND_TYPE_CLASS,"pagenavi",null,new KeyElement(KeyElement.FIND_TYPE_TEXT,
                "下一页",null,KeyElement.RESULT_TYPE_ATTR,
                "href").setRelationship(new Relationship(Relationship.RELATION_SENIOR)))));

        addCoverHeader("Referer","https://www.mzitu.com");
        addCoverHeader("Accept", "image/webp,*/*");
        addCoverHeader("Accept-Encoding","gzip, deflate, br");
        addCoverHeader("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
        addCoverHeader("Connection", "keep-alive");
        addCoverHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0");
        addCoverHeader("Host", "i.meizitu.net");
        addCoverHeader("TE", "Trailers");
    }
}
