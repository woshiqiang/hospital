package com.hbck.hospital.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.hbck.apt.ApiFactory;
import com.hbck.hospital.R;
import com.hbck.hospital.adapter.CellAdapter;
import com.hbck.hospital.bean.Cell;
import com.hbck.hospital.bean.Hospital;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectCellActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.toolbar_right)
    TextView toolbarRight;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.gridView)
    GridView gridView;

    private Hospital data;
    private List<Cell> list = new ArrayList<>();
    private CellAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_cell);
        ButterKnife.bind(this);
        data = (Hospital) getIntent().getSerializableExtra("data");

        init();
        getData();

    }

    private void init() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//左侧添加一个默认的返回图标

        title.setText("选择科室");
        toolbar.setNavigationOnClickListener(v -> finish());
        toolbar.setNavigationIcon(R.mipmap.ic_back);

        gridView.setOnItemClickListener(this);
    }

    @SuppressLint("CheckResult")
    private void getData() {
        ApiFactory.getCells(data.getId())
                .subscribe(baseBean -> {
                            list = baseBean.data.cells;
                            adapter = new CellAdapter(SelectCellActivity.this, list);
                            gridView.setAdapter(adapter);
                        }, e -> {
                            Toast.makeText(this, "网络异常", Toast.LENGTH_SHORT).show();
                        }
                );

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, SelectDoctorActivity.class);
        intent.putExtra("hosId", data.getId());
        intent.putExtra("cellId", list.get(position).getId());
        startActivity(intent);
    }
}
