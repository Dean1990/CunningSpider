package com.deanlib.cunningspider.test.description;

import com.deanlib.cunningspider.description.*;

public class ChinaZPic extends Site {
    public ChinaZPic() {
        setResource(new Page("http://sc.chinaz.com/tag_tupian/DongHuaPian.html"
                ,new Action(new Key(new KeyElement(KeyElement.FIND_TYPE_ATTRIBUTE,"卡通海绵宝宝表情图片",
                "alt",KeyElement.RESULT_TYPE_ATTR,"href")))
                ,new Page(new Action(new Key(new KeyElement(KeyElement.FIND_TYPE_CLASS,"img_open",null,
                new KeyElement(KeyElement.FIND_TYPE_ATTRIBUTE,"卡通海绵宝宝表情图片",
                        "title",KeyElement.RESULT_TYPE_ATTR,"href")))))));
    }


//    public ChinaZPic(){
//        super("chinazpic",1,"http://sc.chinaz.com/tag_tupian/DongHuaPian.html","");
//        addAction(new Action(1, new Action(1,new KeyElement(KeyElement.FIND_TYPE_ATTRIBUTE,"卡通海绵宝宝表情图片",
//                "title",KeyElement.RESULT_TYPE_ATTR,"href")),new KeyElement(KeyElement.FIND_TYPE_ATTRIBUTE,"卡通海绵宝宝表情图片",
//                "alt",KeyElement.RESULT_TYPE_ATTR,"href")));
//
//    }

}
