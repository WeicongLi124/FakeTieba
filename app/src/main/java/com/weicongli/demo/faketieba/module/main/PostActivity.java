package com.weicongli.demo.faketieba.module.main;


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
     }

    @Override
    protected void initListener() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setContentView(R.layout.view_null);
    }
}
