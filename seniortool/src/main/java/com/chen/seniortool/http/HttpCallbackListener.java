package com.chen.seniortool.http;

/**
 * Created by cdd on 2017/4/10 17:53
 * 描述:网络请求回调
 */

public interface HttpCallbackListener {

    void onFinish(String result);

    void onError(Exception e);
}
