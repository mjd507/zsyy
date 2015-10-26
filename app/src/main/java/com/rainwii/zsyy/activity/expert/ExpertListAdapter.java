package com.rainwii.zsyy.activity.expert;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.bean.ExpertListIInfo;

import java.util.List;

/**
 * 描述：
 * 作者 mjd
 * 日期：2015/10/26 9:34
 */
public class ExpertListAdapter extends BaseAdapter {
    private Context context;
    private List<ExpertListIInfo> list;

    public ExpertListAdapter(Context context, List<ExpertListIInfo> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
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
            view = View.inflate(context, R.layout.item_expert_list, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        ExpertListIInfo info = list.get(position);
        holder.ivphoto.setImageResource(R.drawable.ic_doctor_logo);
        holder.tvname.setText(info.getName());
        holder.tvposition.setText(info.getPosition());
        holder.tvskill.setText(info.getSkill());
        return view;
    }

    public static class ViewHolder {
        public final ImageView ivphoto;
        public final TextView tvname;
        public final TextView tvposition;
        public final TextView tvskill;
        public final View root;

        public ViewHolder(View root) {
            ivphoto = (ImageView) root.findViewById(R.id.iv_photo);
            tvname = (TextView) root.findViewById(R.id.tv_name);
            tvposition = (TextView) root.findViewById(R.id.tv_position);
            tvskill = (TextView) root.findViewById(R.id.tv_skill);
            this.root = root;
        }
    }
}
