package com.example.myapplication_test1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ViewUtils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayDeque;
import java.util.Random;

public class LoginMainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tv_password;
    private EditText et_password,et_phone,input_verifycode;
    private Button btn_forget,btn_login;
    private CheckBox ck_remember;
    private RadioButton rb_password,rb_verifycode;
    private ActivityResultLauncher<Intent> register;
    private String mVerifyCode;

    private String mPassword = "666666";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        tv_password = findViewById(R.id.tv_password);
        et_password = findViewById(R.id.et_password);
        et_phone = findViewById(R.id.et_phone);
//        input_verifycode = findViewById(R.id.input_verifycode);
        btn_forget = findViewById(R.id.btn_forget);
        rb_password = findViewById(R.id.rb_password);
        rb_verifycode = findViewById(R.id.rb_verifycode);
        btn_login = findViewById(R.id.btn_login);
        ck_remember = findViewById(R.id.ck_remember);
        RadioGroup rb_login = findViewById(R.id.rg_login);

        //给et_phone和添加文本变更监听器
        et_phone.addTextChangedListener(new HideTextWatcher(et_phone,11));
        et_password.addTextChangedListener(new HideTextWatcher(et_password,11));
//        input_verifycode.addTextChangedListener(new HideTextWatcher(et_password,6));


        register = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Intent intent = result.getData();
                if (intent != null && result.getResultCode() == Activity.RESULT_OK){
                    //用户密码已更新，更改密码变量
                    mPassword =  intent.getStringExtra("new_password");
                }
            }
        });

        //忘记密码的监听事件
        btn_forget.setOnClickListener((View.OnClickListener) LoginMainActivity.this);
        //登入的监听事件
        btn_login.setOnClickListener((View.OnClickListener) LoginMainActivity.this);


        //给rg_login设置单选监听器,Button的第二种监听方式
        rb_login.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            //更换登陆方式
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                       // 使用密码登录
                if (checkedId == R.id.rb_password){
                    tv_password.setText(getString(R.string.login_password));
                    et_password.setHint(getString(R.string.input_password));
                    btn_forget.setText(getString(R.string.forget_password));
                    ck_remember.setVisibility(View.VISIBLE);
                }
                //使用验证码登录
                else if (checkedId == R.id.rb_verifycode) {
                    tv_password.setText(getString(R.string.verifycode));
                    et_password.setHint(getString(R.string.input_verifycode));
                    btn_forget.setText(getString(R.string.get_verifycode));
                    ck_remember.setVisibility(View.GONE);
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
            String phone = et_phone.getText().toString();
            if (phone.length() < 11){
                Toast.makeText(getApplicationContext(),"请输入正确的的手机号",Toast.LENGTH_SHORT).show();
                return;
            }

            //点击忘记密码的按钮
            if (view.getId() == R.id.btn_forget){

                //选择了密码校验方式，此时要跳到找回密码页面
                if (rb_password.isChecked()){
                    //携带手机号码跳转找回密码页面
                    Intent intent = new Intent(LoginMainActivity.this,LoginForgetActivity.class);
                    intent.putExtra("phone",phone);
                    register.launch(intent);
                }else if (rb_verifycode.isChecked()) {
                    //生成六位随机的验证码
                    mVerifyCode = String.format("%06d", new Random().nextInt(999999));
                    //弹出提醒对话框，提示用户记住六位验证码
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginMainActivity.this);
                    builder.setTitle("请记住验证码");
                    builder.setMessage("手机号"+phone + "，本次验证码是"+mVerifyCode+",请输入验证码");
                    builder.setPositiveButton("好的",null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
            //点击登陆的按钮
            if (view.getId() == R.id.btn_login){
                if (rb_password.isChecked()) {
                    if (!mPassword.equals(et_password.getText().toString())) {
                        Toast.makeText(LoginMainActivity.this, "请输入正确的密码", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    //提示登录成功
                    loginSuccess();
                }
                else if (rb_verifycode.isChecked()) {
                    //验证码校验
                    if (!mVerifyCode.equals(et_password.getText().toString())) {
                        Toast.makeText(LoginMainActivity.this, "请输入正确的验证码", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    //提示登录成功
                    loginSuccess();
                }
            }
    }

    private void loginSuccess() {
        String desc = String.format("您的手机号码是%s，恭喜你通过登陆验证，点击“确定”按钮返回上个页面",et_phone.getText().toString());
        //弹出提醒对话框，提示用户登陆成功
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginMainActivity.this);
        builder.setTitle("登录成功");
        builder.setMessage(desc);
        builder.setPositiveButton("确定返回", (dialogInterface, i) -> {
            finish();
        });
        builder.setNegativeButton("继续浏览",null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    private class HideTextWatcher implements TextWatcher {
        private EditText mView;
        private int mMaxLength;

        public HideTextWatcher(EditText v, int maxLength){
            this.mView = v;
            this.mMaxLength = maxLength;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s.toString().length() == mMaxLength){

                ViewUtil.hideOneInputMethod(LoginMainActivity.this,mView);
            }
        }
    }

}