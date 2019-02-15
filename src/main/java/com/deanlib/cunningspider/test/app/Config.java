package com.deanlib.cunningspider.test.app;

import com.deanlib.cunningspider.description.Site;

import java.io.Serializable;
import java.util.List;

public class Config implements Serializable {

    int version;//配置版本
    AppInfo appInfo;
    List<Site> sites;

    public Config(int version, AppInfo appInfo, List<Site> sites) {
        this.version = version;
        this.appInfo = appInfo;
        this.sites = sites;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public AppInfo getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(AppInfo appInfo) {
        this.appInfo = appInfo;
    }

    public List<Site> getSites() {
        return sites;
    }

    public void setSites(List<Site> sites) {
        this.sites = sites;
    }
}
