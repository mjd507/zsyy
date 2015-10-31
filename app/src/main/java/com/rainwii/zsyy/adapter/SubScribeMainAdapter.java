package com.rainwii.zsyy.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rainwii.zsyy.fragment.BaseFragment;

import java.util.List;

/**
 * 描述：订阅主页面的适配器
 * 作者 mjd
 * 日期：2015/10/31 13:25
 */
public class SubScribeMainAdapter extends FragmentPagerAdapter {
    private static String[] titles = {"专题", "饮食", "心理", "妇婴"};
    private List<BaseFragment> fragments;

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    public SubScribeMainAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return titles.length;
    }
}
