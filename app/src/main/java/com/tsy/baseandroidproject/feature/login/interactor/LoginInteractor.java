package com.tsy.baseandroidproject.feature.login.interactor;

import android.os.Handler;

import com.tsy.baseandroidproject.feature.login.bean.UserInfo;
import com.tsy.baseandroidproject.feature.login.contract.LoginContract;

/**
 * Login Interactor层
 * Created by tsy on 16/8/30.
 */
public class LoginInteractor implements LoginContract.Interactor {

    public LoginInteractor() {

    }

    @Override
    public void doLogin(String phone, String password, final LoginCallback callback) {
        //模拟异步网络请求登录

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                UserInfo userInfo = new UserInfo();
                userInfo.uid = "1212121";
                userInfo.userName = "tsy12321";
                callback.onSuccess(userInfo);
            }
        }, 2000);
    }
}
