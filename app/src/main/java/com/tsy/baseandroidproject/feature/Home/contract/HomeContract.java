package com.tsy.baseandroidproject.feature.Home.contract;

import com.tsy.baseandroidproject.Base.BasePresenter;
import com.tsy.baseandroidproject.Base.BaseView;

/**
 * Created by tsy on 16/8/30.
 */
public interface HomeContract {

    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter {
        void onPost();
    }

    interface Interactor {

    }
}
