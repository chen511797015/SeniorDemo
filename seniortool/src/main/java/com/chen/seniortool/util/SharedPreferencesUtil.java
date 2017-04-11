package com.chen.seniortool.util;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created  on 2017/4/8 18:32
 * 描述:SharedPreferences文件都是存放在/data/data/<package name>/shared_prefs/目录下
 * 获取SharedPreferences方法
 * 1.	Context类中的getSharedPreferences()方法
 * 2.	Activity类中的getPreferences()方法
 * 3.	PreferenceManager类中的getDefaultSharedPreferences()方法
 */

public class SharedPreferencesUtil {

    static final String FILE_NAME = "share_data";

    //*************************int start*********************************//
    public static void putInt(Context mContext, int mModel, String mFileName, String mKey, int mValue) {
        SharedPreferences preferences = mContext.getSharedPreferences(mFileName, mModel);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(mKey, mValue);
        editor.commit();
    }

    public static void putInt(Context mContext, String mFileName, String mKey, int mValue) {
        putInt(mContext, Context.MODE_PRIVATE, mFileName, mKey, mValue);
    }

    public static void putInt(Context mContext, String mKey, int mValue) {
        putInt(mContext, FILE_NAME, mKey, mValue);
    }


    public static int getInt(Context mContext, int mModel, String mFileName, String mKey, int mDefValue) {
        SharedPreferences preferences = mContext.getSharedPreferences(mFileName, mModel);
        return preferences.getInt(mKey, mDefValue);
    }

    public static int getInt(Context mContext, String mFileName, String mKey) {
        return getInt(mContext, Context.MODE_PRIVATE, mFileName, mKey, -1);
    }

    public static int getInt(Context mContext, String mKey) {
        return getInt(mContext, FILE_NAME, mKey);
    }

    //************************** String start ***************************************//

    public static void putString(Context mContext, int mModel, String mFileName, String mKey, String mValue) {
        SharedPreferences preferences = mContext.getSharedPreferences(mFileName, mModel);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(mKey, mValue);
        editor.commit();
    }

    public static void putString(Context mContext, String mFileName, String mKey, String mValue) {
        putString(mContext, Context.MODE_PRIVATE, mFileName, mKey, mValue);
    }

    public static void putString(Context mContext, String mKey, String mValue) {
        putString(mContext, FILE_NAME, mKey, mValue);
    }

    public static String getString(Context mContext, int mModel, String mFileName, String mKey) {
        SharedPreferences preferences = mContext.getSharedPreferences(mFileName, mModel);
        return preferences.getString(mKey, "");
    }

    public static String getString(Context mContext, String mFileName, String mKey) {
        return getString(mContext, Context.MODE_PRIVATE, mFileName, mKey);
    }

    public static String getString(Context mContext, String mKey) {
        return getString(mContext, FILE_NAME, mKey);
    }


    //*********************** boolean start **************************************//

    public static void putBoolean(Context mContext, int mModel, String mFileName, String mKey, boolean mValue) {
        SharedPreferences preferences = mContext.getSharedPreferences(mFileName, mModel);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(mKey, mValue);
        editor.commit();
    }


    public static void putBoolean(Context mContext, String mFileName, String mKey, boolean mValue) {
        putBoolean(mContext, Context.MODE_PRIVATE, mFileName, mKey, mValue);
    }

    public static void putBoolean(Context mContext, String mKey, boolean mValue) {
        putBoolean(mContext, FILE_NAME, mKey, mValue);
    }

    public static boolean getBoolean(Context mContext, int mModel, String mFileName, String mKey, boolean mValue) {
        SharedPreferences preferences = mContext.getSharedPreferences(mFileName, mModel);
        return preferences.getBoolean(mKey, mValue);
    }

    public static boolean getBoolean(Context mContext, String mFileName, String mKey) {
        return getBoolean(mContext, Context.MODE_PRIVATE, mFileName, mKey, false);
    }

    public static boolean getBoolean(Context mContext, String mKey) {
        return getBoolean(mContext, FILE_NAME, mKey);
    }

}
