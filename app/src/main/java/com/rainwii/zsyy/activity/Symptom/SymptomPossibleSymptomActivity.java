package com.rainwii.zsyy.activity.symptom;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.base.BaseActivity;
import com.rainwii.zsyy.adapter.SymptomPossibleSymptomAdapter;
import com.rainwii.zsyy.constants.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：智能导诊 --> 部位对应的可能的症状列表
 * 作者 mjd
 * 日期：2015/10/22 13:01
 */
public class SymptomPossibleSymptomActivity extends BaseActivity {

    private ListView lv;
    private String bodyArea;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_symptom_possible_symptom);
        bodyArea = getIntent().getExtras().getString(Constants.BODY_AREA);
        setTitleBack(bodyArea);
        lv = (ListView) this.findViewById(R.id.lv);
    }

    @Override
    protected void initData() {
        List<String> list = new ArrayList<>();
        if (bodyArea.equals("面部")) {
            list.add("面部蝶形红斑");
            list.add("口角抽搐");
            list.add("面部肿块");
            list.add("面部疼痛");
        } else if (bodyArea.equals("手臂")) {
            list.add("肩关节疼痛");
            list.add("关节活动受阻");
            list.add("四肢肿块");
            list.add("指端皮肤色泽改变");
        } else if (bodyArea.equals("胸部")) {
            list.add("乳房肥大");
            list.add("气促");
            list.add("干咳");
            list.add("呼吸困难");
        } else if (bodyArea.equals("腹部")) {
            list.add("呕吐");
            list.add("反酸");
            list.add("上腹痛");
            list.add("下腹痛");
        } else if (bodyArea.equals("会阴")) {
            list.add("尿流中断");
            list.add("尿线变细");
            list.add("夜尿增多");
            list.add("龟头疼痛");
        } else if (bodyArea.equals("腿部")) {
            list.add("肢体无力");
            list.add("关节疼痛");
            list.add("步态异常");
            list.add("晨僵");
        } else if (bodyArea.equals("头部")) {
            list.add("认知障碍");
            list.add("记忆障碍");
            list.add("头部肿块");
            list.add("头晕。头昏");
        } else if (bodyArea.equals("腰背部")) {
            list.add("背部肿块");
            list.add("腰底疼痛");
            list.add("要背痛");
        } else if (bodyArea.equals("臀部")) {
            list.add("大便失禁");
            list.add("肛门痛");
            list.add("便秘");
            list.add("黑便");
        }else {
        }
        SymptomPossibleSymptomAdapter diseaseAdapter = new SymptomPossibleSymptomAdapter(this, list);
        lv.setAdapter(diseaseAdapter);
    }

    @Override
    protected void initListeners() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                enterActivity(SymptomQuestionActivity.class);
            }
        });
    }

    @Override
    protected void handleClick(View view) {

    }
}
