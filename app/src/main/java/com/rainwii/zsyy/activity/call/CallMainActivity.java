package com.rainwii.zsyy.activity.call;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.base.BaseActivity;
import com.rainwii.zsyy.adapter.CallAdapter;
import com.rainwii.zsyy.bean.Call;
import com.rainwii.zsyy.utils.DateUtils;
import com.rainwii.zsyy.view.MyListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        layout2.setVisibility(View.VISIBLE);
        this.findViewById(R.id.btn_search).setVisibility(View.GONE);
        List<Call> callList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            callList.add(new Call("20","口腔门诊", DateUtils.getDate()));
            callList.add(new Call("30","外科门诊", DateUtils.getDate()));
        }
        CallAdapter callAdapter = new CallAdapter(this, callList);
        allList.setAdapter(callAdapter);
    }

    Map<Integer,Boolean> map = new HashMap<>();
    @Override
    protected void initListeners() {
        allList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView ivStar = (ImageView) view.findViewById(R.id.iv_star);
                if(map.get(position)==null || !map.get(position)){
                    ivStar.setImageResource(R.drawable.ic_call_star_select);
                    map.put(position,true);
                }else {
                    ivStar.setImageResource(R.drawable.ic_call_star_unselected);
                    map.put(position,false);
                }
            }
        });
    }

    @Override
    protected void handleClick(View view) {

    }
}
