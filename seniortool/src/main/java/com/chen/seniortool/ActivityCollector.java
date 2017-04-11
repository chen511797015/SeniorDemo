package com.chen.seniortool;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2017/4/7 19:06
 * 描述:Activity管理器
 */

public class ActivityCollector {

    static List<Activity> mList = new ArrayList<>();


    public static void add(Activity activity) {
        mList.add(activity);
    }


    public static void remove(Activity activity) {
        mList.remove(activity);
    }


    public static void finishAll() {
        if (mList.size() > 0) {
            for (Activity activity : mList) {
                if (!activity.isFinishing()) {
                    activity.finish();
                }
            }
        }
    }

}
