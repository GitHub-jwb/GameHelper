package com.jwb.gamehelper.module.mygame.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jwb.gamehelper.R;
import com.jwb.gamehelper.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MyGameActivity extends BaseActivity {

    private List<Fragment> mlistFragments;
    private AllGameFragment mAllGameFragment;
    private NewGameFragment mNewGameFragment;
    private OldGameFragment mOldGameFragment;
    private ViewPager mvpGames;
    private RadioGroup mRGBtns;

    @Override
    public int setViewId() {
        return R.layout.activity_my_game;
    }

    @Override
    public void findViews() {
        mvpGames = (ViewPager) findViewById(R.id.vp_mygame);
        mRGBtns = (RadioGroup) findViewById(R.id.radiogroup_mygame);
    }

    @Override
    public void init() {
        mAllGameFragment = new AllGameFragment();
        mNewGameFragment = new NewGameFragment();
        mOldGameFragment = new OldGameFragment();
        mlistFragments = new ArrayList<>();
        mlistFragments.add(mAllGameFragment);
        mlistFragments.add(mNewGameFragment);
        mlistFragments.add(mOldGameFragment);
        mvpGames.setAdapter(new MyFragmentAdapter(getSupportFragmentManager()));
        mRGBtns.check(R.id.all_rbtn);
    }

    @Override
    public void initEvent() {
        //给ViewPager设置监听，当viewpager切换时，RadioButton也跟随变换。
        mvpGames.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //根据位置获取RadioGroup中的RadioButton
                RadioButton rb= (RadioButton) mRGBtns.getChildAt(position);
                rb.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mRGBtns.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch (id){
                    case R.id.all_rbtn:
                        mvpGames.setCurrentItem(0);
                        break;
                    case R.id.new_rbtn:
                        mvpGames.setCurrentItem(1);
                        break;
                    case R.id.old_rbtn:
                        mvpGames.setCurrentItem(2);
                        break;
                }
            }
        });
    }

    @Override
    public void loadData() {

    }
    //点击返回图标执行的方法
    public void clickBack(View view) {
        finish();
    }
    //点击搜索输入框跳转至搜索界面
    public void clickJump(View view){
        Intent intent=new Intent();
        intent.setClass(this,SearchActivity.class);
        startActivity(intent);
    }

    class MyFragmentAdapter extends FragmentPagerAdapter {

        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mlistFragments.get(position);
        }

        @Override
        public int getCount() {
            return mlistFragments.size();
        }
    }
}
