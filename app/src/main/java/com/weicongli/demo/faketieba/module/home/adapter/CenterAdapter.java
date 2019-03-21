package com.weicongli.demo.faketieba.module.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.weicongli.demo.faketieba.R;
import com.weicongli.demo.faketieba.module.home.model.UserTipItemBean;

import java.util.List;

/**
 * @author: WeicongLi
 * @time: 2019/3/1 17:05
 * @email: 912220261@qq.com
 * @Function:
 */
public class CenterAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<UserTipItemBean> itemBeanList;
    private View.OnClickListener clickListener;
    public final int UPDATE_SHARE = 0;
    public final int UPDATE_CHAT = 1;
    public final int UPDATE_LIKE = 2;

    public CenterAdapter(Context context, List<UserTipItemBean> itemBeanList, View.OnClickListener clickListener) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.itemBeanList = itemBeanList;
        this.clickListener = clickListener;
    }

    public void update(int type, int position) {
        switch (type) {
            case UPDATE_SHARE:
                itemBeanList.get(position).setShareNum(itemBeanList.get(position).getShareNum() + 1);
                break;
            case UPDATE_CHAT:
                itemBeanList.get(position).setChatNum(itemBeanList.get(position).getChatNum() + 1);
                break;
            case UPDATE_LIKE:
                int likeNum = itemBeanList.get(position).getLikeNum();
                if (itemBeanList.get(position).isHadLike()) {
                    itemBeanList.get(position).setLikeNum(likeNum - 1);
                    itemBeanList.get(position).setHadLike(false);
                } else {
                    itemBeanList.get(position).setLikeNum(likeNum + 1);
                    itemBeanList.get(position).setHadLike(true);
                }
                break;
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return itemBeanList.size();
    }

    @Override
    public Object getItem(int i) {
        return itemBeanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        CenterViewHolder viewHolder;
        UserTipItemBean itemBean = itemBeanList.get(position);
        if (view == null) {
            viewHolder = new CenterViewHolder();
            view = inflater.inflate(R.layout.home_user_tip_item, viewGroup, false);
            viewHolder.avatarIv = view.findViewById(R.id.center_item_avatar_iv);
            viewHolder.nameTv = view.findViewById(R.id.center_item_name_tv);
            viewHolder.barNameTv = view.findViewById(R.id.center_item_bar_tv);
            viewHolder.timeTv = view.findViewById(R.id.center_item_time_tv);
            viewHolder.contentTv = view.findViewById(R.id.center_item_content_tv);
            viewHolder.shareLl = view.findViewById(R.id.card_item_share_ll);
            viewHolder.chatLl = view.findViewById(R.id.card_item_chat_ll);
            viewHolder.likeLl = view.findViewById(R.id.card_item_like_ll);
            viewHolder.shareTv = view.findViewById(R.id.card_item_share_tv);
            viewHolder.chatTv = view.findViewById(R.id.card_item_chat_tv);
            viewHolder.likeTv = view.findViewById(R.id.card_item_like_tv);
            viewHolder.likeIv = view.findViewById(R.id.card_item_like_iv);
            viewHolder.closeLl = view.findViewById(R.id.center_item_close_ll);
            //设置监听
            viewHolder.shareLl.setOnClickListener(clickListener);
            viewHolder.chatLl.setOnClickListener(clickListener);
            viewHolder.likeLl.setOnClickListener(clickListener);
            viewHolder.closeLl.setOnClickListener(clickListener);
            view.setTag(viewHolder);
        } else {
            viewHolder = (CenterViewHolder) view.getTag();
        }
        Glide.with(context).load(itemBean.getAvatar()).apply(new RequestOptions().circleCrop()).into(viewHolder.avatarIv);
        viewHolder.nameTv.setText(itemBean.getName());
        viewHolder.barNameTv.setText(itemBean.getBarName());
        viewHolder.timeTv.setText(itemBean.getTime());
        viewHolder.contentTv.setText(itemBean.getContent());
        //设置分享、讨论与点赞数
        if (itemBean.getShareNum() == 0) viewHolder.shareTv.setText("分享");
        else viewHolder.shareTv.setText(itemBean.getShareNum() + "");
        viewHolder.chatTv.setText(itemBean.getChatNum() + "");
        viewHolder.likeTv.setText(itemBean.getLikeNum() + "");
        //设置该贴是否已点赞
        if (itemBean.isHadLike())
            viewHolder.likeIv.setImageResource(R.drawable.icon_home_card_like_s);
        else viewHolder.likeIv.setImageResource(R.drawable.home_card_like_selector);
        viewHolder.shareLl.setTag(R.id.card_item_share_ll, position);
        viewHolder.chatLl.setTag(R.id.card_item_chat_ll, position);
        viewHolder.likeLl.setTag(R.id.card_item_like_ll, position);
        viewHolder.closeLl.setTag(R.id.center_item_close_ll, position);
        return view;
    }

    private class CenterViewHolder {
        ImageView avatarIv;
        TextView nameTv;
        TextView barNameTv;
        TextView timeTv;
        TextView contentTv;
        LinearLayout shareLl;
        LinearLayout chatLl;
        LinearLayout likeLl;
        ImageView closeLl;
        TextView shareTv;
        TextView chatTv;
        TextView likeTv;
        ImageView likeIv;
    }
}
