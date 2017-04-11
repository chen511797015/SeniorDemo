package com.chen.seniordemo.servicebest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by 陈德东 on 2017/4/10 17:18
 * 描述:
 */

public class AlarmReceiver extends BroadcastReceiver {
    private static final String TAG = "AlarmReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
//        Intent i = new Intent(context, LongRunningService.class);
//        context.startService(i);
        Log.e(TAG, "onReceive: 启动任务");
    }
}
