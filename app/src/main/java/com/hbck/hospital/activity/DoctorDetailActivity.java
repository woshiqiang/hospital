package com.hbck.hospital.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.hbck.hospital.R;
import com.hbck.hospital.adapter.TabAdapter;
import com.hbck.hospital.api.C;
import com.hbck.hospital.bean.Doctor;
import com.hbck.hospital.fragment.JianJieFragment;
import com.hbck.hospital.fragment.YuyueFragment;
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
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    private Doctor doctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);
        ButterKnife.bind(this);

        initData();
        initTabLayout();
    }

    private void initTabLayout() {
        String[] titles = {"简介", "预约"};
        tabLayout.setupWithViewPager(viewPager);
        Fragment[] fragments = {JianJieFragment.newInstance(doctor.getDescription()), YuyueFragment.newInstance(doctor)};
        viewPager.setAdapter(new TabAdapter(getSupportFragmentManager(), titles, fragments));
    }

    private void initData() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//左侧添加一个默认的返回图标

        title.setText("医生详情");
        toolbar.setNavigationOnClickListener(v -> finish());
        toolbar.setNavigationIcon(R.mipmap.ic_back);


        doctor = (Doctor) getIntent().getSerializableExtra("doctor");
        ImageLoaderUtil.display(this, C.IMG_URL +doctor.getImage(), rivHead);
        tvName.setText(doctor.getName());
        tvTitle.setText(doctor.getTitle());
        tvSex.setText("性别：" + doctor.getSex());
        tvMoney.setText("诊断费：" + doctor.getMoney());
    }

}
