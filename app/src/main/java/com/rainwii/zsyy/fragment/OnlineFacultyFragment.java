package com.rainwii.zsyy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.online.OnlineFacultyDoctorListActivity;
import com.rainwii.zsyy.adapter.OnlineFacultyAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：科室
 * 作者 mjd
 * 日期：2015/10/28 10:17
 */
public class OnlineFacultyFragment extends BaseFragment {
    private ListView lv;

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_listview, null);
        lv = (ListView) view.findViewById(R.id.lv);
        return view;
    }

    @Override
    protected void initData() {
        List<String> list = new ArrayList<>();
        list.add("感染病科");
        list.add("普内科");
        list.add("血液病科");
        list.add("消化内科");
        list.add("呼吸内科");
        list.add("神经内科");
        list.add("风湿免疫科");
        list.add("感染病科");
        list.add("普内科");
        list.add("血液病科");
        list.add("消化内科");
        list.add("呼吸内科");
        list.add("神经内科");
        list.add("风湿免疫科");
        OnlineFacultyAdapter adapter = new OnlineFacultyAdapter(getActivity(), list);
        lv.setAdapter(adapter);
    }

    @Override
    protected void initListeners() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                enterActivity(OnlineFacultyDoctorListActivity.class);
            }
        });
    }

    @Override
    protected void handleClick(View view) {

    }
}
