package com.chen.seniordemo.lightsensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.chen.seniordemo.R;
import com.chen.seniortool.util.LogUtil;

import static android.R.attr.value;

public class LightSensorActivity extends AppCompatActivity {

    private TextView mTextView;
    private SensorManager mSensorManager;
    private Sensor mSensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_sensor);
        mTextView = (TextView) findViewById(R.id.light_level);
        initSensor();
        LogUtil.e("tag", "启动程序");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSensorManager.unregisterListener(listener);
    }

    private void initSensor() {
        //光照传感器
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mSensorManager.registerListener(listener, mSensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    private SensorEventListener listener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            //values数组中第一个下标的值就是当前的光照强度
            float value = event.values[0];
            mTextView.setText("Current light level is " + value + " lx");
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };


}
