package com.xinxue.android.tmtd;

import android.app.Application;

import net.youmi.android.AdManager;

/**
 * Created by leixinxue on 16-10-19.
 */

public class TmtdApplication extends Application {
    public static boolean isRelease=false;
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化有米广告sdk
        AdManager.getInstance(this).init("cd501df93e5b28c2", "beaedbab0b7655d0", false, true);

    }
}
