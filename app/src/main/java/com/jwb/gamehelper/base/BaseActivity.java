package com.jwb.gamehelper.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2016/6/27.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setViewId());
        findViews();
        init();
        initEvent();
        loadData();
    }
    public abstract int setViewId();
    public abstract void findViews();
    public abstract void init();
    public abstract void initEvent();
    public abstract void loadData();
}
