package com.weicongli.demo.faketieba.module.msg.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.weicongli.demo.faketieba.R;
import com.weicongli.demo.faketieba.module.msg.model.MessageBean;

import java.util.List;

/**
 * @author: WeicongLi
 * @time: 2019/3/5 11:42
 * @email: 912220261@qq.com
 * @Function:
 */
public class MsgListAdapter extends BaseAdapter {
    private List<MessageBean> messageBeanList;
    private Context context;
    private LayoutInflater layoutInflater;

    public MsgListAdapter(Context context, List<MessageBean> messageBeanList) {
        this.messageBeanList = messageBeanList;
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return messageBeanList.size();
    }

    @Override
    public Object getItem(int i) {
        return messageBeanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MessageBean bean = messageBeanList.get(i);
        MessageViewHolder viewHolder;
        if (view == null) {
            viewHolder = new MessageViewHolder();
            view = layoutInflater.inflate(R.layout.msg_message_item, viewGroup, false);
            viewHolder.avatarIv = view.findViewById(R.id.msg_item_avatar_iv);
            viewHolder.nameTv = view.findViewById(R.id.msg_item_name_tv);
            viewHolder.timeTv = view.findViewById(R.id.msg_item_time_tv);
            viewHolder.replayTv = view.findViewById(R.id.msg_item_reply_tv);
            viewHolder.contentTv = view.findViewById(R.id.msg_item_content_tv);
            viewHolder.barNameTv = view.findViewById(R.id.msg_item_bar_tv);
            view.setTag(viewHolder);
        } else {
            viewHolder = (MessageViewHolder) view.getTag();
        }
        Glide.with(context).load(bean.getAvatar()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(viewHolder.avatarIv);
        viewHolder.nameTv.setText(bean.getName());
        viewHolder.timeTv.setText(bean.getTime());
        viewHolder.replayTv.setText(bean.getReply());
        viewHolder.contentTv.setText(bean.getContent());
        viewHolder.barNameTv.setText(bean.getBarName());
        return view;
    }

    class MessageViewHolder {
        ImageView avatarIv;
        TextView nameTv;
        TextView timeTv;
        TextView replayTv;
        TextView contentTv;
        TextView barNameTv;
    }
}
