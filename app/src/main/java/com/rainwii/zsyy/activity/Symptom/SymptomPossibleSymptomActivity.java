package com.rainwii.zsyy.activity.symptom;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.BaseActivity;
import com.rainwii.zsyy.adapter.SymptomPossibleSymptomAdapter;
import com.rainwii.zsyy.constants.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：智能导诊 --> 部位对应的可能的症状列表
 * 作者 mjd
 * 日期：2015/10/22 13:01
 */
public class SymptomPossibleSymptomActivity extends BaseActivity {

    private ListView lv;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_symptom_possible_symptom);
        setTitleBack(getIntent().getExtras().getString(Constants.BODY_AREA));
        lv = (ListView) this.findViewById(R.id.lv);
    }

    @Override
    protected void initData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("肢体无力");
        }
        SymptomPossibleSymptomAdapter diseaseAdapter = new SymptomPossibleSymptomAdapter(this, list);
        lv.setAdapter(diseaseAdapter);
    }

    @Override
    protected void initListeners() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                enterActivity(SymptomQuestionActivity.class);
            }
        });
    }

    @Override
    protected void handleClick(View view) {

    }
}
