package com.rainwii.zsyy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.bean.Call;

import java.util.List;

/**
 * 描述：排队叫号的适配器
 * 作者 mjd
 * 日期：2015/10/19 21:40
 */
public class CallAdapter extends BaseAdapter {
    private Context context;
    private List<Call> callList;

    public CallAdapter(Context context, List<Call> callList) {
        this.context = context;
        this.callList = callList;
    }

    @Override
    public int getCount() {
        return callList.size();
    }

    @Override
    public Object getItem(int position) {
        return callList.get(position);
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
            view = View.inflate(context, R.layout.item_call, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        Call call = callList.get(position);
        holder.tvNum.setText(call.getNum());
        holder.tvFaculty.setText(call.getFaculty());
        holder.tvDate.setText(call.getDate());
        return view;
    }

    public static class ViewHolder {
        public final TextView tvNum;
        public final TextView tvFaculty;
        public final TextView tvDate;
        public final ImageView ivStar;
        public final View root;

        public ViewHolder(View root) {
            tvNum = (TextView) root.findViewById(R.id.tv_num);
            tvFaculty = (TextView) root.findViewById(R.id.tv_faculty);
            tvDate = (TextView) root.findViewById(R.id.tv_date);
            ivStar = (ImageView) root.findViewById(R.id.iv_star);
            this.root = root;
        }
    }
}
