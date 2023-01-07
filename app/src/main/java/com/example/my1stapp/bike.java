package com.example.my1stapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class bike extends AppCompatActivity {

    TextView bike1pr,bike2pr,bike3pr,bike4pr,bike5pr,bike6pr;
    Button btnbike1,btnbike2,btnbike3,btnbike4,btnbike5,btnbike6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.actionbar)));
        getSupportActionBar().setTitle("Bike");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color._bg___1_ek2_color));

        bike1pr = (TextView) findViewById(R.id.bike1pr);
        bike2pr = (TextView) findViewById(R.id.bike2pr);
        bike3pr = (TextView) findViewById(R.id.bike3pr);
        bike4pr = (TextView) findViewById(R.id.bike4pr);
        bike5pr = (TextView) findViewById(R.id.bike5pr);
        bike6pr = (TextView) findViewById(R.id.bike6pr);

        btnbike1 = (Button) findViewById(R.id.btnbike1);
        btnbike2 = (Button) findViewById(R.id.btnbike2);
        btnbike3 = (Button) findViewById(R.id.btnbike3);
        btnbike4 = (Button) findViewById(R.id.btnbike4);
        btnbike5 = (Button) findViewById(R.id.btnbike5);
        btnbike6 = (Button) findViewById(R.id.btnbike6);

        btnbike1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Book_NOw.class);
                startActivity(intent);
            }
        });

        btnbike2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Book_NOw.class);
                startActivity(intent);
            }
        });

        btnbike3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Book_NOw.class);
                startActivity(intent);
            }
        });

        btnbike4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Book_NOw.class);
                startActivity(intent);
            }
        });

        btnbike5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Book_NOw.class);
                startActivity(intent);
            }
        });

        btnbike6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Book_NOw.class);
                startActivity(intent);
            }
        });

        String rupee=getResources().getString(R.string.RS);
        bike1pr.setText(rupee+"4k");
        String rupee1=getResources().getString(R.string.RS);
        bike2pr.setText(rupee1+"5k");
        String rupee2=getResources().getString(R.string.RS);
        bike3pr.setText(rupee2+"9k");
        String rupee3=getResources().getString(R.string.RS);
        bike4pr.setText(rupee3+"8k");
        String rupee4=getResources().getString(R.string.RS);
        bike5pr.setText(rupee4+"7k");
        String rupee5=getResources().getString(R.string.RS);
        bike6pr.setText(rupee5+"15k");

    }
}