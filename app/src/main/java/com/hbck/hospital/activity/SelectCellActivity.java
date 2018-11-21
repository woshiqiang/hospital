package com.hbck.hospital.activity;

import android.annotation.SuppressLint;
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
import com.hbck.hospital.adapter.CellAdapter1;
import com.hbck.hospital.bean.Department;
import com.hbck.hospital.bean.Hospital;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectCellActivity extends AppCompatActivity {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.toolbar_right)
    TextView toolbarRight;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.lv_2)
    ListView lv2;
    @BindView(R.id.lv_1)
    ListView lv1;
    private Hospital data;
    private List<Department> list1 = new ArrayList<>();
    private List<Department> list2 = new ArrayList<>();
    private CellAdapter1 adapter1, adapter2;

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


        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapter1.setCurrentIndex(i);
                getData2(list1.get(i).getId());
            }
        });

        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapter2.setCurrentIndex(i);
                Toast.makeText(SelectCellActivity.this, list2.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @SuppressLint("CheckResult")
    private void getData() {
        ApiFactory.getDepartments(data.getId(), 0L)
                .subscribe(baseBean -> {
                            list1 = baseBean.data.departs;
                            adapter1 = new CellAdapter1(SelectCellActivity.this, list1);
                            lv1.setAdapter(adapter1);
                            if (list1 != null && list1.size() > 0) {
                                getData2(list1.get(0).getId());
                            }
                        }, e -> {
                            Toast.makeText(this, "网络异常", Toast.LENGTH_SHORT).show();
                        }
                );

    }


    @SuppressLint("CheckResult")
    private void getData2(Long pid) {
        ApiFactory.getDepartments(data.getId(), pid)
                .subscribe(baseBean -> {
                            list2 = baseBean.data.departs;
                            adapter2 = new CellAdapter1(SelectCellActivity.this, list2);
                            lv2.setAdapter(adapter2);
                        }, e -> {
                            Toast.makeText(this, "网络异常", Toast.LENGTH_SHORT).show();
                        }
                );

    }


}
