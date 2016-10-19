package com.xinxue.android.tmtd.utils.other;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by leixinxue on 16-10-19.
 */

public class ToastUtils {
    public static Toast toast;

    public static void showLong(Context context, String info) {
        if (null == toast) {
            toast = Toast.makeText(context, info, Toast.LENGTH_LONG);
        } else {
            toast.setText(info);
        }
        toast.show();
    }

    public static void showShort(Context context, String info) {
        if (null == toast) {
            toast = Toast.makeText(context, info, Toast.LENGTH_SHORT);
        } else {
            toast.setText(info);
        }
        toast.show();
    }
}
