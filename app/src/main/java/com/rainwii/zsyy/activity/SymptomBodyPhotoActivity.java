package com.rainwii.zsyy.activity;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
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
    private TextView tvBodyFlip;
    private PopupWindow popupWindow;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_symptom_body_photo);
        setTitleBackAndRight("智能导诊", R.drawable.ic_symptom_body_select);
        ivPhotoRear = (ImageView) this.findViewById(R.id.iv_symptom_photo_rear);
        ivPhotoFront = (ImageView) this.findViewById(R.id.iv_symptom_photo_front);
        ivInfo = (ImageView) this.findViewById(R.id.iv_info);
        cbSex = (CheckBox) this.findViewById(R.id.cb_symptom_sex);
        btnAge = (Button) this.findViewById(R.id.btn_symptom_age);
        tvBodyFlip = (TextView) this.findViewById(R.id.tv_symptom_body_flip);
    }

    @Override
    protected void initData() {
        btnAge.setText("20岁");
    }

    @Override
    protected void initListeners() {
        cbSex.setOnClickListener(this);
        btnAge.setOnClickListener(this);
        tvBodyFlip.setOnClickListener(this);
    }

    @Override
    protected void handleClick(View view) {
        switch (view.getId()) {
            case R.id.cb_symptom_sex:
                break;
            case R.id.btn_symptom_age:
                showPopupWindow();
                break;
            case R.id.tv_symptom_body_flip:
                break;
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
            tvBodyFlip.getLocationOnScreen(loc1);
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

