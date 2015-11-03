package com.rainwii.zsyy.activity.encyclopedia;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.base.BaseActivity;
import com.rainwii.zsyy.adapter.EncyclopediaSecondListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 * 作者 mjd
 * 日期：2015/11/2 10:01
 */
public class EncyclopediaSecondListActivity extends BaseActivity {

    private ListView lv;
    private List<String> list;
    private String tag;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_encyclopedia_listview);
        tag = getIntent().getExtras().getString("tag");
        initTitle();
        lv = (ListView) this.findViewById(R.id.lv);
    }

    private void initTitle() {
        assert tag != null;
        switch (tag) {
            case "disease_1":
                setTitleBack("常见疾病");
                break;
            case "disease_2":
                setTitleBack("发病部位");
                break;
            case "disease_3":
                setTitleBack("所属科室");
                break;
        }
    }

    @Override
    protected void initData() {
        list = new ArrayList<>();
        switch (tag) {
            case "disease_1":
                list.add("病毒性肝炎");
                list.add("急性阑尾炎");
                list.add("消化性溃疡");
                list.add("风湿关节炎");
                list.add("慢性气管炎");
                list.add("前列腺增生");
                break;
            case "disease_2":
                list.add("四肢");
                list.add("口腔");
                list.add("面部");
                list.add("腰部");
                list.add("胸部");
                list.add("腹部");
                break;
            case "disease_3":
                list.add("风湿免疫科");
                list.add("心胸外科");
                list.add("妇产科");
                list.add("新生儿科");
                list.add("职业病科");
                list.add("口腔科");
                break;
        }

        EncyclopediaSecondListAdapter adapter = new EncyclopediaSecondListAdapter(this, list);
        lv.setAdapter(adapter);
    }

    @Override
    protected void initListeners() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString("contentId", "");
                enterActivity(EncyclopediaContentActivity.class, bundle);
            }
        });
    }

    @Override
    protected void handleClick(View view) {

    }
}
