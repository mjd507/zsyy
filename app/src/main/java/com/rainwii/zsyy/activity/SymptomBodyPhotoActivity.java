package com.rainwii.zsyy.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.adapter.SymptomAgeAdapter;
import com.rainwii.zsyy.utils.LogUtils;

/**
 * 描述：智能导诊
 * 作者 mjd
 * 日期：2015/10/20 17:27
 */
public class SymptomBodyPhotoActivity extends BaseActivity {
    private ImageView ivPhotoRear;
    private ImageView ivPhotoFront;
    private ImageView ivInfo;
    private CheckBox cbSex;
    private Button btnAge;
    private Button btnFlip;
    private PopupWindow popupWindow;

    private boolean isFront = true;    //默认是正面

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_symptom_body_photo);
        setTitleBackAndRight("智能导诊", R.drawable.ic_symptom_body_select);
        ivPhotoRear = (ImageView) this.findViewById(R.id.iv_symptom_photo_rear);
        ivPhotoFront = (ImageView) this.findViewById(R.id.iv_symptom_photo_front);
        ivInfo = (ImageView) this.findViewById(R.id.iv_info);
        cbSex = (CheckBox) this.findViewById(R.id.cb_symptom_sex);
        btnAge = (Button) this.findViewById(R.id.btn_symptom_age);
        btnFlip = (Button) this.findViewById(R.id.btn_symptom_body_flip);
    }

    @Override
    protected void initData() {
        btnAge.setText("20岁");
    }

    @Override
    protected void initListeners() {
        cbSex.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {  //女
                    ivPhotoFront.setImageResource(R.drawable.bg_symptom_women_body_up);
                    ivPhotoRear.setImageResource(R.drawable.bg_symptom_women_body_down);
                } else {
                    ivPhotoFront.setImageResource(R.drawable.bg_symptom_man_body_up);
                    ivPhotoRear.setImageResource(R.drawable.bg_symptom_man_body_down);
                }
            }
        });
        btnAge.setOnClickListener(this);
        btnFlip.setOnClickListener(this);
        ivInfo.setOnClickListener(this);
    }

    @Override
    protected void handleClick(View view) {
        switch (view.getId()) {
            case R.id.btn_symptom_age:
                showPopupWindow();
                break;
            case R.id.btn_symptom_body_flip:
                showFrontOrRear();
                break;
            case R.id.iv_info:
                showHintDialog();
                break;
        }
    }

    /**
     * 显示提示的对话框
     */
    private void showHintDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.MyAlertDialogStyle);
        builder.setTitle("提示");
        builder.setMessage("点击人体图上的相应部位，选择症状、伴随症状、病史记录等信息，查看可能疾病和推荐就诊科室。\n"
                + "\n" + " 该测试结果仅供参考，可能产生误诊、漏诊，如有疑问请咨询导医台工作人员。");
        builder.setPositiveButton("我知道了", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

    /**
     * 显示正面或者背面
     */
    private void showFrontOrRear() {
        isFront = !isFront;
        btnFlip.setBackgroundResource(isFront ? R.drawable.btn_symptom_rotate_selector : R.drawable.btn_symptom_rotate_1_selector);
        if (isFront) {
            ivPhotoRear.setVisibility(View.GONE);
            ivPhotoFront.setVisibility(View.VISIBLE);
            ivPhotoFront.setImageResource(cbSex.isChecked() ? R.drawable.bg_symptom_women_body_up : R.drawable.bg_symptom_man_body_up);
        } else {
            ivPhotoFront.setVisibility(View.GONE);
            ivPhotoRear.setVisibility(View.VISIBLE);
            ivPhotoRear.setImageResource(cbSex.isChecked() ? R.drawable.bg_symptom_women_body_down : R.drawable.bg_symptom_man_body_down);
        }

    }

    /**
     * 显示年龄的popupWindow
     */
    private void showPopupWindow() {
        View view = getLayoutInflater().inflate(R.layout.layout_symptom_pop_age, null);
        ListView lv = (ListView) view.findViewById(R.id.lv);
        SymptomAgeAdapter ageAdapter = new SymptomAgeAdapter(this);
        lv.setAdapter(ageAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                popupWindow.dismiss();
                TextView tvAge = (TextView) view.findViewById(R.id.tv_age);
                btnAge.setText(tvAge.getText());
            }
        });
        if (popupWindow == null) {
            int[] loc1 = new int[2];
            btnFlip.getLocationOnScreen(loc1);
            int[] loc2 = new int[2];
            btnAge.getLocationOnScreen(loc2);
            int deltaHeight = loc1[1] - loc2[1] - btnAge.getHeight();
            LogUtils.i("PopupWindow -- Age -- Height:", deltaHeight + "");
            popupWindow = new PopupWindow(view, btnAge.getWidth(), deltaHeight, true);
            popupWindow.setBackgroundDrawable(new BitmapDrawable());
        }
        popupWindow.showAsDropDown(btnAge);
    }

}

