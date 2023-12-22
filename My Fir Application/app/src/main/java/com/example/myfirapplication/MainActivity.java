package com.example.myfirapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

//  private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Log.e(TAG, "--->onCreate()");
    }

//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Log.e(TAG,TAG + "--->onRestart()");
//    }
//
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.e(TAG,TAG + "--->onStart()");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.e(TAG,TAG + "--->onResume()"); //可见
//    }
//
//    @Override
//    protected void onPause(){
//        super.onPause();
//        Log.e(TAG,TAG + "--->onPause()");  //不可见
//    }
//
//    @Override
//    protected void onStop(){
//        super.onStop();
//        Log.e(TAG,TAG + "--->onStop()");
//    }
//
//    @Override
//    protected void onDestroy(){
//        super.onDestroy();
//        Log.e(TAG,TAG + "--->onDestroy()");
//    }
//
    public void startActivity2(View view) {
        startActivity(new Intent(this, MainActivity2.class));
    }

}