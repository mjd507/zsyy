package com.rainwii.zsyy.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.symptom.SymptomPossibleSymptomActivity;
import com.rainwii.zsyy.adapter.SymptomAgeAdapter;
import com.rainwii.zsyy.constants.Constants;
import com.rainwii.zsyy.utils.LogUtils;

/**
 * 描述：智能导诊 --> 图片导诊
 * 作者 mjd
 * 日期：2015/10/20 17:27
 */
public class SymptomPhotoFragment extends BaseFragment {
    private ImageView ivPhotoRear;
    private ImageView ivPhotoFront;
    private ImageView ivInfo;
    private CheckBox cbSex;
    private Button btnAge;
    private Button btnFlip;
    private PopupWindow popupWindow;

    private boolean isFront = true;    //默认是正面

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_symptom_photo, null);
        ivPhotoRear = (ImageView) view.findViewById(R.id.iv_symptom_photo_rear);
        ivPhotoFront = (ImageView) view.findViewById(R.id.iv_symptom_photo_front);
        ivInfo = (ImageView) view.findViewById(R.id.iv_info);
        cbSex = (CheckBox) view.findViewById(R.id.cb_symptom_sex);
        btnAge = (Button) view.findViewById(R.id.btn_symptom_age);
        btnFlip = (Button) view.findViewById(R.id.btn_symptom_body_flip);
        return view;
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

        ivPhotoFront.setOnClickListener(this);
        ivPhotoRear.setOnClickListener(this);
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
            case R.id.iv_symptom_photo_front:
                enterPossibleDiseaseActivity();
                break;
            case R.id.iv_symptom_photo_rear:
                enterPossibleDiseaseActivity();
                break;
        }
    }

    private void enterPossibleDiseaseActivity() {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.BODY_AREA, "四肢");
        enterActivity(SymptomPossibleSymptomActivity.class, bundle);
    }

    /**
     * 显示提示的对话框
     */
    private void showHintDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.MyAlertDialogStyle);
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
        View view = getActivity().getLayoutInflater().inflate(R.layout.layout_symptom_pop_age, null);
        ListView lv = (ListView) view.findViewById(R.id.lv);
        SymptomAgeAdapter ageAdapter = new SymptomAgeAdapter(getActivity());
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

