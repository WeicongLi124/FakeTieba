package com.weicongli.demo.faketieba.module.bar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.weicongli.demo.faketieba.R;
import com.weicongli.demo.faketieba.module.bar.holder.AddMoreHolder;
import com.weicongli.demo.faketieba.module.bar.holder.BarHolder;
import com.weicongli.demo.faketieba.module.bar.holder.FocusBarHolder;
import com.weicongli.demo.faketieba.module.bar.holder.LatelyHolder;
import com.weicongli.demo.faketieba.module.bar.holder.SearchHolder;
import com.weicongli.demo.faketieba.module.bar.model.BarDataBean;

import java.util.List;

/**
 * @author: WeicongLi
 * @time: 2019/2/18 21:55
 * @email: 912220261@qq.com
 * @Function:
 */
@SuppressWarnings("ALL")
public class BarListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<BarDataBean> dataBeanList;
    private static final int LIST_ITEM_SEARCH = 0;
    private static final int LIST_ITEM_LATELY_BAR = 1;
    private static final int LIST_ITEM_VIEW = 2;
    private static final int LIST_ITEM_MY_BARS = 3;
    private static final int LIST_ITEM_ADD_MORE = 4;

    public BarListAdapter(List<BarDataBean> dataBeanList, Context context) {
        this.dataBeanList = dataBeanList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dataBeanList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataBeanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemViewType(int position) {
        int type = dataBeanList.get(position).getType();
        switch (type) {
            case 0:
                return LIST_ITEM_SEARCH;
            case 1:
                return LIST_ITEM_LATELY_BAR;
            case 2:
                return LIST_ITEM_VIEW;
            case 3:
                return LIST_ITEM_MY_BARS;
            default:
                return LIST_ITEM_ADD_MORE;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 5;
    }

    @SuppressWarnings("OverlyLongMethod")
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        BarDataBean bean = dataBeanList.get(position);
        SearchHolder searchHolder;
        final LatelyHolder latelyHolder;
        FocusBarHolder viewHolder;
        BarHolder barHolder;
        AddMoreHolder moreHolder;
        int viewType = getItemViewType(position);
        switch (viewType) {
            case LIST_ITEM_SEARCH:
                //搜索帖子
                if (view == null) {
                    searchHolder = new SearchHolder();
                    view = inflater.inflate(R.layout.bar_list_search_item, viewGroup, false);
                    searchHolder.searchLl = view.findViewById(R.id.bar_list_search_ll);
                    view.setTag(searchHolder);
                } else {
                    searchHolder = (SearchHolder) view.getTag();
                }
                break;
            case LIST_ITEM_LATELY_BAR:
                //最近逛的吧
                if (view == null) {
                    latelyHolder = new LatelyHolder();
                    view = inflater.inflate(R.layout.bar_list_lately_bar_item, viewGroup, false);
                    latelyHolder.showIv = view.findViewById(R.id.lately_show_iv);
                    latelyHolder.containerRl = view.findViewById(R.id.container_rl);
                    latelyHolder.latelyLine = view.findViewById(R.id.lately_line);
                    view.setTag(latelyHolder);
                } else {
                    latelyHolder = (LatelyHolder) view.getTag();
                }
                latelyHolder.showIv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showLatelyBars(latelyHolder);
                    }
                });
                break;
            case LIST_ITEM_VIEW:
                //单View“我关注的吧”
                if (view == null) {
                    viewHolder = new FocusBarHolder();
                    view = inflater.inflate(R.layout.bar_list_view_item, viewGroup, false);
                    viewHolder.viewLl = view.findViewById(R.id.bar_list_view_ll);
                    view.setTag(viewHolder);
                } else {
                    viewHolder = (FocusBarHolder) view.getTag();
                }
                break;
            case LIST_ITEM_MY_BARS:
                //我关注的贴吧
                if (view == null) {
                    barHolder = new BarHolder();
                    view = inflater.inflate(R.layout.bar_list_bar_item, viewGroup, false);
                    barHolder.nameTv1 = view.findViewById(R.id.bar_name_tv1);
                    barHolder.levelIv1 = view.findViewById(R.id.bar_level_iv1);
                    barHolder.signIv1 = view.findViewById(R.id.bar_sign_iv1);
                    barHolder.nameTv2 = view.findViewById(R.id.bar_name_tv2);
                    barHolder.levelIv2 = view.findViewById(R.id.bar_level_iv2);
                    barHolder.signIv2 = view.findViewById(R.id.bar_sign_iv2);
                    barHolder.rightRl = view.findViewById(R.id.bar_item_right_rl);
                    view.setTag(barHolder);
                } else {
                    barHolder = (BarHolder) view.getTag();
                }
                barHolder.nameTv1.setText(bean.getBarNameL());
                barHolder.levelIv1.setImageResource(bean.getBarLevelL());
                if (bean.isSignL())
                    barHolder.signIv1.setImageResource(R.drawable.icon_ba_sign_n);
                if (bean.isHaveRight()) {
                    barHolder.rightRl.setVisibility(View.VISIBLE);
                    barHolder.nameTv2.setText(bean.getBarNameR());
                    barHolder.levelIv2.setImageResource(bean.getBarLevelR());
                    if (bean.isSignR())
                        barHolder.signIv1.setImageResource(R.drawable.icon_ba_sign_n);
                }
                break;
            case LIST_ITEM_ADD_MORE:
                //探索更多有趣的吧
                if (view == null) {
                    moreHolder = new AddMoreHolder();
                    view = inflater.inflate(R.layout.bar_list_add_more_item, viewGroup, false);
                    moreHolder.addMoreLl = view.findViewById(R.id.bar_list_add_more_ll);
                    view.setTag(moreHolder);
                } else {
                    moreHolder = (AddMoreHolder) view.getTag();
                }
                break;
        }
        return view;
    }

    /**
     * 显示最近逛的吧
     * @param latelyHolder
     */
    private void showLatelyBars(LatelyHolder latelyHolder) {
        if (latelyHolder.containerRl.isShown()) {
            latelyHolder.showIv.setImageResource(R.drawable.icon_ba_hide_n);
            latelyHolder.containerRl.setVisibility(View.GONE);
            latelyHolder.latelyLine.setVisibility(View.GONE);
        } else {
            latelyHolder.showIv.setImageResource(R.drawable.icon_ba_show_n);
            latelyHolder.containerRl.setVisibility(View.VISIBLE);
            latelyHolder.latelyLine.setVisibility(View.VISIBLE);
        }
    }
}
