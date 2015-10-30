package com.rainwii.zsyy.activity.symptom;

import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.base.BaseActivity;
import com.rainwii.zsyy.fragment.SymptomPhotoFragment;
import com.rainwii.zsyy.fragment.SymptomTextFragment;

/**
 * 描述：智能导诊 主页面 （包含两个Fragment）
 * 作者 mjd
 * 日期：2015/10/22 10:17
 */
public class SymptomMainActivity extends BaseActivity {

    private SymptomPhotoFragment photoFragment;
    private SymptomTextFragment textFragment;
    private int currentIndex = 0;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_symptom_main);
        setTitleBackAndRight("智能导诊", R.drawable.ic_body_text_select);
    }

    @Override
    protected void initData() {
        switchPhotoOrText(currentIndex);
    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void handleClick(View view) {
        switch (view.getId()) {
            case R.id.iv_title_right:
                if (currentIndex == 0) {
                    currentIndex = 1;
                    ivRight.setImageResource(R.drawable.ic_body_photo_select);
                    switchPhotoOrText(1);
                } else {
                    currentIndex = 0;
                    ivRight.setImageResource(R.drawable.ic_body_text_select);
                    switchPhotoOrText(0);
                }

                break;
        }
    }

    /**
     * 切换图片导诊 或者 文字导诊
     *
     * @param index 0-->图片导诊
     *              1-->文字导诊
     */
    private void switchPhotoOrText(int index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (photoFragment != null) {
            transaction.hide(photoFragment);
        }
        if (textFragment != null) {
            transaction.hide(textFragment);
        }
        switch (index) {
            case 0:
                if (photoFragment == null) {
                    photoFragment = new SymptomPhotoFragment();
                    transaction.add(R.id.fl_intelligent_guide, photoFragment);
                } else {
                    transaction.show(photoFragment);
                }
                break;
            case 1:
                if (textFragment == null) {
                    textFragment = new SymptomTextFragment();
                    transaction.add(R.id.fl_intelligent_guide, textFragment);
                } else {
                    transaction.show(textFragment);
                }
                break;
        }
        transaction.commit();
    }
}
