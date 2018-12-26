package com.hbck.hospital.fragment;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.hbck.apt.ApiFactory;
import com.hbck.hospital.R;
import com.hbck.hospital.activity.ConfirmOrderActivity;
import com.hbck.hospital.adapter.TimeLineAdapter;
import com.hbck.hospital.bean.Doctor;
import com.hbck.hospital.bean.TimeLine;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class YuyueFragment extends Fragment {
    private static final String ARG_PARAM1 = "doctor";
    @BindView(R.id.lv_timelines)
    ListView lv_timelines;
    Unbinder unbinder;
    private Doctor doctor;
    private List<TimeLine> list;
    private TimeLineAdapter adapter;


    public static YuyueFragment newInstance(Doctor doctor) {
        YuyueFragment fragment = new YuyueFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, doctor);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            doctor = (Doctor) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_yuyue, container, false);
        unbinder = ButterKnife.bind(this, view);
        getData();
        initData();
        return view;
    }

    private void initData() {
        lv_timelines.setOnItemClickListener((adapterView, view, i, l) -> {
            TimeLine timeLine = list.get(i);
            if (timeLine.getStatus() != 1) {
                Toast.makeText(getContext(), "已满，不能预约", Toast.LENGTH_SHORT).show();
                return;
            }
            String date = timeLine.getDate();
            String time = timeLine.getStarttime() + " - " + timeLine.getEndtime();
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setMessage("您选择了" + date + "   " + time)
                    .setPositiveButton("确定", (dialogInterface, i12) -> {
                        dialogInterface.dismiss();
                        Intent intent = new Intent(getContext(), ConfirmOrderActivity.class);
                        intent.putExtra("doctor", doctor);
                        intent.putExtra("timeLine", timeLine);
                        startActivity(intent);
                        getActivity().finish();
                    })
                    .setNegativeButton("取消", (dialogInterface, i1) -> dialogInterface.dismiss())
                    .create().show();
        });
    }

    @SuppressLint("CheckResult")
    private void getData() {
        ApiFactory.selectTimeLinesByDocId(doctor.getId())
                .subscribe(baseBean -> {
                            list = baseBean.data.timeLines;
                            adapter = new TimeLineAdapter(getContext(), list);
                            lv_timelines.setAdapter(adapter);
                        }, e -> {
                            Toast.makeText(getContext(), "网络异常", Toast.LENGTH_SHORT).show();
                        }
                );

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
