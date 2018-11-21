package com.hbck.hospital.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hbck.apt.ApiFactory;
import com.hbck.hospital.R;
import com.hbck.hospital.util.Constants;
import com.hbck.hospital.util.DialogUtil;
import com.hbck.hospital.util.SpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 登录界面
 */
public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.et_username)
    EditText et_username;
    @BindView(R.id.et_password)
    EditText et_password;
    @BindView(R.id.btn_login)
    Button btnLogin;

    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        title.setText("登录");
        String username = SpUtil.getString(Constants.USERNAME);
        String password = SpUtil.getString(Constants.PASSWORD);
        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            et_username.setText(username);
            et_password.setText(password);
            btnLogin.performClick();
        }
    }


    @OnClick({R.id.btn_login, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                submit();
                break;
            case R.id.btn_register:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
        }
    }

    @SuppressLint("CheckResult")
    private void submit() {
        String username = et_username.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "账号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = et_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        dialog = DialogUtil.createLoadingDialog(this, "登录中...");
        ApiFactory.login(username, password)
                .subscribe(baseBean -> {
                            dialog.dismiss();
                            Log.d("LoginActivity", "baseBean:" + baseBean);
                            if (baseBean.code == 1) {
                                SpUtil.put(Constants.USERNAME, username);
                                SpUtil.put(Constants.PASSWORD, password);
                                Toast.makeText(this, baseBean.message, Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
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

}
