package com.hbck.hospital.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hbck.hospital.R;
import com.hbck.hospital.bean.TimeLine;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author JianQiang Ding
 * @Date 2018-12-14.
 */
public class TimeLineAdapter extends BaseAdapter {
    private Context mContext;
    private List<TimeLine> list;

    public TimeLineAdapter(Context context, List<TimeLine> list) {
        this.mContext = context;
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
        ViewHolder holder;
        if (view == null) {
            view = View.inflate(mContext, R.layout.item_timeline, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tvDate.setText(list.get(i).getDate());
        holder.tvTime.setText(list.get(i).getStarttime() + " - " + list.get(i).getEndtime());
        Integer status = list.get(i).getStatus();
        String state = status == 1 ? "可预约" : "已满";
        holder.tvState.setText(state);
        if (status == 1) {
            holder.tvState.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
        } else {
            holder.tvState.setTextColor(mContext.getResources().getColor(R.color.red));
        }
        return view;
    }

    static class ViewHolder {
        @BindView(R.id.tv_date)
        TextView tvDate;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_state)
        TextView tvState;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
