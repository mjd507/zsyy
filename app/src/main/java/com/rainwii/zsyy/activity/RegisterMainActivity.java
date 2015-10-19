package com.rainwii.zsyy.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.constants.Constants;

/**
 * 描述：Mobile Registration
 * 作者 mjd
 * 日期：2015/10/13 9:27
 */
public class RegisterMainActivity extends BaseActivity {

    private TextView tvRegisterType1;
    private TextView tvRegisterType2;
    private TextView tvRegisterType3;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_register_main);
        setTitleBack("手机挂号");
        tvRegisterType1 = (TextView) findViewById(R.id.tv_register_type_1);
        tvRegisterType2 = (TextView) findViewById(R.id.tv_register_type_2);
        tvRegisterType3 = (TextView) findViewById(R.id.tv_register_type_3);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListeners() {
        tvRegisterType1.setOnClickListener(this);
        tvRegisterType2.setOnClickListener(this);
        tvRegisterType3.setOnClickListener(this);
    }

    @Override
    protected void handleClick(View view) {
        switch (view.getId()) {
            case R.id.tv_register_type_1://RealTime Registration
                entryRegisterActivity(Constants.REGISTER_TYPE_REAL_TIME);
                break;
            case R.id.tv_register_type_2://CommonNumber Appointment
                entryRegisterActivity(Constants.REGISTER_TYPE_NORMAL);
                break;
            case R.id.tv_register_type_3://Expert Appointment
                entryRegisterActivity(Constants.REGISTER_TYPE_EXPERT);
                break;
        }
    }

    /**
     * 进入挂号页面
     * @param registerType 挂号的类型
     */
    private void entryRegisterActivity(String registerType) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.REGISTER_TYPE, registerType);
        enterActivity(RegisterFacultyActivity.class, bundle);
    }
}
