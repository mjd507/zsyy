package com.rainwii.zsyy.activity.symptom;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.BaseActivity;
import com.rainwii.zsyy.adapter.SymptomQuestionFragmentAdapter;
import com.rainwii.zsyy.fragment.BaseFragment;
import com.rainwii.zsyy.fragment.SymptomQuestionFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：智能导诊 --> 问题界面（包含一个ViewPager）
 * 作者 mjd
 * 日期：2015/10/22 16:28
 */
public class SymptomQuestionActivity extends BaseActivity {

    private ViewPager vp;

    private List<BaseFragment> fragmentList;
    private SymptomQuestionFragment currentFragment;
    private int currentPosition;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_symptom_question);
        setTitleBack("测试");
        vp = (ViewPager) this.findViewById(R.id.vp);
    }

    @Override
    protected void initData() {
        fragmentList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            fragmentList.add(new SymptomQuestionFragment());
        }
        SymptomQuestionFragmentAdapter adapter = new SymptomQuestionFragmentAdapter(getSupportFragmentManager(), fragmentList);
        vp.setAdapter(adapter);
        vp.setOffscreenPageLimit(fragmentList.size());
    }

    @Override
    protected void initListeners() {
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                initFragmentBottom(position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 初始化fragment的底部（按钮文字，状态、中间文字）
     */
    private void initFragmentBottom(int position) {
        currentPosition = position;
        currentFragment = (SymptomQuestionFragment) fragmentList.get(position);
        currentFragment.tvQuestionCurrent.setText((currentPosition + 1) + "/" + fragmentList.size());
        if (currentPosition == 0) {
            currentFragment.btnLast.setText("上一题");
            currentFragment.btnNext.setText("下一题");
            currentFragment.btnLast.setEnabled(false);
        } else if (currentPosition == fragmentList.size() - 1) {
            currentFragment.btnLast.setText("上一题");
            currentFragment.btnNext.setText("提交");
        } else {
            currentFragment.btnLast.setText("上一题");
            currentFragment.btnNext.setText("下一题");
        }
        currentFragment.btnLast.setOnClickListener(this);
        currentFragment.btnNext.setOnClickListener(this);
    }

    @Override
    protected void handleClick(View view) {
        switch (view.getId()) {

            case R.id.btn_last:
                if (currentPosition != 0) {
                    vp.setCurrentItem(currentPosition - 1);
                }
                break;
            case R.id.btn_next:
                if (currentPosition != fragmentList.size() - 1) {
                    vp.setCurrentItem(currentPosition + 1);
                } else {
                    enterActivity(SymptomDiagnosisActivity.class);
                }
                break;
        }
    }
}
