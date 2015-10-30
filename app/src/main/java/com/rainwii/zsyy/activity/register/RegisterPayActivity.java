package com.rainwii.zsyy.activity.register;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.base.BaseActivity;
import com.rainwii.zsyy.constants.Constants;
import com.rainwii.zsyy.utils.SPUtils;

/**
 * 描述：挂号 --> 支付页面（实时挂号）
 * 作者 mjd
 * 日期：2015/10/13 17:07
 */
public class RegisterPayActivity extends BaseActivity {
    private LinearLayout llRegisterType1;
    private LinearLayout llRegisterType2;
    private LinearLayout llRegisterType3;
    private TextView tvFaculty;
    private TextView tvPatientName;
    private TextView tvOrderFee;
    private Button btnPay;

    private String registerType;    //目前支付只有实时挂号需要，所以为1

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_register_pay);
        initTitleAndSubTitle();


        TextView tvTitle3 = (TextView) this.findViewById(R.id.tv_type_1_step_3);
        tvTitle3.setTextColor(getResources().getColor(R.color.bg_title));

        tvFaculty = (TextView) this.findViewById(R.id.tv_faculty);
        tvPatientName = (TextView) this.findViewById(R.id.tv_patient_name);
        tvOrderFee = (TextView) this.findViewById(R.id.tv_order_fee);
        btnPay = (Button) this.findViewById(R.id.btn_pay);
    }

    @Override
    protected void initData() {
        Bundle bundle = getIntent().getExtras();
        tvFaculty.setText(bundle.getString(Constants.REGISTER_FACULTY, ""));
        tvPatientName.setText(bundle.getString(Constants.REGISTER_PATIENT_NAME, ""));
        tvOrderFee.setText("10");
        btnPay.setEnabled(true);
    }

    /**
     * 初始化标题栏 以及 子标题栏
     */
    private void initTitleAndSubTitle() {
        llRegisterType1 = (LinearLayout) this.findViewById(R.id.ll_register_type_1);
        llRegisterType2 = (LinearLayout) this.findViewById(R.id.ll_register_type_2);
        llRegisterType3 = (LinearLayout) this.findViewById(R.id.ll_register_type_3);
        registerType = getIntent().getExtras().getString(Constants.REGISTER_TYPE);
        assert registerType != null;
        if (registerType.equals(Constants.REGISTER_TYPE_REAL_TIME)) {
            llRegisterType1.setVisibility(View.VISIBLE);
            llRegisterType2.setVisibility(View.GONE);
            llRegisterType3.setVisibility(View.GONE);
            TextView tvTitle3 = (TextView) this.findViewById(R.id.tv_type_1_step_3);
            tvTitle3.setTextColor(getResources().getColor(R.color.bg_title));
        } else {
        }
        setTitleBack(SPUtils.getString(this, Constants.REGISTER_TYPE, ""));
    }

    @Override
    protected void initListeners() {
        btnPay.setOnClickListener(this);
    }

    @Override
    protected void handleClick(View view) {
        switch (view.getId()) {
            case R.id.btn_pay:
                Bundle bundle = new Bundle();
                bundle.putString(Constants.REGISTER_TYPE, registerType);
                enterActivity(RegisterSuccessActivity.class, bundle);
                break;
        }
    }

}
