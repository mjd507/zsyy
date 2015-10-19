package com.rainwii.zsyy.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.List;

/**
 * 描述：主页面大图轮播的适配器
 * 作者 mjd
 * 日期：2015/10/11 16:53
 */
public class HomeShuffleAdapter extends PagerAdapter{
    private Context context;
    private List<ImageView> imagesList;
    public HomeShuffleAdapter(Context context, List<ImageView> imageViewList) {
        this.context = context;
        this.imagesList = imageViewList;
    }

    @Override
    public int getCount() {
        return imagesList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = imagesList.get(position);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);// 基于控件大小填充图片
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
