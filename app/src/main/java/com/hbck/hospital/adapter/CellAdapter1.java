package com.hbck.hospital.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hbck.hospital.R;
import com.hbck.hospital.bean.Department;

import java.util.List;

public class CellAdapter1 extends BaseAdapter {
    private Context mContext;
    private List<Department> list;
    private int currentIndex;

    public CellAdapter1(Context mContext, List<Department> list) {
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

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = View.inflate(mContext, R.layout.item_cell, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        if (currentIndex == i) {
            holder.tv_cell.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
        } else {
            holder.tv_cell.setTextColor(mContext.getResources().getColor(R.color.textBlack));
        }
        holder.tv_cell.setText(list.get(i).getName());
        return view;
    }

    public static class ViewHolder {
        public TextView tv_cell;

        public ViewHolder(View view) {
            this.tv_cell = view.findViewById(R.id.tv_cell);
        }
    }
}