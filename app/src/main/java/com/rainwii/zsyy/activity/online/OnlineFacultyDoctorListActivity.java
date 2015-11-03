package com.rainwii.zsyy.activity.online;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.base.BaseActivity;
import com.rainwii.zsyy.adapter.OnlineFacultyDoctorListAdapter;
import com.rainwii.zsyy.bean.OnlineHotDoctor;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：科室 医生列表
 * 作者 mjd
 * 日期：2015/10/28 17:13
 */
public class OnlineFacultyDoctorListActivity extends BaseActivity {

    private ListView lv;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_online_faculty_doctor_list);
        setTitleBack("图文咨询");
        lv = (ListView) findViewById(R.id.lv);
    }

    @Override
    protected void initData() {
        List<OnlineHotDoctor> list = new ArrayList<>();
        list.add(new OnlineHotDoctor("imageuri", "范小芬", "副主任医师", "中医科", "1988年毕业于苏州大学医院院，擅长于消化内镜及肝脏穿刺等诊疗术。", "5"));
        list.add(new OnlineHotDoctor("imageuri", "王　煜", "主任医师", "风湿免疫科", " 从事消化内科工作近30年，对肝胆、肠胃疾病消化道肿瘤的诊断及治疗积累了丰富的经验", "5"));
        list.add(new OnlineHotDoctor("imageuri", "刘志达", "主任医师", "神经内科", "专长：糖尿病，甲状腺疾病和其他内分泌疾病的诊断和治疗。", "5"));
        list.add(new OnlineHotDoctor("imageuri", "谢　莹", "主任医师", "内分泌科", "主要从事内分泌学的临床、教学与科研工作,擅长糖尿病、甲状腺疾病、痛风、肾上腺疾病等。", "5"));
        list.add(new OnlineHotDoctor("imageuri", "范小芬", "副主任医师", "消化科", "擅长消化内镜的诊疗技术如食管曲张静脉的皮圈结扎术、硬化治疗术、胃肠息肉摘除术、粘膜切除术、消化道出血的急诊内镜检查术及多种内镜下止血术", "5"));
        OnlineFacultyDoctorListAdapter adapter = new OnlineFacultyDoctorListAdapter(this, list);
        lv.setAdapter(adapter);
    }

    @Override
    protected void initListeners() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                enterActivity(OnlineHotDoctorDetailActivity.class);
            }
        });
    }

    @Override
    protected void handleClick(View view) {

    }
}
