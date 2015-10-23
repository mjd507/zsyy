package com.rainwii.zsyy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.adapter.SymptomQuestionAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：智能导诊 问题的fragment
 * 作者 mjd
 * 日期：2015/10/22 17:09
 */
public class SymptomQuestionFragment extends BaseFragment {

    private TextView tvQuestionTitle;
    private ListView lv;
    public Button btnLast;
    public TextView tvQuestionCurrent;
    public Button btnNext;

    private List<String> list;
    private SymptomQuestionAdapter questionAdapter;

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_symptom_question, null);
        tvQuestionTitle = (TextView) view.findViewById(R.id.tv_question_title);
        lv = (ListView) view.findViewById(R.id.lv);
        btnLast = (Button) view.findViewById(R.id.btn_last);
        tvQuestionCurrent = (TextView) view.findViewById(R.id.tv_question_current);
        btnNext = (Button) view.findViewById(R.id.btn_next);
        return view;
    }

    @Override
    protected void initData() {
        tvQuestionTitle.setText("您是否伴有以下症状？");
        list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            list.add("咳嗽");
            list.add("发热");
            list.add("胸痛");
            list.add("消瘦");
        }
        questionAdapter = new SymptomQuestionAdapter(getActivity(), list);
        lv.setAdapter(questionAdapter);
    }

    @Override
    protected void initListeners() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView iv = (ImageView) view.findViewById(R.id.iv);
                if (questionAdapter.map.get(position) == null || !questionAdapter.map.get(position)) {
                    iv.setImageResource(R.drawable.ic_symptom_check_select);
                    questionAdapter.map.put(position, true);
                } else {
                    iv.setImageResource(R.drawable.ic_symptom_check_unselect);
                    questionAdapter.map.put(position, false);
                }
            }
        });
    }

    @Override
    protected void handleClick(View view) {

    }
}
