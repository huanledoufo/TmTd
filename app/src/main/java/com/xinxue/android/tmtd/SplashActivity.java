package com.xinxue.android.tmtd;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import net.youmi.android.listener.Interface_ActivityListener;
import net.youmi.android.offers.OffersManager;

/**
 * Created by leixinxue on 16-10-19.
 */

public class SplashActivity extends Activity {
    private static final String TAG_SplashActivity = "SplashActivity--->";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_main);
        //初始化积分墙
        OffersManager.getInstance(this).onAppLaunch();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //全屏积分墙
        OffersManager.getInstance(this).showOffersWall(new Interface_ActivityListener() {
            @Override
            public void onActivityDestroy(Context context) {
                //积分墙关闭
                Log.d(TAG_SplashActivity, "有米积分墙退出");
            }
        });



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //退出积分墙
        OffersManager.getInstance(this).onAppExit();
    }
}
