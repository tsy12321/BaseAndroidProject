package com.tsy.baseandroidproject.util;

import android.widget.Toast;

import com.tsy.baseandroidproject.GlobalApp;

/**
 * Toast相关方法
 * Created by tsy on 16/8/15.
 */
public class ToastUtils {

    /**
     * 显示short message
     * @param resId string 资源id
     */
    public static void showShort(int resId) {
        Toast.makeText(GlobalApp.getInstance().getContext(), resId, Toast.LENGTH_SHORT).show();
    }

    /**
     * 显示short message
     * @param message 显示msg
     */
    public static void showShort(String message) {
        Toast.makeText(GlobalApp.getInstance().getContext(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 显示long message
     * @param resId string 资源id
     */
    public static void showLong(int resId) {
        Toast.makeText(GlobalApp.getInstance().getContext(), resId, Toast.LENGTH_LONG).show();
    }

    /**
     * 显示long message
     * @param message 显示msg
     */
    public static void showLong(String message) {
        Toast.makeText(GlobalApp.getInstance().getContext(), message, Toast.LENGTH_LONG).show();
    }
}
