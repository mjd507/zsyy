package com.rainwii.zsyy.activity.encyclopedia;

import android.os.Bundle;
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
        disease1.setOnClickListener(this);
        disease2.setOnClickListener(this);
        disease3.setOnClickListener(this);
        drug1.setOnClickListener(this);
        drug2.setOnClickListener(this);
        drug3.setOnClickListener(this);
        drug4.setOnClickListener(this);
        drug5.setOnClickListener(this);
        drug6.setOnClickListener(this);
        drug7.setOnClickListener(this);
        drug8.setOnClickListener(this);
        drug9.setOnClickListener(this);
        drug10.setOnClickListener(this);
        drug11.setOnClickListener(this);
        drug12.setOnClickListener(this);
        drug13.setOnClickListener(this);
        action1.setOnClickListener(this);
        action2.setOnClickListener(this);
        action3.setOnClickListener(this);
        tool1.setOnClickListener(this);
        tool2.setOnClickListener(this);
        tool3.setOnClickListener(this);
        tool4.setOnClickListener(this);
        tool5.setOnClickListener(this);
        tool6.setOnClickListener(this);
        tool7.setOnClickListener(this);
        tool8.setOnClickListener(this);
    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void handleClick(View view) {
        Bundle bundle = new Bundle();
        switch (view.getId()) {
            case R.id.disease_1:
                bundle.putString("tag", "disease_1");
                enterActivity(EncyclopediaSecondListActivity.class, bundle);
                break;
            case R.id.disease_2:
                bundle.putString("tag", "disease_2");
                enterActivity(EncyclopediaSecondListActivity.class, bundle);
                break;
            case R.id.disease_3:
                bundle.putString("tag", "disease_3");
                enterActivity(EncyclopediaSecondListActivity.class, bundle);
                break;
            case R.id.drug_1:
                bundle.putString("tag", "drug_1");
                enterActivity(EncyclopediaSecondListActivity.class, bundle);
                break;
            case R.id.drug_2:
                bundle.putString("tag", "drug_2");
                enterActivity(EncyclopediaSecondListActivity.class, bundle);
                break;
            case R.id.drug_3:
                bundle.putString("tag", "drug_3");
                enterActivity(EncyclopediaSecondListActivity.class, bundle);
                break;
            case R.id.drug_4:
                bundle.putString("tag", "drug_4");
                enterActivity(EncyclopediaSecondListActivity.class, bundle);
                break;
            case R.id.drug_5:
                bundle.putString("tag", "drug_5");
                enterActivity(EncyclopediaSecondListActivity.class, bundle);
                break;
            case R.id.drug_6:
                bundle.putString("tag", "drug_6");
                enterActivity(EncyclopediaSecondListActivity.class, bundle);
                break;
            case R.id.drug_7:
                bundle.putString("tag", "drug_7");
                enterActivity(EncyclopediaSecondListActivity.class, bundle);
                break;
            case R.id.drug_8:
                bundle.putString("tag", "drug_8");
                enterActivity(EncyclopediaSecondListActivity.class, bundle);
                break;
            case R.id.drug_9:
                bundle.putString("tag", "drug_9");
                enterActivity(EncyclopediaSecondListActivity.class, bundle);
                break;
            case R.id.drug_10:
                bundle.putString("tag", "drug_10");
                enterActivity(EncyclopediaSecondListActivity.class, bundle);
                break;
            case R.id.drug_11:
                bundle.putString("tag", "drug_11");
                enterActivity(EncyclopediaSecondListActivity.class, bundle);
                break;
            case R.id.drug_12:
                bundle.putString("tag", "drug_12");
                enterActivity(EncyclopediaSecondListActivity.class, bundle);
                break;
            case R.id.drug_13:
                bundle.putString("tag", "drug_13");
                enterActivity(EncyclopediaSecondListActivity.class, bundle);
                break;
            case R.id.action_1:
                bundle.putString("tag", "action_1");
                enterActivity(EncyclopediaSecondListActivity.class, bundle);
                break;
            case R.id.action_2:
                bundle.putString("tag", "action_2");
                enterActivity(EncyclopediaSecondListActivity.class, bundle);
                break;
            case R.id.action_3:
                bundle.putString("tag", "action_3");
                enterActivity(EncyclopediaSecondListActivity.class, bundle);
                break;
            case R.id.tool_1:
                bundle.putString("tag", "tool_1");
                enterActivity(EncyclopediaSecondListActivity.class, bundle);
                break;
            case R.id.tool_2:
                bundle.putString("tag", "tool_2");
                enterActivity(EncyclopediaSecondListActivity.class, bundle);
                break;
            case R.id.tool_3:
                bundle.putString("tag", "tool_3");
                enterActivity(EncyclopediaSecondListActivity.class, bundle);
                break;
            case R.id.tool_4:
                bundle.putString("tag", "tool_4");
                enterActivity(EncyclopediaSecondListActivity.class, bundle);
                break;
            case R.id.tool_5:
                bundle.putString("tag", "tool_5");
                enterActivity(EncyclopediaSecondListActivity.class, bundle);
                break;
            case R.id.tool_6:
                bundle.putString("tag", "tool_6");
                enterActivity(EncyclopediaSecondListActivity.class, bundle);
                break;
            case R.id.tool_7:
                bundle.putString("tag", "tool_7");
                enterActivity(EncyclopediaSecondListActivity.class, bundle);
                break;
            case R.id.tool_8:
                bundle.putString("tag", "tool_8");
                enterActivity(EncyclopediaSecondListActivity.class, bundle);
                break;
        }

    }
}
