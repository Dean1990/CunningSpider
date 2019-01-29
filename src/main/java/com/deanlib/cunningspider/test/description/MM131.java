package com.deanlib.cunningspider.test.description;

import com.deanlib.cunningspider.description.*;

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
        setResource(new Page(new Action(new Key(new KeyElement(KeyElement.FIND_TYPE_CLASS,"content-pic",null,
                new KeyElement(KeyElement.FIND_TYPE_TAG,"img",null,
                        KeyElement.RESULT_TYPE_ATTR,"src"))))));

        setList(new Page("http://www.mm131.com/",new Action(new Key(new KeyElement(KeyElement.FIND_TYPE_ATTRIBUTE,
                "http:\\/\\/www\\.mm131\\.com\\/\\w+\\/\\d+\\.html","href",KeyElement.RESULT_TYPE_TEXT,null),
                new KeyElement(KeyElement.FIND_TYPE_ATTRIBUTE,
                        "http:\\/\\/www\\.mm131\\.com\\/\\w+\\/\\d+\\.html","href",
                        KeyElement.RESULT_TYPE_ATTR,"href"),new KeyElement(KeyElement.FIND_TYPE_ATTRIBUTE,
                "http:\\/\\/www\\.mm131\\.com\\/\\w+\\/\\d+\\.html","href",
                new KeyElement(KeyElement.FIND_TYPE_TAG,"img",null,KeyElement.RESULT_TYPE_ATTR,"src"))))));

    }
}
