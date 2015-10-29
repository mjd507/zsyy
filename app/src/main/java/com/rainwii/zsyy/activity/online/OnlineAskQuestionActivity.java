package com.rainwii.zsyy.activity.online;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.BaseActivity;

/**
 * 描述：
 * 作者 mjd
 * 日期：2015/10/28 19:52
 */
public class OnlineAskQuestionActivity extends BaseActivity {
    private EditText etContent;
    private FrameLayout fm1;
    private ImageView ivPic1;
    private ImageView ivDel1;
    private FrameLayout fm2;
    private ImageView ivPic2;
    private ImageView ivDel2;
    private FrameLayout fm3;
    private ImageView ivPic3;
    private ImageView ivDel3;
    private ImageButton ivAdd;
    private Button btnSubmit;

    private void assignViews() {
        etContent = (EditText) findViewById(R.id.et_content);
        fm1 = (FrameLayout) findViewById(R.id.fm1);
        ivPic1 = (ImageView) findViewById(R.id.iv_pic_1);
        ivDel1 = (ImageView) findViewById(R.id.iv_del_1);
        fm2 = (FrameLayout) findViewById(R.id.fm2);
        ivPic2 = (ImageView) findViewById(R.id.iv_pic_2);
        ivDel2 = (ImageView) findViewById(R.id.iv_del_2);
        fm3 = (FrameLayout) findViewById(R.id.fm3);
        ivPic3 = (ImageView) findViewById(R.id.iv_pic_3);
        ivDel3 = (ImageView) findViewById(R.id.iv_del_3);
        ivAdd = (ImageButton) findViewById(R.id.iv_add);
        btnSubmit = (Button) findViewById(R.id.btn_submit);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            checkBtnState();
        }
    };

    private void checkBtnState() {
        if (!TextUtils.isEmpty(etContent.getText())) {
            btnSubmit.setEnabled(true);
        } else {
            btnSubmit.setEnabled(false);
        }
        handler.sendEmptyMessageDelayed(0, 1000);
    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_online_ask_question);
        setTitleBack("图文咨询");
        assignViews();
    }


    @Override
    protected void initData() {
        checkBtnState();
    }

    @Override
    protected void initListeners() {
        btnSubmit.setOnClickListener(this);
    }

    @Override
    protected void handleClick(View view) {
        switch (view.getId()) {
            case R.id.btn_submit:
                finish();
                break;
        }
    }
}
