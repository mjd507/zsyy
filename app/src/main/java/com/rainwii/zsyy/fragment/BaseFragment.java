package com.rainwii.zsyy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.view.MyProgressDialog;


public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    public boolean isLeftBack = true;   //默认左上角代表返回按钮

    private ImageView ivLeft;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = initView(inflater, container, savedInstanceState);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initListener();
    }

    protected abstract View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    protected abstract void initData();

    protected abstract void initListener();

    protected abstract void handleClick(View view);

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_title_left && isLeftBack) {    //点击左边 并且代表返回时，finish
            getActivity().finish();
        } else {
            handleClick(v);
        }
    }

    /**
     * 设置标题
     */
    public void setTitle(View view, String title) {
        TextView tvTitle = (TextView) view.findViewById(R.id.tv_title);
        tvTitle.setText(title);
    }

    /**
     * 设置标题、返回按钮
     */
    public void setTitleBack(View view, String title) {
        setTitle(view, title);
        ivLeft = (ImageView) view.findViewById(R.id.iv_title_left);
        ivLeft.setVisibility(View.VISIBLE);
        ivLeft.setImageResource(R.drawable.btn_title_back);
        ivLeft.setOnClickListener(this);
    }

    /**
     * 设置标题、返回按钮、右边图片
     */
    public void setTitleBackAndRight(View view, String title, int rightId) {
        setTitleBack(view, title);
        ImageView ivRight = (ImageView) view.findViewById(R.id.iv_title_right);
        ivRight.setVisibility(View.VISIBLE);
        ivRight.setImageResource(rightId);
        ivRight.setOnClickListener(this);
    }

    /**
     * 设置标题、左边图片、右边图片
     */
    public void setTitleLeftAndRight(View view, String title, int leftId, int rightId) {
        isLeftBack = false;
        setTitleBackAndRight(view, title, rightId);
        ivLeft.setImageResource(leftId);
    }

    protected void enterActivity(Class<?> targetClass) {
        startActivity(new Intent(getActivity(), targetClass));
    }

    protected void enterActivity(Class<?> targetClass, Bundle bundle) {
        Intent intent = new Intent(getActivity(), targetClass);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private MyProgressDialog progressDialog;

    /**
     * 显示加载框
     */
    protected void showLoading(String msg) {
        progressDialog = new MyProgressDialog(getActivity(), msg);
        progressDialog.show();
    }

    /**
     * 关闭加载框
     */
    protected void closeLoading() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

}
