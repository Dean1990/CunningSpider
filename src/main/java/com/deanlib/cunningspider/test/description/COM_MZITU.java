package com.deanlib.cunningspider.test.description;

import com.deanlib.cunningspider.description.*;

public class COM_MZITU extends Site {

    public COM_MZITU(){
        setList(new Page("https://www.mzitu.com",new Action(new Key(
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"postlist"),
                        new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_ATTRIBUTE,"data-original","https:\\/\\/i\\.meizitu\\.net\\/thumbs\\/.+\\.jpg"),
                                new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"alt")).setList(true)),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"postlist"),new KeyElement(
                        new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,
                        "li"),new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"a"),
                        new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"href"))).setList(true)),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"postlist"),
                        new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_ATTRIBUTE,"data-original","https:\\/\\/i\\.meizitu\\.net\\/thumbs\\/.+\\.jpg"),
                                new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"data-original")).setList(true))
        ))));

        setResource(new Page("https://www.mzitu.com/167298/44",new Action(new Key(
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"main-image"),new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,
                        "img"),new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR, "alt"))),
                null,
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"main-image"),new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,
                        "img"),new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR, "src")))
        ))).setNextPageLink(new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"pagenavi"),new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TEXT,
                "下一页"),new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,
                "href")).setRelationship(new Relationship(Relationship.RELATION_SENIOR)))));

        setRelated(new Page("https://www.mzitu.com/169122",new Action(new Key(new KeyElement(
                new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"widgets_like"),new KeyElement(
                        new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"a"),
                new KeyElementResult(KeyElementResult.RESULT_TYPE_TEXT)
        ).setList(true)),new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"widgets_like"),new KeyElement(
                new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"a"),
                new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"href")
        ).setList(true))))));
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
