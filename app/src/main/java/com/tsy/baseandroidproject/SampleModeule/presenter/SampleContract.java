package com.tsy.baseandroidproject.SampleModeule.presenter;

import com.tsy.baseandroidproject.SampleModeule.data.SampleInfo;

/**
 * Created by tsy on 16/7/26.
 */
public interface SampleContract {

    interface View {
        void showSample(SampleInfo sampleInfo);     //显示sample

        void errorGetSample(String msg);    //显示错误信息
    }

    interface Presenter {
        void getNewestSample(); //获取当前最新的xxx
    }
}
