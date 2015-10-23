package com.rainwii.zsyy.activity.symptom;

import android.view.View;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.BaseActivity;

/**
 * 描述：智能导诊 --> 可能疾病列表
 * 作者 mjd
 * 日期：2015/10/23 9:55
 */
public class SymptomPossibleDiseaseActivity extends BaseActivity {
    @Override
    protected void initViews() {
        setContentView(R.layout.activity_symptom_possible_disease);
        setTitleBack("诊断结果");
        isLeftBack = false;

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void handleClick(View view) {
        switch (view.getId()){
            case R.id.iv_title_left:
                enterActivityAndClearTop(SymptomMainActivity.class);
                break;
        }
    }


}
