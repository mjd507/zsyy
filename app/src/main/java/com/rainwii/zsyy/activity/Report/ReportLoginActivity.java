package com.rainwii.zsyy.activity.report;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.BaseActivity;
import com.rainwii.zsyy.constants.Constants;

/**
 * 描述：报告查询登陆页面
 * 作者 mjd
 * 日期：2015/10/20 9:29
 */
public class ReportLoginActivity extends BaseActivity {
    private EditText etName;
    private TextView tvCardTip;
    private EditText etCode;
    private TextView tvCodeScan;
    private Button btnSubmit;
    private String reportType;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            updateReportBtnState();
        }
    };

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_report_login);
        reportType = getIntent().getExtras().getString(Constants.REPORT_TYPE);
        etName = (EditText) findViewById(R.id.et_name);
        tvCardTip = (TextView) findViewById(R.id.tv_card_tip);
        etCode = (EditText) findViewById(R.id.et_code);
        tvCodeScan = (TextView) findViewById(R.id.tv_code_scan);
        btnSubmit = (Button) findViewById(R.id.btn_submit);
        assert reportType != null;
        if (reportType.equals(Constants.REPORT_TYPE_EXAMINE)) {
            setTitleBack("检查报告");
        } else if (reportType.equals(Constants.REPORT_TYPE_CHECKUP)) {
            setTitleBack("体检报告");
            tvCodeScan.setVisibility(View.GONE);
        }
    }

    @Override
    protected void initData() {
        updateReportBtnState();
    }

    @Override
    protected void initListeners() {
        btnSubmit.setOnClickListener(this);
    }

    @Override
    protected void handleClick(View view) {
        switch (view.getId()) {
            case R.id.btn_submit:
                enterNextActivity();
                break;
        }
    }

    private void enterNextActivity() {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.REPORT_PERSON_NAME, etName.getText().toString().trim());
        bundle.putString(Constants.REPORT_CODE, etCode.getText().toString().trim());
        if (reportType.equals(Constants.REPORT_TYPE_EXAMINE)) {
            enterActivity(ReportExamineActivity.class, bundle);
        } else if (reportType.equals(Constants.REPORT_TYPE_CHECKUP)) {
            enterActivity(ReportCheckupActivity.class, bundle);
        }
    }

    /**
     * 更新提交按钮状态（每隔一秒）
     */
    private void updateReportBtnState() {
        handler.sendEmptyMessageDelayed(0, 1000);
        setSubmitBtnState();
    }


    /**
     * 设置提交按钮的状态
     */
    private void setSubmitBtnState() {
        if (isSubmitBtnEnabled()) {
            btnSubmit.setEnabled(true);
        } else {
            btnSubmit.setEnabled(false);
        }
    }

    /**
     * 判断提交按钮是否可以点击（初步检查数据）
     */
    private boolean isSubmitBtnEnabled() {
        boolean isNameNull = checkIsNull(etName.getText().toString());
        boolean isCodeNull = checkIsNull(etCode.getText().toString());
        return !(isNameNull || isCodeNull);
    }

    /**
     * 检查数据是否为空
     */
    private boolean checkIsNull(String data) {
        return TextUtils.isEmpty(data.trim());
    }
}
