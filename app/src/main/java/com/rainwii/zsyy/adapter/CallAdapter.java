package com.rainwii.zsyy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.rainwii.zsyy.bean.Call;

import java.util.List;

/**
 * 描述：
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
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
