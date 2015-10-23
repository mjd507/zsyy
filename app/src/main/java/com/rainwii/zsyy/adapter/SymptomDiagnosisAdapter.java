package com.rainwii.zsyy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.rainwii.zsyy.R;

import java.util.List;

/**
 * 描述：症状诊断的适配器
 * 作者 mjd
 * 日期：2015/10/23 8:57
 */
public class SymptomDiagnosisAdapter extends BaseAdapter {

    private Context context;
    private List<String> list;

    public SymptomDiagnosisAdapter(Context context, List<String> list) {
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
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_symptom_diagnosis, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvItem.setText(list.get(position));
        final View finalConvertView = convertView;
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalConvertView.setVisibility(View.GONE);
            }
        });
        return convertView;
    }

    public static class ViewHolder {
        public final TextView tvItem;
        public final Button btnDelete;
        public final View root;

        public ViewHolder(View root) {
            tvItem = (TextView) root.findViewById(R.id.tv_item);
            btnDelete = (Button) root.findViewById(R.id.btn_delete);
            this.root = root;
        }
    }
}
