package com.jwb.gamehelper.module.main.ui;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.jwb.gamehelper.R;
import com.jwb.gamehelper.base.BaseActivity;
import com.jwb.gamehelper.common.constant.Constant;
import com.se7en.utils.SystemUtil;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends BaseActivity {

    private ViewPager mvpWelcome;
    private List<ImageView> mlistImage;
    private Button mwelBtn;
    private int miCurVersion;
    private int miLastVersion;
    private ImageView mivTextLogo;
    private ImageView mivPicLogo;
    private boolean mIsLogin=false;

    @Override
    public int setViewId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void findViews() {
        mvpWelcome = (ViewPager) findViewById(R.id.vp_welcome);
        mwelBtn = (Button) findViewById(R.id.wel_btn);

        mivTextLogo = (ImageView) findViewById(R.id.text_logo);
        mivPicLogo = (ImageView) findViewById(R.id.pic_logo);
    }

    protected void addImageView(int iResId) {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(iResId);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        mlistImage.add(imageView);
    }

    @Override
    public void init() {
        miCurVersion = SystemUtil.getSystemVersionCode();
        miLastVersion = SystemUtil.getSharedInt(Constant.VERSION_STRING, -1);
        if (miLastVersion == -1 || miCurVersion > miLastVersion) {
            mlistImage = new ArrayList<>();
            addImageView(R.mipmap.bg_guide_01);
            addImageView(R.mipmap.bg_guide_02);
            addImageView(R.mipmap.bg_guide_03);
            addImageView(R.mipmap.bg_guide_04);
            mvpWelcome.setAdapter(new PagerAdapter() {
                @Override
                public int getCount() {
                    return mlistImage.size();
                }

                @Override
                public boolean isViewFromObject(View view, Object object) {
                    return view == object;
                }

                @Override
                public Object instantiateItem(ViewGroup container, int position) {
                    //return super.instantiateItem(container, position);
                    container.addView(mlistImage.get(position));
                    return mlistImage.get(position);
                }

                @Override
                public void destroyItem(ViewGroup container, int position, Object object) {
                    //super.destroyItem(container, position, object);
                    container.removeView((View) object);
                }
            });
        } else {
            mvpWelcome.setVisibility(View.GONE);
            mwelBtn.setVisibility(View.GONE);

            mivTextLogo.setVisibility(View.VISIBLE);
            showTextLogoAnim();
        }
        mIsLogin = SystemUtil.getSharedBoolean(Constant.LOGIN_FLAG,false);
    }

    private void showTextLogoAnim() {
        TranslateAnimation animation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT,
                -1.0f,
                Animation.RELATIVE_TO_PARENT,
                0,
                Animation.RELATIVE_TO_PARENT,
                0,
                Animation.RELATIVE_TO_PARENT,
                0
        );
        animation.setDuration(1000);
        animation.setInterpolator(new AnticipateOvershootInterpolator());
        mivTextLogo.setAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mivPicLogo.setVisibility(View.VISIBLE);
                showPicLogoAnim();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void showPicLogoAnim() {
        TranslateAnimation animation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT,
                0,
                Animation.RELATIVE_TO_PARENT,
                0,
                Animation.RELATIVE_TO_PARENT,
                -1.0f,
                Animation.RELATIVE_TO_PARENT,
                0
        );
        animation.setDuration(1000);
        animation.setInterpolator(new BounceInterpolator());
        mivPicLogo.setAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                showNextActivity();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void showNextActivity() {
        Intent intent = new Intent();
        if(mIsLogin) {
            intent.setClass(WelcomeActivity.this, MainActivity.class);
        }else {
            intent.setClass(WelcomeActivity.this, RBActivity.class);
        }
        startActivity(intent);
        finish();
    }

    @Override
    public void initEvent() {
        if (miLastVersion == -1 || miCurVersion > miLastVersion) {
            mvpWelcome.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    if (position == mlistImage.size() - 1) {
                        mwelBtn.setVisibility(View.VISIBLE);
                    } else {
                        mwelBtn.setVisibility(View.GONE);
                    }
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
            mwelBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SystemUtil.setSharedInt(Constant.VERSION_STRING, miCurVersion);
                    showNextActivity();
                }
            });
        }
    }

    @Override
    public void loadData() {

    }
}
