package com.rainwii.zsyy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.symptom.SymptomPossibleSymptomActivity;
import com.rainwii.zsyy.adapter.SymptomPossibleSymptomAdapter;
import com.rainwii.zsyy.constants.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：智能导诊 --> 文字导诊
 * 作者 mjd
 * 日期：2015/10/22 10:45
 */
public class SymptomTextFragment extends BaseFragment {

    private ListView lv;
    private List<String> list;

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_symptom_text, null);
        lv = (ListView) view.findViewById(R.id.lv);
        return view;
    }

    @Override
    protected void initData() {
        list = new ArrayList<>();
        list.add("四肢");
        list.add("口腔");
        list.add("面部");
        list.add("臀部");
        list.add("腰部");
        list.add("会阴");
        list.add("皮肤");
        list.add("上肢");
        list.add("下肢");
        list.add("下肢");
        list.add("下肢");
        list.add("下肢");
        list.add("下肢");
        list.add("下肢");
        list.add("下肢");
        SymptomPossibleSymptomAdapter adapter = new SymptomPossibleSymptomAdapter(getActivity(), list);
        lv.setAdapter(adapter);
    }

    @Override
    protected void initListeners() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString(Constants.BODY_AREA, list.get(position));
                enterActivity(SymptomPossibleSymptomActivity.class, bundle);
            }
        });
    }

    @Override
    protected void handleClick(View view) {

    }
}
