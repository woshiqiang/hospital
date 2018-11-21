package com.hbck.hospital.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hbck.hospital.R;
import com.hbck.hospital.bean.Hospital;

import java.util.List;

/**
 * @Date 2018-11-15.
 */
public class HospitalAdapter extends BaseAdapter {
    private Context mContext;
    private List<Hospital> list;

    public HospitalAdapter(Context mContext, List<Hospital> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = View.inflate(mContext, R.layout.item_hospital, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_name.setText(list.get(i).getName());
        holder.tv_desc.setText(list.get(i).getDescription());
        return view;
    }

    public static class ViewHolder {
        public ImageView imageView;
        public TextView tv_name;
        public TextView tv_desc;

        public ViewHolder(View view) {
            this.imageView = view.findViewById(R.id.imageView);
            this.tv_name = view.findViewById(R.id.tv_name);
            this.tv_desc = view.findViewById(R.id.tv_desc);
        }
    }
}
