package com.example.my1stapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.AlteredCharSequence;

public class LogOut extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_out);
//        getSupportActionBar().setTitle("Log Out");
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color._bg___1_ek2_color)));
//        AlertDialog.Builder dlg = new AlertDialog.Builder(LogOut.this);
//                dlg.setTitle("Logout");
//                dlg.setMessage("Are you sure to want to exit?")
//                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                        startActivity(intent);
//                    }
//                })
//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Intent intent = new Intent(getApplicationContext(),Home_Page.class);
//                        startActivity(intent);
//                    }
//                });
//                AlertDialog a = dlg.create();
//        a.show();
    }
}