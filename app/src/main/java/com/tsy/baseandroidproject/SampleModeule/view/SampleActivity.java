package com.tsy.baseandroidproject.SampleModeule.view;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tsy.baseandroidproject.Base.BaseActivity;
import com.tsy.baseandroidproject.R;
import com.tsy.baseandroidproject.SampleModeule.data.SampleInfo;
import com.tsy.baseandroidproject.SampleModeule.presenter.SampleContract;
import com.tsy.baseandroidproject.SampleModeule.presenter.SamplePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SampleActivity extends BaseActivity implements SampleContract.View {

    @BindView(R.id.txtName)
    TextView txtName;

    @BindView(R.id.imgAvatar)
    ImageView imgAvatar;

    private SampleContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        ButterKnife.bind(this);

        mPresenter = new SamplePresenter(this);
    }

    @Override
    public void showSample(SampleInfo sampleInfo) {
        txtName.setText(sampleInfo.sample_name);
        Glide.with(this)
                .load(sampleInfo.avatar)
                .into(imgAvatar);
    }

    @Override
    public void errorGetSample(String msg) {
        //错误信息
    }

}
