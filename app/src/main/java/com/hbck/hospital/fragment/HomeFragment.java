package com.hbck.hospital.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.hbck.apt.ApiFactory;
import com.hbck.hospital.R;
import com.hbck.hospital.activity.DetailActivity;
import com.hbck.hospital.adapter.HospitalAdapter;
import com.hbck.hospital.bean.Hospital;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeFragment extends Fragment implements AdapterView.OnItemClickListener {
    List<Hospital> list = new ArrayList<>();

    @BindView(R.id.listView)
    ListView listView;
    Unbinder unbinder;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    @SuppressLint("CheckResult")
    private void initData() {

        listView.setOnItemClickListener(this);

        ApiFactory.getHospitals()
                .subscribe(baseBean -> {
                            if (baseBean.code == 1) {
                                list = baseBean.data.hospitals;
                                listView.setAdapter(new HospitalAdapter(getContext(), list));
                            } else {
                                Toast.makeText(getContext(), baseBean.message, Toast.LENGTH_SHORT).show();
                            }
                        }, e -> {
                            e.printStackTrace();
                            Toast.makeText(getContext(), "网络异常", Toast.LENGTH_SHORT).show();
                        }
                );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getContext(),DetailActivity.class);
        intent.putExtra("data",list.get(i));
        startActivity(intent);
    }
}
