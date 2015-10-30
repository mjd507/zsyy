package com.rainwii.zsyy.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
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
import com.rainwii.zsyy.utils.ToastUtils;

/**
 * 描述：智能导诊 --> 图片导诊
 * 作者 mjd
 * 日期：2015/10/20 17:27
 */
public class SymptomPhotoFragment extends BaseFragment implements View.OnTouchListener {
    private static final String TAG = "SymptomPhotoFragment";
    private ImageView ivPhotoRear;
    private ImageView ivPhotoFront;
    private ImageView ivInfo;
    private CheckBox cbSex;
    private Button btnAge;
    private Button btnFlip;
    private PopupWindow popupWindow;

    private boolean isFront = true;    //默认是正面
    private View rootView;
    private float viewHeight;
    private float viewWidth;
    private Bitmap bitmapFront;
    private Bitmap bitmapRear;

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_symptom_photo, null);
        ivPhotoRear = (ImageView) rootView.findViewById(R.id.iv_symptom_photo_rear);
        ivPhotoFront = (ImageView) rootView.findViewById(R.id.iv_symptom_photo_front);
        ivInfo = (ImageView) rootView.findViewById(R.id.iv_info);
        cbSex = (CheckBox) rootView.findViewById(R.id.cb_symptom_sex);
        btnAge = (Button) rootView.findViewById(R.id.btn_symptom_age);
        btnFlip = (Button) rootView.findViewById(R.id.btn_symptom_body_flip);
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                viewWidth = rootView.getWidth();
                viewHeight = rootView.getHeight();
                LogUtils.e(TAG, "rootView: width:" + viewWidth + " height:" + viewHeight);
            }
        });
        bitmapFront = ((BitmapDrawable) (ivPhotoFront.getDrawable())).getBitmap();
        bitmapRear = ((BitmapDrawable) (ivPhotoRear.getDrawable())).getBitmap();
        return rootView;
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

        ivPhotoFront.setOnTouchListener(this);
        ivPhotoRear.setOnTouchListener(this);
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


    private void enterPossibleDiseaseActivity(String body) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.BODY_AREA, body);
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


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.iv_symptom_photo_front:
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        float curX = event.getX();
                        float curY = event.getY();
                        if (bitmapFront.getPixel((int) curX, (int) curY) == 0) {
                            ToastUtils.showShort(getActivity(), "透明");
                            return true;
                        }
                        LogUtils.e(TAG, "curX:" + curX + " curY:" + curY);
                        if (isInFaceArea(curX, curY)) {
                            ToastUtils.showShort(getActivity(), "面部");
                        } else if (isInChestArea(curX, curY)) {
                            ToastUtils.showShort(getActivity(), "胸部");
                        } else if (isInAbdomenArea(curX, curY)) {
                            ToastUtils.showShort(getActivity(), "腹部");
                        } else if (isInPerinaeumArea(curX, curY)) {
                            ToastUtils.showShort(getActivity(), "会阴");
                        } else if (isInArmArea(curX, curY)) {
                            ToastUtils.showShort(getActivity(), "手臂");
                        }else if(isInLegArea(curX,curY)){
                            ToastUtils.showShort(getActivity(), "腿部");
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                break;
            case R.id.iv_symptom_photo_rear:
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        float curX = event.getX();
                        float curY = event.getY();
                        if (bitmapRear.getPixel((int) curX, (int) curY) == 0) {
                            ToastUtils.showShort(getActivity(), "透明");
                            return true;
                        }
                        LogUtils.e(TAG, "curX:" + curX + " curY:" + curY);
                        if (isInFaceArea(curX, curY)) {
                            ToastUtils.showShort(getActivity(), "面部");
                        } else if (isInChestArea(curX, curY)) {
                            ToastUtils.showShort(getActivity(), "胸部");
                        } else if (isInAbdomenArea(curX, curY)) {
                            ToastUtils.showShort(getActivity(), "腹部");
                        } else if (isInPerinaeumArea(curX, curY)) {
                            ToastUtils.showShort(getActivity(), "会阴");
                        } else if (isInArmArea(curX, curY)) {
                            ToastUtils.showShort(getActivity(), "手臂");
                        }else if(isInLegArea(curX,curY)){
                            ToastUtils.showShort(getActivity(), "腿部");
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                break;

        }
        return true;
    }

    private boolean isInFaceArea(float x, float y) {
        float X1 = viewWidth * 260 / 638;
        float X2 = viewWidth * 363 / 638;
        float Y1 = viewHeight * 40 / 1160;
        float Y2 = viewHeight * 180 / 1160;
        if (x >= X1 && x <= X2 && y >= Y1 && y <= Y2) {
            return true;
        }
        return false;
    }

    /**
     * 胸部
     */
    private boolean isInChestArea(float x, float y) {
        float X1 = viewWidth * 215 / 638;
        float X2 = viewWidth * 415 / 638;
        float Y1 = viewHeight * 230 / 1160;
        float Y2 = viewHeight * 320 / 1160;
        if (x >= X1 && x <= X2 && y >= Y1 && y <= Y2) {
            return true;
        }
        return false;
    }

    /**
     * 腹部
     */
    private boolean isInAbdomenArea(float x, float y) {
        float X1 = viewWidth * 215 / 638;
        float X2 = viewWidth * 415 / 638;
        float Y1 = viewHeight * 320 / 1160;
        float Y2 = viewHeight * 500 / 1160;
        if (x >= X1 && x <= X2 && y >= Y1 && y <= Y2) {
            return true;
        }
        return false;
    }

    /**
     * 会阴
     */
    private boolean isInPerinaeumArea(float x, float y) {
        float X1 = viewWidth * 215 / 638;
        float X2 = viewWidth * 415 / 638;
        float Y1 = viewHeight * 500 / 1160;
        float Y2 = viewHeight * 590 / 1160;
        if (x >= X1 && x <= X2 && y >= Y1 && y <= Y2) {
            return true;
        }
        return false;
    }

    /**
     * 手臂
     */
    private boolean isInArmArea(float x, float y) {
        float leftX1 = viewWidth * 10 / 638;
        float leftX2 = viewWidth * 215 / 638;
        float rightX1 = viewWidth * 415 / 638;
        float rightX2 = viewWidth * 622 / 638;
        float Y1 = viewHeight * 230 / 1160;
        float Y2 = viewHeight * 620 / 1160;
        if (y >= Y1 && y <= Y2) {
            if (x >= leftX1 && x <= leftX2) {
                return true;
            } else if (x >= rightX1 && x <= rightX2) {
                return true;
            }
        }
        return false;
    }

    /**
     * 腿部
     */
    private boolean isInLegArea(float x, float y) {
        float Y1 = viewHeight * 590 / 1160;
        if ( y >= Y1) {
            return true;
        }
        return false;
    }

}

