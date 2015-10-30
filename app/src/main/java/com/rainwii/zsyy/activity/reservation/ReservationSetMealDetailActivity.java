package com.rainwii.zsyy.activity.reservation;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.base.BaseActivity;
import com.rainwii.zsyy.bean.ReservationSetMealDetail;

/**
 * 描述：体检套餐详情
 * 作者 mjd
 * 日期：2015/10/29 12:56
 */
public class ReservationSetMealDetailActivity extends BaseActivity {
    private ImageView iv;
    private TextView tvName;
    private TextView tvManCost;
    private TextView tvWomenCost;
    private TextView tvLcjc;
    private TextView tvBelong;
    private TextView tvSysjc;
    private TextView tvYqjc;
    private TextView tvOther;

    private void assignViews() {
        iv = (ImageView) findViewById(R.id.iv);
        tvName = (TextView) findViewById(R.id.tv_name);
        tvManCost = (TextView) findViewById(R.id.tv_man_cost);
        tvWomenCost = (TextView) findViewById(R.id.tv_women_cost);
        tvLcjc = (TextView) findViewById(R.id.tv_lcjc);
        tvBelong = (TextView) findViewById(R.id.tv_belong);
        tvSysjc = (TextView) findViewById(R.id.tv_sysjc);
        tvYqjc = (TextView) findViewById(R.id.tv_yqjc);
        tvOther = (TextView) findViewById(R.id.tv_other);
    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_reservation_set_meal_detail);
        setTitleBack("体检套餐");
        assignViews();
    }

    @Override
    protected void initData() {
        ReservationSetMealDetail detail = new ReservationSetMealDetail(
                " 一般检查：血压、脉搏、身高、体重、腰围、体重指数、健康家族史等\n  内科：心血管系统、呼吸系统、腹部触诊等\n  外科：皮肤、体表淋巴、甲状腺、乳房、四肢、脊柱、直肠指检等",
                " 30岁以下",
                " 血常规\n 尿常规\n 大便常规+隐血试验\n 生化全套（34项）\n \n 女性：\n 阴道分泌物检查\n 宫颈薄层液基细胞学检查（TCT法）",
                " 心电图（12导联）\n 男：膀胱、前列腺\n 女：子宫、附件（已婚） 盆腔（未婚）",
                " 上午来检：供当日早、中餐\n 下午来检：双人间合住一晚，供当日晚餐及次日早餐");

        tvName.setText("体检套餐甲");
        tvManCost.setText("1620元");
        tvWomenCost.setText("（已婚）1920元");
        tvLcjc.setText(detail.getLcjc());
        tvBelong.setText(detail.getBelong());
        tvSysjc.setText(detail.getSysjc());
        tvYqjc.setText(detail.getYqjc());
        tvOther.setText(detail.getOther());
    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void handleClick(View view) {

    }
}
