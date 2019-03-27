package com.weicongli.demo.faketieba.module.msg.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.weicongli.demo.faketieba.R;
import com.weicongli.demo.faketieba.module.msg.model.ContactBean;

import java.util.List;

/**
 * @author: WeicongLi
 * @time: 2019/3/27 21:19
 * @email: 912220261@qq.com
 * @Function:
 */
public class ContactAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<ContactBean> contactBeanList;

    public ContactAdapter(Context context, List<ContactBean> contactBeanList) {
        this.contactBeanList = contactBeanList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return contactBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ContactHolder holder;
        if (convertView == null) {
            holder = new ContactHolder();
            convertView = inflater.inflate(R.layout.msg_contact_item, parent, false);
            holder.avatarIv = convertView.findViewById(R.id.contact_avatar_iv);
            holder.nameTv = convertView.findViewById(R.id.contact_name_tv);
            convertView.setTag(holder);
        } else {
            holder = (ContactHolder) convertView.getTag();
        }
        ContactBean bean = contactBeanList.get(position);
        holder.nameTv.setText(bean.getName());
        holder.avatarIv.setImageResource(bean.getAvatar());
        return convertView;
    }

    class ContactHolder {
        ImageView avatarIv;
        TextView nameTv;
    }
}
