package com.rainwii.zsyy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.online.OnlineHotDoctorDetailActivity;
import com.rainwii.zsyy.adapter.OnlineHotDoctorAdapter;
import com.rainwii.zsyy.adapter.OnlineNewQuestionAdapter;
import com.rainwii.zsyy.bean.OnlineHotDoctor;
import com.rainwii.zsyy.bean.OnlineNewQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：热门医生
 * 作者 mjd
 * 日期：2015/10/28 10:17
 */
public class OnlineHotDoctorFragment extends BaseFragment {
    private ListView lv;

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_listview, null);
        lv = (ListView) view.findViewById(R.id.lv);
        return view;
    }

    @Override
    protected void initData() {
        List<OnlineHotDoctor> hotDoctorList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            hotDoctorList.add(new OnlineHotDoctor("imageuri", "范小芬", "副主任医师", "中医科", "1988年毕业于苏州大学医院院，擅长治疗各种原因引起的各种疾病", "5"));
        }
        OnlineHotDoctorAdapter adapter = new OnlineHotDoctorAdapter(getActivity(), hotDoctorList);
        lv.setAdapter(adapter);
    }

    @Override
    protected void initListeners() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                enterActivity(OnlineHotDoctorDetailActivity.class);
            }
        });
    }

    @Override
    protected void handleClick(View view) {

    }
}
