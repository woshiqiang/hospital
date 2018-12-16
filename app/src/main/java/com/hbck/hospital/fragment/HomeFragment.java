package com.hbck.hospital.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.hbck.apt.ApiFactory;
import com.hbck.hospital.R;
import com.hbck.hospital.activity.DetailActivity;
import com.hbck.hospital.adapter.HospitalAdapter;
import com.hbck.hospital.api.C;
import com.hbck.hospital.bean.Hospital;
import com.hbck.hospital.util.ImageLoaderUtil;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

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


    @BindView(R.id.roll_view_pager)
    RollPagerView mRollViewPager;

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

    private void initBanner() {
        List<String> list = new ArrayList<>();
        list.add(C.IMG_URL + this.list.get(0).getImage());
//        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544258152800&di=262a032d17d28c50ccd494d94a9f6ef9&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F010a02571dd3466ac72538122e29e4.jpg%401280w_1l_2o_100sh.jpg");
//        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544258152800&di=ff17d71ff5be5ec0f5ff30a0b357a43a&imgtype=0&src=http%3A%2F%2Fpic.90sjimg.com%2Fdesign%2F00%2F69%2F99%2F66%2F9fce5755f081660431464492a9aeb003.jpg");
//        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544258152799&di=befcb2a66da93b72639a42e66bbfb34e&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01e12d56ef92586ac7257d20bfaf8d.jpg");

        //设置播放时间间隔
        mRollViewPager.setPlayDelay(3000);
        //设置透明度
        mRollViewPager.setAnimationDurtion(500);
        //设置适配器
        mRollViewPager.setAdapter(new TestNormalAdapter(list));

        //设置指示器（顺序依次）
        //自定义指示器图片
        //设置圆点指示器颜色
        //设置文字指示器
        //隐藏指示器
        //mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));
        mRollViewPager.setHintView(new ColorPointHintView(getContext(), Color.YELLOW, Color.WHITE));
        //mRollViewPager.setHintView(new TextHintView(this));
        //mRollViewPager.setHintView(null);

    }

    private class TestNormalAdapter extends StaticPagerAdapter {
        List<String> list;

        public TestNormalAdapter(List<String> list) {
            this.list = list;
        }

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            ImageLoaderUtil.display(container.getContext(), list.get(position), view);
            return view;
        }


        @Override
        public int getCount() {
            return list.size();
        }
    }


    @SuppressLint("CheckResult")
    private void initData() {

        listView.setOnItemClickListener(this);

        ApiFactory.getHospitals()
                .subscribe(baseBean -> {
                            if (baseBean.code == 1) {
                                list = baseBean.data.hospitals;
                                listView.setAdapter(new HospitalAdapter(getContext(), list));
                                initBanner();
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
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra("data", list.get(i));
        startActivity(intent);
    }
}
