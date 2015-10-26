package com.rainwii.zsyy.activity.expert;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.BaseActivity;
import com.rainwii.zsyy.adapter.ExpertFacultyAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：Expert Scheduling
 * 作者 mjd
 * 日期：2015/10/13 9:27
 */
public class ExpertFacultyActivity extends BaseActivity {

    private ListView lv;
    private List<String> list;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_expert_faculty);
        setTitleBack("专家排班");
        lv = (ListView) this.findViewById(R.id.lv);
    }

    @Override
    protected void initData() {
        list = new ArrayList<>();
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
        ExpertFacultyAdapter adapter = new ExpertFacultyAdapter(this,list);
        lv.setAdapter(adapter);
    }

    @Override
    protected void initListeners() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                enterActivity(ExpertListActivity.class);
            }
        });
    }

    @Override
    protected void handleClick(View view) {

    }
}
