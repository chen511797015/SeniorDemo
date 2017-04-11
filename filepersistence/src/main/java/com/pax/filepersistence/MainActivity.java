package com.pax.filepersistence;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    /**
     *  创建时间:2017/4/8 16:56
     *  描述:将数据存储到文件中
     */
    private void save(String mStr) {
        FileOutputStream fos = null;
        BufferedWriter bw = null;

        try {
            fos = openFileOutput("data", Context.MODE_PRIVATE);
            bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write(mStr);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != bw) {
                    bw.close();
                    bw = null;
                }
                if (null != fos) {
                    fos.close();
                    fos = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
