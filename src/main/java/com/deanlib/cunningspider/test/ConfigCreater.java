package com.deanlib.cunningspider.test;

import com.alibaba.fastjson.JSON;
import com.deanlib.cunningspider.description.Site;
import com.deanlib.cunningspider.test.app.AppInfo;
import com.deanlib.cunningspider.test.app.Config;
import com.deanlib.cunningspider.test.description.CC_UMEI;
import com.deanlib.cunningspider.test.description.COM_MM131;
import com.deanlib.cunningspider.test.description.COM_MZITU;

import java.util.ArrayList;
import java.util.List;

public class ConfigCreater {

    public static void main(String[] args) {

        List<Site> sites = new ArrayList<>();
        sites.add(new COM_MZITU());
        sites.add(new COM_MM131());
        sites.add(new CC_UMEI());

        AppInfo appInfo = new AppInfo(1).setVersionMsg("First version");

        Config config = new Config(1,appInfo,sites);

        String str = JSON.toJSONString(config,false);
        System.out.println(str);

    }
}
