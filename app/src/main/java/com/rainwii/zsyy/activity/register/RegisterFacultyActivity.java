package com.rainwii.zsyy.activity.register;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.base.BaseActivity;
import com.rainwii.zsyy.adapter.RegisterFacultyAdapter;
import com.rainwii.zsyy.constants.Constants;
import com.rainwii.zsyy.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：挂号 --> 选择科室
 * 作者 mjd
 * 日期：2015/10/13 17:07
 */
public class RegisterFacultyActivity extends BaseActivity {

    private ListView lv;

    private LinearLayout llRegisterType1;
    private LinearLayout llRegisterType2;
    private LinearLayout llRegisterType3;

    private String registerType;    //挂号类型
    private String title;
    private List<String> list;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_register_faculty);

        initTitleAndSubTitle();

        lv = (ListView) this.findViewById(R.id.lv);

    }

    @Override
    protected void initData() {

        //模拟加载数据（根据挂号类型去加载相应的科室）
        showLoading("加载中...");
        list = new ArrayList<>();
        list.add("口腔科门诊");
        list.add("眼科门诊");
        list.add("肝炎门诊");
        list.add("普内科门诊");
        list.add("呼吸内科门诊");
        list.add("心血管内科门诊");
        list.add("神经内科门诊");
        list.add("风湿免疫科门诊");
        list.add("骨科门诊");
        list.add("神经外科门诊");
        list.add("心胸外科门诊");
        list.add("肛肠外科门诊");
        list.add("泌尿外科门诊");
        list.add("整形外科门诊");
        closeLoading();

        RegisterFacultyAdapter roomsAdapter = new RegisterFacultyAdapter(this, list);
        lv.setAdapter(roomsAdapter);
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
            title = "实时挂号";
            llRegisterType1.setVisibility(View.VISIBLE);
            llRegisterType2.setVisibility(View.GONE);
            llRegisterType3.setVisibility(View.GONE);
            TextView tvTitle1 = (TextView) this.findViewById(R.id.tv_type_1_step_1);
            tvTitle1.setTextColor(getResources().getColor(R.color.bg_title));
        } else if (registerType.equals(Constants.REGISTER_TYPE_NORMAL)) {
            title = "普通号预约";
            llRegisterType2.setVisibility(View.VISIBLE);
            llRegisterType1.setVisibility(View.GONE);
            llRegisterType3.setVisibility(View.GONE);
            TextView tvTitle1 = (TextView) this.findViewById(R.id.tv_type_2_step_1);
            tvTitle1.setTextColor(getResources().getColor(R.color.bg_title));
        } else if (registerType.equals(Constants.REGISTER_TYPE_EXPERT)) {
            title = "专家号预约";
            llRegisterType3.setVisibility(View.VISIBLE);
            llRegisterType1.setVisibility(View.GONE);
            llRegisterType2.setVisibility(View.GONE);
            TextView tvTitle1 = (TextView) this.findViewById(R.id.tv_type_3_step_1);
            tvTitle1.setTextColor(getResources().getColor(R.color.bg_title));
        } else {
            title = "手机挂号";
        }
        setTitleBackAndRight(title, R.drawable.btn_search);
        SPUtils.putString(this, Constants.REGISTER_TYPE, title);
    }

    @Override
    protected void initListeners() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString(Constants.REGISTER_TYPE, registerType);
                if (registerType.equals(Constants.REGISTER_TYPE_EXPERT)) {   //专家号预约 --> 选择医生
                    enterActivity(RegisterDoctorScheduleActivity.class, bundle);
                } else {         //信息确认
                    bundle.putString(Constants.REGISTER_FACULTY, list.get(position));
                    enterActivity(RegisterInfoActivity.class, bundle);
                }
            }
        });
    }

    @Override
    protected void handleClick(View view) {
        switch (view.getId()) {
            case R.id.iv_title_right:   //search
                break;
        }
    }

}
