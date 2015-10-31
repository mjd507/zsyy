package com.rainwii.zsyy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.bean.SubscribeSpecial;

import java.util.List;

/**
 * 描述：订阅 --> 专题适配器
 * 作者 mjd
 * 日期：2015/10/31 15:15
 */
public class SubscribeSpecialAdapter extends BaseAdapter {
    private Context context;
    private List<SubscribeSpecial> specialList;

    public SubscribeSpecialAdapter(Context context, List<SubscribeSpecial> specialList) {
        this.context = context;
        this.specialList = specialList;
    }

    @Override
    public int getCount() {
        return specialList.size();
    }

    @Override
    public Object getItem(int position) {
        return specialList.get(position);
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
            view = View.inflate(context, R.layout.item_subscribe_special, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        SubscribeSpecial special = specialList.get(position);
        if (position % 3 == 0)
            holder.ivitem.setImageResource(R.drawable.demo5);
        else if (position % 3 == 1)
            holder.ivitem.setImageResource(R.drawable.demo6);
        else
            holder.ivitem.setImageResource(R.drawable.demo4);
        holder.tvitem.setText(special.getTitle());
        return view;
    }

    public class ViewHolder {
        public final ImageView ivitem;
        public final TextView tvitem;
        public final FrameLayout detaillayout;
        public final View root;

        public ViewHolder(View root) {
            ivitem = (ImageView) root.findViewById(R.id.iv_item);
            tvitem = (TextView) root.findViewById(R.id.tv_item);
            detaillayout = (FrameLayout) root.findViewById(R.id.detail_layout);
            this.root = root;
        }
    }
}
