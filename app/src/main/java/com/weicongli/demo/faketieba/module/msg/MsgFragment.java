package com.weicongli.demo.faketieba.module.msg;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.weicongli.library.adapter.PagerAdapter;
import com.demo.weicongli.library.base.BaseFragment;
import com.demo.weicongli.library.utils.ObjectUtils;
import com.weicongli.demo.faketieba.R;
import com.weicongli.demo.faketieba.module.msg.fragments.ChatFragment;
import com.weicongli.demo.faketieba.module.msg.fragments.MessageFragment;
import com.weicongli.demo.faketieba.module.msg.fragments.NotifyFragment;
import com.weicongli.demo.faketieba.other.slidingTab.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: WeicongLi
 * @time: 2019/2/15 16:25
 * @email: 912220261@qq.com
 * @Function:
 */
public class MsgFragment extends BaseFragment {
    private TextView actionBarTv;
    private ImageView actionBarIvL;
    private ImageView actionBarIvR1;
    private ImageView actionBarIvR2;
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    private PagerAdapter adapter;

    private MessageFragment messageFragment;
    private ChatFragment chatFragment;
    private NotifyFragment notifyFragment;
    private List<Fragment> fragmentList;
    private List<String> titleList;
    private boolean isFirstInit = true;

    @Override
    protected int setLayout() {
        return R.layout.msg_fragment;
    }

    @Override
    protected void initParams(View view) {
        actionBarTv = view.findViewById(R.id.actionbar_title);
        actionBarIvL = view.findViewById(R.id.actionbar_left);
        actionBarIvR1 = view.findViewById(R.id.actionbar_right1);
        actionBarIvR2 = view.findViewById(R.id.actionbar_right2);
        slidingTabLayout = view.findViewById(R.id.actionbar_tab);
        viewPager = view.findViewById(R.id.msg_viewpager);
        actionBarTv.setVisibility(View.GONE);
        actionBarIvL.setVisibility(View.GONE);
        actionBarIvR1.setImageResource(R.drawable.top_chat_selector);
        actionBarIvR2.setVisibility(View.GONE);
        slidingTabLayout.setVisibility(View.VISIBLE);
        initViewPager();
    }

    @Override
    protected void initListener() {

    }

    private void initViewPager() {
        if (isFirstInit) {
            fragmentList = new ArrayList<>();
            titleList = new ArrayList<>();
            messageFragment = new MessageFragment();
            chatFragment = new ChatFragment();
            notifyFragment = new NotifyFragment();
            fragmentList.add(messageFragment);
            fragmentList.add(chatFragment);
            fragmentList.add(notifyFragment);
            titleList.add("消息");
            titleList.add("聊天");
            titleList.add("通知");
            isFirstInit = false;
        }
        adapter = new PagerAdapter(getChildFragmentManager(), fragmentList, titleList, false);
        viewPager.setAdapter(adapter);
        slidingTabLayout.setTabTitleTextSize(20);
        slidingTabLayout.setTabStripWidth(100);
        slidingTabLayout.setTitleTextColor(Color.BLACK, R.color.colorTabUnSelectedText);
        slidingTabLayout.setCustomTabView(R.layout.viewpager_tab_view, R.id.tabText);
        slidingTabLayout.setViewPager(viewPager);
        slidingTabLayout.setSelectedIndicatorColors(Color.BLACK);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ObjectUtils.handGC(adapter, messageFragment, chatFragment, notifyFragment, fragmentList, titleList);
    }
}
