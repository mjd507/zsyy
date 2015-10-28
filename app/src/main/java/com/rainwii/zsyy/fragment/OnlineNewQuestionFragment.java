package com.rainwii.zsyy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.adapter.OnlineNewQuestionAdapter;
import com.rainwii.zsyy.bean.OnlineNewQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：最新解答
 * 作者 mjd
 * 日期：2015/10/28 10:17
 */
public class OnlineNewQuestionFragment extends BaseFragment {

    private ListView lv;

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_listview, null);
        lv = (ListView) view.findViewById(R.id.lv);
        return view;
    }

    @Override
    protected void initData() {
        List<OnlineNewQuestion> newQuestionList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            newQuestionList.add(new OnlineNewQuestion("你好！我今年二十三岁，甲亢2年了，目前复用赛治0.75毫克，服药期间能吃阿胶吗？谢谢","imageuri","范小芬","副主任医师","12小时前","中医科","吃阿胶不影响甲亢治疗！但请中医会诊一下你是否有需要吃阿胶"));
        }
        OnlineNewQuestionAdapter adapter = new OnlineNewQuestionAdapter(getActivity(),newQuestionList);
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
