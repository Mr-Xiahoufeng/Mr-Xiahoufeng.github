package com.example.myfirapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void startActivity4(View view) {
        startActivity(new Intent(this, MainActivity4.class));
    }






//    ===============非BindService=====================

//    ======================启动服务==================
    public void startService(View view) {
        startService(new Intent(this, MyService.class));
    }

//      ======================停止服务==================
    public void stopService(View view) {
        stopService(new Intent(this, MyService.class));
    }









//     ===============BindService=====================
    public void bindService(View view) {
        bindService(new Intent(this, MyService.class),connecton, Context.BIND_AUTO_CREATE);
    }

    public void unbindService(View view) {
        unbindService(connecton);
    }
//    =================Activity3与MyService的连接========================
        private ServiceConnection connecton = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };



}