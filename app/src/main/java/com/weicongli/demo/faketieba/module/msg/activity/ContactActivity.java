package com.weicongli.demo.faketieba.module.msg.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.demo.weicongli.library.base.BaseActivity;
import com.weicongli.demo.faketieba.R;
import com.weicongli.demo.faketieba.module.msg.adapter.ContactAdapter;
import com.weicongli.demo.faketieba.module.msg.model.ContactBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: WeicongLi
 * @time: 2019/3/27 20:57
 * @email: 912220261@qq.com
 * @Function:
 */
public class ContactActivity extends BaseActivity {
    private TextView titleTv;
    private ImageView leftIv;
    private TextView leftTv;
    private ImageView rightIv1;
    private ImageView rightIv2;
    private ListView listView;
    private List<ContactBean> contactBeanList;
    private ContactAdapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.msg_contact;
    }

    @Override
    protected void initParams() {
        titleTv = findViewById(R.id.actionbar_title_tv);
        leftTv = findViewById(R.id.actionbar_left_tv);
        leftIv = findViewById(R.id.actionbar_left_iv);
        rightIv1 = findViewById(R.id.actionbar_right_iv1);
        rightIv2 = findViewById(R.id.actionbar_right_iv2);
        listView = findViewById(R.id.contact_lv);
        titleTv.setText("选择联系人");
        leftIv.setVisibility(View.GONE);
        leftTv.setVisibility(View.VISIBLE);
        rightIv2.setVisibility(View.GONE);
        rightIv1.setImageResource(R.drawable.top_search_selector);
        initData();
        adapter = new ContactAdapter(this, contactBeanList);
        listView.setDividerHeight(0);
        listView.setAdapter(adapter);
    }

    @Override
    protected void initListener() {

    }

    private void initData() {
        contactBeanList = new ArrayList<>();
        contactBeanList.add(new ContactBean(R.drawable.avatar, "某某人"));
        contactBeanList.add(new ContactBean(R.drawable.hero, "Hero"));
        contactBeanList.add(new ContactBean(R.drawable.sp, "Summer"));
        contactBeanList.add(new ContactBean(R.drawable.game, "游戏玩家"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setContentView(R.layout.view_null);
    }
}
