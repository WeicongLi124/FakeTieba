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
import com.weicongli.demo.faketieba.module.home.model.BarTipItemBean;

import java.util.List;

/**
 * @author: WeicongLi
 * @time: 2019/3/7 16:23
 * @email: 912220261@qq.com
 * @Function:
 */
public class FocusAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<BarTipItemBean> itemBeanList;
    private View.OnClickListener clickListener;
    public final int UPDATE_SHARE = 0;
    public final int UPDATE_CHAT = 1;
    public final int UPDATE_LIKE = 2;

    public FocusAdapter(Context context, List<BarTipItemBean> itemBeanList, View.OnClickListener clickListener) {
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
    public Object getItem(int position) {
        return itemBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CenterViewHolder viewHolder;
        BarTipItemBean itemBean;
        if (convertView == null) {
            viewHolder = new CenterViewHolder();
            convertView = inflater.inflate(R.layout.home_bar_tip_item, parent, false);
            viewHolder.avatarIv = convertView.findViewById(R.id.focus_item_avatar_iv);
            viewHolder.nameTv = convertView.findViewById(R.id.focus_item_bar_name_tv);
            viewHolder.userNameTv = convertView.findViewById(R.id.focus_item_user_name_tv);
            viewHolder.timeTv = convertView.findViewById(R.id.focus_item_time_tv);
            viewHolder.contentTv = convertView.findViewById(R.id.focus_item_content_tv);
            viewHolder.shareLl = convertView.findViewById(R.id.card_item_share_ll);
            viewHolder.chatLl = convertView.findViewById(R.id.card_item_chat_ll);
            viewHolder.likeLl = convertView.findViewById(R.id.card_item_like_ll);
            viewHolder.shareTv = convertView.findViewById(R.id.card_item_share_tv);
            viewHolder.chatTv = convertView.findViewById(R.id.card_item_chat_tv);
            viewHolder.likeTv = convertView.findViewById(R.id.card_item_like_tv);
            viewHolder.likeIv = convertView.findViewById(R.id.card_item_like_iv);
            //设置监听
            viewHolder.shareLl.setOnClickListener(clickListener);
            viewHolder.chatLl.setOnClickListener(clickListener);
            viewHolder.likeLl.setOnClickListener(clickListener);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (CenterViewHolder) convertView.getTag();
        }
        itemBean = itemBeanList.get(position);
        setData(viewHolder, itemBean, position);
        return convertView;
    }

    /**
     * 为item设置数据
     *
     * @param viewHolder
     * @param itemBean
     * @param position
     */
    private void setData(CenterViewHolder viewHolder, BarTipItemBean itemBean, int position) {
        Glide.with(context).load(itemBean.getAvatar()).apply(new RequestOptions().circleCrop()).into(viewHolder.avatarIv);
        viewHolder.nameTv.setText(itemBean.getName());
        viewHolder.userNameTv.setText(itemBean.getUserName());
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
    }

    private class CenterViewHolder {
        ImageView avatarIv;
        TextView nameTv;
        TextView userNameTv;
        TextView timeTv;
        TextView contentTv;
        LinearLayout shareLl;
        LinearLayout chatLl;
        LinearLayout likeLl;
        TextView shareTv;
        TextView chatTv;
        TextView likeTv;
        ImageView likeIv;
    }
}
