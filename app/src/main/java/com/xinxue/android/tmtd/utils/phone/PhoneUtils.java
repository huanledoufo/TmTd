package com.xinxue.android.tmtd.utils.phone;

import android.content.Context;
import android.telephony.TelephonyManager;

import com.xinxue.android.tmtd.R;
import com.xinxue.android.tmtd.utils.other.LogUtils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * Created by leixinxue on 16-10-19.
 *
 * 获取手机自身相关的信息
 */

public class PhoneUtils {
    private static final String TAG = "PhoneUtils";

    //获取手机ip
    public static String getIp(Context context) {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (Exception e) {
            LogUtils.printLogIgnore(TAG, context.getResources().getString(R.string.netutils_error_ip));
        }
        return null;
    }

    //获取手机imei码
    public static String getIMEI(Context context) {
        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE))
                .getDeviceId();
    }

}
