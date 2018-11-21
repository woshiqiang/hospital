package com.hbck.hospital.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hbck.hospital.R;
import com.hbck.hospital.util.Constants;
import com.hbck.hospital.util.SpUtil;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @time 2018-11-14 16:26
 * @类描述：我的
 * @变更记录:
 */
public class MeFragment extends Fragment {


    @BindView(R.id.riv_head)
    RoundedImageView rivHead;
    @BindView(R.id.tv_nick)
    TextView tvNick;
    @BindView(R.id.tv_introduction)
    TextView tvIntroduction;
    @BindView(R.id.ll_my_info)
    LinearLayout llMyInfo;
    @BindView(R.id.ll_my_product)
    LinearLayout llMyProduct;
    @BindView(R.id.ll_logout)
    LinearLayout llLogout;
    Unbinder unbinder;

    public MeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        tvNick.setText(SpUtil.getString(Constants.USERNAME));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
