package com.tsy.baseandroidproject;

import android.app.Application;
import android.content.Context;

/**
 * 全局Application
 * Created by tsy on 16/7/15.
 */
public class GlobalApp extends Application {

    private static GlobalApp mGlobalApp;
    private Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mGlobalApp = this;
        this.mContext = getApplicationContext();
    }

    /**
     * 获取全局Application
     * @return
     */
    public static synchronized GlobalApp getInstance() {
        return mGlobalApp;
    }

    /**
     * 获取ApplicationContext
     * @return
     */
    public Context getContext() {
        return mContext;
    }
}
