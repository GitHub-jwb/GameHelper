package com.jwb.gamehelper.module.main.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.jwb.gamehelper.R;
import com.jwb.gamehelper.base.BaseActivity;
import com.jwb.gamehelper.common.widget.BottomMenu;
import com.jwb.gamehelper.module.guess.ui.GuessFragment;
import com.jwb.gamehelper.module.home.ui.HomeFragment;
import com.jwb.gamehelper.module.me.ui.MeFragment;
import com.jwb.gamehelper.module.money.ui.MoneyFragment;
import com.jwb.gamehelper.module.shop.ui.ShopFragment;

public class MainActivity extends BaseActivity {

    private FragmentTransaction mfmTrans;
    private BottomMenu mlastMenu=null;
    private GuessFragment guessFragment;
    private HomeFragment homeFragment;
    private MoneyFragment moneyFragment;
    private ShopFragment shopFragment;
    private MeFragment meFragment;

    private Fragment mlastSelFragment;//记录前一个fragment
    private long mlExitTime=0;

    @Override
    public int setViewId() {
        return R.layout.activity_main;
    }

    public void init() {
        mfmTrans = getSupportFragmentManager().beginTransaction();
        guessFragment = new GuessFragment();
        homeFragment = new HomeFragment();
        moneyFragment = new MoneyFragment();
        shopFragment = new ShopFragment();
        meFragment = new MeFragment();

        mfmTrans.add(R.id.frame_container,guessFragment);
        mfmTrans.hide(guessFragment);
        mfmTrans.add(R.id.frame_container,meFragment);
        mfmTrans.hide(meFragment);
        mfmTrans.add(R.id.frame_container,moneyFragment);
        mfmTrans.hide(moneyFragment);
        mfmTrans.add(R.id.frame_container,shopFragment);
        mfmTrans.hide(shopFragment);
        //默认显示首页
        mfmTrans.add(R.id.frame_container,homeFragment);
        mfmTrans.commit();
        mlastSelFragment =homeFragment;

    }

    @Override
    public void initEvent() {

    }

    @Override
    public void loadData() {

    }

    public void findViews() {
        mlastMenu= (BottomMenu) findViewById(R.id.menu_home);
        mlastMenu.onSelect();
    }

    public void jumpMoney(){
        BottomMenu menu= (BottomMenu) findViewById(R.id.menu_money);
        onChoose(menu);
    }

    public void onChoose(View view){
        BottomMenu menu= (BottomMenu) view;
        if(!menu.equals(mlastMenu)){
            mlastMenu.onUnSelect();
        }
        menu.onSelect();
        mlastMenu=menu;
        FragmentTransaction mfmTrans = getSupportFragmentManager().beginTransaction();
        switch (menu.getId()){
            case R.id.menu_home:
                if(!(mlastSelFragment instanceof HomeFragment)){
                    mfmTrans.hide(mlastSelFragment);
                }
                mlastSelFragment =homeFragment;
                mfmTrans.show(homeFragment);
                break;
            case R.id.menu_money:
                if(!(mlastSelFragment instanceof MoneyFragment)){
                    mfmTrans.hide(mlastSelFragment);
                }
                mlastSelFragment =moneyFragment;
                mfmTrans.show(moneyFragment);
                moneyFragment.showLoadDialog();//显示加载提示
                break;
            case R.id.menu_guess:
                if(!(mlastSelFragment instanceof GuessFragment)){
                    mfmTrans.hide(mlastSelFragment);
                }
                mlastSelFragment =guessFragment;
                mfmTrans.show(guessFragment);
                break;
            case R.id.menu_shop:
                if(!(mlastSelFragment instanceof ShopFragment)){
                    mfmTrans.hide(mlastSelFragment);
                }
                mlastSelFragment =shopFragment;
                mfmTrans.show(shopFragment);
                break;
            case R.id.menu_me:
                if(!(mlastSelFragment instanceof MeFragment)){
                    mfmTrans.hide(mlastSelFragment);
                }
                mlastSelFragment =meFragment;
                mfmTrans.show(meFragment);
                break;
            default:
                break;
        }
        mfmTrans.commit();
    }

    //两次连续点击返回退出应用的处理方法
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
