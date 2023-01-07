package com.example.my1stapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Profile extends AppCompatActivity {

    TextView textuser;
    SharedPreferences preferences;
    private TextInputEditText txtprofile;
    private Button btnupdate,btndelete;
    private TextInputEditText txtmobile;
    private TextInputEditText txtpassword;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.actionbar)));
        getSupportActionBar().setTitle("Pofile");
        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color._bg___1_ek2_color));

        textuser = findViewById(R.id.textuser);
        txtprofile = findViewById(R.id.txtprofile);
        txtmobile = findViewById(R.id.txtmobile);
        txtpassword = findViewById(R.id.txtpassword);
        btnupdate = findViewById(R.id.btnupdate);
        btndelete = findViewById(R.id.btndelete);
        preferences = getSharedPreferences("SHARED_PREF",MODE_PRIVATE);
        DB = new DBHelper(this);

        String uname = preferences.getString("UName",null);

        textuser.setText(uname);
        txtprofile.setText(uname);

//        String uname = preferences.getString("UNAME",null);
//        textuser.setText(uname);

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=txtprofile.getText().toString();
                String mobile=txtmobile.getText().toString();
                String password=txtpassword.getText().toString();
                Boolean i = DB.UpdateMobile(username,password,mobile);
                if (i==true)
                    Toast.makeText(Profile.this,"Profile Updated Successfully",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Profile.this,"Profile not Updated",Toast.LENGTH_LONG).show();
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = txtprofile.getText().toString();
                String mobile = txtmobile.getText().toString();
                String pass = txtpassword.getText().toString();
                boolean checkdeletedata = DB.deletedata(user, mobile, pass);
                if (checkdeletedata == true) {
                    Toast.makeText(Profile.this, "User Deleted succesfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), signup.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Profile.this, "user not Deleted", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), Profile.class);
                    startActivity(intent);
                }
            }
        });
    }
}