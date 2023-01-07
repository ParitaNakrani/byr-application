package com.example.my1stapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class car extends AppCompatActivity {

    TextView car1pr,car2pr,car3pr,car4pr,car5pr,car6pr;
    Button btncar1,btncar2,btncar3,btncar4,btncar5,btncar6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.actionbar)));
        getSupportActionBar().setTitle("Car");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color._bg___1_ek2_color));

        car1pr = (TextView) findViewById(R.id.car1pr);
        car2pr = (TextView) findViewById(R.id.car2pr);
        car3pr = (TextView) findViewById(R.id.car3pr);
        car4pr = (TextView) findViewById(R.id.car4pr);
        car5pr = (TextView) findViewById(R.id.car5pr);
        car6pr = (TextView) findViewById(R.id.car6pr);

        btncar1 = (Button) findViewById(R.id.btncar1);
        btncar2 = (Button) findViewById(R.id.btncar2);
        btncar3 = (Button) findViewById(R.id.btncar3);
        btncar4 = (Button) findViewById(R.id.btncar4);
        btncar5 = (Button) findViewById(R.id.btncar5);
        btncar6 = (Button) findViewById(R.id.btncar6);

        btncar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Book_NOw.class);
                startActivity(intent);
            }
        });

        btncar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Book_NOw.class);
                startActivity(intent);
            }
        });

        btncar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Book_NOw.class);
                startActivity(intent);
            }
        });

        btncar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Book_NOw.class);
                startActivity(intent);
            }
        });

        btncar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Book_NOw.class);
                startActivity(intent);
            }
        });

        btncar6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Book_NOw.class);
                startActivity(intent);
            }
        });

        String rupee=getResources().getString(R.string.RS);
        car1pr.setText(rupee+"6k");
        String rupee1=getResources().getString(R.string.RS);
        car2pr.setText(rupee1+"8k");
        String rupee2=getResources().getString(R.string.RS);
        car3pr.setText(rupee2+"10k");
        String rupee3=getResources().getString(R.string.RS);
        car4pr.setText(rupee3+"9k");
        String rupee4=getResources().getString(R.string.RS);
        car5pr.setText(rupee4+"7k");
        String rupee5=getResources().getString(R.string.RS);
        car6pr.setText(rupee5+"15k");
    }
}