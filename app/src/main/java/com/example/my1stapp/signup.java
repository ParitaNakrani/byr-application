package com.example.my1stapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    private TextView _login_ek1;
    private EditText txtsuname;
    private EditText txtphone;
    private EditText txtspassword;
    private EditText txtcpassword;
    private Button btnsignup;
    boolean passwordVisible;
    DBHelper DB;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color._bg___1_ek2_color));

        _login_ek1 = (TextView) findViewById(R.id._login_ek1);
        EditText txtsuname = findViewById(R.id.txtsuname);
        EditText txtphone = findViewById(R.id.txtphone);
        EditText txtspassword = findViewById(R.id.txtspassword);
        EditText txtcpassword = findViewById(R.id.txtcpassword);
        Button btnsignup = findViewById(R.id.btnsignup);
        sharedPreferences = getSharedPreferences("SHARED_PREF",MODE_PRIVATE);

        txtspassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right=2;
                if (event.getAction()==MotionEvent.ACTION_UP){
                    if (event.getRawX()>=txtspassword.getRight()-txtspassword.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=txtspassword.getSelectionEnd();
                        if (passwordVisible){
                            txtspassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_sharp_visibility_off_24,0);
                            txtspassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        }else {
                            txtspassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_round_visibility_24,0);
                            txtspassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        txtspassword.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        txtcpassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right=2;
                if (event.getAction()==MotionEvent.ACTION_UP){
                    if (event.getRawX()>=txtcpassword.getRight()-txtcpassword.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=txtcpassword.getSelectionEnd();
                        if (passwordVisible){
                            txtcpassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_sharp_visibility_off_24,0);
                            txtcpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        }else {
                            txtcpassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_round_visibility_24,0);
                            txtcpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        txtcpassword.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        DB = new DBHelper(this);

            _login_ek1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });
            btnsignup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String user = txtsuname.getText().toString();
                    String pass = txtspassword.getText().toString();
                    String repass = txtcpassword.getText().toString();
                    String mobile = txtphone.getText().toString();

                    if(user.equals("") || pass.equals("") || repass.equals("") || mobile.equals(""))
                    {
                        Toast.makeText(signup.this,"Please enter all the feilds.",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if(pass.equals(repass)){
                           Boolean checkuser = DB.checkusername(user);
                           if(checkuser == false)
                           {
                              Boolean insert =  DB.insertData(user,pass,mobile);
                              if(insert == true)
                              {
                                  String uname=txtsuname.getText().toString();
                                  SharedPreferences.Editor editor = sharedPreferences.edit();
                                  editor.putString("UName",uname);

                                  editor.apply();
                                  Toast.makeText(signup.this,"Registration succesfully",Toast.LENGTH_SHORT).show();
                                  Intent intent = new Intent(getApplicationContext(),Home_Page.class);
                                  intent.putExtra("USERNAME",user);
                                  startActivity(intent);
                              }
                              else
                              {
                                  Toast.makeText(signup.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                              }
                           }
                           else {
                               Toast.makeText(signup.this,"User already exist.\n Please Sign In",Toast.LENGTH_SHORT).show();
                           }
                        }
                        else
                        {
                            Toast.makeText(signup.this,"Password not matching",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });

        }
    }
