package com.hbck.hospital.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hbck.hospital.R;
import com.hbck.hospital.api.C;
import com.hbck.hospital.bean.Hospital;
import com.hbck.hospital.util.ImageLoaderUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.toolbar_right)
    TextView toolbar_right;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.iv_hospital)
    ImageView ivHospital;
    @BindView(R.id.tv_hospital)
    TextView tvHospital;
    @BindView(R.id.tv_main_depart)
    TextView tvMainDepart;
    @BindView(R.id.tv_grade)
    TextView tvGrade;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_route)
    TextView tvRoute;
    @BindView(R.id.tv_desc)
    TextView tvDesc;

    private Hospital data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        toolbar_right.setText("预约");
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//左侧添加一个默认的返回图标

        title.setText("医院详情");
        toolbar.setNavigationOnClickListener(v -> finish());
        toolbar.setNavigationIcon(R.mipmap.ic_back);
        data = (Hospital) getIntent().getSerializableExtra("data");

        tvHospital.setText(data.getName());
        tvMainDepart.setText(data.getCell());
        tvGrade.setText(data.getLevel());
        tvPhone.setText(data.getTel());
        tvAddress.setText(data.getAddress());
        tvRoute.setText(data.getRout());
        tvDesc.setText(data.getDescription());

        ImageLoaderUtil.display(this, C.IMG_URL + data.getImage(), ivHospital);
    }


    @OnClick({R.id.toolbar_right, R.id.tv_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar_right:
                Intent intent = new Intent(this, SelectCellActivity.class);
                intent.putExtra("data", data);
                startActivity(intent);
                break;
            case R.id.tv_address://导航
                daoHang();
                break;
        }

    }

    private void daoHang() {
        try {
            Intent intent = Intent.getIntent("androidamap://navi?sourceApplication=慧医&poiname=" + data.getAddress() + "&lat=" + data.getLatitude() + "&lon=" + data.getLongitude() + "&dev=0");
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "您尚未安装高德地图", Toast.LENGTH_LONG).show();
            Uri uri = Uri.parse("market://details?id=com.autonavi.minimap");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    }
}
