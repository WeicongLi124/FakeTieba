package com.weicongli.demo.faketieba.module.bar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.weicongli.library.base.BaseFragment;
import com.weicongli.demo.faketieba.R;

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
    }

    @Override
    protected void initListener() {

    }
}
