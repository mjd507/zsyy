package com.rainwii.zsyy.activity.expert;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.base.BaseActivity;
import com.rainwii.zsyy.activity.register.RegisterInfoActivity;
import com.rainwii.zsyy.bean.ExpertListIInfo;
import com.rainwii.zsyy.bean.RegisterExpertInfo;
import com.rainwii.zsyy.constants.Constants;
import com.rainwii.zsyy.utils.SPUtils;

/**
 * 描述：专家排班 --> 工作表
 * 作者 mjd
 * 日期：2015/10/26 10:11
 */
public class ExpertScheduleActivity extends BaseActivity {
    private ImageView ivPhoto;
    private TextView tvName;
    private TextView tvPosition;
    private RatingBar rbRatingBar;
    private Button btnOrder;
    private TextView tvSkill;
    private ImageView ivStar1;
    private ImageView ivStar3;
    private ImageView ivStar5;
    private ImageView ivStar7;
    private ImageView ivStar9;
    private ImageView ivStar11;
    private ImageView ivStar13;
    private ImageView ivStar2;
    private ImageView ivStar4;
    private ImageView ivStar6;
    private ImageView ivStar8;
    private ImageView ivStar10;
    private ImageView ivStar12;
    private ImageView ivStar14;
    private TextView tvPlace;
    private TextView tvFee;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_expert_detail);
        setTitleBack("专家排班");
        ivPhoto = (ImageView) findViewById(R.id.iv_photo);
        tvName = (TextView) findViewById(R.id.tv_name);
        tvPosition = (TextView) findViewById(R.id.tv_position);
        rbRatingBar = (RatingBar) findViewById(R.id.rb_ratingBar);
        btnOrder = (Button) findViewById(R.id.btn_order);
        tvSkill = (TextView) findViewById(R.id.tv_skill);
        ivStar1 = (ImageView) findViewById(R.id.iv_star_1);
        ivStar3 = (ImageView) findViewById(R.id.iv_star_3);
        ivStar5 = (ImageView) findViewById(R.id.iv_star_5);
        ivStar7 = (ImageView) findViewById(R.id.iv_star_7);
        ivStar9 = (ImageView) findViewById(R.id.iv_star_9);
        ivStar11 = (ImageView) findViewById(R.id.iv_star_11);
        ivStar13 = (ImageView) findViewById(R.id.iv_star_13);
        ivStar2 = (ImageView) findViewById(R.id.iv_star_2);
        ivStar4 = (ImageView) findViewById(R.id.iv_star_4);
        ivStar6 = (ImageView) findViewById(R.id.iv_star_6);
        ivStar8 = (ImageView) findViewById(R.id.iv_star_8);
        ivStar10 = (ImageView) findViewById(R.id.iv_star_10);
        ivStar12 = (ImageView) findViewById(R.id.iv_star_12);
        ivStar14 = (ImageView) findViewById(R.id.iv_star_14);
        tvPlace = (TextView) findViewById(R.id.tv_place);
        tvFee = (TextView) findViewById(R.id.tv_fee);
    }

    @Override
    protected void initData() {
        ExpertListIInfo info = (ExpertListIInfo) getIntent().getExtras().getSerializable("expertListInfo");
        ivPhoto.setImageResource(R.drawable.ic_doctor_logo);
        assert info != null;
        tvName.setText(info.getName());
        tvPosition.setText(info.getPosition());
        tvSkill.setText(info.getSkill());
        tvPlace.setText("江苏省-苏州市-滨河路-1701号");
        tvFee.setText("100元");
        ivStar1.setVisibility(View.VISIBLE);
        ivStar8.setVisibility(View.VISIBLE);
    }

    @Override
    protected void initListeners() {
        btnOrder.setOnClickListener(this);
    }

    @Override
    protected void handleClick(View view) {
        switch (view.getId()) {
            case R.id.btn_order:
                SPUtils.putString(this, Constants.REGISTER_TYPE, "专家号预约");
                Bundle bundle = new Bundle();
                RegisterExpertInfo info = new RegisterExpertInfo(1, "2015-10-30 星期五", "华佗", "主治医师", "祖籍江苏东台", true, true, "100", "2个号");
                bundle.putSerializable(Constants.REGISTER_EXPERT_SCHEDULE,info);
                bundle.putString(Constants.REGISTER_TYPE, Constants.REGISTER_TYPE_EXPERT);
                enterActivity(RegisterInfoActivity.class, bundle);
                break;
        }
    }
}
