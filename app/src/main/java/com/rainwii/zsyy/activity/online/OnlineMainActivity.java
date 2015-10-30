package com.rainwii.zsyy.activity.online;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.base.BaseActivity;
import com.rainwii.zsyy.adapter.OnlineMainAdapter;
import com.rainwii.zsyy.fragment.BaseFragment;
import com.rainwii.zsyy.fragment.OnlineNewQuestionFragment;
import com.rainwii.zsyy.fragment.OnlineFacultyFragment;
import com.rainwii.zsyy.fragment.OnlineHotDoctorFragment;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：图文咨询主页面
 * 作者 mjd
 * 日期：2015/10/28 9:54
 */
public class OnlineMainActivity extends BaseActivity {
    private TabPageIndicator vpi;
    private ViewPager vp;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_online_main);
        setTitleBack("图文咨询");
        vpi = (TabPageIndicator) findViewById(R.id.vpi);
        vp = (ViewPager) findViewById(R.id.vp);

    }

    @Override
    protected void initData() {
        List<BaseFragment> fragmentList = new ArrayList<>();
        fragmentList.add(new OnlineNewQuestionFragment());
        fragmentList.add(new OnlineHotDoctorFragment());
        fragmentList.add(new OnlineFacultyFragment());
        OnlineMainAdapter adapter = new OnlineMainAdapter(getSupportFragmentManager(), fragmentList);
        vp.setAdapter(adapter);
        vpi.setViewPager(vp);
    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void handleClick(View view) {

    }

}
