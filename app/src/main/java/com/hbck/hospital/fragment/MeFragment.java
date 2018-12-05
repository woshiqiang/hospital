package com.hbck.hospital.fragment;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hbck.apt.ApiFactory;
import com.hbck.hospital.R;
import com.hbck.hospital.activity.AboutActivity;
import com.hbck.hospital.activity.LoginActivity;
import com.hbck.hospital.bean.User;
import com.hbck.hospital.util.Constants;
import com.hbck.hospital.util.DialogUtil;
import com.hbck.hospital.util.ImageLoaderUtil;
import com.hbck.hospital.util.SpUtil;
import com.makeramen.roundedimageview.RoundedImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.model.PhotoInfo;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * @time 2018-11-14 16:26
 * @类描述：我的
 * @变更记录:
 */
public class MeFragment extends Fragment {
    private User currentUser;

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
    @BindView(R.id.ll_about)
    LinearLayout llAbout;

    @BindView(R.id.ll_logout)
    LinearLayout llLogout;
    Unbinder unbinder;
    private Dialog dialog;

    private static final int REQUEST_CODE_CHOOSE = 100;

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
        currentUser = SpUtil.getUser();
        if (currentUser != null) {
            tvNick.setText(SpUtil.getString(Constants.USERNAME));
            tvIntroduction.setText(currentUser.getNickname());
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.riv_head, R.id.tv_introduction, R.id.ll_my_info, R.id.ll_my_product, R.id.ll_about, R.id.ll_logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.riv_head:
                selectImage();
                break;
            case R.id.tv_introduction:
                break;
            case R.id.ll_my_info:
                break;
            case R.id.ll_my_product:
                break;
            case R.id.ll_about:
                //关于我们
                startActivity(new Intent(getContext(),AboutActivity.class));
                break;
            case R.id.ll_logout:
                SpUtil.put(Constants.USERNAME, "");
                SpUtil.put(Constants.PASSWORD, "");
                startActivity(new Intent(getContext(), LoginActivity.class));
                getActivity().finish();
                break;
        }
    }

    private void selectImage() {
        GalleryFinal.openGallerySingle(REQUEST_CODE_CHOOSE, mOnHanlderResultCallback);
    }

    private GalleryFinal.OnHanlderResultCallback mOnHanlderResultCallback = new GalleryFinal.OnHanlderResultCallback() {
        @Override
        public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
            if (resultList != null) {
                final String photoPath = resultList.get(0).getPhotoPath();

                currentUser.setImage(photoPath);
                uploadImage(photoPath);
            }
        }

        @Override
        public void onHanlderFailure(int requestCode, String errorMsg) {
            Toast.makeText(getContext(), errorMsg, Toast.LENGTH_SHORT).show();
        }
    };

    /**
     * 上传头像
     *
     * @param photoPath
     */
    @SuppressLint("CheckResult")
    private void uploadImage(String photoPath) {
        dialog = DialogUtil.createLoadingDialog(getContext(), "上传中...");
        File file = new File(photoPath);
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        Map<String, RequestBody> mapParam = new HashMap<>();
        mapParam.put("file" + "\"; filename=\"" + file.getName(), requestFile);

        ApiFactory.uploadFile(mapParam, "2")
                .subscribe(baseBean -> {
                    if (baseBean.code == 1) {
                        ArrayList<String> list = baseBean.data.list;
                        String s = list.get(0);
                        currentUser.setImage(s);
                        ImageLoaderUtil.display(getContext(), s, rivHead);
                        updateUserInfo(currentUser);
                    } else {
                        dialog.dismiss();
                        Toast.makeText(getContext(), baseBean.message, Toast.LENGTH_SHORT).show();
                    }
                }, throwable -> {
                    dialog.dismiss();
                    Toast.makeText(getContext(), "图片上传失败", Toast.LENGTH_SHORT).show();
                });

    }

    /**
     * 更改用户信息
     *
     * @param currentUser
     */
    @SuppressLint("CheckResult")
    private void updateUserInfo(User currentUser) {
        Gson gson = new Gson();
        String obj = gson.toJson(currentUser);
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), obj);
        ApiFactory.updateUser(body)
                .subscribe(baseBean -> {
                            dialog.dismiss();
                            if (baseBean.code == 1) {
                            } else {
                                Toast.makeText(getContext(), baseBean.message, Toast.LENGTH_SHORT).show();
                            }
                        }, e -> {
                            dialog.dismiss();
                            e.printStackTrace();
                            Toast.makeText(getContext(), "网络异常", Toast.LENGTH_SHORT).show();
                        }
                );
    }
}
