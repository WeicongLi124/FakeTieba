package com.weicongli.demo.faketieba.module.main;

import android.os.Bundle;
import android.widget.Toast;

import com.demo.weicongli.library.base.BaseActivity;
import com.weicongli.demo.faketieba.R;

/**
 * @author: WeicongLi
 * @time: 2019/2/16 22:32
 * @email: 912220261@qq.com
 * @Function:
 */
public class PostActivity extends BaseActivity {
    @Override
    protected int setLayout() {
        return R.layout.post_activity;
    }

    @Override
    protected void initParams() {
        /*if (getIntent().getData() != null) {
            String host = getIntent().getData().getHost();
            Bundle bundle = getIntent().getExtras();
            String value = bundle.getString("value");
            Toast.makeText(this, host + ":" + value, Toast.LENGTH_LONG).show();
        }*/
    }

    @Override
    protected void initListener() {

    }
}
