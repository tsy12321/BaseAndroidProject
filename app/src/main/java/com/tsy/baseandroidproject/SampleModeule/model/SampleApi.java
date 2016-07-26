package com.tsy.baseandroidproject.SampleModeule.model;

import com.tsy.baseandroidproject.Base.BaseApi;
import com.tsy.baseandroidproject.SampleModeule.data.GetSampleInfoRet;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by tsy on 16/7/26.
 */
public class SampleApi extends BaseApi {

    private static final String mBaseUrl = "http://192.168.3.1/";

    private ApiStore mApiStore;

    public SampleApi() {
        super(mBaseUrl);
        mApiStore = mRetrofit.create(ApiStore.class);
    }

    /**
     * 获取xxx数据
     * @param uid
     * @param callback
     */
    public void getSampleInfo(String uid, ApiCallback<GetSampleInfoRet> callback) {
        Call<GetSampleInfoRet> call = ((ApiStore)mApiStore).getSampleInfo(uid);
        call.enqueue(new RetrofitCallback<GetSampleInfoRet>(callback));
    }

    public interface ApiStore {
        @FormUrlEncoded
        @POST("test_retrofit.php")
        Call<GetSampleInfoRet> getSampleInfo(@Field("uid") String uid);
    }
}
