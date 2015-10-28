package com.rainwii.zsyy.activity.online;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.BaseActivity;
import com.rainwii.zsyy.adapter.OnlineFacultyDoctorListAdapter;
import com.rainwii.zsyy.bean.OnlineHotDoctor;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：科室 医生列表
 * 作者 mjd
 * 日期：2015/10/28 17:13
 */
public class OnlineFacultyDoctorListActivity extends BaseActivity {

    private ListView lv;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_online_faculty_doctor_list);
        setTitleBack("图文咨询");
        lv = (ListView) findViewById(R.id.lv);
    }

    @Override
    protected void initData() {
        List<OnlineHotDoctor> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new OnlineHotDoctor("imageuri", "范小芬", "副主任医师", "中医科", "1988年毕业于苏州大学医院院，擅长治疗各种原因引起的各种疾病", "5"));
        }
        OnlineFacultyDoctorListAdapter adapter = new OnlineFacultyDoctorListAdapter(this, list);
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
