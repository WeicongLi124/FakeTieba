package com.weicongli.demo.faketieba.module.person;

import android.view.View;
import android.widget.ListView;

import com.demo.weicongli.library.base.BaseFragment;
import com.weicongli.demo.faketieba.R;
import com.weicongli.demo.faketieba.module.person.adapter.PersonListAdapter;
import com.weicongli.demo.faketieba.module.person.bean.PersonListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: WeicongLi
 * @time: 2019/2/15 16:26
 * @email: 912220261@qq.com
 * @Function:
 */
public class PersonFragment extends BaseFragment {
    private int[] image = {R.drawable.icon_mine_list_collect, R.drawable.icon_mine_list_history,
            R.drawable.icon_mine_list_friend, R.drawable.borrow_cash, R.drawable.icon_mine_list_finance,
            R.drawable.icon_mine_list_member, R.drawable.icon_mine_list_gift, R.drawable.icon_mine_list_card,
            R.drawable.icon_mine_list_grade, R.drawable.icon_post_topic_n, R.drawable.icon_mine_list_live,
            R.drawable.icon_mine_list_service, R.drawable.icon_mine_bdcard_72, R.drawable.icon_mine_list_more};
    private String[] title = {"我的收藏", "浏览历史", "我的群组", "有钱花", "度小满金融", "会员中心",
            "我的礼物", "卡包", "蓝钻", "话题", "直播", "服务中心", "免流量特权", "更多"};
    private List<PersonListBean> personListBeanList;
    private ListView listView;
    private PersonListAdapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.person_fragment;
    }

    @Override
    protected void initView(View view) {
        listView = view.findViewById(R.id.person_lv);
        listView.setDividerHeight(0);
    }

    @Override
    protected void initListener() {
        initData();
        adapter = new PersonListAdapter(personListBeanList, getContext());
        listView.setAdapter(adapter);
    }

    private void initData() {
        personListBeanList = new ArrayList<>();
        personListBeanList.add(new PersonListBean(0, "ぼく", R.drawable.avatar));
        personListBeanList.add(new PersonListBean(1, 2 + "", 86 + "", 6 + "", 20 + ""));
        personListBeanList.add(new PersonListBean(2));
        for (int i = 0; i < image.length; i++) {
            personListBeanList.add(new PersonListBean(3, image[i], title[i]));
        }
    }
}
