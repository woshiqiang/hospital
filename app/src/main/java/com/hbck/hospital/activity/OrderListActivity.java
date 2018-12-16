package com.hbck.hospital.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hbck.apt.ApiFactory;
import com.hbck.hospital.R;
import com.hbck.hospital.adapter.OrderAdapter;
import com.hbck.hospital.bean.OrderDetail;
import com.hbck.hospital.util.DialogUtil;
import com.hbck.hospital.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderListActivity extends AppCompatActivity {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.listView)
    ListView listView;

    OrderAdapter adapter;
    List<OrderDetail> list = new ArrayList<>();

    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        ButterKnife.bind(this);


        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//左侧添加一个默认的返回图标

        title.setText("最近预约");
        toolbar.setNavigationOnClickListener(v -> finish());
        toolbar.setNavigationIcon(R.mipmap.ic_back);

        initData();
        getData();
    }

    @SuppressLint("CheckResult")
    private void getData() {
        dialog = DialogUtil.createLoadingDialog(this, "查询中...");
        ApiFactory.selectOrders(SpUtil.getUser().getId())
                .subscribe(baseBean -> {
                            dialog.dismiss();
                            if (baseBean.code == 1) {
                                list.clear();
                                list.addAll(baseBean.data.orders);
                                adapter.notifyDataSetChanged();
                            } else {
                                Toast.makeText(this, baseBean.message, Toast.LENGTH_SHORT).show();
                            }
                        }, e -> {
                            dialog.dismiss();
                            e.printStackTrace();
                            Toast.makeText(this, "网络异常", Toast.LENGTH_SHORT).show();
                        }
                );

    }

    private void initData() {
        adapter = new OrderAdapter(this, list);
        listView.setAdapter(adapter);
    }
}
