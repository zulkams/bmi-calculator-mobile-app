package com.example.bmi_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class bmiactivity extends AppCompatActivity {


    android.widget.Button recalculatebmi;

    TextView bmiDisplay, bmiCategory, bmiText;
    Intent intent;
    ImageView imageView;
    String bmi;
    String newbmi;
    float floatbmi;

    String height;
    String weight;
    float intheight, intweight;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent=getIntent();

        bmiDisplay=findViewById(R.id.bmidisplay);
        bmiCategory=findViewById(R.id.bmicategory);
        bmiText=findViewById(R.id.bmitext);
        imageView=findViewById(R.id.imageView);
        recalculatebmi=findViewById(R.id.recalculateBmi);

        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);

        intheight=intheight/100;

        floatbmi=intweight/(intheight*intheight);

        bmi=Float.toString(floatbmi);
        newbmi=String.format("%.1f", floatbmi);

        if (floatbmi<18.5)
        {
            bmiCategory.setText("UNDERWEIGHT");
            bmiCategory.setTextColor(Color.parseColor("#FF4C4C"));
            imageView.setImageResource(R.drawable.caution);
            bmiText.setText("HEALTH PROBLEM RISK: MEDIUM");

        }
        else if(floatbmi>18.4 && floatbmi<25)
        {
            bmiCategory.setText("NORMAL");
            bmiCategory.setTextColor(Color.parseColor("#009688"));
            imageView.setImageResource(R.drawable.ok);
            bmiText.setText("HEALTH PROBLEM RISK: LOW");
        }
        else if(floatbmi>24.9 && floatbmi<30)
        {
            bmiCategory.setText("OVERWEIGHT");
            bmiCategory.setTextColor(Color.parseColor("#FF4C4C"));
            imageView.setImageResource(R.drawable.caution);
            bmiText.setText("HEALTH PROBLEM RISK: MEDIUM");
        }
        else
        {
            bmiCategory.setText("OBESITY");
            bmiCategory.setTextColor(Color.parseColor("#FF4C4C"));
            imageView.setImageResource(R.drawable.caution);
            bmiText.setText("HEALTH PROBLEM RISK: HIGH");
        }


        bmiDisplay.setText(newbmi);







        getSupportActionBar().hide();
        recalculatebmi=findViewById(R.id.recalculateBmi);

        recalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( bmiactivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}