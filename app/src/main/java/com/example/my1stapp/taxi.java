package com.example.my1stapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class taxi extends AppCompatActivity {

    TextView texttodate;
    TextView textfromdate;
    TextView textfromtime;
    TextView texttotime;
    EditText txtlocation;
    EditText txtpeople;
    Button btnbook;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxi);
        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color._bg___1_ek2_color));

        textfromdate = findViewById(R.id.textfromdate);
        texttodate = findViewById(R.id.texttodate);
        textfromtime = findViewById(R.id.textfromtime);
        texttotime = findViewById(R.id.texttotime);
        btnbook = findViewById(R.id.btnbook);
        txtlocation = findViewById(R.id.txtlocation);
        txtpeople = findViewById(R.id.txtpeople);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);

        sharedPreferences = getSharedPreferences("SHARED_PREF",MODE_PRIVATE);

        textfromdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(taxi.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        textfromdate.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
        texttodate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(taxi.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        texttodate.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
        textfromtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(taxi.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        Calendar c = Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        c.set(Calendar.MINUTE,minute);
                        c.setTimeZone(TimeZone.getDefault());
                        SimpleDateFormat format = new SimpleDateFormat("k:mm a");
                        String time = format.format(c.getTime());
                        textfromtime.setText(time);
                    }
                },hours,min,false);
                timePickerDialog.show();
            }
        });
        texttotime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(taxi.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        Calendar c = Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        c.set(Calendar.MINUTE,minute);
                        c.setTimeZone(TimeZone.getDefault());
                        SimpleDateFormat format = new SimpleDateFormat("k:mm a");
                        String time = format.format(c.getTime());
                        texttotime.setText(time);
                    }
                },hours,min,false);
                timePickerDialog.show();
            }
        });
        btnbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fromdate1 = textfromdate.getText().toString();
                String todate1 = texttodate.getText().toString();
                String fromtime1 = textfromtime.getText().toString();
                String totime1 = texttotime.getText().toString();
                String location1 = txtlocation.getText().toString();
                String people1 = txtpeople.getText().toString();
                if (fromdate1.equals("") || todate1.equals("") || fromtime1.equals("") || totime1.equals("") || location1.equals("") || people1.equals("")){
                    Toast.makeText(getApplicationContext(),"Please,Select Date and Time...",Toast.LENGTH_SHORT).show();
                }
                else {
                    String fromdate = textfromdate.getText().toString();
                    String todate = texttodate.getText().toString();
                    String fromtime = textfromtime.getText().toString();
                    String totime = texttotime.getText().toString();
                    String location = txtlocation.getText().toString();
                    String people = txtpeople.getText().toString();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("FDATE", fromdate);
                    editor.putString("TDATE", todate);
                    editor.putString("FTIME", fromtime);
                    editor.putString("TTIME", totime);
                    editor.putString("LOCATION", location);
                    editor.putString("PEOPLE", people);
                    editor.apply();
                    Intent intent = new Intent(getApplicationContext(), txi_book.class);
                    startActivity(intent);
                }
            }
        });

    }
}