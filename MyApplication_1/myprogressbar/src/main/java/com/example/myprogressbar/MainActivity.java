package com.example.myprogressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressbar;
    private ProgressBar progressbar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressbar = findViewById(R.id.pb);
        progressbar2 = findViewById(R.id.pb2);

    }

    public void clk1(View view){
        if (progressbar.getVisibility() == View.GONE){
            progressbar.setVisibility(View.VISIBLE);
        }
        else{
            progressbar.setVisibility(View.GONE);
        }
    }

    public void clk2(View view){
        int progress = progressbar2.getProgress();
        progress += 2;
        progressbar2.setProgress(progress);
    }

}