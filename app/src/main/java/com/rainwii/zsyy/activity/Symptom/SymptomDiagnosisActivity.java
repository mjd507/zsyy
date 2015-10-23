package com.rainwii.zsyy.activity.symptom;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.BaseActivity;
import com.rainwii.zsyy.adapter.SymptomDiagnosisAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：智能导诊 --> 诊断界面
 * 作者 mjd
 * 日期：2015/10/23 8:30
 */
public class SymptomDiagnosisActivity extends BaseActivity {

    private ListView lv;
    private Button btnDiagnosis;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_symptom_diagnosis);
        setTitleBackAndRight("已选择的症状", R.drawable.btn_title_add);
        isLeftBack = false;
        lv = (ListView) this.findViewById(R.id.lv);
        btnDiagnosis = (Button) this.findViewById(R.id.btn_submit);
    }

    @Override
    protected void initData() {
        List<String> list = new ArrayList<>();
        list.add("肢体无力");
        SymptomDiagnosisAdapter adapter = new SymptomDiagnosisAdapter(this, list);
        lv.setAdapter(adapter);
    }

    @Override
    protected void initListeners() {
        btnDiagnosis.setOnClickListener(this);
    }

    @Override
    protected void handleClick(View view) {
        switch (view.getId()) {
            case R.id.iv_title_left:
                enterActivityAndClearTop(SymptomMainActivity.class);
                break;
            case R.id.iv_title_right:
                enterActivityAndClearTop(SymptomMainActivity.class);
                break;
            case R.id.btn_submit:
                enterActivity(SymptomPossibleDiseaseActivity.class);
                break;
        }

    }
}
