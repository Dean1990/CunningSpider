package com.deanlib.cunningspider.test.app;

import java.io.Serializable;

public class AppInfo implements Serializable {

    int versionCode;//应用版本，用于判断更新

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }
}
