package com.weicongli.demo.faketieba.module.main;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.weicongli.library.base.BaseActivity;
import com.weicongli.demo.faketieba.R;
import com.weicongli.demo.faketieba.other.MyTextView;

/**
 * @author: WeicongLi
 * @time: 2019/2/16 22:32
 * @email: 912220261@qq.com
 * @Function:
 */
public class PostActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageIv;
    private MyTextView textView;
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
        textView = findViewById(R.id.text);
        textView.setOnClickListener(this);
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
            case R.id.text:
                ObjectAnimator animator = ObjectAnimator.ofInt(textView, "num", 0, 100);
                animator.setDuration(5000);
                animator.setInterpolator(new FastOutSlowInInterpolator());//设置插值器
                animator.start();


//                //使用ObjectAnimator在同一动画中改变多个属性
//                PropertyValuesHolder holder1 = PropertyValuesHolder.ofFloat("scaleX",1);
//                PropertyValuesHolder holder2 = PropertyValuesHolder.ofFloat("scaleY",1);
//                PropertyValuesHolder holder3 = PropertyValuesHolder.ofFloat("alpha",1);
//                ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(textView,holder1,holder2,holder3);
//                animator.start();

//                //自定义执行关系
//                ObjectAnimator animator = ObjectAnimator.ofFloat(imageIv,"scaleX",50);
//                ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageIv,"scaleY",50);
//                ObjectAnimator animator3 = ObjectAnimator.ofFloat(imageIv,"alpha",0,1);
//                AnimatorSet animatorSet = new AnimatorSet();
//                animatorSet.play(animator).with(animator2);
//                animatorSet.play(animator2).before(animator3);
//                animatorSet.play(animator2).after(animator3);
//                animatorSet.start();

//                //拆分同一属性
//                //从0开始
//                Keyframe keyframe1 = Keyframe.ofInt(0, 0);
//                //运行到50%时，进度完成100
//                Keyframe keyframe2 = Keyframe.ofInt(0.5f, 100);
//                //运行到100%时，进度为80%
//                Keyframe keyframe3 = Keyframe.ofInt(1, 80);
//                PropertyValuesHolder holder = PropertyValuesHolder.ofKeyframe("num", keyframe1, keyframe2, keyframe3);
//                ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(textView, holder);
//                animator.setDuration(5000);
//                animator.start();

                break;
        }
    }
}
