package com.rainwii.zsyy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.education.EducationMainActivity;
import com.rainwii.zsyy.activity.online.OnlineMainActivity;
import com.rainwii.zsyy.activity.reservation.ReservationSetMealActivity;
import com.rainwii.zsyy.bean.ReservationSetMeal;

/**
 * 描述：
 * 作者 mjd
 * 日期：2015/10/12 9:08
 */
public class ServiceFragment extends BaseFragment {
    private TextView tvAction1;
    private TextView tvAction2;
    private TextView tvAction4;
    private TextView tvAction5;
    private TextView tvAction6;
    private TextView tvAction8;
    private TextView tvAction9;

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_service, null);
        setTitle(view, "服务");
        tvAction1 = (TextView) view.findViewById(R.id.tv_action_1);
        tvAction2 = (TextView) view.findViewById(R.id.tv_action_2);
        tvAction4 = (TextView) view.findViewById(R.id.tv_action_4);
        tvAction5 = (TextView) view.findViewById(R.id.tv_action_5);
        tvAction6 = (TextView) view.findViewById(R.id.tv_action_6);
        tvAction8 = (TextView) view.findViewById(R.id.tv_action_8);
        tvAction9 = (TextView) view.findViewById(R.id.tv_action_9);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListeners() {
        tvAction1.setOnClickListener(this);
        tvAction2.setOnClickListener(this);
        tvAction4.setOnClickListener(this);
        tvAction5.setOnClickListener(this);
        tvAction6.setOnClickListener(this);
        tvAction8.setOnClickListener(this);
        tvAction9.setOnClickListener(this);
    }

    @Override
    protected void handleClick(View view) {
        switch (view.getId()) {
            case R.id.tv_action_1:
                enterActivity(OnlineMainActivity.class);
                break;
            case R.id.tv_action_2:
                break;
            case R.id.tv_action_4:
                enterActivity(ReservationSetMealActivity.class);
                break;
            case R.id.tv_action_5:
                break;
            case R.id.tv_action_6:
                enterActivity(EducationMainActivity.class);
                break;
            case R.id.tv_action_8:
                break;
            case R.id.tv_action_9:
                break;
        }
    }
}
