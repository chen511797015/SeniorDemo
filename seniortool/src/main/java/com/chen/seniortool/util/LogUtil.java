package com.chen.seniortool.util;

import android.util.Log;

/**
 * Created by Administrator on 2017/4/11 10:15
 * 描述:
 */

public class LogUtil {

    public static final int VERBOSE = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
    public static final int WARN = 4;
    public static final int ERROR = 5;
    public static final int NOTHING = 6;
    /**
     * 只需要修改LEVEL常量的值，就可以自由地控制日志的打印行为了。
     * 比如让LEVEL等于VERBOSE就可以把所有的日志都打印出来，让LEVEL等于WARN就可以只打印警告以上级别的日志，
     * 让LEVEL等于NOTHING就可以把所有日志都屏蔽掉。
     */
    private static int LEVEL = VERBOSE;


    public static void setLEVEL(int LEVEL) {
        LogUtil.LEVEL = LEVEL;
    }

    public static void v(String tag, String msg) {
        if (LEVEL <= VERBOSE) {
            Log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (LEVEL <= DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (LEVEL <= INFO) {
            Log.i(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (LEVEL <= WARN) {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (LEVEL <= ERROR) {
            Log.e(tag, msg);
        }
    }


}
