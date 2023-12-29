package com.example.myapplication_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(TAG,TAG + "--->onCreate()");

//        TextView textView_1 = findViewById(R.id.textview_1);
//        textView_1.setText("冬季");
    }
//    MainActivity.java中设置的textView_1.setText("冬季")会将activity_main.xml中的覆盖

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(TAG,TAG + "--->onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG,TAG + "--->onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG,TAG + "--->onResume()"); //可见
    }

    @Override
    protected void onPause(){
        super.onPause();

        Log.d(TAG,TAG + "--->onPause()");  //不可见
    }

    @Override
    protected void onStop(){
        super.onStop();

        Log.d(TAG,TAG + "--->onStop()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        Log.d(TAG,TAG + "--->onDestroy()");
    }


}