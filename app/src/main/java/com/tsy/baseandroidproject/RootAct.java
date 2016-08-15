package com.tsy.baseandroidproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * 启动Activity
 */
public class RootAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);
    }
}
