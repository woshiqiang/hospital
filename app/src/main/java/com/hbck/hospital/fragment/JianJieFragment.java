package com.hbck.hospital.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hbck.hospital.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class JianJieFragment extends Fragment {
    private static final String ARG_PARAM1 = "description";
    private String description;

    @BindView(R.id.tv_jianjie)
    TextView tvJianjie;
    Unbinder unbinder;

    public static JianJieFragment newInstance(String description) {
        JianJieFragment fragment = new JianJieFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, description);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            description = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jian_jie, container, false);
        unbinder = ButterKnife.bind(this, view);

        tvJianjie.setText(description);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
