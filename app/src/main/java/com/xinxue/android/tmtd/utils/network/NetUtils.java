package com.xinxue.android.tmtd.utils.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/**
 * Created by leixinxue on 16-10-19.
 */

public class NetUtils {
    private static final String TAG = "NetUtils";
    public static final int NET_TYPE_WIFI = 1, NET_TYPE_MOBILE_4G = 4, NET_TYPE_MOBILE_3G = 3,
            NET_TYPE_MOBILE_2G = 2, NET_TYPE_MOBILE_UNKNOWN = 5, NET_TYPE_BLUE = 0, NET_TYPE_NULL = -1, NET_TYPE_WIMAX = 6;

    //判断网络的具体类型
    public static int judgetNetType(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (null != networkInfo && networkInfo.isConnected()) {//有网
            switch (networkInfo.getType()) {
                case ConnectivityManager.TYPE_WIFI:
                    return NET_TYPE_WIFI;
                case ConnectivityManager.TYPE_MOBILE://判断具体的网络类型
                    switch (networkInfo.getSubtype()) {
                        case TelephonyManager.NETWORK_TYPE_UNKNOWN:
                            return NET_TYPE_MOBILE_UNKNOWN;
                        case TelephonyManager.NETWORK_TYPE_GPRS:
                        case TelephonyManager.NETWORK_TYPE_EDGE:
                        case TelephonyManager.NETWORK_TYPE_1xRTT:
                        case TelephonyManager.NETWORK_TYPE_IDEN:
                            return NET_TYPE_MOBILE_2G;
                        case TelephonyManager.NETWORK_TYPE_UMTS:
                        case TelephonyManager.NETWORK_TYPE_CDMA:
                        case TelephonyManager.NETWORK_TYPE_EVDO_0:
                        case TelephonyManager.NETWORK_TYPE_EVDO_B:
                        case TelephonyManager.NETWORK_TYPE_EVDO_A:
                        case TelephonyManager.NETWORK_TYPE_HSDPA:
                        case TelephonyManager.NETWORK_TYPE_HSUPA:
                        case TelephonyManager.NETWORK_TYPE_HSPA:
                            return NET_TYPE_MOBILE_3G;
                        case TelephonyManager.NETWORK_TYPE_LTE:
                        case TelephonyManager.NETWORK_TYPE_EHRPD:
                        case TelephonyManager.NETWORK_TYPE_HSPAP:
                            return NET_TYPE_MOBILE_4G;
                    }
                case ConnectivityManager.TYPE_WIMAX:
                    return NET_TYPE_WIMAX;
                case ConnectivityManager.TYPE_BLUETOOTH:
                    return NET_TYPE_BLUE;
                default:
                    return NET_TYPE_MOBILE_UNKNOWN;
            }
        }
        return NET_TYPE_NULL;
    }

    //判断是否有网
    public static boolean netWorkActived(Context context) {
        return judgetNetType(context) == NET_TYPE_NULL;
    }

    //判断是否是wifi
    public static boolean isWifiActived(Context context) {
        return judgetNetType(context) == NET_TYPE_WIFI;
    }


}
