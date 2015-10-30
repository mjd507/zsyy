package com.rainwii.zsyy.activity.online;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.base.BaseActivity;
import com.rainwii.zsyy.adapter.OnlineHotDoctorDetailAdapter;
import com.rainwii.zsyy.bean.OnlineHotDoctorDetailQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：图文咨询 热门医生 详情
 * 作者 mjd
 * 日期：2015/10/28 16:11
 */
public class OnlineHotDoctorDetailActivity extends BaseActivity {
    private ImageView ivPhoto;
    private TextView tvName;
    private TextView tvPosition;
    private RatingBar ratingBar;
    private Button btnAsk;
    private ScrollView scrollView;
    private TextView tvSkill;
    private TextView tvComment;
    private ListView lv;


    @Override
    protected void initViews() {
        setContentView(R.layout.activity_online_hot_doctor_detail);
        setTitleBack("中医科");
        ivPhoto = (ImageView) findViewById(R.id.iv_photo);
        tvName = (TextView) findViewById(R.id.tv_name);
        tvPosition = (TextView) findViewById(R.id.tv_position);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        btnAsk = (Button) findViewById(R.id.btn_ask);
        scrollView = (ScrollView) findViewById(R.id.scroll_view);
        tvSkill = (TextView) findViewById(R.id.tv_skill);
        tvComment = (TextView) findViewById(R.id.tv_comment);
        lv = (ListView) findViewById(R.id.lv);
    }

    @Override
    protected void initData() {
        tvName.setText("范小芬");
        tvPosition.setText("副主任医师");
        ratingBar.setRating(5);
        tvSkill.setText("中医科副主任医师，研究生导师，博士，擅长各种原因引起的各种疾病。周四下午专家门诊。");

        List<OnlineHotDoctorDetailQuestion> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new OnlineHotDoctorDetailQuestion("138****421" + i, "5", "11-1" + i, "这里是患者所提出的问题", "这里是患者的评价"));
        }

        OnlineHotDoctorDetailAdapter adapter = new OnlineHotDoctorDetailAdapter(this, list);
        lv.setAdapter(adapter);

    }

    @Override
    protected void initListeners() {
        btnAsk.setOnClickListener(this);
    }

    @Override
    protected void handleClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ask:
                enterActivity(OnlineAskQuestionActivity.class);
                break;

        }
    }
}
