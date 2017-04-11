package com.chen.seniordemo;

import android.app.Application;
import android.content.Context;
import android.os.Parcelable;

import com.chen.seniortool.util.LogUtil;

import java.io.Serializable;

/**
 * Created by cdd on 2017/4/11 10:02
 * 描述:
 */

public class MyApplication extends Application {

    private static Context sContext;


    @Override
    public void onCreate() {
        //super.onCreate();
        sContext = getApplicationContext();

//        Serializable
        //Parcelable
    }

    public static Context getContext() {
        return sContext;
    }
}
