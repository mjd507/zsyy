package com.rainwii.zsyy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rainwii.zsyy.R;

import java.util.List;

/**
 * 描述：身体各部位对应的疾病的适配器
 * 作者 mjd
 * 日期：2015/10/22 10:50
 */
public class SymptomPossibleSymptomAdapter extends BaseAdapter {
    private Context context;
    private List<String> list;

    public SymptomPossibleSymptomAdapter(Context context, List<String> list) {
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
            view = View.inflate(context, R.layout.item_symptom_possible_symptom, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.tvItem.setText(list.get(position));
        return view;
    }

    public static class ViewHolder {
        public final TextView tvItem;
        public final View root;

        public ViewHolder(View root) {
            tvItem = (TextView) root.findViewById(R.id.tv_item);
            this.root = root;
        }
    }
}
