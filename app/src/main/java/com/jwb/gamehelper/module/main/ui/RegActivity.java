package com.jwb.gamehelper.module.main.ui;

import android.os.CountDownTimer;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.jwb.gamehelper.R;
import com.jwb.gamehelper.base.BaseActivity;

public class RegActivity extends BaseActivity {

    private CheckBox mCheckBox;
    private Button mBtnGetCode;
    private int miCnt=120;

    @Override
    public int setViewId() {
        return R.layout.activity_reg;
    }

    @Override
    public void findViews() {
        mCheckBox= (CheckBox) findViewById(R.id.checkbox_reg);
        //让mCheckBox中的文字具有超链接功能
        mCheckBox.setMovementMethod(new LinkMovementMethod());

        mBtnGetCode = (Button) findViewById(R.id.btn_getCode);
    }

    @Override
    public void init() {

    }

    @Override
    public void initEvent() {
        //点击获取验证码时调用的方法
        mBtnGetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(miCnt*1000,1000){
                    @Override
                    public void onTick(long l) {
                        mBtnGetCode.setEnabled(false);
                        miCnt--;
                        mBtnGetCode.setText(miCnt+" s");
                    }

                    @Override
                    public void onFinish() {
                        mBtnGetCode.setEnabled(true);
                        miCnt=120;
                        mBtnGetCode.setText("重新获取验证码");
                    }
                }.start();
            }
        });
    }

    @Override
    public void loadData() {

    }
    //点击返回按钮图标是调用的方法
    public void clickBack(View view){
        finish();
    }
}
