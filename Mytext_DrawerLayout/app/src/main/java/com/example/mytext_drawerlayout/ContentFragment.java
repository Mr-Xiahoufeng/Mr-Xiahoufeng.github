package com.example.mytext_drawerlayout;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import com.example.mytext_drawerlayout.R.drawable;


public class ContentFragment extends Fragment {

    private TextView tv_content;
    private ImageView img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content, container, false);
        tv_content = view.findViewById(R.id.tv_content);
        img = view.findViewById(R.id.img);

        String text = getArguments().getString("text");
        tv_content.setText(text);
        img.setBackgroundResource(drawable.ys2);
        return view;
    }
}
