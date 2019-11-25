package com.deanlib.cunningspider.test;

import com.deanlib.cunningspider.description.*;
import com.deanlib.cunningspider.rule.Executor;
import com.deanlib.cunningspider.test.description.*;

public class Test {

    public static void main(String[] args) {
        Executor executor = new Executor();
        try {
                Site site = new NET_UC96XX();
            PageResult pageResult = executor.excute(site.getResource(), 10000,null,site.getCoverHeaders());
            if (pageResult!=null && pageResult.getResults()!=null) {
                for (Result result : pageResult.getResults()) {
                    System.out.println(result);
                    //Downloader.download(action.getResult(),new File("C:\\Users\\Dean\\Desktop\\"),"111.jpg");
//                Downloader.download(action.getLastResult(),new File("/Users/dean/Downloads"),"111.jpg");
                }
                System.out.println("下一页信息："+pageResult.getNextPageLink());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
