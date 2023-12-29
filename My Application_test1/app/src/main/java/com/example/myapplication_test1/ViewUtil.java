package com.example.myapplication_test1;

import android.content.Context;
import android.view.View;
import android.app.Activity;
import android.view.inputmethod.InputMethodManager;

public class ViewUtil {
        public static void hideOneInputMethod(Activity activity, View view){
            //从系统服务中获取输入法管理
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            //关闭屏幕上的输入法
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

}
