package com.rainwii.zsyy.activity.education;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.base.BaseActivity;

/**
 * 描述：健康宣教
 * 作者 mjd
 * 日期：2015/10/29 14:42
 */
public class EducationDetailActivity extends BaseActivity {

    private ListView lv;
    private TextView tvDetail;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_education_detail);
        setTitleBack("详细资料");
        tvDetail = (TextView) this.findViewById(R.id.tv_detail);
    }

    @Override
    protected void initData() {
        tvDetail.setText(" 这里是健康宣教的内容\n 这里是健康宣教的内容\n 这里是健康宣教的内容\n 这里是健康宣教的内容");
    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void handleClick(View view) {

    }
}
