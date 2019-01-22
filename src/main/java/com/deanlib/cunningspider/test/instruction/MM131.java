package com.deanlib.cunningspider.test.instruction;

import com.deanlib.cunningspider.instruction.Action;
import com.deanlib.cunningspider.instruction.Instruction;
import com.deanlib.cunningspider.instruction.KeyElement;

import java.util.ArrayList;
import java.util.List;

public class MM131 extends Instruction {
    public MM131() {
        super("mm131",1,"http://www.mm131.com","");
        addAction(new Action(1,1,0,
                new Action(1,
                        new Action(1,new KeyElement(KeyElement.FIND_TYPE_CLASS,"content-pic",null,
                                new KeyElement(KeyElement.FIND_TYPE_TAG,"img",null,KeyElement.RESULT_TYPE_ATTR,"src")))
                        ,true,new KeyElement(KeyElement.FIND_TYPE_CLASS,"list-left public-box",null,
                        new KeyElement(KeyElement.FIND_TYPE_ATTRIBUTE,"_blank","target",KeyElement.RESULT_TYPE_ATTR,"href")))
                ,false,new KeyElement(KeyElement.FIND_TYPE_CLASS,"nav",null,
                new KeyElement(KeyElement.FIND_TYPE_TAG,"a",null,KeyElement.RESULT_TYPE_ATTR,"href"))));
    }
}
