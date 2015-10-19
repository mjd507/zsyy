package com.rainwii.zsyy.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.RegisterInfoActivity;
import com.rainwii.zsyy.bean.ExpertScheduleInfo;
import com.rainwii.zsyy.constants.Constants;
import com.rainwii.zsyy.view.MyRegisterDialog;

import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * 描述：专家号预约 专家列表的适配器
 * 作者 mjd
 * 日期：2015/10/16 22:34
 */
public class RegisterDoctorScheduleAdapter extends BaseAdapter implements StickyListHeadersAdapter {
    private Context context;
    private List<ExpertScheduleInfo> expertInfoList;

    public RegisterDoctorScheduleAdapter(Context context, List<ExpertScheduleInfo> expertInfoList) {
        this.context = context;
        this.expertInfoList = expertInfoList;
    }

    @Override
    public int getCount() {
        return expertInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return expertInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder holder;
        if (convertView == null) {
            view = View.inflate(context, R.layout.item_register_doctor_schedule, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        ExpertScheduleInfo info = expertInfoList.get(position);
        holder.tvName.setText(info.getName());
        holder.tvRank.setText(info.getRank());
        if (info.isAm() && !info.isPm()) {
            holder.tvAmFlag.setText("上午");
            holder.tvAmFee.setText(info.getFee());
            holder.tvAmCount.setText(info.getCount());
            holder.layout1.setVisibility(View.VISIBLE);
            holder.layout2.setVisibility(View.GONE);
            holder.layout1.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.shape_content_bottom_selector));
        } else if (info.isPm() && !info.isAm()) {
            holder.tvPmFlag.setText("下午");
            holder.tvPmFee.setText(info.getFee());
            holder.tvPmCount.setText(info.getCount());
            holder.layout1.setVisibility(View.GONE);
            holder.layout2.setVisibility(View.VISIBLE);
            holder.layout2.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.shape_content_bottom_selector));
        } else if (info.isAm() && info.isPm()) {
            holder.layout1.setVisibility(View.VISIBLE);
            holder.layout2.setVisibility(View.VISIBLE);
            holder.tvAmFlag.setText("上午");
            holder.tvAmFee.setText(info.getFee());
            holder.tvAmCount.setText(info.getCount());
            holder.tvPmFlag.setText("下午");
            holder.tvPmFee.setText(info.getFee());
            holder.tvPmCount.setText(info.getCount());
        }
        holder.tvMoreInfo.setOnClickListener(new MyListener(position));
        holder.layout1.setOnClickListener(new MyListener(position));
        holder.layout2.setOnClickListener(new MyListener(position));
        return view;
    }

    private static class ViewHolder {
        TextView tvName;
        TextView tvRank;
        TextView tvMoreInfo;
        TextView tvAmFlag;
        TextView tvAmFee;
        TextView tvAmCount;
        TextView tvPmFlag;
        TextView tvPmFee;
        TextView tvPmCount;
        LinearLayout layout1;
        LinearLayout layout2;

        public ViewHolder(View view) {
            layout1 = (LinearLayout) view.findViewById(R.id.ll_layout_1);
            layout2 = (LinearLayout) view.findViewById(R.id.ll_layout_2);
            tvName = (TextView) view.findViewById(R.id.tv_name);
            tvRank = (TextView) view.findViewById(R.id.tv_rank);
            tvMoreInfo = (TextView) view.findViewById(R.id.tv_more_info);
            tvAmFlag = (TextView) view.findViewById(R.id.tv_am_flag);
            tvAmFee = (TextView) view.findViewById(R.id.tv_am_fee);
            tvAmCount = (TextView) view.findViewById(R.id.tv_am_count);
            tvPmFlag = (TextView) view.findViewById(R.id.tv_pm_flag);
            tvPmFee = (TextView) view.findViewById(R.id.tv_pm_fee);
            tvPmCount = (TextView) view.findViewById(R.id.tv_pm_count);
        }
    }

    private class MyListener implements View.OnClickListener {
        int position;

        public MyListener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            ExpertScheduleInfo info = expertInfoList.get(position);
            switch (v.getId()) {
                case R.id.tv_more_info:
                    MyRegisterDialog dialog = new MyRegisterDialog(context, info.getName(), info.getIntroduction(), "确定");
                    dialog.show();
                    break;
                case R.id.ll_layout_1:
                    enterRegisterInfoActivity(info, true);
                    break;
                case R.id.ll_layout_2:
                    enterRegisterInfoActivity(info, false);
                    break;
            }
        }
    }

    private void enterRegisterInfoActivity(ExpertScheduleInfo info, boolean isAm) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.REGISTER_TYPE, Constants.REGISTER_TYPE_EXPERT);
        bundle.putSerializable(Constants.REGISTER_EXPERT_SCHEDULE, info);
        bundle.putBoolean("isAm", isAm);
        Intent intent = new Intent(context, RegisterInfoActivity.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }


    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        View view;
        HeaderViewHolder holder;
        if (convertView == null) {
            view = View.inflate(context, R.layout.item_register_doctor_schedule_sticky_header, null);
            holder = new HeaderViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (HeaderViewHolder) view.getTag();
        }
        holder.tvHeaderTitle.setText(expertInfoList.get(position).getDate());
        return view;
    }

    private class HeaderViewHolder {
        TextView tvHeaderTitle;

        public HeaderViewHolder(View view) {
            tvHeaderTitle = (TextView) view.findViewById(R.id.tv_title);
        }
    }

    @Override
    public long getHeaderId(int position) {
        return expertInfoList.get(position).getDateId();
    }


}
