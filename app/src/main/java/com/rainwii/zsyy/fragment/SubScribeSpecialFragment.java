package com.rainwii.zsyy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.adapter.SubscribeSpecialAdapter;
import com.rainwii.zsyy.bean.SubscribeSpecial;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 * 作者 mjd
 * 日期：2015/10/31 13:32
 */
public class SubscribeSpecialFragment extends BaseFragment {
    private ListView lv;

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subscribe_child, null);
        lv = (ListView) view.findViewById(R.id.lv);
        return view;
    }

    @Override
    protected void initData() {
        List<SubscribeSpecial> specialList = new ArrayList<>();
        specialList.add(new SubscribeSpecial("imageUri","每周孕事"));
        specialList.add(new SubscribeSpecial("imageUri","幼儿教育"));
        specialList.add(new SubscribeSpecial("imageUri","医学前沿"));
        SubscribeSpecialAdapter adapter = new SubscribeSpecialAdapter(getActivity(),specialList);
        lv.setAdapter(adapter);
    }

    @Override
    protected void initListeners() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    @Override
    protected void handleClick(View view) {

    }
}
