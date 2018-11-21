package com.hbck.hospital.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hbck.apt.ApiFactory;
import com.hbck.hospital.R;
import com.hbck.hospital.util.DialogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 注册
 */
public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.et_username)
    EditText et_username;
    @BindView(R.id.et_password)
    EditText et_password;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initView();


    }

    private void initView() {
        title.setText("注册");
        toolbar.setNavigationIcon(R.mipmap.ic_back);
        toolbar.setNavigationOnClickListener(view -> finish());
    }


    @SuppressLint("CheckResult")
    private void submit() {
        String username = et_username.getText().toString().trim();
        if (TextUtils.isEmpty(username) || username.length() != 11) {
            Toast.makeText(this, "请输入正确的手机号！", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = et_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        dialog = DialogUtil.createLoadingDialog(this, "注册中...");
        ApiFactory.register(username, password)
                .subscribe(baseBean -> {
                            dialog.dismiss();
                            Log.d("RegisterActivity", "baseBean:" + baseBean);
                            if (baseBean.code == 1) {
                                Toast.makeText(this, baseBean.message, Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                finish();
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


    @OnClick(R.id.btn_register)
    public void onViewClicked() {
        submit();
    }
}
