package com.tsy.baseandroidproject;

import android.os.Bundle;
import android.os.Environment;

import com.tsy.baseandroidproject.Base.BaseActivity;
import com.tsy.baseandroidproject.util.LogUtils;
import com.tsy.myokhttp.MyOkHttp;
import com.tsy.myokhttp.response.GsonResponseHandler;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

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

//        MyOkHttp.get().post(this, "http://192.168.3.1/test_okhttp.php", null, new GsonResponseHandler<BB>() {
//
//            @Override
//            public void onFailure(int statusCode, String error_msg) {
//                LogUtils.v(TAG, statusCode + " " + error_msg);
//            }
//
//            @Override
//            public void onSuccess(int statusCode, BB response) {
//                LogUtils.v(TAG, statusCode + " " + response.ret);
//            }
//        });

        Map<String, String> params = new HashMap<String, String>();
        params.put("name", "tsy");

        Map<String, File> files = new HashMap<String, File>();
        File file = new File(Environment.getExternalStorageDirectory() + "/com.ci123.service.splashandroid/splash/1.png");
        files.put("avatar", file);

        MyOkHttp.get().upload(this, "http://192.168.3.1/test_post.php", params, files, new GsonResponseHandler<BB>() {
            @Override
            public void onFailure(int statusCode, String error_msg) {
                LogUtils.v(TAG, statusCode + " " + error_msg);
            }

            @Override
            public void onSuccess(int statusCode, BB response) {
                LogUtils.v(TAG, statusCode + " " + response.ret);
            }

            @Override
            public void onProgress(long currentBytes, long totalBytes) {
                LogUtils.v(TAG, currentBytes + "/" + totalBytes);
            }
        });

    }

    public class BB {
        public int ret;

    }
}
