package com.rainwii.zsyy.activity.online;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.BaseActivity;

/**
 * 描述：
 * 作者 mjd
 * 日期：2015/10/29 10:23
 */
public class OnlineQuestionTalkActivity extends BaseActivity {
    private ImageView tvDoctorPhoto;
    private TextView tvName;
    private TextView tvPosition;
    private RatingBar ratingBar;
    private Button btnAsk;
    private ListView lv;
    private RelativeLayout layoutMedia;

    private void assignViews() {
        tvDoctorPhoto = (ImageView) findViewById(R.id.tv_doctor_photo);
        tvName = (TextView) findViewById(R.id.tv_name);
        tvPosition = (TextView) findViewById(R.id.tv_position);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        btnAsk = (Button) findViewById(R.id.btn_ask);
        lv = (ListView) findViewById(R.id.lv);
        layoutMedia = (RelativeLayout) findViewById(R.id.layout_media);
    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_online_question_talk);
        setTitleBack("图文咨询");
        assignViews();
    }

    @Override
    protected void initData() {
        tvDoctorPhoto.setImageResource(R.drawable.ic_doctor_logo);
        tvName.setText("范小芬");
        tvPosition.setText("副主任医师");
        ratingBar.setRating(5);
        btnAsk.setVisibility(View.VISIBLE);
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
