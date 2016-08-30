package com.tsy.baseandroidproject.feature.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.tsy.baseandroidproject.Base.BaseActivity;
import com.tsy.baseandroidproject.GlobalApp;
import com.tsy.baseandroidproject.R;
import com.tsy.baseandroidproject.feature.Home.view.HomeActivity;
import com.tsy.baseandroidproject.feature.login.contract.LoginContract;
import com.tsy.baseandroidproject.feature.login.presenter.LoginPresenter;
import com.tsy.sdk.myutil.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @BindView(R.id.editPhone)
    EditText editPhone;

    @BindView(R.id.editPassword)
    EditText editPassword;

    private LoginContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mPresenter = new LoginPresenter(this);
    }

    @OnClick(R.id.btnLogin)
    public void onLogin() {
        mPresenter.onLogin(editPhone.getText().toString(), editPassword.getText().toString());
    }

    @OnClick(R.id.txtRegister)
    public void goRegister() {
        ToastUtils.showShort(GlobalApp.getInstance().getContext(), "goRegister");
    }

    @OnClick(R.id.txtForgetPwd)
    public void goForgetPwd() {
        ToastUtils.showShort(GlobalApp.getInstance().getContext(), "goForgetPwd");
    }

    @Override
    public void showToast(String msg) {
        ToastUtils.showShort(GlobalApp.getInstance().getContext(), msg);
    }

    @Override
    public void goHome() {
        //跳转Home页面
        ToastUtils.showShort(GlobalApp.getInstance().getContext(), "登录成功, 跳转Home页面");

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}
