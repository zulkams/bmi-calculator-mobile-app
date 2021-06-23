package com.example.bmi_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class resume extends AppCompatActivity {



    android.widget.Button github;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);
        getSupportActionBar().hide();

        github=findViewById(R.id.github);


    }

    public void browser (View view){
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/zulkams"));
        startActivity(browserIntent);
    }
}