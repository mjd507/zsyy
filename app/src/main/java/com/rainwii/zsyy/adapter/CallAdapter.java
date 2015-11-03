package com.rainwii.zsyy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.adapter.base.DefaultAdapter;
import com.rainwii.zsyy.bean.Call;
import com.rainwii.zsyy.holder.BaseViewHolder;
import com.rainwii.zsyy.holder.CallHolder;

import java.util.List;

/**
 * 描述：排队叫号的适配器
 * 作者 mjd
 * 日期：2015/10/19 21:40
 */
public class CallAdapter extends DefaultAdapter<Call> {

    public CallAdapter(Context context, List<Call> list) {
        super(context, list);
    }

    @Override
    public BaseViewHolder<Call> getViewHolder(Context context) {
        return new CallHolder(context);
    }


}
