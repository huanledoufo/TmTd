package com.xinxue.android.tmtd.utils.other;

import android.util.Log;

import com.xinxue.android.tmtd.TmtdApplication;

/**
 * Created by leixinxue on 16-10-19.
 */

public class LogUtils {
    public static void printLogIgnore(String tag, String info) {
        Log.d("tmtd_" + tag, info);
    }

    public static void printLog(String tag, String info) {
        if (!TmtdApplication.isRelease) printLogIgnore(tag, info);
    }
}
