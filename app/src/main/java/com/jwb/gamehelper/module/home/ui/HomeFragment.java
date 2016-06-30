package com.jwb.gamehelper.module.home.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.jwb.gamehelper.R;
import com.jwb.gamehelper.base.BaseFragment;
import com.jwb.gamehelper.module.main.ui.MainActivity;

/**
 * Created by Administrator on 2016/6/29.
 */
public class HomeFragment extends BaseFragment {

    private Button mBtnStartMoney;

    @Override
    public int setViewId() {
        return R.layout.layout_fragment_home;
    }

    @Override
    public void findViews(View view) {
        mBtnStartMoney = (Button) view.findViewById(R.id.btn_start_money);
    }

    @Override
    public void init() {

    }

    @Override
    public void initEvent() {
        mBtnStartMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity= (MainActivity) getActivity();
                //调用activity中的事先定义好的处理方法
                mainActivity.jumpMoney();
            }
        });
    }

    @Override
    public void loadData() {

    }
}
