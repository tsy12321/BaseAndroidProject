package com.tsy.baseandroidproject.SampleModeule.presenter;

import com.tsy.baseandroidproject.Base.BaseApi;
import com.tsy.baseandroidproject.Base.BasePresenter;
import com.tsy.baseandroidproject.GlobalApp;
import com.tsy.baseandroidproject.SampleModeule.data.GetSampleInfoRet;
import com.tsy.baseandroidproject.SampleModeule.data.SampleInfo;
import com.tsy.baseandroidproject.SampleModeule.model.SampleApi;
import com.tsy.baseandroidproject.SampleModeule.model.SampleCache;

/**
 * Created by tsy on 16/7/26.
 */
public class SamplePresenter extends BasePresenter implements SampleContract.Presenter {

    private SampleContract.View mView;
    private SampleApi mApi;
    private SampleCache mCache;

    public SamplePresenter(SampleContract.View view) {
        mView = view;

        mApi = new SampleApi();
        mCache = new SampleCache(GlobalApp.getInstance().getContext());
    }

    @Override
    public void getNewestSample() {
        //先从缓存获取
        SampleInfo sampleInfo = mCache.getNewestSampleInfo();

        if(sampleInfo == null) {
            //从网络获取
            mApi.getSampleInfo("uid", new BaseApi.ApiCallback<GetSampleInfoRet>() {
                @Override
                public void onSuccess(GetSampleInfoRet ret) {
                    //缓存
                    mCache.saveNewestSample(ret.data);

                    //页面显示
                    mView.showSample(ret.data);
                }

                @Override
                public void onError(int err_code, String err_msg) {
                    //服务端返回错误码
                    mView.errorGetSample(err_msg);
                }

                @Override
                public void onFailure() {
                    //网络请求或者解析错误
                    mView.errorGetSample("服务器请求错误");
                }
            });
        } else {
            mView.showSample(sampleInfo);
        }
    }
}
