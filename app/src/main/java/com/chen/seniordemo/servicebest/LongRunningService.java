package com.chen.seniordemo.servicebest;

import android.app.AlarmManager;
import android.app.AliasActivity;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

import java.util.Date;

public class LongRunningService extends Service {
    private static final String TAG = "LongRunningService";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG, "executed at " + new Date().toString());
            }
        }).start();

        //创建时间:2017/4/10 17:14 描述:启动一个定时任务
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        int anHour = 60 * 60 * 1000;
        int anTime = 10 * 1000;
        long triherAtMillis = SystemClock.elapsedRealtime() + anTime;
        Intent mPendingIntent = new Intent(this, AlarmReceiver.class);
        PendingIntent operation = PendingIntent.getBroadcast(this, 0, mPendingIntent, 0);
        //完成设定
       // manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triherAtMillis, operation);
        //4.4之后使用,保证任务准时执行
        manager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP, triherAtMillis, operation);

        return super.onStartCommand(intent, flags, startId);
    }
}
