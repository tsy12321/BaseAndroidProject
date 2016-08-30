package com.tsy.baseandroidproject.feature.Home.presenter;

import com.tsy.baseandroidproject.feature.Home.contract.HomeContract;
import com.tsy.baseandroidproject.feature.Home.interactor.HomeInteractor;
import com.tsy.baseandroidproject.feature.login.contract.LoginContract;
import com.tsy.baseandroidproject.feature.login.interactor.LoginInteractor;

/**
 * Created by tsy on 16/8/30.
 */
public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View mView;
    private HomeContract.Interactor mInteractor;
    private LoginContract.Interactor mLoginInteractor;

    public HomePresenter(HomeContract.View view) {
        mView = view;
        mInteractor = new HomeInteractor();
        mLoginInteractor = new LoginInteractor();
    }

    @Override
    public void start() {

    }

    @Override
    public void onPost() {
        //判断用户有没有登录
        if(!mLoginInteractor.isLogin()) {
            // 跳转登录
            // TODO: 16/8/30
            return;
        }

        //跳转发帖页面
        // TODO: 16/8/30
    }
}
