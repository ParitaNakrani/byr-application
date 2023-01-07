package com.example.my1stapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class txi_book extends AppCompatActivity {

    TextView textfromdate;
    TextView texttodate;
    TextView textfromtime;
    TextView texttotime;
    TextView textpeople;
    TextView textlocation;
    Button btnconfirm;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_txi_book);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.actionbar)));
        getSupportActionBar().setTitle("taxi booking");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color._bg___1_ek2_color));

        textfromdate = findViewById(R.id.textfromdate);
        texttodate = findViewById(R.id.texttodate);
        textfromtime = findViewById(R.id.textfromtime);
        texttotime = findViewById(R.id.texttotime);
        btnconfirm = findViewById(R.id.btnconfirm);
        textpeople= findViewById(R.id.textpeople);
        textlocation = findViewById(R.id.textlocation);
        sharedPreferences = getSharedPreferences("SHARED_PREF",MODE_PRIVATE);


        String fromdate = sharedPreferences.getString("FDATE",null);
        String todate = sharedPreferences.getString("TDATE",null);
        String fromtime = sharedPreferences.getString("FTIME",null);
        String totime = sharedPreferences.getString("TTIME",null);
        String location = sharedPreferences.getString("LOCATION",null);
        String people= sharedPreferences.getString("PEOPLE",null);
        textfromdate.setText(fromdate);
        texttodate.setText(todate);
        textfromtime.setText(fromtime);
        texttotime.setText(totime);
        textlocation.setText(location);
        textpeople.setText(people);

        btnconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                Intent intent = new Intent(getApplicationContext(),Successful.class);
                startActivity(intent);
            }
        });

    }
}