package com.tsy.baseandroidproject.feature.login.presenter;

import com.tsy.baseandroidproject.feature.login.bean.UserInfo;
import com.tsy.baseandroidproject.feature.login.contract.LoginContract;
import com.tsy.baseandroidproject.feature.login.interactor.LoginInteractor;
import com.tsy.sdk.myutil.StringUtils;

/**
 * Login presenter层
 * Created by tsy on 16/8/30.
 */
public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mView;
    private LoginContract.Interactor mInteractor;

    public LoginPresenter(LoginContract.View view) {
        mView = view;
        mInteractor = new LoginInteractor();
    }

    @Override
    public void start() {

    }

    @Override
    public void onLogin(String phone, String password) {
        if(StringUtils.isEmpty(phone)) {
            mView.showToast("Empty phone");
            return;
        }

        if(StringUtils.isEmpty(password)) {
            mView.showToast("Empty password");
            return;
        }

        mInteractor.doLogin(phone, password, new LoginContract.Interactor.LoginCallback() {
            @Override
            public void onSuccess(UserInfo user_info) {
                mView.goHome();
            }

            @Override
            public void onFailure(String msg) {
                mView.showToast(msg);
            }
        });
    }
}
