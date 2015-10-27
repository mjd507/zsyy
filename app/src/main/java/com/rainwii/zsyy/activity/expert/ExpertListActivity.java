package com.rainwii.zsyy.activity.expert;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.BaseActivity;
import com.rainwii.zsyy.adapter.ExpertListAdapter;
import com.rainwii.zsyy.bean.ExpertListIInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：专家排班 --> 医生列表
 * 作者 mjd
 * 日期：2015/10/26 9:08
 */
public class ExpertListActivity extends BaseActivity {

    private ListView lv;
    private List<ExpertListIInfo> list;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_expert_list);
        setTitleBack("专家排班");
        lv = (ListView) this.findViewById(R.id.lv);
    }

    @Override
    protected void initData() {
        list = new ArrayList<>();
        list.add(new ExpertListIInfo("imageUrl", "华佗", "主治医师", "擅长各种疾病"));
        list.add(new ExpertListIInfo("imageUrl", "华佗", "主治医师", "擅长各种疾病"));
        list.add(new ExpertListIInfo("imageUrl", "华佗", "主治医师", "擅长各种疾病"));
        list.add(new ExpertListIInfo("imageUrl", "华佗", "主治医师", "擅长各种疾病"));
        list.add(new ExpertListIInfo("imageUrl", "华佗", "主治医师", "擅长各种疾病"));
        list.add(new ExpertListIInfo("imageUrl", "华佗", "主治医师", "擅长各种疾病"));
        list.add(new ExpertListIInfo("imageUrl", "华佗", "主治医师", "擅长各种疾病"));
        list.add(new ExpertListIInfo("imageUrl", "华佗", "主治医师", "擅长各种疾病"));
        list.add(new ExpertListIInfo("imageUrl", "华佗", "主治医师", "擅长各种疾病"));
        list.add(new ExpertListIInfo("imageUrl", "华佗", "主治医师", "擅长各种疾病"));
        ExpertListAdapter adapter = new ExpertListAdapter(this, list);
        lv.setAdapter(adapter);
    }

    @Override
    protected void initListeners() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                enterActivity(ExpertScheduleActivity.class);
            }
        });
    }

    @Override
    protected void handleClick(View view) {

    }
}
