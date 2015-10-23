package com.rainwii.zsyy.activity.register;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.BaseActivity;
import com.rainwii.zsyy.constants.Constants;
import com.rainwii.zsyy.utils.SharedPreferencesUtils;

/**
 * 描述：挂号 --> 预约/挂号成功的粗略展示
 * 作者 mjd
 * 日期：2015/10/13 17:07
 */
public class RegisterSuccessActivity extends BaseActivity {
    private LinearLayout llRegisterType1;
    private LinearLayout llRegisterType2;
    private LinearLayout llRegisterType3;
    private Button btnOk;

    private String registerType;
    private TextView tvSuccess;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_register_success);
        initTitleAndSubTitle();
        tvSuccess = (TextView) this.findViewById(R.id.tv_success);
        btnOk = (Button) this.findViewById(R.id.btn_ok);
        initText();
    }

    private void initText() {
        if(registerType.equals(Constants.REGISTER_TYPE_REAL_TIME)){
            tvSuccess.setText("恭喜你，挂号成功！");
        }else {
            tvSuccess.setText("恭喜你，预约成功！");
        }
    }

    /**
     * 初始化标题栏 以及 子标题栏
     */
    private void initTitleAndSubTitle() {
        setTitleBack(SharedPreferencesUtils.getString(this, Constants.REGISTER_TYPE, ""));
        llRegisterType1 = (LinearLayout) this.findViewById(R.id.ll_register_type_1);
        llRegisterType2 = (LinearLayout) this.findViewById(R.id.ll_register_type_2);
        llRegisterType3 = (LinearLayout) this.findViewById(R.id.ll_register_type_3);
        registerType = getIntent().getExtras().getString(Constants.REGISTER_TYPE);
        assert registerType != null;
        if (registerType.equals(Constants.REGISTER_TYPE_REAL_TIME)) {
            llRegisterType1.setVisibility(View.VISIBLE);
            llRegisterType2.setVisibility(View.GONE);
            llRegisterType3.setVisibility(View.GONE);
            TextView tvTitle4 = (TextView) this.findViewById(R.id.tv_type_1_step_4);
            tvTitle4.setTextColor(getResources().getColor(R.color.bg_title));
        } else if (registerType.equals(Constants.REGISTER_TYPE_NORMAL)) {
            llRegisterType2.setVisibility(View.VISIBLE);
            llRegisterType1.setVisibility(View.GONE);
            llRegisterType3.setVisibility(View.GONE);
            TextView tvTitle3 = (TextView) this.findViewById(R.id.tv_type_2_step_3);
            tvTitle3.setTextColor(getResources().getColor(R.color.bg_title));
        } else if (registerType.equals(Constants.REGISTER_TYPE_EXPERT)) {
            llRegisterType3.setVisibility(View.VISIBLE);
            llRegisterType1.setVisibility(View.GONE);
            llRegisterType2.setVisibility(View.GONE);
            TextView tvTitle4 = (TextView) this.findViewById(R.id.tv_type_3_step_4);
            tvTitle4.setTextColor(getResources().getColor(R.color.bg_title));
        } else {
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListeners() {
        btnOk.setOnClickListener(this);
    }

    @Override
    protected void handleClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ok:
                enterActivityAndClearTop(RegisterMainActivity.class);
                break;
        }
    }
}
