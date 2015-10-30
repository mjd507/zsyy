package com.rainwii.zsyy.activity.encyclopedia;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.base.BaseActivity;

/**
 * 描述：健康百科
 * 作者 mjd
 * 日期：2015/10/30 9:50
 */
public class EncyclopediaMainActivity extends BaseActivity {
    private ImageView diseaseSearch;
    private TextView disease1;
    private TextView disease2;
    private TextView disease3;
    private ImageView drugSearch;
    private TextView drug1;
    private TextView drug2;
    private TextView drug3;
    private TextView drug4;
    private TextView drug5;
    private TextView drug6;
    private TextView drug7;
    private TextView drug8;
    private TextView drug9;
    private TextView drug10;
    private TextView drug11;
    private TextView drug12;
    private TextView drug13;
    private TextView action1;
    private TextView action2;
    private TextView action3;
    private TextView tool1;
    private TextView tool2;
    private TextView tool3;
    private TextView tool4;
    private TextView tool5;
    private TextView tool6;
    private TextView tool7;
    private TextView tool8;

    private void assignViews() {
        diseaseSearch = (ImageView) findViewById(R.id.disease_search);
        disease1 = (TextView) findViewById(R.id.disease_1);
        disease2 = (TextView) findViewById(R.id.disease_2);
        disease3 = (TextView) findViewById(R.id.disease_3);
        drugSearch = (ImageView) findViewById(R.id.drug_search);
        drug1 = (TextView) findViewById(R.id.drug_1);
        drug2 = (TextView) findViewById(R.id.drug_2);
        drug3 = (TextView) findViewById(R.id.drug_3);
        drug4 = (TextView) findViewById(R.id.drug_4);
        drug5 = (TextView) findViewById(R.id.drug_5);
        drug6 = (TextView) findViewById(R.id.drug_6);
        drug7 = (TextView) findViewById(R.id.drug_7);
        drug8 = (TextView) findViewById(R.id.drug_8);
        drug9 = (TextView) findViewById(R.id.drug_9);
        drug10 = (TextView) findViewById(R.id.drug_10);
        drug11 = (TextView) findViewById(R.id.drug_11);
        drug12 = (TextView) findViewById(R.id.drug_12);
        drug13 = (TextView) findViewById(R.id.drug_13);
        action1 = (TextView) findViewById(R.id.action_1);
        action2 = (TextView) findViewById(R.id.action_2);
        action3 = (TextView) findViewById(R.id.action_3);
        tool1 = (TextView) findViewById(R.id.tool_1);
        tool2 = (TextView) findViewById(R.id.tool_2);
        tool3 = (TextView) findViewById(R.id.tool_3);
        tool4 = (TextView) findViewById(R.id.tool_4);
        tool5 = (TextView) findViewById(R.id.tool_5);
        tool6 = (TextView) findViewById(R.id.tool_6);
        tool7 = (TextView) findViewById(R.id.tool_7);
        tool8 = (TextView) findViewById(R.id.tool_8);
    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_encyclopedia_main);
        setTitleBack("健康百科");
        assignViews();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListeners() {
        diseaseSearch.setOnClickListener(this);
    }

    @Override
    protected void handleClick(View view) {

    }
}
