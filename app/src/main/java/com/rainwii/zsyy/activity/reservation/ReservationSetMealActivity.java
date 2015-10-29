package com.rainwii.zsyy.activity.reservation;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.BaseActivity;
import com.rainwii.zsyy.adapter.ReservationSetMealAdapter;
import com.rainwii.zsyy.bean.ReservationSetMeal;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：体检套餐
 * 作者 mjd
 * 日期：2015/10/29 11:13
 */
public class ReservationSetMealActivity extends BaseActivity {

    private ListView lv;
    private TextView tvTip;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_reservation_set_meal);
        setTitleBack("体检套餐");
        lv = (ListView) this.findViewById(R.id.lv);
        tvTip = (TextView) this.findViewById(R.id.tv_tip);
    }

    @Override
    protected void initData() {
        List<ReservationSetMeal> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add(new ReservationSetMeal("体检套餐甲","30岁以下","1620元","（已婚）1920元","暂时空着","一般检查：血压、脉搏、身高、体重、腰围、体重指数、健康家族史等\n 内科：心血管系统、呼吸系统、腹部触诊等\n 外科：皮肤、体表淋巴、甲状腺、乳房、四肢、脊柱、直肠指检等"));
        }
        ReservationSetMealAdapter adapter = new ReservationSetMealAdapter(this,list);
        lv.setAdapter(adapter);

    }

    @Override
    protected void initListeners() {
        tvTip.setOnClickListener(this);
    }

    @Override
    protected void handleClick(View view) {
        switch (view.getId()){
            case R.id.tv_tip:
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+"051268282030"));
                startActivity(intent);
                break;
        }

    }
}
