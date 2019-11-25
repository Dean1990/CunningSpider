package com.deanlib.cunningspider.test.description;

import com.deanlib.cunningspider.description.*;

public class COM_ZDQX extends Site {

    public COM_ZDQX(){
        setList(new Page("http://www.zdqx.com/qingchun/",new Action(new Key(
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"listbox"),new KeyElement(
                        new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"a"),new KeyElementResult(
                                KeyElementResult.RESULT_TYPE_ATTR,"title")
                )),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"listbox"),new KeyElement(
                        new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"a"),new KeyElementResult(
                        KeyElementResult.RESULT_TYPE_ATTR,"href")
                )),
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"listbox"),new KeyElement(
                        new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),new KeyElementResult(
                        KeyElementResult.RESULT_TYPE_ATTR,"src")
                ))
        ).setList(true))));
        setResource(new Page("http://www.zdqx.com/sjbz/84774.html",new Action(new Key(
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"main_center_img"),new KeyElement(
                        new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),
                                new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"alt")
                )),null,
                new KeyElement(new KeyElementFind(KeyElementFind.FIND_TYPE_CLASS,"main_center_img"),new KeyElement(
                        new KeyElementFind(KeyElementFind.FIND_TYPE_TAG,"img"),
                        new KeyElementResult(KeyElementResult.RESULT_TYPE_ATTR,"src")
                ))
        ))).setNextPageLink(new KeyElement()));//todo
    }
}
