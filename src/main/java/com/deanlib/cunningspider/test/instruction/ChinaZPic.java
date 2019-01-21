package com.deanlib.cunningspider.test.instruction;

import com.deanlib.cunningspider.instruction.Action;
import com.deanlib.cunningspider.instruction.Instruction;
import com.deanlib.cunningspider.instruction.KeyElement;

public class ChinaZPic extends Instruction {

    public ChinaZPic(){
        super("chinazpic",1,"http://sc.chinaz.com/tag_tupian/DongHuaPian.html","");
        addAction(new Action(1,new KeyElement(KeyElement.FIND_TYPE_ATTRIBUTE,"卡通海绵宝宝表情图片",
                "alt",KeyElement.RESULT_TYPE_ATTR,"href"),
                new Action(1,new KeyElement(KeyElement.FIND_TYPE_ATTRIBUTE,"卡通海绵宝宝表情图片",
                "title",KeyElement.RESULT_TYPE_ATTR,"href"))));

    }

}
