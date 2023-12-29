package com.example.myapplication_test1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class LoginForgetActivity extends AppCompatActivity implements View.OnClickListener{

    private String mPhone;
    private EditText et_password_first;
    private EditText et_password_second;
    private EditText et_verifycode;
    private String mVerifyCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_forget);
        et_password_first = findViewById(R.id.et_password_first);
        et_password_second = findViewById(R.id.et_password_second);
        et_verifycode = findViewById(R.id.et_verifycode);

        mPhone = getIntent().getStringExtra("phone");
        findViewById(R.id.btn_verifycode).setOnClickListener((View.OnClickListener) LoginForgetActivity.this);
        findViewById(R.id.btn_confirm).setOnClickListener((View.OnClickListener) LoginForgetActivity.this);


    }

    @Override
    public void onClick(View view) {
        //点击获取验证码按钮
        if (view.getId() == R.id.btn_verifycode) {
            //生成六位随机的验证码
            mVerifyCode = String.format("%06d", new Random().nextInt(999999));
            //弹出提醒对话框，提示用户记住六位验证码
            AlertDialog.Builder builder = new AlertDialog.Builder(LoginForgetActivity.this);
            builder.setTitle("请记住验证码");
            builder.setMessage("手机号" + mPhone + "，本次验证码是" + mVerifyCode + ",请输入验证码");
            builder.setPositiveButton("好的", null);
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        //点击确定按钮
        if (view.getId() == R.id.btn_confirm){
            String password_first = et_password_first.getText().toString();
            String password_second = et_password_second.getText().toString();
            if (password_first.length() > 11 && password_first.length() <6 ){
                Toast.makeText(getApplicationContext(),"请输入正确的的密码",Toast.LENGTH_SHORT).show();
                return;
            }
            if (!password_first.equals(password_second)) {
                Toast.makeText(getApplicationContext(),"两次输入的密码不一致",Toast.LENGTH_SHORT).show();
                return;
            }
            if (!mVerifyCode.equals(et_verifycode.getText().toString())) {
                Toast.makeText(getApplicationContext(),"请输入正确的验证码",Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(getApplicationContext(),"密码修改成功",Toast.LENGTH_SHORT).show();
            //将修改好的密码传给上一个页面
            Intent intent = new Intent();
            intent.putExtra("new_password",password_first);
            setResult(Activity.RESULT_OK, intent);
            finish();
        }
    }
}