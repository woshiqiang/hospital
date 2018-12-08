package com.hbck.hospital.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hbck.hospital.R;
import com.hbck.hospital.bean.Cell;
import com.hbck.hospital.util.ImageLoaderUtil;

import java.util.List;

public class CellAdapter extends BaseAdapter {
    private Context mContext;
    private List<Cell> list;

    public CellAdapter(Context mContext, List<Cell> list) {
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
            view = View.inflate(mContext, R.layout.item_cell, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.tv_cell.setText(list.get(i).getName());
        ImageLoaderUtil.display(mContext, list.get(i).getIcon(), holder.iv_cell);
        return view;
    }

    public static class ViewHolder {
        public TextView tv_cell;
        public ImageView iv_cell;

        public ViewHolder(View view) {
            this.tv_cell = view.findViewById(R.id.tv_cell);
            this.iv_cell = view.findViewById(R.id.iv_cell);
        }
    }
}