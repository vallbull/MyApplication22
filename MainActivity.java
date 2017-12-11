package com.example.valval.myapplication22;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    View layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button red = (Button) findViewById(R.id.redButton);
        Button blue = (Button) (findViewById(R.id.blueButton));
        layout = findViewById(R.id.back);
        red.setOnClickListener(new RedListener());
        blue.setOnClickListener(new BlueListener());


    }
    class RedListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            layout.setBackgroundColor(Color.RED);
        }
    }
    class BlueListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            layout.setBackgroundColor(Color.BLUE);
        }
    }
}

