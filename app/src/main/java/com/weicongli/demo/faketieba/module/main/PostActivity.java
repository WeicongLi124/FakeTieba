package com.weicongli.demo.faketieba.module.main;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.demo.weicongli.library.base.BaseActivity;
import com.weicongli.demo.faketieba.R;

/**
 * @author: WeicongLi
 * @time: 2019/2/16 22:32
 * @email: 912220261@qq.com
 * @Function:
 */
public class PostActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageIv;
    private TranslateAnimation translateAnimation;
    private RotateAnimation rotateAnimation;
    private ScaleAnimation scaleAnimation;
    private AlphaAnimation alphaAnimation;

    @Override
    protected int setLayout() {
        return R.layout.post_activity;
    }

    @Override
    protected void initParams() {
        findViewById(R.id.translate).setOnClickListener(this);
        findViewById(R.id.rotate).setOnClickListener(this);
        findViewById(R.id.scale).setOnClickListener(this);
        findViewById(R.id.alpha).setOnClickListener(this);
        findViewById(R.id.set).setOnClickListener(this);
        imageIv = findViewById(R.id.image);
        translateAnimation = (TranslateAnimation) AnimationUtils.loadAnimation(this, R.anim.test_translate);
        rotateAnimation = (RotateAnimation) AnimationUtils.loadAnimation(this, R.anim.test_rotate);
        scaleAnimation = (ScaleAnimation) AnimationUtils.loadAnimation(this, R.anim.test_scale);
        alphaAnimation = (AlphaAnimation) AnimationUtils.loadAnimation(this, R.anim.test_alpha);
    }

    @Override
    protected void initListener() {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.translate:
                imageIv.startAnimation(translateAnimation);
                /*translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        imageIv.startAnimation(alphaAnimation);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });*/
                break;
            case R.id.rotate:
                imageIv.startAnimation(rotateAnimation);
                break;
            case R.id.scale:
                imageIv.startAnimation(scaleAnimation);
                break;
            case R.id.alpha:
                imageIv.startAnimation(alphaAnimation);
                break;
            case R.id.set:
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(translateAnimation);
                animationSet.addAnimation(alphaAnimation);
                animationSet.addAnimation(scaleAnimation);
                imageIv.startAnimation(animationSet);
                break;
        }
    }
}
