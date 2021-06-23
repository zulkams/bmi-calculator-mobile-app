package com.example.bmi_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    android.widget.Button calculatebmi;
    android.widget.Button aboutme;

    TextView currentheight;
    TextView currentweight;
    SeekBar seekbarforheight;
    SeekBar seekbarforweight;

    int intweight=0;
    int intheight=0;
    int currentprogressheight;
    int currentprogressweight;

    String intprogressheight="0";
    String intprogressweight="0";






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        calculatebmi=findViewById(R.id.calculateBmi);
        aboutme=findViewById(R.id.aboutme);
        currentheight=findViewById(R.id.currentHeight);
        currentweight=findViewById(R.id.currentWeight);
        seekbarforheight=findViewById(R.id.seekbarHeight);
        seekbarforweight=findViewById(R.id.seekbarWeight);


        seekbarforheight.setMax(250);
        seekbarforheight.setProgress(0);
        seekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentprogressheight=progress;
                intprogressheight=String.valueOf(currentprogressheight);
                currentheight.setText(intprogressheight);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekbarforweight.setMax(250);
        seekbarforweight.setProgress(0);
        seekbarforweight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentprogressweight=progress;
                intprogressweight=String.valueOf(currentprogressweight);
                currentweight.setText(intprogressweight);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




        calculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,bmiactivity.class);
                startActivity(intent);

                if(intprogressheight.equals("0"))
                {
                    Toast.makeText(getApplicationContext(), "Please Enter Your Height", Toast.LENGTH_SHORT).show();
                }
                else if(intprogressweight.equals("0"))
                {
                    Toast.makeText(getApplicationContext(), "Please Enter Your Weight", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent in=new Intent(MainActivity.this,bmiactivity.class);
                    in.putExtra("height", intprogressheight);
                    in.putExtra("weight", intprogressweight);

                    startActivity(in);
                }

            }
        });

        aboutme.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intentt = new Intent( MainActivity.this,resume.class);
                startActivity(intentt);
            }
        });






    }
}