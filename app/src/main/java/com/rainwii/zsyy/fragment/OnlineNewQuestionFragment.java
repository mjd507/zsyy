package com.rainwii.zsyy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.online.OnlineQuestionTalkActivity;
import com.rainwii.zsyy.adapter.OnlineNewQuestionAdapter;
import com.rainwii.zsyy.bean.OnlineHotDoctor;
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
        newQuestionList.add(new OnlineNewQuestion("你好！我甲亢2年了，服用赛治0.75毫克，服药期间能吃阿胶吗？", "imageuri", "范小芬", "副主任医师", "12小时前", "中医科", "吃阿胶不影响甲亢治疗！但请中医会诊一下你是否有需要吃阿胶"));
        newQuestionList.add(new OnlineNewQuestion("你好！最近喉咙总是干咳，什么原因呢？有时候有痰，有时候咳不出来又咽不下去", "imageuri", "王　煜", "副主任医师", "2小时前", "消化科", "秋冬天气干燥，如咳嗽持续2周以上，建议来我院就诊"));
        newQuestionList.add(new OnlineNewQuestion("刘医生，最近老失眠，醒的又早，怎么办呢？以前总来没有过，就这几天，非常奇怪", "imageuri", "刘志达", "主任医师", "6小时前", "神经内科", "失眠一般由于压力过大，精神紧张或兴奋而引起的，保持良好的心态是最重要的。"));
        newQuestionList.add(new OnlineNewQuestion("谢医生，我身上莫名奇妙的很痒，该注意什么呢？我用手桡，可是却越饶越痒，好难受", "imageuri", "谢　莹", "主任医师", "6小时前", "内分泌科", "平时多注意身体清洁。"));
        OnlineNewQuestionAdapter adapter = new OnlineNewQuestionAdapter(getActivity(), newQuestionList);
        lv.setAdapter(adapter);
    }

    @Override
    protected void initListeners() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                enterActivity(OnlineQuestionTalkActivity.class);
            }
        });
    }

    @Override
    protected void handleClick(View view) {

    }
}
