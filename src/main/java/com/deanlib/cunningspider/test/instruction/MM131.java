package com.deanlib.cunningspider.test.instruction;

import com.deanlib.cunningspider.instruction.Action;
import com.deanlib.cunningspider.instruction.Instruction;
import com.deanlib.cunningspider.instruction.KeyElement;

import java.util.ArrayList;
import java.util.List;

public class MM131 extends Instruction {
    public MM131() {
        super("mm131",1,"http://www.mm131.com/xinggan/3378_25.html","测试单页");
        List<Action> actions = new ArrayList<>();
        KeyElement keyElement = new KeyElement(KeyElement.FIND_TYPE_CLASS,"content-pic",null
                ,new KeyElement(KeyElement.FIND_TYPE_TAG,"img",null,KeyElement.RESULT_TYPE_ATTR,"src"));
        actions.add(new Action(1,keyElement));
        setActions(actions);
    }
}
