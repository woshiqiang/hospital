package com.hbck.hospital.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hbck.hospital.R;
import com.hbck.hospital.bean.Doctor;
import com.hbck.hospital.util.ImageLoaderUtil;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DoctorAdapter extends BaseAdapter {
    private Context mContext;
    private List<Doctor> list;

    public DoctorAdapter(Context mContext, List<Doctor> list) {
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
            view = View.inflate(mContext, R.layout.item_doctor, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.tvName.setText(list.get(i).getName());
        ImageLoaderUtil.display(mContext, list.get(i).getImage(), holder.rivHead);

        return view;
    }

    static class ViewHolder {
        @BindView(R.id.riv_head)
        RoundedImageView rivHead;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_sex)
        TextView tvSex;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}