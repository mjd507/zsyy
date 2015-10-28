package com.rainwii.zsyy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.bean.OnlineHotDoctorDetailQuestion;

import java.util.List;

/**
 * 描述：
 * 作者 mjd
 * 日期：2015/10/28 16:25
 */
public class OnlineHotDoctorDetailAdapter extends BaseAdapter {

    private Context context;
    private List<OnlineHotDoctorDetailQuestion> list;

    public OnlineHotDoctorDetailAdapter(Context context, List<OnlineHotDoctorDetailQuestion> list) {
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
            view = View.inflate(context, R.layout.item_online_hot_doctor_detail, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        OnlineHotDoctorDetailQuestion detail = list.get(position);
        holder.score.setRating(Integer.parseInt(detail.getScore()));
        holder.name.setText(detail.getName());
        holder.date.setText(detail.getDate());
        holder.question.setText(detail.getQuestion());
        holder.content.setText(detail.getContent());

        return view;
    }

    public class ViewHolder {
        public final RatingBar score;
        public final TextView name;
        public final TextView date;
        public final TextView question;
        public final TextView content;
        public final View root;

        public ViewHolder(View root) {
            name = (TextView) root.findViewById(R.id.tv_name);
            score = (RatingBar) root.findViewById(R.id.rb_score);
            date = (TextView) root.findViewById(R.id.tv_date);
            question = (TextView) root.findViewById(R.id.tv_question);
            content = (TextView) root.findViewById(R.id.tv_content);
            this.root = root;
        }
    }
}
