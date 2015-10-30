package com.rainwii.zsyy.activity.education;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.base.BaseActivity;
import com.rainwii.zsyy.adapter.EducationAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：健康宣教
 * 作者 mjd
 * 日期：2015/10/29 14:42
 */
public class EducationSecondActivity extends BaseActivity {

    private ListView lv;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_education_main);
        setTitleBack("健康宣教小类");
        lv = (ListView) this.findViewById(R.id.lv);
    }

    @Override
    protected void initData() {

        List<String> list = new ArrayList<>();
        list.add("宣教资料小类一");
        list.add("宣教资料小类二");
        list.add("宣教资料小类三");
        list.add("宣教资料小类四");
        list.add("宣教资料小类五");
        EducationAdapter adapter = new EducationAdapter(this, list);
        lv.setAdapter(adapter);
    }

    @Override
    protected void initListeners() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                enterActivity(EducationDetailActivity.class);
            }
        });
    }

    @Override
    protected void handleClick(View view) {

    }
}
