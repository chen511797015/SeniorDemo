package com.chen.seniortool.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by cdd on 2017/4/10 17:42
 * 描述:
 */

public class HttpUtil {

    /**
     * 创建时间:2017/4/10 17:50
     * 描述:获取网络数据
     */
    public static void sendHttpRequest(final String address, final HttpCallbackListener listener) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection mConnection = null;
                InputStream sStream = null;
                BufferedReader sReader = null;
                StringBuilder result = new StringBuilder();
                try {
                    URL url = new URL(address);
                    mConnection = (HttpURLConnection) url.openConnection();
                    mConnection.setRequestMethod("GET");
                    mConnection.setConnectTimeout(10000);
                    mConnection.setReadTimeout(10000);
                    mConnection.setDoInput(true);
                    mConnection.setDoOutput(true);
                    sStream = mConnection.getInputStream();
                    sReader = new BufferedReader(new InputStreamReader(sStream));
                    String line;
                    while ((line = sReader.readLine()) != null) {
                        result.append(line);
                    }
                    if (null != listener) {
                        listener.onFinish(result.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (null != listener) {
                        listener.onError(e);
                    }
                } finally {
                    try {
                        if (null != sReader) {
                            sReader.close();
                        }
                        if (null != sStream) {
                            sStream.close();
                        }
                        if (null != mConnection) {
                            mConnection.disconnect();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
