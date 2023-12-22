package com.example.myfirapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


// ==========       定义一个接收者           =========
public class UpdatelpSelectCity extends BroadcastReceiver {

    private final String TAG = UpdatelpSelectCity.class.getSimpleName();

    public void onReceive(Context arg0, Intent arg1){
        Log.e(TAG, "UpdatelpSelectCity onReceive 广播接收者");
    }

}
