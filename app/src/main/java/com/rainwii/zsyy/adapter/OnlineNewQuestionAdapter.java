package com.rainwii.zsyy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.bean.OnlineNewQuestion;

import java.util.List;

/**
 * 描述：最新解答的适配器
 * 作者 mjd
 * 日期：2015/10/28 12:49
 */
public class OnlineNewQuestionAdapter extends BaseAdapter {
    private Context context;
    private List<OnlineNewQuestion> newQuestionList;

    public OnlineNewQuestionAdapter(Context context, List<OnlineNewQuestion> newQuestionList) {
        this.context = context;
        this.newQuestionList = newQuestionList;
    }

    @Override
    public int getCount() {
        return newQuestionList.size();
    }

    @Override
    public Object getItem(int position) {
        return newQuestionList.get(position);
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
            view = View.inflate(context, R.layout.item_online_new_question, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        OnlineNewQuestion newQuestion = newQuestionList.get(position);
        holder.question.setText(newQuestion.getQuestion());
        holder.photo.setImageResource(R.drawable.ic_online_doctor_photo);
        holder.name.setText(newQuestion.getName());
        holder.position.setText(newQuestion.getPosition());
        holder.createtime.setText(newQuestion.getCreateTime());
        holder.department.setText(newQuestion.getDepartment());
        holder.reply.setText(newQuestion.getReply());
        return view;
    }

    public class ViewHolder {
        public final TextView question;
        public final ImageView photo;
        public final TextView name;
        public final TextView position;
        public final TextView createtime;
        public final TextView department;
        public final TextView reply;
        public final View root;

        public ViewHolder(View root) {
            question = (TextView) root.findViewById(R.id.tv_question);
            photo = (ImageView) root.findViewById(R.id.tv_photo);
            name = (TextView) root.findViewById(R.id.tv_name);
            position = (TextView) root.findViewById(R.id.tv_position);
            createtime = (TextView) root.findViewById(R.id.tv_create_time);
            department = (TextView) root.findViewById(R.id.tv_department);
            reply = (TextView) root.findViewById(R.id.tv_reply);
            this.root = root;
        }
    }
}
