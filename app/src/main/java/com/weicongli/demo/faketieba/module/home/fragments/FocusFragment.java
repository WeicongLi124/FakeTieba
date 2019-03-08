package com.weicongli.demo.faketieba.module.home.fragments;

import android.view.View;
import android.widget.ListView;

import com.demo.weicongli.library.base.BaseFragment;
import com.weicongli.demo.faketieba.R;
import com.weicongli.demo.faketieba.module.home.adapter.FocusAdapter;
import com.weicongli.demo.faketieba.module.home.model.BarTipItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: WeicongLi
 * @time: 2019/2/20 17:29
 * @email: 912220261@qq.com
 * @Function:
 */
public class FocusFragment extends BaseFragment implements View.OnClickListener {
    private ListView listView;
    private List<BarTipItemBean> itemBeanList;
    private FocusAdapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.home_focus_fragment;
    }

    @Override
    protected void initView(View view) {
        initData();
        listView = view.findViewById(R.id.home_focus_lv);
        adapter = new FocusAdapter(getContext(), itemBeanList, this);
        listView.setDividerHeight(0);
        listView.setAdapter(adapter);
    }

    @Override
    protected void initListener() {

    }

    private void initData() {
        itemBeanList = new ArrayList<>();
        itemBeanList.add(new BarTipItemBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551960561328&di=d19e93f27b85917619b9ab126427913a&imgtype=0&src=http%3A%2F%2Fp2.music.126.net%2F8wVqpVaJW8OISRbmowNTtg%3D%3D%2F109951163571311598.jpg", "SummerPockets", "ぼく",
                "2019-03-07", "这是一张宣传图", 0, 6, 1, true));
        itemBeanList.add(new BarTipItemBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551960656399&di=96fb0a34205e6a6fe6268118af9d76a3&imgtype=0&src=http%3A%2F%2Fcrawl.nosdn.127.net%2F8cff1c78f5d9d745f576d4768ae0905d.jpg", "我的英雄学院", "ぼく",
                "2019-03-02", "这是一张宣传图", 7, 6, 9, false));
        itemBeanList.add(new BarTipItemBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551960695798&di=7226f70bfd4c4c26dbedd1af74cd212d&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201203%2F16%2F20120316214731_eJS8L.jpeg", "漫画", "ぼく",
                "2019-02-20", "这是一张宣传图", 10, 55, 60, false));
        itemBeanList.add(new BarTipItemBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551960715761&di=c54872e68752a6cc50147ba66b2bc266&imgtype=0&src=http%3A%2F%2Fimg.go007.com%2F2017%2F02%2F08%2F762f1e4609211107_0.jpg", "游戏", "ぼく",
                "2019-01-30", "这是一张宣传图", 6, 1, 9, false));
    }

    @Override
    public void onClick(View v) {
        int position;
        switch (v.getId()) {
            case R.id.card_item_share_ll:
                position = (int) v.getTag(R.id.card_item_share_ll);
                adapter.update(adapter.UPDATE_SHARE, position);
                break;
            case R.id.card_item_chat_ll:
                position = (int) v.getTag(R.id.card_item_chat_ll);
                adapter.update(adapter.UPDATE_CHAT, position);
                break;
            case R.id.card_item_like_ll:
                position = (int) v.getTag(R.id.card_item_like_ll);
                adapter.update(adapter.UPDATE_LIKE, position);
                break;
        }
    }
}
