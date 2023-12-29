package com.example.myapplication_1;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MytextView extends TextView {


    public MytextView(Context context) {
        super(context);
    }

    public MytextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MytextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


//    获取焦点
    @Override
    public boolean isFocused() {
        return true;
    }
}
