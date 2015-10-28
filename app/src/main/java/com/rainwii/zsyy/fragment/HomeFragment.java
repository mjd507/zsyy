package com.rainwii.zsyy.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.call.CallMainActivity;
import com.rainwii.zsyy.activity.expert.ExpertFacultyActivity;
import com.rainwii.zsyy.activity.hospital.HospitalMainActivity;
import com.rainwii.zsyy.activity.symptom.SymptomMainActivity;
import com.rainwii.zsyy.activity.register.RegisterMainActivity;
import com.rainwii.zsyy.activity.report.ReportMainActivity;
import com.rainwii.zsyy.adapter.HomeModulesAdapter;
import com.rainwii.zsyy.adapter.HomeShuffleAdapter;
import com.rainwii.zsyy.view.MyGridView;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 * 作者 mjd
 * 日期：2015/10/12 9:08
 */
public class HomeFragment extends BaseFragment {
    private ViewPager vpShuffle;
    private MyGridView gvMainModules;
    private CirclePageIndicator indicator;

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        setTitle(view, "掌上医院");
        vpShuffle = (ViewPager) view.findViewById(R.id.vp_shuffle);
        indicator = (CirclePageIndicator) view.findViewById(R.id.indicator);
        gvMainModules = (MyGridView) view.findViewById(R.id.gv_modules);
        return view;
    }

    @Override
    protected void initData() {
        initShuffle();
        initModules();
    }

    /**
     * 初始化轮播图
     */
    private void initShuffle() {
        List<ImageView> imagesList = new ArrayList<>();
        ImageView imageView1 = new ImageView(getActivity());
        imageView1.setImageResource(R.drawable.demo1);
        ImageView imageView2 = new ImageView(getActivity());
        imageView2.setImageResource(R.drawable.demo2);
        ImageView imageView3 = new ImageView(getActivity());
        imageView3.setImageResource(R.drawable.demo3);
        imagesList.add(imageView1);
        imagesList.add(imageView2);
        imagesList.add(imageView3);
        HomeShuffleAdapter shuffleAdapter = new HomeShuffleAdapter(getActivity(), imagesList);
        vpShuffle.setAdapter(shuffleAdapter);
        indicator.setViewPager(vpShuffle);
    }

    /**
     * 初始化功能模块（6个）
     */
    private void initModules() {
        HomeModulesAdapter modulesAdapter = new HomeModulesAdapter(getActivity());
        gvMainModules.setAdapter(modulesAdapter);
    }

    @Override
    protected void initListeners() {
        gvMainModules.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:     //Mobile Registration
                        enterActivity(RegisterMainActivity.class);
                        break;
                    case 1:     //Queuing for calling
                        enterActivity(CallMainActivity.class);
                        break;
                    case 2:     //Report Query
                        enterActivity(ReportMainActivity.class);
                        break;
                    case 3:     //Intelligent Guide
                        enterActivity(SymptomMainActivity.class);
                        break;
                    case 4:     //Expert Scheduling
                        enterActivity(ExpertFacultyActivity.class);
                        break;
                    case 5:     //Hospital Navigation
                        enterActivity(HospitalMainActivity.class);
                        break;
                }
            }
        });
    }

    @Override
    protected void handleClick(View view) {

    }
}
