package com.rainwii.zsyy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rainwii.zsyy.R;

import java.util.List;

/**
 * 描述：挂号 --> 点击选择日期弹出内容的适配器
 * 作者 mjd
 * 日期：2015/10/16 19:28
 */
public class RegisterPopDialogAdapter extends BaseAdapter{
    private Context context;
    private List<String> futureFiveDays;

    public RegisterPopDialogAdapter(Context context, List<String> futureFiveDays) {
        this.context = context;
        this.futureFiveDays = futureFiveDays;
    }

    @Override
    public int getCount() {
        return futureFiveDays.size();
    }

    @Override
    public Object getItem(int position) {
        return futureFiveDays.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(context, R.layout.item_register_pop_dialog, null);
        TextView tvFutureDate = (TextView) convertView.findViewById(R.id.tv_dateBtn);
        tvFutureDate.setText(futureFiveDays.get(position));
        return convertView;
    }
}
