package com.deanlib.cunningspider.test;

import com.alibaba.fastjson.JSON;
import com.deanlib.cunningspider.Downloader;
import com.deanlib.cunningspider.instruction.Action;
import com.deanlib.cunningspider.instruction.Instruction;
import com.deanlib.cunningspider.rule.Executor;
import com.deanlib.cunningspider.test.instruction.ChinaZPic;
import com.deanlib.cunningspider.test.instruction.MM131;

import java.io.File;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        Executor executor = new Executor();
        try {
            Instruction instruction = new ChinaZPic();
            executor.excute(instruction,10000);
            for (Action action : instruction.getActions()){
                System.out.println(action.getLastResult());
                //Downloader.download(action.getResult(),new File("C:\\Users\\Dean\\Desktop\\"),"111.jpg");
//                Downloader.download(action.getLastResult(),new File("/Users/dean/Downloads"),"111.jpg");
            }
            String str = JSON.toJSONString(instruction);
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
