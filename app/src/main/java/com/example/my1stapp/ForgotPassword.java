package com.example.my1stapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class ForgotPassword extends AppCompatActivity {

    private EditText txtuname1;
    private EditText txtnewpwd;
    private Button btnnext1;
    private TextView _back_to_login;
//    private TextView _phone;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color._bg___1_ek2_color));
        TextView _back_to_login = findViewById(R.id._back_to_login);
        EditText txtuname1 = findViewById(R.id.txtuname1);
        EditText txtnewpwd = findViewById(R.id.txtnewpwd);
       // TextView _phone = findViewById(R.id._phone);
        Button btnnext1 = findViewById(R.id.btnnext1);

        DB = new DBHelper(this);

//        _phone.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(),ForgotPasswordPhone.class);
//                startActivity(intent);
//            }
//        });
        btnnext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = txtuname1.getText().toString();
                String pass = txtnewpwd.getText().toString();
                Boolean i = DB.UpdatePassword(user,pass);
                if (i==true)
                {
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(ForgotPassword.this,"Password Updated succesfully",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(ForgotPassword.this,"Password Not Updated ",Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        _back_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }
}