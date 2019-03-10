package com.weicongli.demo.faketieba.module.bar;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.demo.weicongli.library.base.BaseFragment;
import com.weicongli.demo.faketieba.R;
import com.weicongli.demo.faketieba.module.bar.adapter.BarListAdapter;
import com.weicongli.demo.faketieba.module.bar.model.BarDataBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: WeicongLi
 * @time: 2019/2/15 16:25
 * @email: 912220261@qq.com
 * @Function:
 */
public class BarFragment extends BaseFragment {
    private TextView actionBarTv;
    private ImageView actionBarIvL;
    private ImageView actionBarIvR1;
    private ImageView actionBarIvR2;
    private ListView barLv;
    private BarListAdapter adapter;
    private List<BarDataBean> dataBeanList;

    @Override
    protected int setLayout() {
        return R.layout.bar_fragment;
    }

    @Override
    protected void initView(View view) {
        actionBarTv = view.findViewById(R.id.actionbar_title);
        actionBarIvL = view.findViewById(R.id.actionbar_left);
        actionBarIvR1 = view.findViewById(R.id.actionbar_right1);
        actionBarIvR2 = view.findViewById(R.id.actionbar_right2);
        actionBarTv.setText("进吧");
        actionBarIvL.setVisibility(View.GONE);
        actionBarIvR1.setImageResource(R.drawable.top_checkin_selector);
        actionBarIvR2.setVisibility(View.GONE);

        initData();
        barLv = view.findViewById(R.id.bar_lv);
        barLv.setDividerHeight(0);
        adapter = new BarListAdapter(dataBeanList, getContext());
        barLv.setAdapter(adapter);
    }

    @Override
    protected void initListener() {

    }

    private void initData() {
        dataBeanList = new ArrayList<>();
        dataBeanList.add(new BarDataBean(0));
        dataBeanList.add(new BarDataBean(1));
        dataBeanList.add(new BarDataBean(2));
        dataBeanList.add(new BarDataBean("Summer Pockets", R.drawable.icon_level_18, true, true,
                "game", R.drawable.icon_level_17, true, 3));
        dataBeanList.add(new BarDataBean("海贼王", R.drawable.icon_level_13, true, true,
                "我的英雄学院", R.drawable.icon_level_13, true, 3));
        dataBeanList.add(new BarDataBean("KEY", R.drawable.icon_level_13, true, true,
                "CLANNAD", R.drawable.icon_level_12, true, 3));
        dataBeanList.add(new BarDataBean("漫画", R.drawable.icon_level_08, true, true,
                "动画", R.drawable.icon_level_07, true, 3));
        dataBeanList.add(new BarDataBean("魔兽世界", R.drawable.icon_level_03, true, true,
                "音乐", R.drawable.icon_level_03, true, 3));
        dataBeanList.add(new BarDataBean("华南理工大学广州学院", R.drawable.icon_level_02, true, false, 3));
        dataBeanList.add(new BarDataBean(4));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        adapter = null;
        dataBeanList = null;
    }
}
