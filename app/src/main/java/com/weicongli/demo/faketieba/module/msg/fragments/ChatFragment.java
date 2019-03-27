package com.weicongli.demo.faketieba.module.msg.fragments;

import android.view.View;
import android.widget.ListView;

import com.demo.weicongli.library.base.BaseFragment;
import com.weicongli.demo.faketieba.R;
import com.weicongli.demo.faketieba.module.msg.adapter.ChatAdapter;
import com.weicongli.demo.faketieba.module.msg.model.ChatBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: WeicongLi
 * @time: 2019/2/20 22:33
 * @email: 912220261@qq.com
 * @Function:
 */
public class ChatFragment extends BaseFragment {
    private ListView listView;
    private List<ChatBean> chatBeanList;
    private ChatAdapter adapter;
    private boolean isFirstInit = true;

    @Override
    protected int setLayout() {
        return R.layout.msg_chat_fragment;
    }

    @Override
    protected void initParams(View view) {
        listView = view.findViewById(R.id.chat_lv);
        listView.setDividerHeight(0);
        if (isFirstInit) {
            initData();
            adapter = new ChatAdapter(getContext(), chatBeanList);
            isFirstInit = false;
        }
        listView.setAdapter(adapter);
    }

    @Override
    protected void initListener() {

    }

    private void initData() {
        chatBeanList = new ArrayList<>();
        chatBeanList.add(new ChatBean(R.drawable.icon_im_subscribe, "吧广播", "clannad吧", "这周新专题企划：『追忆专题』那些永远被定格在二次元的幕后功臣们", "2019-03-20"));
        chatBeanList.add(new ChatBean(R.drawable.icon_new_stranger, "陌生人的消息", "某陌生人", "能加一下你的微信吗", "2019-03-27"));
    }
}
