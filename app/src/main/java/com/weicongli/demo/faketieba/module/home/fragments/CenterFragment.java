package com.weicongli.demo.faketieba.module.home.fragments;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.weicongli.library.base.BaseFragment;
import com.demo.weicongli.library.utils.ObjectUtils;
import com.demo.weicongli.library.utils.ToastUtils;
import com.weicongli.demo.faketieba.R;
import com.weicongli.demo.faketieba.module.home.adapter.CenterAdapter;
import com.weicongli.demo.faketieba.module.home.model.UserTipItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: WeicongLi
 * @time: 2019/2/20 17:29
 * @email: 912220261@qq.com
 * @Function:
 */
public class CenterFragment extends BaseFragment implements View.OnClickListener {
    private ListView listView;
    private CenterAdapter adapter;
    private List<UserTipItemBean> itemBeanList;
    private TextView notLike;
    private LinearLayout popBgLl;
    private PopupWindow popupWindow;
    private boolean isFirstInit = true;
    private String TAG = "CenterFragment";


    @Override
    protected int setLayout() {
        return R.layout.home_center_fragment;
    }

    @Override
    protected void initParams(View view) {
        listView = view.findViewById(R.id.home_center_lv);
        listView.setDividerHeight(0);
        if (isFirstInit) {
            initData();
            adapter = new CenterAdapter(getContext(), itemBeanList, this);
            isFirstInit = false;
        }
        listView.setAdapter(adapter);
    }

    @Override
    protected void initListener() {

    }


    private void initData() {
        itemBeanList = new ArrayList<>();
        itemBeanList.add(new UserTipItemBean(R.drawable.avatar, "ぼく", "SummerPockets",
                "5分钟", "这是一张宣传图", 0, 6, 1, true));
        itemBeanList.add(new UserTipItemBean(R.drawable.avatar, "ぼく", "我的英雄学院",
                "7分钟", "这是一张宣传图", 7, 6, 9, false));
        itemBeanList.add(new UserTipItemBean(R.drawable.avatar, "ぼく", "漫画",
                "15分钟", "这是一张宣传图", 10, 55, 60, false));
        itemBeanList.add(new UserTipItemBean(R.drawable.avatar, "ぼく", "游戏",
                "56分钟", "这是一张宣传图", 6, 1, 9, false));
    }

    @Override
    public void onClick(View view) {
        int position;
        switch (view.getId()) {
            case R.id.card_item_share_ll:
                position = (int) view.getTag(R.id.card_item_share_ll);
                adapter.update(adapter.UPDATE_SHARE, position);
                break;
            case R.id.card_item_chat_ll:
                position = (int) view.getTag(R.id.card_item_chat_ll);
                adapter.update(adapter.UPDATE_CHAT, position);
                break;
            case R.id.card_item_like_ll:
                position = (int) view.getTag(R.id.card_item_like_ll);
                adapter.update(adapter.UPDATE_LIKE, position);
                break;
            case R.id.center_item_close_ll:
//                position = (int) view.getTag(R.id.center_item_close_iv);
                showPopupWindow(view);
                break;
            case R.id.home_pop_notlike:
                ToastUtils.showText(getContext(), "notLike", Gravity.CENTER, Toast.LENGTH_LONG);
                break;
        }
    }

    /**
     * 初始化弹框
     *
     * @param view
     */
    private void showPopupWindow(View view) {
        View contentView = LayoutInflater.from(getContext()).inflate(R.layout.home_feedback_pop, null);
        notLike = contentView.findViewById(R.id.home_pop_notlike);
        popBgLl = contentView.findViewById(R.id.feedback_bg_ll);
        notLike.setOnClickListener(this);
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = 0.5f;
        getActivity().getWindow().setAttributes(lp);
        popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
                lp.alpha = 1f;
                getActivity().getWindow().setAttributes(lp);
            }
        });
        //设置背景
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.fb_popupwindow_bg));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        showPopupWindowTop(view, contentView, popupWindow);
    }

    /**
     * 设置弹框出现位置：上、下
     *
     * @param touchView
     * @param popupView
     * @param popupWindow
     */
    private void showPopupWindowTop(View touchView, View popupView, PopupWindow popupWindow) {
        int viewLocal[] = new int[2];
        //获取被点击的View在屏幕上的左上角坐标位置
        touchView.getLocationOnScreen(viewLocal);
        //获取被点击的View的高度
        final int viewHeight = touchView.getHeight();
        //获取屏幕高度
        final int screenHeight = getContext().getResources().getDisplayMetrics().heightPixels;
        //计算contentView的高度
        popupView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        final int windowHeight = popupView.getMeasuredHeight();
        //判断屏幕高度与参照view的高度、参照物位置高度的差是否小于弹窗高度
        final boolean isShowOnTop = (screenHeight - viewLocal[1] - viewHeight * 2 < windowHeight);
        if (isShowOnTop) {

            popupWindow.setAnimationStyle(R.style.FbPopTopStyle);

            popBgLl.setBackgroundResource(R.drawable.bg_home_feedback_under);
            popupWindow.showAtLocation(touchView, Gravity.NO_GRAVITY, 0,
                    viewLocal[1] - windowHeight);
        } else {
            popupWindow.setAnimationStyle(R.style.FbPopUnderStyle);
            popBgLl.setBackgroundResource(R.drawable.bg_home_feedback_top);
            popupWindow.showAtLocation(touchView, Gravity.NO_GRAVITY, 0,
                    viewLocal[1] + viewHeight);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
