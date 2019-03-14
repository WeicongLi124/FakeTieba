package com.weicongli.demo.faketieba.module.main.activity;


import android.net.Uri;
import android.widget.ImageView;

import com.demo.weicongli.library.base.BaseActivity;
import com.weicongli.demo.faketieba.R;
import com.weicongli.demo.faketieba.view.utils.BitmapUtils;

import java.io.FileNotFoundException;

/**
 * @author: WeicongLi
 * @time: 2019/2/16 22:32
 * @email: 912220261@qq.com
 * @Function:
 */
public class PostActivity extends BaseActivity {
    private ImageView image;

    @Override
    protected int setLayout() {
        return R.layout.post_activity;
    }

    @Override
    protected void initParams() {
        Uri uri = Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1552565075343&di=c13c95a149d11107dc66036b7f2ba328&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farticle%2F5904981a236456809d4f60351436dcf3cde97c6a.png");
        image = findViewById(R.id.image);
        try {
            image.setImageBitmap(BitmapUtils.getBitmapFromUri(this, uri, 720, 1280));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
