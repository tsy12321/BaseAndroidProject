package com.tsy.baseandroidproject.feature.login.bean;

import java.io.Serializable;

/**
 * Created by tsy on 16/8/30.
 */
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L; // 定义序列化ID

    public String uid;
    public String userName;
    public String token;
}
