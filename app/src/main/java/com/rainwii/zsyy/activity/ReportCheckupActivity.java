package com.rainwii.zsyy.activity;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.constants.Constants;

/**
 * 描述：体检报告
 * 作者 mjd
 * 日期：2015/10/20 9:29
 */
public class ReportCheckupActivity extends BaseActivity {

    private TextView tvTip;
    private Button btnSubmit;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_report_checkup);
        setTitleBack("体检报告");
        tvTip = (TextView) this.findViewById(R.id.tv_tip);
        btnSubmit = (Button) this.findViewById(R.id.btn_submit);

    }

    @Override
    protected void initData() {
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString(Constants.REPORT_PERSON_NAME);
        String code = bundle.getString(Constants.REPORT_CODE);
        tvTip.setText("未能查询到"+name+code+"的报告，请核对信息后重试。");
        SpannableStringBuilder builder = new SpannableStringBuilder(tvTip.getText().toString());
        ForegroundColorSpan yellowSpan = new ForegroundColorSpan(getResources().getColor(R.color.text_yellow));
        builder.setSpan(yellowSpan, 5, tvTip.getText().toString().lastIndexOf("的"), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvTip.setText(builder);
    }

    @Override
    protected void initListeners() {
        btnSubmit.setOnClickListener(this);
    }

    @Override
    protected void handleClick(View view) {

    }
}
