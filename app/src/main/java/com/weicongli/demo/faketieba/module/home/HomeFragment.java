package com.weicongli.demo.faketieba.module.home;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.weicongli.library.adapter.PagerAdapter;
import com.demo.weicongli.library.base.BaseFragment;
import com.weicongli.demo.faketieba.R;
import com.weicongli.demo.faketieba.module.home.fragments.CenterFragment;
import com.weicongli.demo.faketieba.module.home.fragments.FocusFragment;
import com.weicongli.demo.faketieba.module.home.fragments.VideoFragment;
import com.weicongli.demo.faketieba.other.slidingTab.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: WeicongLi
 * @time: 2019/2/15 16:24
 * @email: 912220261@qq.com
 * @Function:
 */
public class HomeFragment extends BaseFragment {
    private TextView actionBarTv;
    private ImageView actionBarIvL;
    private ImageView actionBarIvR1;
    private ImageView actionBarIvR2;
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    private PagerAdapter adapter;

    private List<Fragment> fragmentList;
    private List<String> titleList;

    @Override
    protected int setLayout() {
        return R.layout.home_fragment;
    }

    @Override
    protected void initView(View view) {
        actionBarTv = view.findViewById(R.id.actionbar_title);
        actionBarIvL = view.findViewById(R.id.actionbar_left);
        actionBarIvR1 = view.findViewById(R.id.actionbar_right1);
        actionBarIvR2 = view.findViewById(R.id.actionbar_right2);
        slidingTabLayout = view.findViewById(R.id.actionbar_tab);
        viewPager = view.findViewById(R.id.home_viewpager);
        actionBarTv.setVisibility(View.GONE);
        actionBarIvL.setImageResource(R.drawable.top_search_selector);
        actionBarIvR1.setVisibility(View.GONE);
        actionBarIvR2.setVisibility(View.GONE);
        slidingTabLayout.setVisibility(View.VISIBLE);
        initViewPager();
    }

    @Override
    protected void initListener() {

    }

    private void initViewPager() {
        fragmentList = new ArrayList<>();
        titleList = new ArrayList<>();
        fragmentList.add(new FocusFragment());
        fragmentList.add(new CenterFragment());
        fragmentList.add(new VideoFragment());
        titleList.add("关注");
        titleList.add("首页");
        titleList.add("视频");
        adapter = new PagerAdapter(getChildFragmentManager(), fragmentList, titleList, false);
        viewPager.setAdapter(adapter);
        slidingTabLayout.setTabTitleTextSize(20);
        slidingTabLayout.setTabStripWidth(100);
        slidingTabLayout.setTitleTextColor(Color.BLACK, R.color.colorTabUnSelectedText);
        slidingTabLayout.setCustomTabView(R.layout.viewpager_tab_view, R.id.tabText);
        slidingTabLayout.setViewPager(viewPager);
        slidingTabLayout.setSelectedIndicatorColors(Color.BLACK);
        viewPager.setCurrentItem(1);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        adapter = null;
        fragmentList = null;
        titleList = null;
    }
}
