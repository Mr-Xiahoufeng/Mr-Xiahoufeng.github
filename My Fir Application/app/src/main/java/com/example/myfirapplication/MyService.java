package com.example.myfirapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {

    public void onCreate(){
        super.onCreate();
    }
    public IBinder onBind(Intent intent){
        return null;
    }
    public void onDestroy(){
        super.onDestroy();
    }




}
