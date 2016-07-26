package com.tsy.baseandroidproject.SampleModeule.model;

import android.content.Context;

import com.tsy.baseandroidproject.Base.BaseCache;
import com.tsy.baseandroidproject.SampleModeule.data.SampleInfo;

import java.io.Serializable;

/**
 * Created by tsy on 16/7/26.
 */
public class SampleCache  extends BaseCache {

    private final String KEY_NEWEST_SAMPLE_INFO = "sample_newest_info";

    public SampleCache(Context context) {
        super(context);
    }

    /**
     * 保存sample信息
     * @param serializable
     */
    public void saveNewestSample(Serializable serializable) {
        mCache.put(KEY_NEWEST_SAMPLE_INFO, serializable);
    }

    /**
     * 获取sample信息
     * @return
     */
    public SampleInfo getNewestSampleInfo() {
        return (SampleInfo) mCache.getAsObject(KEY_NEWEST_SAMPLE_INFO);
    }

    /**
     * 移除缓存
     */
    public void removeNewestSampleInfo() {
        mCache.remove(KEY_NEWEST_SAMPLE_INFO);
    }
}
