package com.tsy.baseandroidproject;

import android.os.Bundle;
import android.os.Environment;

import com.tsy.baseandroidproject.Base.BaseActivity;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.DownloadResponseHandler;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;
import com.tsy.sdk.myokhttp.response.JsonResponseHandler;
import com.tsy.sdk.myokhttp.response.RawResponseHandler;
import com.tsy.sdk.myutil.LogUtils;

import org.json.JSONObject;

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

//        doPost();
        doGet();
//        doUpload();
//        doDownload();
    }

    //post请求
    private void doPost() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", "tsy");

        MyOkHttp.get().post(this, "http://192.168.3.1/test_okhttp.php", params, new JsonResponseHandler() {
            @Override
            public void onSuccess(int statusCode, JSONObject response) {
                LogUtils.v(TAG, statusCode + " " + response);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                LogUtils.v(TAG, statusCode + " " + error_msg);
            }
        });
    }

    //get请求
    private void doGet() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", "tsy");

        MyOkHttp.get().get(this, "http://192.168.3.1/test_okhttp.php", params, new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                LogUtils.v(TAG, statusCode + " " + response);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                LogUtils.v(TAG, statusCode + " " + error_msg);
            }
        });
    }

    //上传文件
    private void doUpload() {
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

    //下载文件
    private void doDownload() {
        MyOkHttp.get().download(this, "http://192.168.3.1/output_tmp.jpg",
                Environment.getExternalStorageDirectory() + "/com.ci123.service.splashandroid/", "1.jpg",
                new DownloadResponseHandler() {
            @Override
            public void onFinish(File download_file) {
                LogUtils.v(TAG, "onFinish:" + download_file.getPath());
            }

            @Override
            public void onProgress(long currentBytes, long totalBytes) {
                LogUtils.v(TAG, currentBytes + "/" + totalBytes);
            }

            @Override
            public void onFailure(String error_msg) {
                LogUtils.v(TAG, error_msg);
            }
        });
    }

    public class BB {
        public int ret;

    }
}
