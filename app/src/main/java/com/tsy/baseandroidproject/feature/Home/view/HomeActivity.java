package com.tsy.baseandroidproject.feature.Home.view;

import android.os.Bundle;

import com.tsy.baseandroidproject.Base.BaseActivity;
import com.tsy.baseandroidproject.R;
import com.tsy.baseandroidproject.feature.Home.contract.HomeContract;
import com.tsy.baseandroidproject.feature.Home.presenter.HomePresenter;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity implements HomeContract.View {

    private HomeContract.Presenter mPresnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        mPresnter = new HomePresenter(this);
    }

    @OnClick(R.id.btnPost)
    public void onPost() {
        mPresnter.onPost();
    }

    @Override
    public void showToast(String msg) {

    }
}
