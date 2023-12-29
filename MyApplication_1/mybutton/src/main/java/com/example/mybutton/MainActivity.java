package com.example.mybutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;



//public class MainActivity extends AppCompatActivity implements View.OnClickListener{
public class MainActivity extends AppCompatActivity {

    private static final String TAG = " click ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);

//        点击事件

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e(TAG, "onClick: ");
                Toast.makeText(MainActivity.this,"第二种监听",Toast.LENGTH_LONG).show();
            }
        });

//        长按事件
        btn.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view){
                Log.e(TAG, "onLongClick: ");
                return false;
            }
        });

//        触摸事件
        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.e(TAG, "onTouch: " + motionEvent.getAction());
                return false;
            }
        });


    }

//        class MyClickListener implements View.OnClickListener{
//            @Override
//            public void onClick(View v){
//                Toast.makeText(MainActivity.this,"第三种监听",Toast.LENGTH_LONG).show();
//            }
//        }


//    public void theclick(View view){
//        Log.e(TAG, "onClick: ");
//        Toast.makeText(MainActivity.this,"第一种监听",Toast.LENGTH_LONG).show();
//    }


//    public void onClick(View v){
//        Toast.makeText(MainActivity.this,"第四种监听",Toast.LENGTH_LONG).show();
//    }

    public void trans(View view) {
        startActivity(new Intent(this, MainActivity2_radiobutton.class));
    }


}