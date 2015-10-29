package com.rainwii.zsyy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rainwii.zsyy.R;

import java.util.List;

/**
 * 描述：
 * 作者 mjd
 * 日期：2015/10/29 14:48
 */
public class EducationAdapter extends BaseAdapter {
    private Context context;
    private List<String> list;

    public EducationAdapter(Context context, List<String> list) {
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
        TextView tv;
        if (convertView == null) {
            view = View.inflate(context, R.layout.item_expert_faculty, null);
            tv = (TextView) view.findViewById(R.id.tv_item);
            view.setTag(tv);
        } else {
            view = convertView;
            tv = (TextView) view.getTag();
        }
        tv.setText(list.get(position));
        return view;
    }
}
