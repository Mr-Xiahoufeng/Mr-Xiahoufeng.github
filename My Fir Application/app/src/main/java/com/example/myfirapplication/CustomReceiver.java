package com.example.myfirapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class CustomReceiver extends BroadcastReceiver {

    private final String TAG = CustomReceiver.class.getSimpleName();

    public void onReceive(Context context, Intent intent){
        Log.e(TAG, "CustomReceiver onReceive 广播接收者");
    }
}
