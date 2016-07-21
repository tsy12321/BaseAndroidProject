package com.tsy.baseandroidproject.Login.model;

import com.tsy.baseandroidproject.Base.BaseApi;
import com.tsy.baseandroidproject.Login.data.LoginRetData;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by tsy on 16/7/18.
 */
public class LoginApi extends BaseApi {

    private static final String mBaseUrl = "http://192.168.3.1/";

    private ApiStore mApiStore;

    public LoginApi() {
        super(mBaseUrl);
        mApiStore = mRetrofit.create(ApiStore.class);
    }

    public void login(String username, String password, ApiCallback callback) {
        Call<LoginRetData> call = ((ApiStore)mApiStore).login();
        call.enqueue(callBack(new LoginRetData(), callback));
    }

    public interface ApiStore {
        @GET("test_retrofit.php")
        Call<LoginRetData> login();
    }
}
