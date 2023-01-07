package com.example.my1stapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgotPasswordPhone extends AppCompatActivity {

    private EditText txtphone2;
    private EditText txtnewpwd2;
    private Button btnnext2;
    private TextView _username2;
    private TextView _back_to_login2;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_phone);

        TextView _back_to_login2 = findViewById(R.id._back_to_login2);
        EditText txtphone2 = findViewById(R.id.txtphone2);
        EditText txtnewpwd2 = findViewById(R.id.txtnewpwd2);
        Button btn_next2 = findViewById(R.id.btnnext2);
        TextView _username2 = findViewById(R.id._username2);
        DB = new DBHelper(this);

        _username2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ForgotPassword.class);
                startActivity(intent);
            }
        });
        btn_next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = txtphone2.getText().toString();
                String pass = txtnewpwd2.getText().toString();
                Boolean i = DB.UpdatePassword(user,pass);
                if (i==true)
                {
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(ForgotPasswordPhone.this,"Password Updated succesfully",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(ForgotPasswordPhone.this,"Password Not Updated ",Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        _back_to_login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}