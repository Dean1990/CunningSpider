package com.deanlib.cunningspider.test.description;

import com.deanlib.cunningspider.description.*;

public class COM_27220 extends Site {

    public COM_27220(){
//        setList(new Page("https://www.27270.com/zt/motezt/",new Action(new Key(
//                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"span")
//                ,new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"a")
//                        ,new KeyElementResult(KeyElementResult.RESULT_TYPE_TEXT))
//                        ).setList(true)
//                ,new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"span")
//                ,new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"a")
//                ,new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"href")))
//                .setList(true)
//        ))));
        setList(new Page("https://www.27270.com/zt/motezt/",new Action(new Key(
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_ATTRIBUTE,"href","\\/ent\\/[\\w\\/]+\\.html")
                        ,new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"a")
                        ,new KeyElementResult(KeyElementResult.RESULT_TYPE_TEXT))
                ).setList(true)
                ,new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"span")
                ,new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"a")
                ,new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"href")))
                .setList(true)
        ))));
    }
}
