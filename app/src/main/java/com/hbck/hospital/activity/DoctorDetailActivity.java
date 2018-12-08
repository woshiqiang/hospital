package com.hbck.hospital.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.hbck.hospital.R;
import com.hbck.hospital.bean.Doctor;
import com.hbck.hospital.util.ImageLoaderUtil;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DoctorDetailActivity extends AppCompatActivity {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.toolbar_right)
    TextView toolbarRight;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.riv_head)
    RoundedImageView rivHead;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_desc)
    TextView tvDesc;

    private Doctor doctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//左侧添加一个默认的返回图标

        title.setText("医生详情");
        toolbar.setNavigationOnClickListener(v -> finish());
        toolbar.setNavigationIcon(R.mipmap.ic_back);


        doctor = (Doctor) getIntent().getSerializableExtra("doctor");
        ImageLoaderUtil.display(this, doctor.getImage(), rivHead);
        tvName.setText(doctor.getName());
        tvTitle.setText(doctor.getTitle());
        tvSex.setText("性别：" + doctor.getSex());
        tvMoney.setText("诊断费：" + doctor.getMoney());
        tvDesc.setText(doctor.getDescription());
    }

    public void yy(View view) {

    }
}
