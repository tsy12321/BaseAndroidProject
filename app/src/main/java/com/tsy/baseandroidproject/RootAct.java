package com.tsy.baseandroidproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
