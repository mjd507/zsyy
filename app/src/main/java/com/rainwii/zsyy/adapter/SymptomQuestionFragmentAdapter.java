package com.rainwii.zsyy.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rainwii.zsyy.fragment.BaseFragment;

import java.util.List;

/**
 * 描述：症状 --> 问题 (viewPager)的适配器
 * 作者 mjd
 * 日期：2015/10/22 18:24
 */
public class SymptomQuestionFragmentAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> fragmentList;

    public SymptomQuestionFragmentAdapter(FragmentManager fm, List<BaseFragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

}
