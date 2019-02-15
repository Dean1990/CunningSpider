package com.deanlib.cunningspider.test.app;

import java.io.Serializable;

public class AppInfo implements Serializable {

    int versionCode;//应用版本，用于判断更新
    boolean forcedUpdate;//强制更新
    String versionMsg;//版本信息

    public AppInfo() {
    }

    public AppInfo(int versionCode) {
        this.versionCode = versionCode;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public boolean isForcedUpdate() {
        return forcedUpdate;
    }

    public AppInfo setForcedUpdate(boolean forcedUpdate) {
        this.forcedUpdate = forcedUpdate;
        return this;
    }

    public String getVersionMsg() {
        return versionMsg;
    }

    public AppInfo setVersionMsg(String versionMsg) {
        this.versionMsg = versionMsg;
        return this;
    }
}
