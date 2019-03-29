package com.weicongli.demo.faketieba.module.msg.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.demo.weicongli.library.utils.ViewUtils;
import com.weicongli.demo.faketieba.R;
import com.weicongli.demo.faketieba.module.msg.model.ContactBean;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * @author: WeicongLi
 * @time: 2019/3/27 21:19
 * @email: 912220261@qq.com
 * @Function:
 */
public class ContactAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<ContactBean> contactBeanList;
    private RequestOptions options;

    public ContactAdapter(Context context, List<ContactBean> contactBeanList) {
        this.contactBeanList = contactBeanList;
        this.context = context;
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
            options = RequestOptions.bitmapTransform(new MultiTransformation<>(
                    new CenterCrop(),
                    new RoundedCornersTransformation((int) ViewUtils.dpToPixel(3), 3, RoundedCornersTransformation.CornerType.ALL)));
            convertView = inflater.inflate(R.layout.msg_contact_item, parent, false);
            holder.avatarIv = convertView.findViewById(R.id.contact_avatar_iv);
            holder.nameTv = convertView.findViewById(R.id.contact_name_tv);
            convertView.setTag(holder);
        } else {
            holder = (ContactHolder) convertView.getTag();
        }
        ContactBean bean = contactBeanList.get(position);
        holder.nameTv.setText(bean.getName());
        Glide.with(context).load(bean.getAvatar()).apply(options).into(holder.avatarIv);
        return convertView;
    }

    class ContactHolder {
        ImageView avatarIv;
        TextView nameTv;
    }
}
