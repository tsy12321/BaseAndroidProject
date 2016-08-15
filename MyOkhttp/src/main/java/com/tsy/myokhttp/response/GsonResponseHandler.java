package com.tsy.myokhttp.response;

/**
 * Created by tsy on 16/8/15.
 */
public abstract class GsonResponseHandler<T> implements IResponseHandler {

    Class<T> mCls;

    public GsonResponseHandler(Class<T> cls) {
        mCls = cls;
    }

    public Class<T> getCls() {
        return mCls;
    }

    public abstract void onSuccess(int statusCode, T response);
}
