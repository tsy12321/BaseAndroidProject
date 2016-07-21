package com.tsy.baseandroidproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.tsy.baseandroidproject.Base.BaseApi;
import com.tsy.baseandroidproject.Base.BaseDataRet;
import com.tsy.baseandroidproject.Login.model.LoginApi;

/**
 * 启动Activity
 */
public class RootAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);

        new LoginApi().login("tsy", "as", new BaseApi.ApiCallback() {
            @Override
            public void onSuccess(BaseDataRet ret) {
                Log.i("tsy", "onSuccess:");
            }

            @Override
            public void onError(int err_code, String err_msg) {
                Log.i("tsy", "onError:");
            }

            @Override
            public void onFailure() {
                Log.i("tsy", "onFailure:");
            }
        });
    }
}
