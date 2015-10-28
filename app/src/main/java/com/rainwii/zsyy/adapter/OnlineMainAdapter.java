package com.rainwii.zsyy.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rainwii.zsyy.fragment.BaseFragment;

import java.util.List;

/**
 * 描述：图文咨询的适配器
 * 作者 mjd
 * 日期：2015/10/28 10:20
 */
public class OnlineMainAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> fragmentList;
    private static String[] titles = {"最新解答", "热门医生", "科室"};

    public OnlineMainAdapter(FragmentManager fm, List<BaseFragment> fragmentList) {
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

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
