package com.rainwii.zsyy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.bean.SubscribeChild;

import java.util.List;

/**
 * 描述：订阅 --> 饮食适配器
 * 作者 mjd
 * 日期：2015/10/31 15:15
 */
public class SubscribeChildAdapter extends BaseAdapter {
    private Context context;
    private List<SubscribeChild> foodList;

    public SubscribeChildAdapter(Context context, List<SubscribeChild> foodList) {
        this.context = context;
        this.foodList = foodList;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int position) {
        return foodList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder holder;
        if (convertView == null) {
            view = View.inflate(context, R.layout.item_subscribe_content, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        SubscribeChild food = foodList.get(position);
        if (position % 4 == 0)
            holder.ivitem.setImageResource(R.drawable.demo5);
        else if (position % 4 == 1)
            holder.ivitem.setImageResource(R.drawable.demo6);
        else if (position % 4 == 2)
            holder.ivitem.setImageResource(R.drawable.demo4);
        else
            holder.ivitem.setImageResource(R.drawable.demo7);
        holder.tvitemtitle.setText(food.getTitle());
        holder.tvitemdate.setText(food.getDate());
        return view;
    }


    public class ViewHolder {
        public final ImageView ivitem;
        public final FrameLayout articlelistlayout;
        public final TextView tvitemtitle;
        public final TextView tvitemdate;
        public final View root;

        public ViewHolder(View root) {
            ivitem = (ImageView) root.findViewById(R.id.iv_item);
            articlelistlayout = (FrameLayout) root.findViewById(R.id.article_list_layout);
            tvitemtitle = (TextView) root.findViewById(R.id.tv_item_title);
            tvitemdate = (TextView) root.findViewById(R.id.tv_item_date);
            this.root = root;
        }
    }
}
