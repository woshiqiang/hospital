package com.hbck.hospital.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hbck.apt.ApiFactory;
import com.hbck.hospital.R;
import com.hbck.hospital.adapter.DoctorAdapter;
import com.hbck.hospital.bean.Doctor;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectDoctorActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.toolbar_right)
    TextView toolbarRight;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.listView)
    ListView listView;

    private Long hosId, cellId;
    private List<Doctor> list;
    private DoctorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_doctor);
        ButterKnife.bind(this);
        init();
        getData();
    }

    private void init() {
        hosId = getIntent().getLongExtra("hosId", 0);
        cellId = getIntent().getLongExtra("cellId", 0);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//左侧添加一个默认的返回图标

        title.setText("选择医生");
        toolbar.setNavigationOnClickListener(v -> finish());
        toolbar.setNavigationIcon(R.mipmap.ic_back);

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this,DoctorDetailActivity.class);
        intent.putExtra("doctor",list.get(position));
        startActivity(intent);

    }


    @SuppressLint("CheckResult")
    private void getData() {
        ApiFactory.getDoctorsByCellID(cellId)
                .subscribe(baseBean -> {
                            list = baseBean.data.doctors;
                            adapter = new DoctorAdapter(SelectDoctorActivity.this, list);
                            listView.setAdapter(adapter);
                        }, e -> {
                            Toast.makeText(this, "网络异常", Toast.LENGTH_SHORT).show();
                        }
                );

    }
}
