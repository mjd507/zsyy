package com.rainwii.zsyy.activity.subscribe;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.base.BaseActivity;
import com.rainwii.zsyy.adapter.SubscribeChildAdapter;
import com.rainwii.zsyy.bean.SubscribeChild;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 * 作者 mjd
 * 日期：2015/11/1 12:22
 */
public class SubscribeSpecialActivity extends BaseActivity {
    private ListView lv;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_subscribe_special);
        setTitleBack("专题");
        lv = (ListView) findViewById(R.id.lv);
    }

    @Override
    protected void initData() {
        List<SubscribeChild> foodList = new ArrayList<>();
        foodList.add(new SubscribeChild("imageuri", "均衡膳食--防止病从口入", "2015-11-07"));
        foodList.add(new SubscribeChild("imageuri", "节后综合征？美食来帮忙", "2015-11-07"));
        foodList.add(new SubscribeChild("imageuri", "那些年被误会的食物搭配", "2015-11-07"));
        foodList.add(new SubscribeChild("imageuri", "营养早餐技能，你get了吗", "2015-11-07"));
        foodList.add(new SubscribeChild("imageuri", "粗粮不好吃，其实是你的打开方式不对", "2015-11-07"));
        SubscribeChildAdapter adapter = new SubscribeChildAdapter(this, foodList);

        View headerView = View.inflate(this, R.layout.item_subscribe_header, null);
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
                bundle.putString("tab", "专题");
                enterActivity(SubscribeContentActivity.class, bundle);
            }
        });
    }

    @Override
    protected void handleClick(View view) {

    }
}
