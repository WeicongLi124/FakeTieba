package com.weicongli.demo.faketieba.module.main.pagerAdapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author: WeicongLi
 * @time: 2019/2/20 17:27
 * @email: 912220261@qq.com
 * @Function:
 */
public class PagerAdapter extends FragmentPagerAdapter {
    private Context context;
    private List<Fragment> fragmentList;
    private List<String> titleList;

    public PagerAdapter(FragmentManager fm, Context context, List<Fragment> fragmentList, List<String> titleList) {
        super(fm);
        this.context = context;
        this.fragmentList = fragmentList;
        this.titleList = titleList;
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return titleList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
