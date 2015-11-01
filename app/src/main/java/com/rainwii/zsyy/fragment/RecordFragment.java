package com.rainwii.zsyy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rainwii.zsyy.R;

/**
 * 描述：健康档案
 * 作者 mjd
 * 日期：2015/10/12 9:08
 */
public class RecordFragment extends BaseFragment {
    private LinearLayout recordItem1Layout;
    private TextView recordItem1Name;
    private TextView recordItem1Date;
    private LinearLayout recordItem2Layout;
    private TextView recordItem2Name;
    private TextView recordItem2Date;
    private LinearLayout recordItem3Layout;
    private TextView recordItem3Name;
    private TextView recordItem3Date;
    private LinearLayout recordItem4Layout;
    private TextView recordItem4Name;
    private TextView recordItem4Date;
    private LinearLayout recordItem5Layout;
    private TextView recordItem5Name;
    private TextView recordItem5Date;
    private LinearLayout recordItem6Layout;
    private TextView recordItem6Name;
    private TextView recordItem6Date;

    private void assignViews(View view) {
        recordItem1Layout = (LinearLayout) view.findViewById(R.id.record_item_1_layout);
        recordItem1Name = (TextView) view.findViewById(R.id.record_item_1_name);
        recordItem1Date = (TextView) view.findViewById(R.id.record_item_1_date);
        recordItem2Layout = (LinearLayout) view.findViewById(R.id.record_item_2_layout);
        recordItem2Name = (TextView) view.findViewById(R.id.record_item_2_name);
        recordItem2Date = (TextView) view.findViewById(R.id.record_item_2_date);
        recordItem3Layout = (LinearLayout) view.findViewById(R.id.record_item_3_layout);
        recordItem3Name = (TextView) view.findViewById(R.id.record_item_3_name);
        recordItem3Date = (TextView) view.findViewById(R.id.record_item_3_date);
        recordItem4Layout = (LinearLayout) view.findViewById(R.id.record_item_4_layout);
        recordItem4Name = (TextView) view.findViewById(R.id.record_item_4_name);
        recordItem4Date = (TextView) view.findViewById(R.id.record_item_4_date);
        recordItem5Layout = (LinearLayout) view.findViewById(R.id.record_item_5_layout);
        recordItem5Name = (TextView) view.findViewById(R.id.record_item_5_name);
        recordItem5Date = (TextView) view.findViewById(R.id.record_item_5_date);
        recordItem6Layout = (LinearLayout) view.findViewById(R.id.record_item_6_layout);
        recordItem6Name = (TextView) view.findViewById(R.id.record_item_6_name);
        recordItem6Date = (TextView) view.findViewById(R.id.record_item_6_date);
    }

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_record, null);
        setTitle(view, "健康档案");
        assignViews(view);
        return view;
    }

    @Override
    protected void initData() {
        recordItem1Name.setText("无记录");
        recordItem2Name.setText("无记录");
        recordItem3Name.setText("无记录");
        recordItem4Name.setText("无记录");
        recordItem5Name.setText("无记录");
        recordItem6Name.setText("无记录");
    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void handleClick(View view) {

    }
}
