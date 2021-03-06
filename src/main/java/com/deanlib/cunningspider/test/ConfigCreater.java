package com.deanlib.cunningspider.test;

import com.alibaba.fastjson.JSON;
import com.deanlib.cunningspider.description.Site;
import com.deanlib.cunningspider.test.app.AppInfo;
import com.deanlib.cunningspider.test.app.Config;
import com.deanlib.cunningspider.test.description.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfigCreater {

    static String[] belleUrls = {
            "http://www.umei.cc/p/gaoqing/xiuren_VIP/",
            "https://www.7160.com/rentiyishu/",
            "http://www.mm131.com/",
            "https://www.mzitu.com",
            "http://www.18rtys.com/",
            "http://www.tu11.com/meituisiwatupian/",
            "http://www.tu11.com/xingganmeinvxiezhen/",
            "http://www.tu11.com/gaoxiaotupian/",
            "http://www.tu11.com/qingchunmeinvxiezhen/",
            "https://sjd226.com/zhaifuli/",
            "https://sjd226.com/zhainanshe/",
            "https://sjd226.com/luyilu/",
            "https://sjd226.com/MiiTao/",
            "https://96ucqq.com/tuinvlang/",
            "https://96ucqq.com/meiyuanguan/",
            "https://96ucqq.com/youguowang/",
            "https://96ucqq.com/AISSaisi/",
            "https://96ucqq.com/meiyanshe/",
            "https://96ucqq.com/luyilu/",
            "https://qqa92.com/zhaifuli/",
            "https://qqa92.com/luyilu/",
            "https://qqa92.com/zhainanshe/",
            "https://qqa92.com/MiiTao/",
//            "https://www.520mm.co/category/zhaifuli/",
//            "https://www.520mm.co/category/zhainanshe/",
//            "https://www.520mm.co/category/luyilu/",
//            "https://www.520mm.co/category/luyilu/",
//            "https://www.520mm.co/category/miitao/",
            "https://www.meitulu.com/"
    };
    static String[] bellecUrls = {
            "https://www.7160.com/xiaohua/",
            "http://www.tu11.com/xingganmeinvxiezhen/",
            "http://www.tu11.com/shenghuomeinvzipai/",
            "http://www.umei.cc/bizhitupian/meinvbizhi/"
    };
    static String[] bellexUrls = {
            "https://111gai.com/p01/index.html",
            "https://111gai.com/p02/index.html",
            "https://111gai.com/p03/index.html",
            "https://111gai.com/p04/index.html",
            "https://111gai.com/p05/index.html",
            "https://111gai.com/p06/index.html",
            "https://111gai.com/p07/index.html",
            "https://111gai.com/p08/index.html"
    };

    static String[] testUrls = {
            "http://www.tu11.com/shenghuomeinvzipai/"
    };

    static Map<String,Site> descMap = new HashMap<>();

    public static void main(String[] args) {

        String[] urls = belleUrls;

        descMap.put("www.umei.cc",new CC_UMEI());
        descMap.put("www.7160.com",new COM_7160());
        descMap.put("www.18rtys.com",new COM_18RTYS());
        descMap.put("www.tu11.com",new COM_TU11());

        descMap.put("96ucqq.com",new NET_UC96XX());
        descMap.put("qqa92.com",new NET_UC96XX());
        NET_UC96XX sjd226 = new NET_UC96XX();
//        sjd226.addCoverHeader("Host","www.images.zhaofulipic.com:8819");
        descMap.put("sjd226.com",sjd226);
        NET_UC96XX w520mm = new NET_UC96XX();
        w520mm.addCoverHeader("Host","www.images.zhaofulipic.com:8819");
        descMap.put("www.520mm.co",w520mm);
        descMap.put("www.meitulu.com",new COM_MEITULU());
        descMap.put("111gai.com",new COM_111GEI());

        //做了防爬虫，可以抓不到信息，但不能访问 待解决 TODO
//        descMap.put("www.mzitu.com",new COM_MZITU());
//        descMap.put("www.mm131.com",new COM_MM131());

        List<Site> sites = new ArrayList<>();
        for (String url : urls){
            String domain = getDomain(url);
            if (domain!=null){
                //查找对应域名的规则描述
                Site site = descMap.get(domain);
                if (site!=null){
                    site.setListPageUrl(url);
                    sites.add(site);
                }
            }
        }

        AppInfo appInfo = new AppInfo(1).setVersionMsg("First version");

        Config config = new Config(1,appInfo,sites);

        String str = JSON.toJSONString(config,false);
        System.out.println(str);

    }

    /**
     * 提取域名
     * @param url
     * @return
     */
    private static String getDomain(String url){
        String domain = null;
        if (url!=null && !"".equals(url)){
            Pattern pattern = Pattern.compile("https?:\\/\\/([^\\/]+)\\/?.*");
            Matcher matcher = pattern.matcher(url);
            if (matcher.find()){
                domain = matcher.group(1);
            }
        }
        return domain;
    }
}
