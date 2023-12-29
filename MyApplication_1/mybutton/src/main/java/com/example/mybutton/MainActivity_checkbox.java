package com.example.mybutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_checkbox extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private CheckBox cb1,cb2,cb3,cb4;
//    private TextView mTextView;
//    String mContent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_checkbox);
//        mContent = new String();
        initView();
    }

    private void initView(){
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        cb4 = findViewById(R.id.cb4);
//        mTextView = findViewById(R.id.textView);
        cb1.setOnCheckedChangeListener(MainActivity_checkbox.this);
        cb2.setOnCheckedChangeListener(MainActivity_checkbox.this);
        cb3.setOnCheckedChangeListener(MainActivity_checkbox.this);
        cb4.setOnCheckedChangeListener(MainActivity_checkbox.this);


    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//        String motion = buttonView.getText().toString();
        if(isChecked){
            Toast.makeText(MainActivity_checkbox.this, "你选择了"+buttonView.getText(),Toast.LENGTH_SHORT ).show();
        }
        else{
            Toast.makeText(MainActivity_checkbox.this, "你取消了"+buttonView.getText(), Toast.LENGTH_SHORT ).show();
        }

//        if (isChecked){
//            if (!mContent.contains(motion)){
//                mContent = mContent + motion;
//                mTextView.setText(mContent);
//            }
//        }
//        else {
//            if (mContent.contains(motion)){
//                mContent = mContent.replace(motion,"");
//                mTextView.setText(mContent);
//            }
//        }
    }
}
