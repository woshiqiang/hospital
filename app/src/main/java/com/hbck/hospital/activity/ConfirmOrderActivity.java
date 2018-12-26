package com.hbck.hospital.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hbck.apt.ApiFactory;
import com.hbck.hospital.R;
import com.hbck.hospital.bean.Doctor;
import com.hbck.hospital.bean.Order;
import com.hbck.hospital.bean.OrderDetail;
import com.hbck.hospital.bean.TimeLine;
import com.hbck.hospital.util.SpUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 确认订单
 */
public class ConfirmOrderActivity extends AppCompatActivity {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_phone)
    TextView tvPhone;

    Doctor doctor;
    TimeLine timeLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//左侧添加一个默认的返回图标

        title.setText("确认订单");
        toolbar.setNavigationOnClickListener(v -> finish());
        toolbar.setNavigationIcon(R.mipmap.ic_back);

        doctor = (Doctor) getIntent().getSerializableExtra("doctor");
        timeLine = (TimeLine) getIntent().getSerializableExtra("timeLine");
        tvDate.setText("就诊时间：" + timeLine.getDate() + " , " + timeLine.getStarttime() + " - " + timeLine.getEndtime());
        tvMoney.setText("就诊费：" + doctor.getMoney());

        tvPhone.setText("电话：" + SpUtil.getUser().getPhone());
    }

    @OnClick({R.id.btn_submit, R.id.btn_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_submit:
                try {
                    submit();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_cancel:
                finish();
                break;
        }
    }

    @SuppressLint("CheckResult")
    private void submit() throws ParseException {
        Order order = new Order();
        order.setUserId(SpUtil.getUser().getId());
        order.setDocId(doctor.getId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String code = sdf.format(new Date());
        order.setOrderCode(code);
        order.setMoney(doctor.getMoney());
        order.setYydate(timeLine.getDate());
        order.setStarttime(timeLine.getStarttime());
        order.setEndtime(timeLine.getEndtime());
        order.setPayState(0);
        order.setDepId(doctor.getDep_id());

        ApiFactory.saveOrder(order,timeLine.getId())
                .subscribe(baseBean -> {
                            if (baseBean.code == 1) {
                                OrderDetail orderDetail = baseBean.data.orderDetail;
                                Intent intent = new Intent(ConfirmOrderActivity.this, OrderDetailActivity.class);
                                intent.putExtra("orderDetail", orderDetail);
                                Toast.makeText(this, "预约成功", Toast.LENGTH_SHORT).show();
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(this, baseBean.message, Toast.LENGTH_SHORT).show();
                            }
                        }, e -> {
                            Toast.makeText(this, "网络异常", Toast.LENGTH_SHORT).show();
                        }
                );


    }
}
