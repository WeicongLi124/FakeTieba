package com.weicongli.demo.faketieba.module.main;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.Log;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.demo.weicongli.library.base.BaseActivity;
import com.demo.weicongli.library.utils.ObjectUtils;
import com.demo.weicongli.library.utils.ViewUtils;
import com.weicongli.demo.faketieba.R;
import com.weicongli.demo.faketieba.module.bar.BarFragment;
import com.weicongli.demo.faketieba.module.home.HomeFragment;
import com.weicongli.demo.faketieba.module.msg.MsgFragment;
import com.weicongli.demo.faketieba.module.person.PersonFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    /**
     * 底部导航栏
     */
    private ImageView homeImg;
    private ImageView enterformImg;
    private ImageView messageImg;
    private ImageView personImg;
    private AnimationDrawable animationDrawable;
    private int localTab = 1;//当前所处fragment

    /**
     * 所用到的fragments
     */
    private HomeFragment homeFg;
    private BarFragment barFg;
    private MsgFragment messageFg;
    private PersonFragment personFg;

    /**
     * 新增帖子界面
     *
     * @return
     */
    private RelativeLayout postContainerRl;
    private ImageView closeIv;
    private RelativeLayout postBg;
    private LinearLayout textLl;
    private LinearLayout photoLl;
    private LinearLayout imageLl;
    private LinearLayout liveLl;
    private int postState = 1;

    private AnimatorSet animatorSet;
    private OvershootInterpolator overshootInterpolator;
    private FastOutSlowInInterpolator fastOutSlowInInterpolator;
    private String TAG = "MainActivity";

    @Override
    protected int setLayout() {
        return R.layout.main_activity;
    }

    @Override
    protected void initParams() {
        homeImg = findViewById(R.id.main_home_img);
        enterformImg = findViewById(R.id.main_enterform_img);
        messageImg = findViewById(R.id.main_messgae_img);
        personImg = findViewById(R.id.main_person_img);
        homeImg.setImageResource(R.drawable.home14);
        homeFg = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, homeFg).commit();

        postContainerRl = findViewById(R.id.main_post_container);
        postBg = findViewById(R.id.post_bg);
        closeIv = findViewById(R.id.post_close_iv);
        textLl = findViewById(R.id.post_text_ll);
        photoLl = findViewById(R.id.post_photo_ll);
        imageLl = findViewById(R.id.post_image_ll);
        liveLl = findViewById(R.id.post_live_ll);
    }

    @Override
    protected void initListener() {
        findViewById(R.id.main_home_ll).setOnClickListener(this);
        findViewById(R.id.main_enterform_ll).setOnClickListener(this);
        findViewById(R.id.main_message_ll).setOnClickListener(this);
        findViewById(R.id.main_person_ll).setOnClickListener(this);
        findViewById(R.id.main_post_btn).setOnClickListener(this);

        postContainerRl.setOnClickListener(this);
        findViewById(R.id.post_text_iv).setOnClickListener(this);
        findViewById(R.id.post_photo_iv).setOnClickListener(this);
        findViewById(R.id.post_image_iv).setOnClickListener(this);
        findViewById(R.id.post_live_iv).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //底部导航栏
            case R.id.main_home_ll:
                if (homeFg == null) homeFg = new HomeFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, homeFg).commit();
                animationButton(1);
                break;
            case R.id.main_enterform_ll:
                if (barFg == null) barFg = new BarFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, barFg).commit();
                animationButton(2);
                break;
            case R.id.main_message_ll:
                if (messageFg == null) messageFg = new MsgFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, messageFg).commit();
                animationButton(3);
                break;
            case R.id.main_person_ll:
                if (personFg == null) personFg = new PersonFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, personFg).commit();
                animationButton(4);
                break;
            //添加帖子界面
            case R.id.main_post_btn:
                if (postState == 1) {
                    postState = 0;
                    postContainerRl.setVisibility(View.VISIBLE);
                    postOpenAnimate();
                }
                break;
            case R.id.main_post_container:
                if (postState == 2) {
                    postState = 0;
                    postCloseAnimate();
                }
                break;
            case R.id.post_text_iv:
            case R.id.post_photo_iv:
            case R.id.post_image_iv:
            case R.id.post_live_iv:
                start(this, PostActivity.class);
                postCloseAnimate();
                break;
        }
    }

    /**
     * app底部导航栏图标的动画替换
     *
     * @param switchTab
     */
    private void animationButton(int switchTab) {
        if (localTab != switchTab) {
            localTab = switchTab;
            if (animationDrawable != null) animationDrawable.stop();
            homeImg.setImageResource(R.drawable.bottom_tab_home_anim);
            enterformImg.setImageResource(R.drawable.bottom_tab_enterforum_anim);
            messageImg.setImageResource(R.drawable.bottom_tab_message_anim);
            personImg.setImageResource(R.drawable.bottom_tab_person_anim);
            switch (switchTab) {
                case 1:
                    animationDrawable = (AnimationDrawable) homeImg.getDrawable();
                    break;
                case 2:
                    animationDrawable = (AnimationDrawable) enterformImg.getDrawable();
                    break;
                case 3:
                    animationDrawable = (AnimationDrawable) messageImg.getDrawable();
                    break;
                case 4:
                    animationDrawable = (AnimationDrawable) personImg.getDrawable();
                    break;
            }
            animationDrawable.setOneShot(true);
            animationDrawable.start();
        }
    }

    /**
     * 新增帖子界面弹出
     */
    private void postOpenAnimate() {
        closeIv.animate().rotation(90).setDuration(400);
        postBg.animate().alpha(1).setDuration(600);
        animatorPlayer(textLl, -200, 0, 700, NO_LAST, OPEN);
        animatorPlayer(photoLl, -200, 100, 800, NO_LAST, OPEN);
        animatorPlayer(imageLl, -200, 200, 900, NO_LAST, OPEN);
        animatorPlayer(liveLl, -200, 300, 1000, OPEN_LAST, OPEN);
    }

    /**
     * 新增帖子界面收起
     */
    private void postCloseAnimate() {
        closeIv.animate().rotation(0).setDuration(600);
        postBg.animate().alpha(0).setDuration(1000);
        animatorPlayer(textLl, 200, 300, 1000, CLOSE_LAST, CLOSE);
        animatorPlayer(photoLl, 200, 200, 900, NO_LAST, CLOSE);
        animatorPlayer(imageLl, 200, 100, 800, NO_LAST, CLOSE);
        animatorPlayer(liveLl, 200, 0, 700, NO_LAST, CLOSE);
    }


    private final static boolean OPEN = true;
    private final static boolean CLOSE = false;
    private final static int OPEN_LAST = 2;
    private final static int CLOSE_LAST = 1;
    private final static int NO_LAST = 0;

    /**
     * 新增帖子弹出动画框架
     *
     * @param view
     * @param translationY
     * @param delay
     * @param duration
     * @param lastTime
     * @param order
     */
    private void animatorPlayer(View view, float translationY, long delay, long duration, final int lastTime, boolean order) {
        animatorSet = new AnimatorSet();
        ObjectAnimator animator2;
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "translationY", ViewUtils.dpToPixel(translationY)).setDuration(duration);
        if (order) {
            animator2 = ObjectAnimator.ofFloat(view, "alpha", 0, 1).setDuration(1000);
            if (overshootInterpolator == null) {
                overshootInterpolator = new OvershootInterpolator();
            }
            animatorSet.setInterpolator(overshootInterpolator);
        } else {
            animator2 = ObjectAnimator.ofFloat(view, "alpha", 1, 1).setDuration(1000);
            if (fastOutSlowInInterpolator == null) {
                fastOutSlowInInterpolator = new FastOutSlowInInterpolator();
            }
            animatorSet.setInterpolator(fastOutSlowInInterpolator);
        }
        animatorSet.play(animator1).with(animator2);
        animatorSet.setStartDelay(delay);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                switch (lastTime) {
                    case CLOSE_LAST:
                        postContainerRl.setVisibility(View.GONE);
                        textLl.setAlpha(0);
                        imageLl.setAlpha(0);
                        photoLl.setAlpha(0);
                        liveLl.setAlpha(0);
                        textLl.setY(ViewUtils.dpToPixel(200));
                        photoLl.setY(ViewUtils.dpToPixel(200));
                        imageLl.setY(ViewUtils.dpToPixel(200));
                        liveLl.setY(ViewUtils.dpToPixel(200));
                        postState = 1;
                        break;
                    case OPEN_LAST:
                        postState = 2;
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ObjectUtils.handGC(homeFg, barFg, messageFg, personFg, animationDrawable, animatorSet, overshootInterpolator, fastOutSlowInInterpolator);
    }
}
