package com.rainwii.zsyy.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.bean.Call;

/**
 * 描述：
 * 作者 mjd
 * 日期：2015/11/3 11:31
 */
public class CallHolder extends BaseViewHolder<Call> {
    private TextView tvNum;
    private TextView tvFaculty;
    private TextView tvDate;
    private ImageView ivStar;

    public CallHolder(Context context) {
        super(context);
    }

    @Override
    public View initView(Context context) {
        View view = View.inflate(context, R.layout.item_call, null);
        tvNum = (TextView) view.findViewById(R.id.tv_num);
        tvFaculty = (TextView) view.findViewById(R.id.tv_faculty);
        tvDate = (TextView) view.findViewById(R.id.tv_date);
        ivStar = (ImageView) view.findViewById(R.id.iv_star);
        return view;
    }

    @Override
    public void refreshView(Call call) {
        tvNum.setText(call.getNum());
        tvFaculty.setText(call.getFaculty());
        tvDate.setText(call.getDate());
    }

}
