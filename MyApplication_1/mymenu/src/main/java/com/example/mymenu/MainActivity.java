package com.example.mymenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    private static String TAG ;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mTextView = findViewById(R.id.text);
//        registerForContextMenu(mTextView);
    }

    //重写上下文菜单的创建方法
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        MenuInflater inflator = new MenuInflater(this);
//        inflator.inflate(R.menu.menu_context, menu);
//        super.onCreateContextMenu(menu, v, menuInfo);
//    }

    //上下文菜单的点击事件
//    @Override
//    public boolean onContextItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId() == R.id.blue) {
//            mTextView.setTextColor(Color.BLUE);
//        }
//        else if (item.getItemId() == R.id.green) {
//            mTextView.setTextColor(Color.GREEN);
//        }else if (item.getItemId() == R.id.red) {
//            mTextView.setTextColor(Color.RED);
//        }else if (item.getItemId() == R.id.yellow) {
//            mTextView.setTextColor(Color.YELLOW);
//        }
//
//        return super.onContextItemSelected(item);
//    }

    //该方法用于创建显示Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_optionmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        mTextView.setText(item.getTitle());
        if(item.getItemId() == R.id.menu1){
            Toast.makeText(this, "点击了第" + 1 + "个", Toast.LENGTH_SHORT).show();

        }
        else if(item.getItemId() == R.id.menu2){
            Toast.makeText(this, "点击了第" + 1 + "个", Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }

    //在选项菜单打开以后会调用这个方法，设置menu图标显示（icon）
//    @Override
//    public boolean onMenuOpened(int featureId, Menu menu) {
//        if (menu != null) {
//            if (menu.getClass().getSimpleName().equalsIgnoreCase("MenuBuilder")) {
//                try {
//                    Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
//                    method.setAccessible(true);
//                    method.invoke(menu, true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return super.onMenuOpened(featureId, menu);
//    }

    //该方法对菜单的item进行监听




}