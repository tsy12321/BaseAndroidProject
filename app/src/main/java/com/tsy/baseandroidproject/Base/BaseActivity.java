package com.tsy.baseandroidproject.Base;

import android.app.Activity;

import com.tsy.sdk.myokhttp.MyOkHttp;

/**
 * BaseActivity
 * Created by tsy on 16/7/22.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onDestroy() {
        MyOkHttp.get().cancel(this);
        super.onDestroy();
    }
}
