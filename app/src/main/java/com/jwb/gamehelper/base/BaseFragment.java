package com.jwb.gamehelper.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/6/27.
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(setViewId(),container,false);
        findViews(view);
        init();
        initEvent();
        loadData();
        return view;
    }

    /**
     * 获取布局文件的id
     * @return
     */
    public abstract int setViewId();

    /**
     * 获得控件对象
     * @param view
     */
    public abstract void findViews(View view);

    public abstract void init();

    public abstract void initEvent();

    public abstract void loadData();
}
