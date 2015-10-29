package com.rainwii.zsyy.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.reservation.ReservationSetMealActivity;
import com.rainwii.zsyy.activity.reservation.ReservationSetMealDetailActivity;
import com.rainwii.zsyy.bean.ReservationSetMeal;
import com.rainwii.zsyy.utils.ToastUtils;

import java.util.List;

/**
 * 描述：
 * 作者 mjd
 * 日期：2015/10/29 11:40
 */
public class ReservationSetMealAdapter extends BaseAdapter {
    private Context context;
    private List<ReservationSetMeal> list;

    public ReservationSetMealAdapter(Context context, List<ReservationSetMeal> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder holder;
        if (convertView == null) {
            view = View.inflate(context, R.layout.item_reservation_set_meal, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        ReservationSetMeal setMeal = list.get(position);
        holder.tvname.setText(setMeal.getName());
        holder.tvbelong.setText(setMeal.getBelong());
        holder.tvmancost.setText(setMeal.getManCost());
        holder.tvwomencost.setText(setMeal.getWomenCost());
        holder.tvcontent.setText(setMeal.getContent());
//        final String setMealDetail = setMeal.getDetail();
        holder.tvdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ToastUtils.showShort(context, "position:" + position);
                Intent intent = new Intent(context, ReservationSetMealDetailActivity.class);
//                intent.putExtra("setMealDetail",setMealDetail);
                context.startActivity(intent);
            }
        });
        return view;
    }


    public static class ViewHolder {
        public final ImageView iv;
        public final TextView tvname;
        public final TextView tvbelong;
        public final TextView tvmancost;
        public final TextView tvwomencost;
        public final TextView tvdetail;
        public final TextView tvcontent;
        public final View root;

        public ViewHolder(View root) {
            iv = (ImageView) root.findViewById(R.id.iv);
            tvname = (TextView) root.findViewById(R.id.tv_name);
            tvbelong = (TextView) root.findViewById(R.id.tv_belong);
            tvmancost = (TextView) root.findViewById(R.id.tv_man_cost);
            tvwomencost = (TextView) root.findViewById(R.id.tv_women_cost);
            tvdetail = (TextView) root.findViewById(R.id.tv_detail);
            tvcontent = (TextView) root.findViewById(R.id.tv_content);
            this.root = root;
        }
    }
}
