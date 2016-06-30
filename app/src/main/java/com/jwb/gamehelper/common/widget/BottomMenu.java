package com.jwb.gamehelper.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jwb.gamehelper.R;

/**
 * Created by Administrator on 2016/6/28.
 */
public class BottomMenu extends LinearLayout {

    private ImageView mivMenu;
    private TextView mtvMenu;
    private int miNormalPic;
    private int miPressedPic;
    private static boolean mbIsSelect=false;

    public BottomMenu(Context context) {
        super(context);
        //init(context,null);
    }

    public BottomMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        View view=LayoutInflater.from(context).inflate(R.layout.layout_bottom_menu,this,true);
        findViews(view);
        if(attrs!=null){
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BottomMenu);
            String strText = (String) typedArray.getText(R.styleable.BottomMenu_text);
            miNormalPic = typedArray.getResourceId(R.styleable.BottomMenu_normalPic, -1);
            miPressedPic = typedArray.getResourceId(R.styleable.BottomMenu_pressedPic, -1);

            mtvMenu.setText(strText);
            mivMenu.setImageResource(miNormalPic);

            typedArray.recycle();
       }
    }

    private void findViews(View view) {
        mivMenu = (ImageView) view.findViewById(R.id.bot_menu_iv);
        mtvMenu = (TextView) view.findViewById(R.id.bot_menu_tv);
    }

    public void onSelect(){
        //如果前面的状态是已经选中，就直接返回
        if (mbIsSelect){
            return;
        }
        mbIsSelect = true;

        //切换图片,把图片设置为选中的图片
        mivMenu.setImageResource(miPressedPic);

        //让标题执行平移动画，往下消失
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,
                0,
                Animation.RELATIVE_TO_SELF,
                0,
                Animation.RELATIVE_TO_SELF,
                0,
                Animation.RELATIVE_TO_SELF,
                1.5f);
        translateAnimation.setDuration(200);
        translateAnimation.setFillAfter(true);//保持动画停留在最后一帧

        mtvMenu.startAnimation(translateAnimation);

        //让图片执行scale动画，显示放大效果
        ScaleAnimation scaleAnimation = new ScaleAnimation(1f,
                1.5f,
                1f,
                1.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0f);
        scaleAnimation.setDuration(200);
        scaleAnimation.setFillAfter(true);
        mivMenu.startAnimation(scaleAnimation);
    }
    public void onUnSelect(){
        mbIsSelect = false;

        //切换图片,把图片设置为默认的图片
        mivMenu.setImageResource(miNormalPic);

        //让标题执行平移动画，往上出现
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,
                0,
                Animation.RELATIVE_TO_SELF,
                0,
                Animation.RELATIVE_TO_SELF,
                1,
                Animation.RELATIVE_TO_SELF,
                0);
        translateAnimation.setDuration(200);
        mtvMenu.startAnimation(translateAnimation);

        //让图片执行scale动画，显示放大效果
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.5f,
                1f,
                1.5f,
                1f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0f);
        scaleAnimation.setDuration(200);
        mivMenu.startAnimation(scaleAnimation);
    }
}
