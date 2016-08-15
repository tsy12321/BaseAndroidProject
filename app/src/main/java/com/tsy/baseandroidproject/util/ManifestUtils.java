package com.tsy.baseandroidproject.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.tsy.baseandroidproject.GlobalApp;

/**
 * manifest工具类
 * Created by tsy on 16/7/25.
 */
public class ManifestUtils {

    private static final String TAG = "ManifestUtils";

    /**
     * 返回Manifest指定meta-data值
     * @param key
     * @return
     *      成功-value
     *      失败-""
     */
    public static String getMetaData(String key) {
        Context context = GlobalApp.getInstance().getContext();
        ApplicationInfo app_info = null;
        try {
            app_info = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            if(app_info == null || app_info.metaData == null) {
                return "";
            } else {
                Object obj = app_info.metaData.get(key);
                if(obj != null) {
                    return obj.toString();
                } else {
                    return "";
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            LogUtils.e(TAG, "getMetaData error", e);
            return "";
        }
    }

    /**
     * 获取版本名
     * @return
     */
    public static String getVersionName() {
        Context context = GlobalApp.getInstance().getContext();
        String version = "0.0";
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            version = packInfo.versionName;
        } catch (Exception e) {
            LogUtils.e(TAG, "getVersionName error", e);
        }

        return version;
    }
}
