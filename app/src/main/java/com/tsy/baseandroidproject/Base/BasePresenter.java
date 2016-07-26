package com.tsy.baseandroidproject.Base;


import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * Created by tsy on 16/7/26.
 */
public class BasePresenter {

    /**
     * BaseHandler 防止内存泄露
     * @param <T>
     */
    protected static class BaseHandler<T> extends Handler {
        private final WeakReference<T> mPresenter;

        public BaseHandler(T presenter) {
            mPresenter = new WeakReference<T>(presenter);
        }

        @Override
        public void handleMessage(Message msg) {
            T presenter = mPresenter.get();
            if(presenter == null) {
                return;
            }
        }
    }
}
