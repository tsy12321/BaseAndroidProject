package com.tsy.baseandroidproject.util;

/**
 * 字符串相关方法
 * Created by tsy on 16/8/15.
 */
public class StringUtils {

    /**
     * 是否为空
     * @param str
     * @return
     */
    public static Boolean isEmpty(String str) {
        if(str == null || str.equals("")) {
            return true;
        }

        return false;
    }
}
