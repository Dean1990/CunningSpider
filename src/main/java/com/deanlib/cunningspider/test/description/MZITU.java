package com.deanlib.cunningspider.test.description;

import com.deanlib.cunningspider.description.*;

public class MZITU extends Site {

    public MZITU(){
        setList(new Page(new Action(new Key(new KeyElement(KeyElement.FIND_TYPE_ATTRIBUTE,"https:\\/\\/i\\.meizitu\\.net\\/thumbs\\/.+\\.jpg",
                "data-original",KeyElement.RESULT_TYPE_ATTR,"data-original"),new KeyElement()))));
    }
}
