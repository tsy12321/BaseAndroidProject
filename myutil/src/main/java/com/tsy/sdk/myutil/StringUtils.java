package com.tsy.sdk.myutil;

/**
 * 字符串相关方法
 * Created by tsy on 16/8/15.
 */
public class StringUtils {

    /**
     * 是否为空
     * @param str 字符串
     * @return true 空 false 非空
     */
    public static Boolean isEmpty(String str) {
        if(str == null || str.equals("")) {
            return true;
        }

        return false;
    }
}
