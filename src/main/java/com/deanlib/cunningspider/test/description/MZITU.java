package com.deanlib.cunningspider.test.description;

import com.deanlib.cunningspider.description.*;

public class MZITU extends Site {

    public MZITU(){
        setList(new Page("https://www.mzitu.com",new Action(new Key(
                new KeyElement(KeyElement.FIND_TYPE_CLASS,"postlist",null,new KeyElement(KeyElement.FIND_TYPE_ATTRIBUTE,"https:\\/\\/i\\.meizitu\\.net\\/thumbs\\/.+\\.jpg",
                        "data-original",KeyElement.RESULT_TYPE_ATTR,"alt").setList(true)),
                new KeyElement(KeyElement.FIND_TYPE_CLASS,"postlist",null,new KeyElement(KeyElement.FIND_TYPE_TAG,
                        "li",null,KeyElement.RESULT_TYPE_ATTR,"href").setList(true)),
                new KeyElement(KeyElement.FIND_TYPE_CLASS,"postlist",null,new KeyElement(KeyElement.FIND_TYPE_ATTRIBUTE,"https:\\/\\/i\\.meizitu\\.net\\/thumbs\\/.+\\.jpg",
                        "data-original",KeyElement.RESULT_TYPE_ATTR,"data-original").setList(true))
        ))));

        setResource(new Page("https://www.mzitu.com/167298",new Action(new Key(
                new KeyElement(KeyElement.FIND_TYPE_CLASS,"main-image",null,new KeyElement(KeyElement.FIND_TYPE_TAG,
                        "img",null,KeyElement.RESULT_TYPE_ATTR, "alt")),
                null,
                new KeyElement(KeyElement.FIND_TYPE_CLASS,"main-image",null,new KeyElement(KeyElement.FIND_TYPE_TAG,
                        "img",null,KeyElement.RESULT_TYPE_ATTR, "src"))
        ))).setNextPageLink(new KeyElement(KeyElement.FIND_TYPE_CLASS,"pagenavi",null,new KeyElement(KeyElement.FIND_TYPE_TAG,
                "a",null,KeyElement.RESULT_TYPE_ATTR,
                "href").setStart(-1))));
    }
}
