package com.jwb.gamehelper.module.main.ui;

import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jwb.gamehelper.R;
import com.jwb.gamehelper.base.BaseActivity;
import com.jwb.gamehelper.base.NetCallBack;
import com.jwb.gamehelper.common.constant.Constant;
import com.jwb.gamehelper.common.net.HttpNet;
import com.jwb.gamehelper.module.main.bean.LoginInfo;
import com.se7en.utils.SystemUtil;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends BaseActivity {

    long mlExitTime=0;
    private EditText mEditUser;
    private EditText mEditPwd;
    private Button mBtnLogin;
    private String msUserName;
    private String msPwd;
    private CheckBox mcbRemenber;

    @Override
    public int setViewId() {
        return R.layout.activity_login;
    }

    @Override
    public void findViews() {
        mEditUser = (EditText) findViewById(R.id.login_edtuser);
        mEditPwd = (EditText) findViewById(R.id.login_edtpwd);
        mBtnLogin = (Button) findViewById(R.id.btnLogin);
        mcbRemenber = (CheckBox) findViewById(R.id.cbremenber);
    }

    @Override
    public void init() {

    }

    public void doLoginInfo(String strJsonRedult){

        Gson gson=new Gson();
        LoginInfo loginInfo = gson.fromJson(strJsonRedult, LoginInfo.class);
        //获得登录验证成功状态
        String strState=loginInfo.getState();
        //如果登陆成功,跳转至主页面，并关闭当前页面
        if(strState.equals("success")){
            //是否勾选下次自动登录
            if(mcbRemenber.isChecked()){
                //缓存本地
                SystemUtil.setSharedBoolean(Constant.LOGIN_FLAG,true);
            }else{
                SystemUtil.setSharedBoolean(Constant.LOGIN_FLAG,false);
            }
            Intent intent=new Intent();
            intent.setClass(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }else{
            mBtnLogin.setText("登录");
            Toast.makeText(this,"登录失败！",Toast.LENGTH_SHORT).show();
        }
    }
    public void getJsonResult(){
        msUserName = mEditUser.getText().toString();
        msPwd = mEditPwd.getText().toString();
        //Base64加密
        msPwd =new String(Base64.encode(msPwd.getBytes(),Base64.DEFAULT));

        Map<String,String> params=new HashMap<String, String>();
        params.put("username",msUserName);
        params.put("password",msPwd);
        HttpNet.doHttpRequest("POST", Constant.LOGIN_URL,
                params,
                new NetCallBack() {
                    @Override
                    public void success(String strResult) {
                        doLoginInfo(strResult);
                    }

                    @Override
                    public void fail(String strResult) {
                        Toast.makeText(LoginActivity.this,"网络请求失败！",Toast.LENGTH_SHORT).show();
                    }
                });
    }
    @Override
    public void initEvent() {
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBtnLogin.setText("正在登录...");
                getJsonResult();
            }
        });
    }

    @Override
    public void loadData() {

    }
    //点击注册按钮跳转至注册页面
    public void toReg(View view){
        Intent intent=new Intent(this,RegActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==event.KEYCODE_BACK) {
            long lCurTime = System.currentTimeMillis();
            if ((lCurTime - mlExitTime) > 2000) {
                mlExitTime = lCurTime;
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
