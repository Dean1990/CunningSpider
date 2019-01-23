package com.deanlib.cunningspider.test;

import com.alibaba.fastjson.JSON;
import com.deanlib.cunningspider.description.Action;
import com.deanlib.cunningspider.description.Page;
import com.deanlib.cunningspider.description.Result;
import com.deanlib.cunningspider.description.Site;
import com.deanlib.cunningspider.rule.Executor;
import com.deanlib.cunningspider.test.description.ChinaZPic;
import com.deanlib.cunningspider.test.description.MM131;

import java.io.IOException;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Executor executor = new Executor();
        try {
            Site site = new ChinaZPic();
            List<Result> results = executor.excute(site.getDetail(), 10000);
            for (Result result : results){
                System.out.println(result);
                //Downloader.download(action.getResult(),new File("C:\\Users\\Dean\\Desktop\\"),"111.jpg");
//                Downloader.download(action.getLastResult(),new File("/Users/dean/Downloads"),"111.jpg");
            }
            String str = JSON.toJSONString(site);
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
