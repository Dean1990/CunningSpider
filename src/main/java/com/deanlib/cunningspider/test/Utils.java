package com.deanlib.cunningspider.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Utils {

    public static void main(String[] args) {
        String reqHeader = "Accept\t\n" +
                "image/webp,*/*\n" +
                "Accept-Encoding\t\n" +
                "gzip, deflate, br\n" +
                "Accept-Language\t\n" +
                "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2\n" +
                "Cache-Control\t\n" +
                "max-age=0\n" +
                "Connection\t\n" +
                "keep-alive\n" +
                "Cookie\t\n" +
                "Hm_lvt_c87959b92e43d58c8a26e9b…8c8a26e9b70e5a6795=1553161397\n" +
                "Host\t\n" +
                "pic.qqtn.com\n" +
                "If-Modified-Since\t\n" +
                "Tue, 20 Mar 2018 08:37:07 GMT\n" +
                "If-None-Match\t\n" +
                "\"EE6B17A99F92D62BB7F57F2400BA9C21\"\n" +
                "Referer\t\n" +
                "https://www.qqtn.com/article/article_121388_1.html\n" +
                "TE\t\n" +
                "Trailers\n" +
                "User-Agent\t\n" +
                "Mozilla/5.0 (Macintosh; Intel …) Gecko/20100101 Firefox/65.0";
        String code = createCode_addCoverHeader(requestHeaderTransform(reqHeader));
        System.out.println(code);
    }

    public static String createCode_addCoverHeader(Map<String,String> headerMap){
        StringBuilder sb = new StringBuilder();
        if (headerMap!=null){
            Set<Map.Entry<String, String>> entries = headerMap.entrySet();
            for (Map.Entry<String,String> entry:entries){
                sb.append("addCoverHeader(\""+entry.getKey()+"\",\""+entry.getValue()+"\");\n");
            }
        }

        return sb.toString();
    }

    public static Map<String,String> requestHeaderTransform(String reqHeader){
        //Accept
        //image/webp,*/*
        //Accept-Encoding
        //gzip, deflate, br
        //Accept-Language
        //zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2
        //Cache-Control
        //max-age=0
        //Connection
        //keep-alive
        //Host
        //img.gsdlcn.com
        //Referer
        //https://www.7160.com/rentiyishu/59577/
        //User-Agent
        //Mozilla/5.0 (Windows NT 10.0; …) Gecko/20100101 Firefox/65.0


        Map<String,String> headerMap = new HashMap<>();

        reqHeader = reqHeader.replace("\t\n","|");
        String[] split = reqHeader.split("\n");
        for (String str:split){
            String[] split1 = str.split("\\|");
//            System.out.println(split1[0]+" - " +split1[1]);
            headerMap.put(split1[0],split1[1]);
        }

        return headerMap;
    }
}
