package com.rainwii.zsyy.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.constants.Constants;

/**
 * 描述：
 * 作者 mjd
 * 日期：2015/10/20 9:12
 */
public class ReportMainActivity extends BaseActivity {
    private TextView tvReportType1;
    private TextView tvReportType2;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_report_main);
        setTitleBack("报告查询");
        tvReportType1 = (TextView) findViewById(R.id.tv_report_type_1);
        tvReportType2 = (TextView) findViewById(R.id.tv_report_type_2);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListeners() {
        tvReportType1.setOnClickListener(this);
        tvReportType2.setOnClickListener(this);
    }

    @Override
    protected void handleClick(View view) {
        switch (view.getId()) {
            case R.id.tv_report_type_1:
                enterLoginActivity(Constants.REPORT_TYPE_EXAMINE);
                break;
            case R.id.tv_report_type_2:
                enterLoginActivity(Constants.REPORT_TYPE_CHECKUP);
                break;
        }
    }

    public void enterLoginActivity(String reportType) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.REPORT_TYPE, reportType);
        enterActivity(ReportLoginActivity.class, bundle);
    }
}
