package com.deanlib.cunningspider.test;

import com.alibaba.fastjson.JSON;
import com.deanlib.cunningspider.description.*;
import com.deanlib.cunningspider.rule.Executor;
import com.deanlib.cunningspider.test.description.MM131;
import com.deanlib.cunningspider.test.description.MZITU;

public class Test {

    public static void main(String[] args) {
        Executor executor = new Executor();
        try {
            Site site = new MZITU();
            PageResult pageResult = executor.excute(site.getResource(), 10000,null,site.getCoverHeaders());
            if (pageResult!=null && pageResult.getResults()!=null) {
                for (Result result : pageResult.getResults()) {
                    System.out.println(result);
                    //Downloader.download(action.getResult(),new File("C:\\Users\\Dean\\Desktop\\"),"111.jpg");
//                Downloader.download(action.getLastResult(),new File("/Users/dean/Downloads"),"111.jpg");
                }
                System.out.println(pageResult.getNextPageLink());

            }
            String str = JSON.toJSONString(site);
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
