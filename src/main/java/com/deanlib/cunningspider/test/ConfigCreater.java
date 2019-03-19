package com.deanlib.cunningspider.test;

import com.alibaba.fastjson.JSON;
import com.deanlib.cunningspider.description.Site;
import com.deanlib.cunningspider.test.app.AppInfo;
import com.deanlib.cunningspider.test.app.Config;
import com.deanlib.cunningspider.test.description.CC_UMEI;
import com.deanlib.cunningspider.test.description.COM_7160;
import com.deanlib.cunningspider.test.description.COM_MM131;
import com.deanlib.cunningspider.test.description.COM_MZITU;

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
            "https://www.mzitu.com"
    };
    static String[] bellecUrls = {
            "https://www.7160.com/xiaohua/"
    };

    static Map<String,Site> descMap = new HashMap<>();

    public static void main(String[] args) {

        String[] urls = belleUrls;

        descMap.put("www.mzitu.com",new COM_MZITU());
        descMap.put("www.mm131.com",new COM_MM131());
        descMap.put("www.umei.cc",new CC_UMEI());
        descMap.put("www.7160.com",new COM_7160());

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
