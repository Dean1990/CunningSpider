package com.deanlib.cunningspider.test.description;

import com.deanlib.cunningspider.description.*;

public class COM_111GEI extends Site {

    public COM_111GEI(){
        setList(new Page("https://111gei.com/p01/index.html",new Action(new Key(
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_ID,"colList"),
                        new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"li"),
                                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"h2"),
                                        new KeyElementResult(KeyElementResult.RESULT_TYPE_TEXT))).setList(true)),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_ID,"colList"),
                        new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"li"),
                                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"a"),
                                        new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"href"))).setList(true)))
        )));

        setResource(new Page("https://111gei.com/htm/2020/5/7/p01/465175.html",new Action(new Key(
                null,null,
            new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"main-content"),
                    new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),
                            new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"src")).setList(true))
        ))));
    }
}
