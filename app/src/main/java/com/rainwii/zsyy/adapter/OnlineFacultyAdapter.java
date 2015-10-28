package com.rainwii.zsyy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rainwii.zsyy.R;

import java.util.List;

/**
 * 描述：图文咨询 --> 科室列表的适配器
 * 作者 mjd
 * 日期：2015/10/13 19:21
 */
public class OnlineFacultyAdapter extends BaseAdapter {

    private Context context;
    private List<String> facultyList;

    public OnlineFacultyAdapter(Context context, List<String> facultyList) {
        this.context = context;
        this.facultyList = facultyList;
    }

    @Override
    public int getCount() {
        return facultyList.size();
    }

    @Override
    public Object getItem(int position) {
        return facultyList.get(position);
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
            view = View.inflate(context, R.layout.item_register_faculty, null);
            tv = (TextView) view.findViewById(R.id.tv_item);
            view.setTag(tv);
        } else {
            view = convertView;
            tv = (TextView) view.getTag();
        }
        tv.setText(facultyList.get(position));
        return view;
    }
}
