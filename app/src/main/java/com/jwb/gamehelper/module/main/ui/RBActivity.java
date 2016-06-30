package com.jwb.gamehelper.module.main.ui;

import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.jwb.gamehelper.R;
import com.jwb.gamehelper.base.BaseActivity;

public class RBActivity extends BaseActivity {
    PopupWindow mpopWindow=null;
    private View mRbView;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(mpopWindow==null){
            setAlpha(0.5f);//设置Activity的透明度
            mpopWindow =new PopupWindow(mRbView,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    false
            );
            mpopWindow.showAtLocation(getWindow().getDecorView(), Gravity.CENTER,0,0);
        }
    }
    private void setAlpha(float fAlpha){
        WindowManager.LayoutParams params=getWindow().getAttributes();
        params.alpha=fAlpha;
        getWindow().setAttributes(params);
    }
    @Override
    public int setViewId() {
        return R.layout.activity_rb;
    }

    @Override
    public void findViews() {

    }

    @Override
    public void init() {
        mRbView = LayoutInflater.from(this).inflate(R.layout.rb_pupupwindow_layout,null);
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void loadData() {

    }

    //当点击红包视图中的"立即注册"按钮时触发的方法
    public void startReg(View view){
        Intent intent=new Intent();
        intent.setClass(this,RegActivity.class);
        startActivity(intent);
    }

    //当点击红包视图中的"立即登录"按钮时触发的方法
    public void startLogin(View view){
        Intent intent=new Intent();
        intent.setClass(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    protected void onDestroy() {

        if(mpopWindow!=null){
            mpopWindow.dismiss();
            mpopWindow=null;
        }
        super.onDestroy();
    }
}
