package com.rainwii.zsyy.activity.expert;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.base.BaseActivity;
import com.rainwii.zsyy.adapter.ExpertListAdapter;
import com.rainwii.zsyy.bean.ExpertListIInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：专家排班 --> 医生列表
 * 作者 mjd
 * 日期：2015/10/26 9:08
 */
public class ExpertListActivity extends BaseActivity {

    private ListView lv;
    private List<ExpertListIInfo> list;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_expert_list);
        setTitleBack("专家排班");
        lv = (ListView) this.findViewById(R.id.lv);
    }

    @Override
    protected void initData() {
        list = new ArrayList<>();
        list.add(new ExpertListIInfo("imageUrl", "姜忠", "主治医师,硕士生导师", "擅长恶性肿瘤以放疗为主要治疗手段的综合治疗"));
        list.add(new ExpertListIInfo("imageUrl", "王少雄", "副主任医师", "擅长各类风湿免疫性疾病的诊治，如系统性红斑狼疮，类风湿性关节炎，强直性脊柱炎等各类风湿免疫性疾病。"));
        list.add(new ExpertListIInfo("imageUrl", "孙光夏", "主治医师", "擅长对肺部弥漫性病变，各种肺部感染，胸膜病变，哮喘等的诊断和治疗。"));
        list.add(new ExpertListIInfo("imageUrl", "刘春风", "主治医师", "擅长腹泻肠道性疾病，如：急性肠胃炎，细菌性痢疾，食物中毒，慢性肠炎，伤寒及发热咳嗽呼吸道感染性疾病等疾病的诊治"));
        list.add(new ExpertListIInfo("imageUrl", "张国庆", "主治医师", "擅长慢性阻塞性肺病和支气管哮喘的诊断和规范化治疗"));
        list.add(new ExpertListIInfo("imageUrl", "魏钦海", "主治医师", "主要从事内分泌学的临床、教学与科研工作,擅长糖尿病、甲状腺疾病、痛风、肾上腺疾病等"));
        list.add(new ExpertListIInfo("imageUrl", "孙亦晖", "主治医师", "主要从事肾脏风湿性疾病，继发性肾病的临床、病理研究"));
        list.add(new ExpertListIInfo("imageUrl", "毛卫东", "主治医师", "擅长原发性肾小球肾炎、急性肾功能不全、尿毒症、尿路感染等的诊断和治疗"));
        ExpertListAdapter adapter = new ExpertListAdapter(this, list);
        lv.setAdapter(adapter);
    }

    @Override
    protected void initListeners() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("expertListInfo", list.get(position));
                enterActivity(ExpertScheduleActivity.class, bundle);
            }
        });
    }

    @Override
    protected void handleClick(View view) {

    }
}
