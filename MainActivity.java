package com.example.valval.myapplication22;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    View layout;
    private EditText editText;
    private SeekBar seekBar;
    private ToggleButton toggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        toggleButton= (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) editText.setGravity(Gravity.TOP);
                else editText.setGravity(Gravity.BOTTOM);
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                editText.setTextSize(i);
                SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
                editor.putInt("fontSize", i);
                editor.commit();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences("Settings", MODE_PRIVATE);
        int fontSize = preferences.getInt("fontSize", 50);
        editText.setTextSize(fontSize);
        seekBar.setProgress(fontSize);

    }
}

