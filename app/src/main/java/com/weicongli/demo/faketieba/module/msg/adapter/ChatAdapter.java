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
import com.weicongli.demo.faketieba.module.msg.model.ChatBean;

import java.util.List;

/**
 * @author: WeicongLi
 * @time: 2019/3/27 19:09
 * @email: 912220261@qq.com
 * @Function:
 */
public class ChatAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Context context;
    private List<ChatBean> chatBeanList;

    public ChatAdapter(Context context, List<ChatBean> chatBeanList) {
        this.context = context;
        this.chatBeanList = chatBeanList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return chatBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return chatBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChatHolder holder;
        if (convertView == null){
            holder = new ChatHolder();
            convertView = inflater.inflate(R.layout.msg_chat_item,parent,false);
            holder.imageView = convertView.findViewById(R.id.chat_iv);
            holder.titleTv = convertView.findViewById(R.id.chat_title_tv);
            holder.contentTv = convertView.findViewById(R.id.chat_content_tv);
            holder.timeTv = convertView.findViewById(R.id.chat_time_tv);
            convertView.setTag(holder);
        }else {
            holder = (ChatHolder) convertView.getTag();
        }
        ChatBean chatBean = chatBeanList.get(position);
        Glide.with(context).load(chatBean.getImage()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(holder.imageView);
        holder.titleTv.setText(chatBean.getTitle());
        holder.timeTv.setText(chatBean.getTime());
        holder.contentTv.setText(chatBean.getName()+":"+chatBean.getContent());
        return convertView;
    }

    class ChatHolder{
        ImageView imageView;
        TextView titleTv;
        TextView contentTv;
        TextView timeTv;
    }
}
