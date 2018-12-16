package com.hbck.hospital.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.hbck.hospital.R;
import com.hbck.hospital.bean.OrderDetail;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderDetailActivity extends AppCompatActivity {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_doctor)
    TextView tvDoctor;
    @BindView(R.id.tv_department)
    TextView tvDepartment;
    @BindView(R.id.tv_yydate)
    TextView tvYydate;
    @BindView(R.id.tv_code)
    TextView tvCode;

    OrderDetail orderDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//左侧添加一个默认的返回图标

        title.setText("订单详情");
        toolbar.setNavigationOnClickListener(v -> finish());
        toolbar.setNavigationIcon(R.mipmap.ic_back);

        orderDetail = (OrderDetail) getIntent().getSerializableExtra("orderDetail");
        tvCode.setText(orderDetail.orderCode);
        tvDepartment.setText(orderDetail.depName);
        tvDoctor.setText(orderDetail.docName);
        tvYydate.setText(orderDetail.yydate + " " + orderDetail.starttime + "-" + orderDetail.endtime);
    }
}
