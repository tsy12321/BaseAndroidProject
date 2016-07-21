package com.tsy.baseandroidproject.Base;

/**
 * Gson返回Ret基本格式
 * 成功:ret=1 + 业务数据
 * 失败:ret=0 + err_code + err_msg
 * Created by tsy on 16/7/21.
 */
public class BaseDataRet {
    public int ret;         //成功-1 失败-0
    public int err_code;    //错误code
    public String err_msg;  //错误msg
}
