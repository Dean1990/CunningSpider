package com.deanlib.cunningspider.test.app;

import java.io.Serializable;

public class AppInfo implements Serializable {

    int versionCode;//应用版本，用于判断更新
    boolean forcedUpdate;//强制更新

    public AppInfo(int versionCode) {
        this.versionCode = versionCode;
    }

    public AppInfo(int versionCode, boolean forcedUpdate) {
        this.versionCode = versionCode;
        this.forcedUpdate = forcedUpdate;
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

    public void setForcedUpdate(boolean forcedUpdate) {
        this.forcedUpdate = forcedUpdate;
    }
}
