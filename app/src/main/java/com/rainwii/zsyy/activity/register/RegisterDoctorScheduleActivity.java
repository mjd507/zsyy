package com.rainwii.zsyy.activity.register;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.base.BaseActivity;
import com.rainwii.zsyy.adapter.RegisterDoctorScheduleAdapter;
import com.rainwii.zsyy.bean.RegisterExpertInfo;
import com.rainwii.zsyy.constants.Constants;
import com.rainwii.zsyy.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * 描述：专家号预约 --> 选择医生界面（医生工作时间表）
 * 作者 mjd
 * 日期：2015/10/16 21:44
 */
public class RegisterDoctorScheduleActivity extends BaseActivity {
    private LinearLayout llRegisterType1;
    private LinearLayout llRegisterType2;
    private LinearLayout llRegisterType3;
    private StickyListHeadersListView lvSticky;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_register_doctor_schedule);
        initTitleAndSubTitle();
        lvSticky = (StickyListHeadersListView) this.findViewById(R.id.lv);

    }

    /**
     * 初始化标题栏 以及 子标题栏
     */
    private void initTitleAndSubTitle() {
        setTitleBack(SPUtils.getString(this, Constants.REGISTER_TYPE, ""));
        llRegisterType1 = (LinearLayout) this.findViewById(R.id.ll_register_type_1);
        llRegisterType2 = (LinearLayout) this.findViewById(R.id.ll_register_type_2);
        llRegisterType3 = (LinearLayout) this.findViewById(R.id.ll_register_type_3);
        llRegisterType3.setVisibility(View.VISIBLE);
        llRegisterType1.setVisibility(View.GONE);
        llRegisterType2.setVisibility(View.GONE);
        TextView tvTitle2 = (TextView) this.findViewById(R.id.tv_type_3_step_2);
        tvTitle2.setTextColor(getResources().getColor(R.color.bg_title));
    }

    @Override
    protected void initData() {

        //获取专家列表数据
        List<RegisterExpertInfo> scheduleInfoList = new ArrayList<>();
        RegisterExpertInfo info0 = new RegisterExpertInfo(1, "2015-10-30 星期五", "马剑东", "主治医师", "祖籍江苏东台", true, true, "100", "2个号");
        RegisterExpertInfo info1 = new RegisterExpertInfo(1, "2015-10-30 星期五", "华佗", "主治医师", "祖籍江苏东台", true, true, "100", "2个号");
        RegisterExpertInfo info2 = new RegisterExpertInfo(2, "2015-10-31 星期六", "张仲景", "主治医师", "祖籍江苏东台", false, true, "100", "2个号");
        RegisterExpertInfo info3 = new RegisterExpertInfo(3, "2015-11-01 星期日", "孙思邈", "主治医师", "祖籍江苏东台", false, true, "100", "2个号");
        RegisterExpertInfo info4 = new RegisterExpertInfo(4, "2015-11-02 星期一", "扁鹊", "主治医师", "祖籍江苏东台", true, true, "100", "2个号");
        scheduleInfoList.add(info0);
        scheduleInfoList.add(info1);
        scheduleInfoList.add(info2);
        scheduleInfoList.add(info3);
        scheduleInfoList.add(info4);

        RegisterDoctorScheduleAdapter doctorScheduleAdapter = new RegisterDoctorScheduleAdapter(this, scheduleInfoList);
        lvSticky.setAdapter(doctorScheduleAdapter);
    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void handleClick(View view) {

    }
}
