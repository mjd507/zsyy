package com.rainwii.zsyy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.bean.OnlineHotDoctor;

import java.util.List;

/**
 * 描述：热门医生的适配器
 * 作者 mjd
 * 日期：2015/10/28 12:49
 */
public class OnlineHotDoctorAdapter extends BaseAdapter {
    private Context context;
    private List<OnlineHotDoctor> hotDoctorList;

    public OnlineHotDoctorAdapter(Context context, List<OnlineHotDoctor> hotDoctorList) {
        this.context = context;
        this.hotDoctorList = hotDoctorList;
    }

    @Override
    public int getCount() {
        return hotDoctorList.size();
    }

    @Override
    public Object getItem(int position) {
        return hotDoctorList.get(position);
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
            view = View.inflate(context, R.layout.item_online_hot_doctor, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        OnlineHotDoctor hotDoctor = hotDoctorList.get(position);
        holder.photo.setImageResource(R.drawable.ic_online_doctor_photo);
        holder.name.setText(hotDoctor.getName());
        holder.position.setText(hotDoctor.getPosition());
        holder.department.setText(hotDoctor.getDepartment());
        holder.introduction.setText(hotDoctor.getIntroduction());
        return view;
    }

    public class ViewHolder {
        public final ImageView photo;
        public final TextView name;
        public final TextView position;
        public final TextView department;
        public final TextView introduction;
        public final RatingBar score;
        public final View root;

        public ViewHolder(View root) {
            photo = (ImageView) root.findViewById(R.id.tv_photo);
            name = (TextView) root.findViewById(R.id.tv_name);
            position = (TextView) root.findViewById(R.id.tv_position);
            department = (TextView) root.findViewById(R.id.tv_department);
            introduction = (TextView) root.findViewById(R.id.tv_introduction);
            score = (RatingBar) root.findViewById(R.id.rb_score);
            this.root = root;
        }
    }

}
