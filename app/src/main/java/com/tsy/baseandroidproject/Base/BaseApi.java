package com.tsy.baseandroidproject.Base;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * BaseApi
 * Created by tsy on 16/7/21.
 */
public abstract class BaseApi {

    private static final String mBaseUrl = "http://www.baidu.com/";

    protected Retrofit mRetrofit;


    public BaseApi() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public BaseApi(String baseUrl) {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    //处理retrofit回调 并调用ApiCallback相应返回
    protected <T> Callback<T> callBack(T t, final ApiCallback callback) {
        return new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if(response.isSuccessful()) {
                    if(((BaseDataRet)response.body()).ret == 1) {
                        callback.onSuccess(((BaseDataRet)response.body()));
                    } else {
                        callback.onError(((BaseDataRet)response.body()).err_code, ((BaseDataRet)response.body()).err_msg);
                    }
                } else {
                    callback.onFailure();
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                callback.onFailure();
            }
        };
    }

    public interface ApiCallback {
        void onSuccess(BaseDataRet ret);        //ret=1时返回
        void onError(int err_code, String err_msg);   //ret=0时返回
        void onFailure();   //网络请求失败
    }
}
