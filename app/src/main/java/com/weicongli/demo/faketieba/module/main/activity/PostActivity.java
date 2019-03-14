package com.weicongli.demo.faketieba.module.main.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.weicongli.library.base.BaseActivity;
import com.weicongli.demo.faketieba.R;

/**
 * @author: WeicongLi
 * @time: 2019/2/16 22:32
 * @email: 912220261@qq.com
 * @Function:
 */
public class PostActivity extends BaseActivity implements View.OnClickListener {
    private TextView titleTv;
    private ImageView actionLeftIv;
    private TextView actionRightTv;
    private ImageView actionRightIv1;
    private ImageView actionRightIv2;
    private EditText addTitleEdt;


    @Override
    protected int setLayout() {
        return R.layout.post_activity;
    }

    @Override
    protected void initParams() {
        titleTv = findViewById(R.id.actionbar_title_tv);
        actionLeftIv = findViewById(R.id.actionbar_left_iv);
        actionRightIv1 = findViewById(R.id.actionbar_right_iv1);
        actionRightIv2 = findViewById(R.id.actionbar_right_iv2);
        actionRightTv = findViewById(R.id.actionbar_right_tv);
        addTitleEdt = findViewById(R.id.post_title_edt);
        titleTv.setText("发布到我的主页");
        actionLeftIv.setImageResource(R.drawable.icon_topbar_close_n);
        actionRightIv1.setVisibility(View.GONE);
        actionRightIv2.setVisibility(View.GONE);
        actionRightTv.setVisibility(View.VISIBLE);
    }

    @Override
    protected void initListener() {
        actionLeftIv.setOnClickListener(this);
        findViewById(R.id.post_add_title_tv).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.actionbar_left_iv:
                finish();
                break;
            case R.id.post_add_title_tv:
                if (addTitleEdt.getVisibility() == View.GONE) {
                    addTitleEdt.setVisibility(View.VISIBLE);
                } else {
                    addTitleEdt.setVisibility(View.GONE);
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setContentView(R.layout.view_null);
    }
}
