package com.rainwii.zsyy.activity.register;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.BaseActivity;
import com.rainwii.zsyy.adapter.RegisterPopDialogAdapter;
import com.rainwii.zsyy.bean.RegisterExpertInfo;
import com.rainwii.zsyy.constants.Constants;
import com.rainwii.zsyy.utils.DateUtils;
import com.rainwii.zsyy.utils.SharedPreferencesUtils;
import com.rainwii.zsyy.utils.ToastUtils;
import com.rainwii.zsyy.view.MyRegisterDialog;

import java.util.List;

/**
 * 描述：挂号 --> 信息确认
 * 作者 mjd
 * 日期：2015/10/13 17:07
 */
public class RegisterInfoActivity extends BaseActivity {

    // --------------控件--------------------
    private LinearLayout llRegisterType1;
    private LinearLayout llRegisterType2;
    private LinearLayout llRegisterType3;

    private TextView tvFacultyOrDoctor;
    private TextView tvFaculty;
    private TextView tvMoreInfo;

    private TextView tvDate;
    private ImageView ivDatePick;

    private LinearLayout LlMorningCheck;
    private TextView tvMorningOrFee;
    private TextView tvMorningTime;
    private ImageButton ibMorningCheck;

    private LinearLayout LlAfternoonCheck;
    private TextView tvAfternoonOrOrderNum;
    private TextView tvAfternoonTime;
    private ImageButton ibAfternoonCheck;

    private TextView tvSelectCard;

    private TextView tvPatientName;

    private RadioGroup rgCheckBtn;
    private RadioButton rbMan;
    private RadioButton rbWomen;

    private TextView tvPatientPhone;

    private TextView tvPatientTreate;

    private TextView tvPatientCard;

    private Button btnSubmit;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            updateRegisterBtnState();
        }
    };
    //  -----------成员变量-----------------------
    private String faculty;//科室
    private String registerType;//挂号类型
    private Bundle bundle;
    private RegisterExpertInfo scheduleInfo;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_register_info);

        initTitleAndSubTitle();

        tvFacultyOrDoctor = (TextView) this.findViewById(R.id.tv_faculty_or_doctor);
        tvFaculty = (TextView) this.findViewById(R.id.tv_faculty);
        tvMoreInfo = (TextView) this.findViewById(R.id.tv_more_info);
        tvDate = (TextView) this.findViewById(R.id.tv_date);
        ivDatePick = (ImageView) this.findViewById(R.id.iv_date_pick);
        LlMorningCheck = (LinearLayout) this.findViewById(R.id.ll_morning_check);
        tvMorningOrFee = (TextView) this.findViewById(R.id.tv_morning_or_fee);
        tvMorningTime = (TextView) this.findViewById(R.id.tv_morning_time);
        ibMorningCheck = (ImageButton) this.findViewById(R.id.ib_morning_check);
        LlAfternoonCheck = (LinearLayout) this.findViewById(R.id.ll_afternoon_check);
        tvAfternoonOrOrderNum = (TextView) this.findViewById(R.id.tv_afternoon_or_order_num);
        tvAfternoonTime = (TextView) this.findViewById(R.id.tv_afternoon_time);
        ibAfternoonCheck = (ImageButton) this.findViewById(R.id.ib_afternoon_check);
        tvSelectCard = (TextView) this.findViewById(R.id.tv_select_card);
        tvPatientName = (TextView) this.findViewById(R.id.tv_patient_name);
        rgCheckBtn = (RadioGroup) this.findViewById(R.id.rg_check_btn);
        rbMan = (RadioButton) this.findViewById(R.id.rb_man);
        rbWomen = (RadioButton) this.findViewById(R.id.rb_women);
        tvPatientPhone = (TextView) this.findViewById(R.id.tv_patient_phone);
        tvPatientTreate = (TextView) this.findViewById(R.id.tv_patient_treate);
        tvPatientCard = (TextView) this.findViewById(R.id.tv_patient_card);
        btnSubmit = (Button) this.findViewById(R.id.btn_submit);
    }

    /**
     * 初始化标题栏 以及 子标题栏
     */
    private void initTitleAndSubTitle() {
        setTitleBack(SharedPreferencesUtils.getString(this, Constants.REGISTER_TYPE, ""));
        llRegisterType1 = (LinearLayout) this.findViewById(R.id.ll_register_type_1);
        llRegisterType2 = (LinearLayout) this.findViewById(R.id.ll_register_type_2);
        llRegisterType3 = (LinearLayout) this.findViewById(R.id.ll_register_type_3);
        bundle = getIntent().getExtras();
        registerType = bundle.getString(Constants.REGISTER_TYPE);
        assert registerType != null;
        if (registerType.equals(Constants.REGISTER_TYPE_REAL_TIME)) {
            llRegisterType1.setVisibility(View.VISIBLE);
            llRegisterType2.setVisibility(View.GONE);
            llRegisterType3.setVisibility(View.GONE);
            TextView tvTitle2 = (TextView) this.findViewById(R.id.tv_type_1_step_2);
            tvTitle2.setTextColor(getResources().getColor(R.color.bg_title));
        } else if (registerType.equals(Constants.REGISTER_TYPE_NORMAL)) {
            llRegisterType2.setVisibility(View.VISIBLE);
            llRegisterType1.setVisibility(View.GONE);
            llRegisterType3.setVisibility(View.GONE);
            TextView tvTitle2 = (TextView) this.findViewById(R.id.tv_type_2_step_2);
            tvTitle2.setTextColor(getResources().getColor(R.color.bg_title));
        } else if (registerType.equals(Constants.REGISTER_TYPE_EXPERT)) {
            llRegisterType3.setVisibility(View.VISIBLE);
            llRegisterType1.setVisibility(View.GONE);
            llRegisterType2.setVisibility(View.GONE);
            TextView tvTitle3 = (TextView) this.findViewById(R.id.tv_type_3_step_3);
            tvTitle3.setTextColor(getResources().getColor(R.color.bg_title));
        } else {
        }
    }


    @Override
    protected void initData() {
        updateRegisterBtnState();
        initFacultyOrDoctor();
        initDate();
    }

    /**
     * 初始化科室或者医生
     */
    private void initFacultyOrDoctor() {
        if (!registerType.equals(Constants.REGISTER_TYPE_EXPERT)) {
            faculty = bundle.getString(Constants.REGISTER_FACULTY);
            tvFaculty.setText(faculty);
        } else {
            scheduleInfo = (RegisterExpertInfo) bundle.getSerializable(Constants.REGISTER_EXPERT_SCHEDULE);
            tvFacultyOrDoctor.setText("医生：");
            tvFaculty.setText(scheduleInfo.getName());
            tvMoreInfo.setVisibility(View.GONE);
        }
    }

    /**
     * 初始化日期时间（实时/普通号）
     * 初始化费用预约号（专家号）
     */
    private void initDate() {
        if (registerType.equals(Constants.REGISTER_TYPE_EXPERT)) {
            String date = scheduleInfo.getDate() + (bundle.getBoolean("isAm") ? " 上午" : " 下午");
            tvDate.setText(date);
            tvMorningOrFee.setText("费用：");
            tvMorningTime.setText(scheduleInfo.getFee());
            ibMorningCheck.setVisibility(View.GONE);
            tvAfternoonOrOrderNum.setText("预约号：");
            tvAfternoonTime.setText("20");
            ibAfternoonCheck.setImageResource(R.drawable.ic_arrow_down_yellow);
            btnSubmit.setText("预约");
        } else {
            tvMorningTime.setText("6:00~11:30");
            tvAfternoonTime.setText("12:00~16:30");
            if (registerType.equals(Constants.REGISTER_TYPE_REAL_TIME)) {   //实时
                tvDate.setText(DateUtils.getDate());
                tvDate.setOnClickListener(null);
                if (!DateUtils.isRegisterTime()) {
                    btnSubmit.setText("非挂号时间");
                    noChoose();
                } else if (DateUtils.isRegisterMorning()) {
                    chooseMorning();
                } else {
                    chooseAfternoon();
                }
            } else if (registerType.equals(Constants.REGISTER_TYPE_NORMAL)) {      //普通号预约
                ivDatePick.setVisibility(View.VISIBLE);
                ivDatePick.setOnClickListener(this);
                tvDate.setOnClickListener(this);
                btnSubmit.setText("预约");
            }
        }

    }

    @Override
    protected void initListeners() {
        tvMoreInfo.setOnClickListener(this);

        LlMorningCheck.setOnClickListener(this);
        ibMorningCheck.setOnClickListener(this);

        LlAfternoonCheck.setOnClickListener(this);
        ibAfternoonCheck.setOnClickListener(this);

        tvSelectCard.setOnClickListener(this);

        btnSubmit.setOnClickListener(this);

    }

    @Override
    protected void handleClick(View view) {
        switch (view.getId()) {
            case R.id.tv_more_info:
                getThisRoomIntroduction();
                break;
            case R.id.tv_date:
                chooseAppointmentDate();
                break;
            case R.id.iv_date_pick:
                chooseAppointmentDate();
                break;
            case R.id.ll_morning_check:
                if (!registerType.equals(Constants.REGISTER_TYPE_EXPERT))
                    chooseMorning();
                break;
            case R.id.ib_morning_check:
                chooseMorning();
                break;
            case R.id.ll_afternoon_check:
                if (!registerType.equals(Constants.REGISTER_TYPE_EXPERT))
                    chooseAfternoon();
                break;
            case R.id.ib_afternoon_check:
                if (!registerType.equals(Constants.REGISTER_TYPE_EXPERT)) {
                    chooseAfternoon();
                }else{
                    getAlternativeOrderNum();
                }
                break;
            case R.id.tv_select_card:
                break;
            case R.id.btn_submit:
                enterNextActivity();
                break;
        }
    }

    /**
     * 获取可供选择的预约号码
     */
    private void getAlternativeOrderNum() {
        ToastUtils.showShort(this, "暂无其它预约号");
    }

    private void enterNextActivity() {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.REGISTER_TYPE, registerType);
        if (registerType.equals(Constants.REGISTER_TYPE_REAL_TIME)) {      //实时挂号 --> 支付页面
            bundle.putString(Constants.REGISTER_FACULTY, faculty);
            bundle.putString(Constants.REGISTER_PATIENT_NAME, tvPatientName.getText().toString().trim());
            enterActivity(RegisterPayActivity.class, bundle);
        } else if (registerType.equals(Constants.REGISTER_TYPE_NORMAL)) {     //普通号预约  --> 预约成功
            enterActivity(RegisterSuccessActivity.class, bundle);
        } else if (registerType.equals(Constants.REGISTER_TYPE_EXPERT)) {    //专家号预约 --> 预约成功
            enterActivity(RegisterSuccessActivity.class, bundle);
        }

    }

    /**
     * 没有选择（非挂号时间）
     */
    private void noChoose() {
        ibAfternoonCheck.setEnabled(false);
        ibAfternoonCheck.setImageResource(R.drawable.ic_check_unselect);
        ibMorningCheck.setEnabled(false);
        ibMorningCheck.setImageResource(R.drawable.ic_check_unselect);
    }

    /**
     * 选择下午
     */
    private void chooseAfternoon() {
        ibAfternoonCheck.setEnabled(false);
        ibAfternoonCheck.setImageResource(R.drawable.ic_check_select);
        ibMorningCheck.setEnabled(true);
        ibMorningCheck.setImageResource(R.drawable.ic_check_unselect);
    }

    /**
     * 选择上午
     */
    private void chooseMorning() {
        ibMorningCheck.setEnabled(false);
        ibMorningCheck.setImageResource(R.drawable.ic_check_select);
        ibAfternoonCheck.setEnabled(true);
        ibAfternoonCheck.setImageResource(R.drawable.ic_check_unselect);
    }

    private PopupWindow popupWindow;

    /**
     * 选择预约日期（未来五天）
     */
    private void chooseAppointmentDate() {
        if (popupWindow == null) {
            final List<String> futureFiveDays = DateUtils.getFutureFiveDays();
            View popView = getLayoutInflater().inflate(R.layout.layout_register_pop_dialog, null);
            final ListView lvPop = (ListView) popView.findViewById(R.id.lv);
            lvPop.setAdapter(new RegisterPopDialogAdapter(this, futureFiveDays));
            popupWindow = new PopupWindow(popView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
            popupWindow.setBackgroundDrawable(new BitmapDrawable());
            lvPop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    popupWindow.dismiss();
                    tvDate.setText(futureFiveDays.get(position).substring(0, 10));
                }
            });
        }
        popupWindow.showAtLocation(this.findViewById(R.id.ll_register_info), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0); //设置layout在PopupWindow中显示的位置
    }

    /**
     * 获取该科室的简介
     */
    private void getThisRoomIntroduction() {
        String info = "建立了完整先进的治疗体系，收治XX、XX、XX、XX、XX，主要包括临床表现专科性不强的复杂疾病以及多个系统......";
        MyRegisterDialog dialog = new MyRegisterDialog(this, faculty, info, "确定");
        dialog.show();
    }

    /**
     * 更新挂号按钮状态（每隔一秒）
     */
    private void updateRegisterBtnState() {
        handler.sendEmptyMessageDelayed(0, 1000);
        setRegisterBtnState();
    }

    /**
     * 设置挂号按钮的状态
     */
    private void setRegisterBtnState() {
        if (isRegisterBtnEnabled()) {
            btnSubmit.setEnabled(true);
        } else {
            btnSubmit.setEnabled(false);
        }
    }

    /**
     * 判断挂号按钮是否可以点击（初步检查数据）
     */
    private boolean isRegisterBtnEnabled() {
        if(registerType.equals(Constants.REGISTER_TYPE_REAL_TIME) && !DateUtils.isRegisterTime()){
            return false;
        }
        boolean isDateNull = checkIsNull(tvDate.getText().toString());
//        ibMorningCheck.isEnabled()?
//        checkIsNull(tvSelectCard.getText().toString())
        boolean isPatientNameNull = checkIsNull(tvPatientName.getText().toString());
        boolean isPatientPhoneNull = checkIsNull(tvPatientPhone.getText().toString());
        boolean isPatientTreateNull = checkIsNull(tvPatientTreate.getText().toString());
        boolean isPatientCardNull = checkIsNull(tvPatientCard.getText().toString());
        if (isDateNull || isPatientNameNull || isPatientPhoneNull || isPatientTreateNull || isPatientCardNull) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 检查数据是否为空
     */
    private boolean checkIsNull(String data) {
        if (TextUtils.isEmpty(data.trim())) {
            return true;
        } else {
            return false;
        }
    }

}
