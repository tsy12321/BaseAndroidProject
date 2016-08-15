package com.tsy.baseandroidproject;

import android.os.Bundle;

import com.tsy.baseandroidproject.Base.BaseActivity;

/**
 * 启动Activity
 */
public class RootAct extends BaseActivity {

    private String TAG = "RootAct";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);

//        MyOkHttp.get().post(this, "http://192.168.3.1/test_okhttp.php", null, new JsonResponseHandler() {
//            @Override
//            public void onSuccess(int statusCode, JSONObject response) {
//                LogUtils.v(TAG, statusCode + " " + response);
//            }
//
//            @Override
//            public void onFailure(int statusCode, String error_msg) {
//                LogUtils.v(TAG, statusCode + " " + error_msg);
//            }
//        });
    }
}
