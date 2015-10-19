package com.rainwii.zsyy.activity;

import android.view.View;
import android.widget.LinearLayout;

import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.rainwii.zsyy.R;
import com.rainwii.zsyy.view.MyListView;

/**
 * 描述：Queuing for calling
 * 作者 mjd
 * 日期：2015/10/13 9:27
 */
public class CallMainActivity extends BaseActivity {
    private LinearLayout layout1;
    private PullToRefreshScrollView scrollView1;
    private LinearLayout layout2;
    private PullToRefreshScrollView scrollView2;
    private MyListView allList;


    @Override
    protected void initViews() {
        setContentView(R.layout.activity_call_main_of_all);
        setTitleBack("排队叫号");
        layout1 = (LinearLayout) findViewById(R.id.layout_1);
        scrollView1 = (PullToRefreshScrollView) findViewById(R.id.scroll_view_1);
        layout2 = (LinearLayout) findViewById(R.id.layout_2);
        scrollView2 = (PullToRefreshScrollView) findViewById(R.id.scroll_view_2);
        allList = (MyListView) findViewById(R.id.all_list);
    }

    @Override
    protected void initData() {


    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void handleClick(View view) {

    }
}
