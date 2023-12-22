package com.example.myfirapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //       用Java代码注册接收者即可
        //     第二步，在onCreate注册广播（订阅）
        //     动态使用Java代码注册一个广播接收者
        UpdatelpSelectCity updatelpSelectCity = new UpdatelpSelectCity();
        IntentFilter filter = new IntentFilter();
        filter.addAction(ActionUtils.ACTION_EQUES_UPDATE_IP);
        registerReceiver(updatelpSelectCity, filter);


    }


    //=============      静态发送广播~给~接收者        ============
    public void sendAction1(View view) {
        Intent intent = new Intent();
        //ActionUtils.ACTION_EQUES_UPDATE_IP   与注册时保持一致
        intent.setAction(ActionUtils.ACTION_FLAG);
        sendBroadcast(intent);
    }

    // ================         第三步            =============
    //=============      发送给动态注册的接收者        ============
    public void sendAction2(View view) {
        Intent intent = new Intent();
        //ActionUtils.ACTION_EQUES_UPDATE_IP   与注册时保持一致
        intent.setAction(ActionUtils.ACTION_EQUES_UPDATE_IP);
        sendBroadcast(intent);
    }

}