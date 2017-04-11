package com.chen.seniortool;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created on 2017/4/10 09:52
 * 描述: 屏幕管理工具,设置全屏,横竖屏等
 * 参考网址:http://2960629.blog.51cto.com/2950629/701227
 */

public class WindowAdmin {

    /**
     * 创建时间:2017/4/10 9:52
     * 描述:全屏   在Activity的onCreate方法中的setContentView(myview)调用之前
     */
    public static void setFullScreen(Context mContext) {
        //创建时间:2017/4/10 9:55 描述:隐藏标题
        ((AppCompatActivity) mContext).supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        // ((Activity) mContext).requestWindowFeature(Window.FEATURE_NO_TITLE);

        //创建时间:2017/4/10 9:55 描述:设置全屏
        ((AppCompatActivity) mContext).getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //((Activity) mContext).getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    /**
     * 创建时间:2017/4/10 9:57
     * 描述:横屏   在Activity的onResume方法中添加
     */
    public static void setLandScreen(Context mContext) {
        if (((AppCompatActivity) mContext).getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            ((AppCompatActivity) mContext).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    /**
     * 创建时间:2017/4/10 10:00
     * 描述:竖屏
     */
    public static void setPortScreen(Context mContext) {
        if (((AppCompatActivity) mContext).getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            ((AppCompatActivity) mContext).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

}
