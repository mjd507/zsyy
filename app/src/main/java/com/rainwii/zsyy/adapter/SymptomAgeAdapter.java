package com.rainwii.zsyy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rainwii.zsyy.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：智能导诊 年龄弹窗的适配器
 * 作者 mjd
 * 日期：2015/10/20 19:09
 */
public class SymptomAgeAdapter extends BaseAdapter {
    private Context context;
    private List<String> list;

    public SymptomAgeAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
        for (int i = 16; i < 120; i++) {
            list.add(i + "岁");
        }
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_symptom_pop_age, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvage.setText(list.get(position));
        return convertView;
    }

    public static class ViewHolder {
        public final TextView tvage;
        public final View root;

        public ViewHolder(View root) {
            tvage = (TextView) root.findViewById(R.id.tv_age);
            this.root = root;
        }
    }
}
