package com.hbck.hospital.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hbck.apt.ApiFactory;
import com.hbck.hospital.R;
import com.hbck.hospital.bean.User;
import com.hbck.hospital.util.DialogUtil;
import com.hbck.hospital.util.SpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.RequestBody;

public class ModifyInfoActivity extends AppCompatActivity {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.toolbar_right)
    TextView toolbarRight;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_sex)
    EditText etSex;
    @BindView(R.id.et_nick)
    EditText etNick;

    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_info);
        ButterKnife.bind(this);


        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//左侧添加一个默认的返回图标

        title.setText("个人资料");
        toolbar.setNavigationOnClickListener(v -> finish());
        toolbar.setNavigationIcon(R.mipmap.ic_back);
        toolbarRight.setText("提交");
        init();
    }

    private void init() {
        User user = SpUtil.getUser();
        if (user == null) return;
        //姓名
        if (!TextUtils.isEmpty(user.getName())) {
            etName.setText(user.getName());
        }
        //昵称
        if (!TextUtils.isEmpty(user.getNickname())) {
            etNick.setText(user.getNickname());
        }

        String sex = user.getSex() == 0 ? "未知" : (user.getSex() == 1 ? "男" : "女");
        etPhone.setText(user.getPhone());
        etSex.setText(sex);


    }

    @SuppressLint("CheckResult")
    @OnClick({R.id.toolbar_right, R.id.et_sex})
    public void onViewClicked(View view) {
        if (view.getId() == R.id.et_sex) {//性别
            selectSex();
        } else if (view.getId() == R.id.toolbar_right) {
            submit();
        }

    }

    private void selectSex() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final String[] items = {"男", "女"};
        builder.setTitle("选择性别")
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        etSex.setText(items[i]);
                    }
                })
                .create().show();
    }

    /**
     * 提交
     */
    private void submit() {
        dialog = DialogUtil.createLoadingDialog(this, "上传中...");
        String name = etName.getText().toString();
        String nick = etNick.getText().toString();
        String sex = etSex.getText().toString();
        int sexInt = "男".equals(sex) ? 1 : ("女".equals(sex) ? 1 : 0);
        User user = SpUtil.getUser();
        user.setName(name);
        user.setNickname(nick);

        user.setSex(sexInt);
        Gson gson = new Gson();
        String obj = gson.toJson(user);
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), obj);
        ApiFactory.updateUser(body)
                .subscribe(baseBean -> {
                            dialog.dismiss();
                            if (baseBean.code == 1) {
                                Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
                                SpUtil.saveUser(user);
                                init();
                            } else {
                                Toast.makeText(this, baseBean.message, Toast.LENGTH_SHORT).show();
                            }
                        }, e -> {
                            dialog.dismiss();
                            e.printStackTrace();
                            Toast.makeText(this, "网络异常", Toast.LENGTH_SHORT).show();
                        }
                );
    }


}
