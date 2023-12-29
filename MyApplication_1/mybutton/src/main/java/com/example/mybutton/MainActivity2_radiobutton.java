package com.example.mybutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity2_radiobutton extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_radiobutton);

        RadioGroup group = (RadioGroup) findViewById(R.id.radioGroup);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton=(RadioButton) findViewById(checkedId);
                String checkText = radioButton.getText().toString();
                Toast.makeText(MainActivity2_radiobutton.this,"你选择了  "+checkText,Toast.LENGTH_LONG).show();
            }
        });




    }

    public void checkbox(View view) {
        startActivities(new Intent[]{new Intent(this, MainActivity_checkbox.class)});
    }


}