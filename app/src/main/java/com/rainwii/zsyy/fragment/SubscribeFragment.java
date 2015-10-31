package com.rainwii.zsyy.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.adapter.SubScribeMainAdapter;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：订阅
 * 作者 mjd
 * 日期：2015/10/12 9:08
 */
public class SubscribeFragment extends BaseFragment {
    private TabPageIndicator vpi;
    private ViewPager vp;
    private SubscribeSpecialFragment specialFragment;
    private SubscribeFoodFragment foodFragment;
    private SubscribeMindFragment mindFragment;
    private SubscribeBabyFragment babyFragment;


    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subscribe, null);
        setTitle(view, "订阅");
        vpi = (TabPageIndicator) view.findViewById(R.id.vpi);
        vp = (ViewPager) view.findViewById(R.id.vp);
        return view;
    }

    @Override
    protected void initData() {
        List<BaseFragment> fragmentList = new ArrayList<>();
        specialFragment = new SubscribeSpecialFragment();
        foodFragment = new SubscribeFoodFragment();
        mindFragment = new SubscribeMindFragment();
        babyFragment = new SubscribeBabyFragment();
        fragmentList.add(specialFragment);
        fragmentList.add(foodFragment);
        fragmentList.add(mindFragment);
        fragmentList.add(babyFragment);
        SubScribeMainAdapter adapter = new SubScribeMainAdapter(getChildFragmentManager(), fragmentList);
        vp.setAdapter(adapter);
        vp.setOffscreenPageLimit(3);
        vpi.setViewPager(vp);
    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void handleClick(View view) {

    }

}
