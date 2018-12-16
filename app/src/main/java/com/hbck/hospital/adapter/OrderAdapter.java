package com.hbck.hospital.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hbck.hospital.R;
import com.hbck.hospital.api.C;
import com.hbck.hospital.bean.OrderDetail;
import com.hbck.hospital.util.ImageLoaderUtil;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author JianQiang Ding
 * @Date 2018-12-16.
 */
public class OrderAdapter extends BaseAdapter {
    private Context mContext;
    private List<OrderDetail> list;

    public OrderAdapter(Context mContext, List<OrderDetail> list) {
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
        ViewHolder holder;
        if (view == null) {
            view = View.inflate(mContext, R.layout.item_order, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        OrderDetail detail = list.get(i);
        ImageLoaderUtil.display(mContext, C.IMG_URL + detail.docImage, holder.ivDocImage);
        holder.tvDocName.setText(detail.docName);
        holder.tvOrderCode.setText(detail.orderCode);

        holder.tvDepartment.setText("科室：" + detail.depName);
        holder.tvDate.setText("日期：" + detail.yydate);
        holder.tvTime.setText("时间：" + detail.starttime + "-" + detail.endtime);

        holder.tvPhone.setText("电话：" + detail.docPhone);
        holder.tvTitle.setText("医生职称：" + detail.docTitle);
        holder.tvFee.setText("诊查费：" + detail.money + "元");

        return view;
    }

    static class ViewHolder {
        @BindView(R.id.iv_doc_image)
        RoundedImageView ivDocImage;
        @BindView(R.id.tv_doc_name)
        TextView tvDocName;
        @BindView(R.id.tv_order_code)
        TextView tvOrderCode;
        @BindView(R.id.tv_department)
        TextView tvDepartment;
        @BindView(R.id.tv_date)
        TextView tvDate;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_phone)
        TextView tvPhone;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_fee)
        TextView tvFee;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
