package com.tsy.baseandroidproject.Base;

import android.content.Context;

import com.tsy.sdk.acache.ACache;


/**
 * BaseCache
 * Created by tsy on 16/7/25.
 */
public class BaseCache {

    protected ACache mCache;

    public BaseCache(Context context) {
        mCache = ACache.get(context);
    }
}
