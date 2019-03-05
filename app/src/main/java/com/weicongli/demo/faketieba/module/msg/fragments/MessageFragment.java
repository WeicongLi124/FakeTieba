package com.weicongli.demo.faketieba.module.msg.fragments;

import android.view.View;
import android.widget.ListView;

import com.demo.weicongli.library.base.BaseFragment;
import com.weicongli.demo.faketieba.R;
import com.weicongli.demo.faketieba.module.msg.adapter.MsgListAdapter;
import com.weicongli.demo.faketieba.module.msg.model.MessageBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: WeicongLi
 * @time: 2019/2/20 22:33
 * @email: 912220261@qq.com
 * @Function:
 */
public class MessageFragment extends BaseFragment {
    private ListView listView;
    private MsgListAdapter adapter;
    private List<MessageBean> messageBeanList;

    @Override
    protected int setLayout() {
        return R.layout.msg_message_fragment;
    }

    @Override
    protected void initView(View view) {
        initData();
        View headerView = getLayoutInflater().inflate(R.layout.msg_message_header_item, null);
        listView = view.findViewById(R.id.message_lv);
        listView.addHeaderView(headerView);
        adapter = new MsgListAdapter(getContext(), messageBeanList);
        listView.setDividerHeight(0);
        listView.setAdapter(adapter);
    }

    @Override
    protected void initListener() {

    }

    private void initData() {
        messageBeanList = new ArrayList<>();
        messageBeanList.add(new MessageBean(R.drawable.avatar, "ぼく", "5分钟", "sp赛高！", "《Summer Pockets 》为key社PC平台新作，于2016年12月8日宣布制作。" +
                "以离岛的乡下小镇为舞台，描绘了一个怀旧的夏天的故事。《Summer Pockets》将登录NS主机。", "summerpockets吧"));
        messageBeanList.add(new MessageBean(R.drawable.avatar, "ぼく", "7分钟", "宝可梦剑盾", "《精灵宝可梦》，另有常见非官方译名：《口袋妖怪》(中国大陆民间译名)、" +
                "《宠物小精灵》(中国香港译名)、《神奇宝贝》（中国台湾译名），是由Game Freak和Creatures株式会社开发，任天堂发行的系列游戏，是精灵宝可梦媒体作品的主要部分。", "宝可梦吧"));
        messageBeanList.add(new MessageBean(R.drawable.avatar, "ぼく", "10分钟", "key社赛高！", "《Key是ビジュアルアーツ（Visual Art's）旗下的一个品牌，创立于1998年7月21日，" +
                "是日本大阪市的一所游戏制作公司，以制作感人的Galgame而著称于业界。", "Key吧"));
        messageBeanList.add(new MessageBean(R.drawable.avatar, "ぼく", "55分钟", "任天堂就是世界主宰哒哒哒哒哒哒哒哒哒哒哒哒哒哒哒哒哒哒哒哒哒哒哒哒哒哒哒！", "《NS，全名NINTENDO SWITCH，" +
                "是任天堂游戏公司于2017年3月首发的旗舰产品，主机采用家用机掌机一体化设计。", "switch吧"));
    }
}
