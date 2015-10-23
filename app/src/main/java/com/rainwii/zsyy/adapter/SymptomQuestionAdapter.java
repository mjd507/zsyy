package com.rainwii.zsyy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rainwii.zsyy.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：导诊 --> 问题(listView)的适配器
 * 作者 mjd
 * 日期：2015/10/22 17:16
 */
public class SymptomQuestionAdapter extends BaseAdapter {

    private Context context;
    private List<String> list;
    public Map<Integer, Boolean> map = new HashMap<>();

    public SymptomQuestionAdapter(Context context, List<String> list) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder holder;
        if (convertView == null) {
            view = View.inflate(context, R.layout.item_symptom_question, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.tvItem.setText(list.get(position));
        if (map.get(position) == null || !map.get(position)) {
            holder.iv.setImageResource(R.drawable.ic_symptom_check_unselect);
            map.put(position, false);
        } else {
            holder.iv.setImageResource(R.drawable.ic_symptom_check_select);
            map.put(position, true);
        }

        return view;
    }

    public static class ViewHolder {
        public final TextView tvItem;
        public final ImageView iv;
        public final View root;

        public ViewHolder(View root) {
            tvItem = (TextView) root.findViewById(R.id.tv_item);
            iv = (ImageView) root.findViewById(R.id.iv);
            this.root = root;
        }
    }
}
