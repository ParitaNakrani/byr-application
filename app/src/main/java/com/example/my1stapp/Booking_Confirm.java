package com.example.my1stapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Booking_Confirm extends AppCompatActivity {

    TextView textfromdate;
    TextView texttodate;
    TextView textfromtime;
    TextView texttotime;
    Button btnconfirm;
    TextView textlocation;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_confirm);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.actionbar)));
        getSupportActionBar().setTitle("Confirm Your Booking");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color._bg___1_ek2_color));

        textfromdate = findViewById(R.id.textfromdate);
        texttodate = findViewById(R.id.texttodate);
        textfromtime = findViewById(R.id.textfromtime);
        texttotime = findViewById(R.id.texttotime);
        btnconfirm = findViewById(R.id.btnconfirm);
        textlocation = findViewById(R.id.textlocation);
        sharedPreferences = getSharedPreferences("SHARED_PREF",MODE_PRIVATE);

        String fromdate = sharedPreferences.getString("FDATE",null);
        String fromtime = sharedPreferences.getString("FTIME",null);
        String todate = sharedPreferences.getString("TDATE",null);
        String totime = sharedPreferences.getString("TTIME",null);
        String location = sharedPreferences.getString("LOCATION",null);
        textfromdate.setText(fromdate);
        texttodate.setText(todate);
        textfromtime.setText(fromtime);
        texttotime.setText(totime);
        textlocation.setText(location);

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