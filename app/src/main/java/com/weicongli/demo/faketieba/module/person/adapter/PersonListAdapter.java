package com.weicongli.demo.faketieba.module.person.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.weicongli.demo.faketieba.R;
import com.weicongli.demo.faketieba.module.person.bean.PersonListBean;
import com.weicongli.demo.faketieba.module.person.holder.AdHolder;
import com.weicongli.demo.faketieba.module.person.holder.AvatarButtonHolder;
import com.weicongli.demo.faketieba.module.person.holder.AvatarHolder;
import com.weicongli.demo.faketieba.module.person.holder.TitleHolder;

import java.util.List;

/**
 * @author: WeicongLi
 * @time: 2019/2/17 16:13
 * @email: 912220261@qq.com
 * @Function:
 */
public class PersonListAdapter extends BaseAdapter {
    private List<PersonListBean> listBeanList;
    private LayoutInflater inflater;
    private Context context;
    private static final int LIST_ITEM_AVATAR = 0;
    private static final int LIST_ITEM_AVATAR_BUTTON = 1;
    private static final int LIST_ITEM_AD = 2;
    private static final int LIST_ITEM_TITLE = 3;


    public PersonListAdapter(List<PersonListBean> listBeanList, Context context) {
        this.listBeanList = listBeanList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listBeanList.size();
    }

    @Override
    public Object getItem(int i) {
        return listBeanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemViewType(int position) {
        int type = listBeanList.get(position).getType();
        switch (type) {
            case 0:
                return LIST_ITEM_AVATAR;
            case 1:
                return LIST_ITEM_AVATAR_BUTTON;
            case 2:
                return LIST_ITEM_AD;
            case 3:
            default:
                return LIST_ITEM_TITLE;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 4;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        PersonListBean bean = listBeanList.get(position);
        AvatarHolder avatarHolder;
        AvatarButtonHolder avatarButtonHolder;
        AdHolder adHolder;
        TitleHolder titleHolder;
        int viewType = getItemViewType(position);
        switch (viewType) {
            case LIST_ITEM_AVATAR:
                //头像部分
                if (view == null) {
                    avatarHolder = new AvatarHolder();
                    view = inflater.inflate(R.layout.person_list_avatar_item, viewGroup, false);
                    avatarHolder.avatar = view.findViewById(R.id.person_avatar_iv);
                    avatarHolder.name = view.findViewById(R.id.person_name_tv);
                    view.setTag(avatarHolder);
                } else {
                    avatarHolder = (AvatarHolder) view.getTag();
                }
                Glide.with(context).load(bean.getAvatar()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(avatarHolder.avatar);
                avatarHolder.name.setText(bean.getName());
                break;
            case LIST_ITEM_AVATAR_BUTTON:
                //头像下的按钮
                if (view == null) {
                    avatarButtonHolder = new AvatarButtonHolder();
                    view = inflater.inflate(R.layout.person_list_avatar_button_item, viewGroup, false);
                    avatarButtonHolder.focus = view.findViewById(R.id.person_button_focus);
                    avatarButtonHolder.fans = view.findViewById(R.id.person_button_fans);
                    avatarButtonHolder.focusBars = view.findViewById(R.id.person_button_focusbars);
                    avatarButtonHolder.tips = view.findViewById(R.id.person_button_tips);
                    view.setTag(avatarButtonHolder);
                } else {
                    avatarButtonHolder = (AvatarButtonHolder) view.getTag();
                }
                setAvatarItemData(avatarButtonHolder, bean);
                break;
            case LIST_ITEM_AD:
                //广告栏
                if (view == null) {
                    adHolder = new AdHolder();
                    view = inflater.inflate(R.layout.person_list_ad_item, viewGroup, false);
                    adHolder.adIv = view.findViewById(R.id.person_item_ad_iv);
                    view.setTag(adHolder);
                } else {
                    adHolder = (AdHolder) view.getTag();
                }
//                adHolder.adIv.setImageResource(Color.BLUE);
                break;
            case LIST_ITEM_TITLE:
                //列表选项
                if (view == null) {
                    titleHolder = new TitleHolder();
                    view = inflater.inflate(R.layout.person_list_function_item, viewGroup, false);
                    titleHolder.title = view.findViewById(R.id.person_list_item_title);
                    titleHolder.image = view.findViewById(R.id.person_list_item_iv);
                    titleHolder.slimDivider = view.findViewById(R.id.item_divider_slim);
                    titleHolder.fatDivider = view.findViewById(R.id.item_divider_fat);
                    titleHolder.beanLl = view.findViewById(R.id.person_list_item_bean);
                    view.setTag(titleHolder);
                } else {
                    titleHolder = (TitleHolder) view.getTag();
                }
                setItemData(titleHolder, bean);
                break;
        }
        return view;
    }

    /**
     * 设置列为avatarButton的item数据
     *
     * @param avatarButtonHolder
     * @param bean
     */
    private void setAvatarItemData(AvatarButtonHolder avatarButtonHolder, PersonListBean bean) {
        avatarButtonHolder.focus.setText(bean.getFocus());
        avatarButtonHolder.fans.setText(bean.getFans());
        avatarButtonHolder.focusBars.setText(bean.getFocusBars());
        avatarButtonHolder.tips.setText(bean.getTips());
    }

    /**
     * 设置列表菜单item数据
     *
     * @param titleHolder
     * @param bean
     */
    private void setItemData(TitleHolder titleHolder, PersonListBean bean) {
        if (bean.getTitle().equals("我的群组") || bean.getTitle().equals("蓝钻") || bean.getTitle().equals("直播")
                || bean.getTitle().equals("服务中心") || bean.getTitle().equals("更多")) {
            titleHolder.slimDivider.setVisibility(View.GONE);
            titleHolder.fatDivider.setVisibility(View.VISIBLE);
        }
        if (bean.getTitle().equals("我的礼物")) titleHolder.beanLl.setVisibility(View.VISIBLE);
        titleHolder.title.setText(bean.getTitle());
        titleHolder.image.setImageResource(bean.getImage());
    }
}
