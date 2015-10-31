package com.rainwii.zsyy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.subscribe.SubscribeContentActivity;
import com.rainwii.zsyy.adapter.SubscribeChildAdapter;
import com.rainwii.zsyy.bean.SubscribeChild;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 * 作者 mjd
 * 日期：2015/10/31 13:32
 */
public class SubscribeBabyFragment extends BaseFragment {

    private ListView lv;

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subscribe_child, null);
        lv = (ListView) view.findViewById(R.id.lv);
        return view;
    }

    @Override
    protected void initData() {
        List<SubscribeChild> foodList = new ArrayList<>();
        foodList.add(new SubscribeChild("imageuri", "均衡膳食--防止病从口入", "2015-11-07"));
        foodList.add(new SubscribeChild("imageuri", "节后综合征？美食来帮忙", "2015-11-07"));
        foodList.add(new SubscribeChild("imageuri", "那些年被误会的食物搭配", "2015-11-07"));
        foodList.add(new SubscribeChild("imageuri", "营养早餐技能，你get了吗", "2015-11-07"));
        foodList.add(new SubscribeChild("imageuri", "粗粮不好吃，其实是你的打开方式不对", "2015-11-07"));
        SubscribeChildAdapter adapter = new SubscribeChildAdapter(getActivity(), foodList);

        View headerView = View.inflate(getActivity(), R.layout.item_subscribe_header, null);
        ImageView ivHeader = (ImageView) headerView.findViewById(R.id.iv_item);
        TextView tvHeader = (TextView) headerView.findViewById(R.id.tv_item);
        ivHeader.setImageResource(R.drawable.demo4);
        tvHeader.setText("减肥，你真的需要吗？");
        lv.addHeaderView(headerView);
        lv.setAdapter(adapter);

    }

    @Override
    protected void initListeners() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString("tab", "妇婴");
                enterActivity(SubscribeContentActivity.class,bundle);
            }
        });
    }
    @Override
    protected void handleClick(View view) {

    }
}
