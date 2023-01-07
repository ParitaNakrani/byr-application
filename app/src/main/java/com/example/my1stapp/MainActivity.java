package com.example.my1stapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class  MainActivity extends AppCompatActivity {

    private EditText txtuname;
    private EditText txtpassword;
    private Button btnlogin;
    private TextView _forgotten_password_;
    private TextView _sign_up;
    CheckBox mRemember;
    boolean passwordVisible;
    boolean isRemembered = false;
    String userStr;
    DBHelper DB;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color._bg___1_ek2_color));

        TextView _forgotten_password_ = findViewById(R.id._forgotten_password_);
        EditText txtpassword = findViewById(R.id.txtpassword);
        EditText txtuname = findViewById(R.id.txtuname);
        Button btnlogin = findViewById(R.id.btnlogin);
        mRemember = findViewById(R.id.checkBox);
        TextView _sign_up = findViewById(R.id._sign_up);

        sharedPreferences = getSharedPreferences("SHARED_PREF",MODE_PRIVATE);

        isRemembered = sharedPreferences.getBoolean("CHECKBOX",false);

        if (isRemembered){
            Intent intent = new Intent(MainActivity.this, Home_Page.class);
            startActivity(intent);
        }

        txtpassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right=2;
                if (event.getAction()==MotionEvent.ACTION_UP){
                    if (event.getRawX()>=txtpassword.getRight()-txtpassword.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=txtpassword.getSelectionEnd();
                        if (passwordVisible){
                            txtpassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_sharp_visibility_off_24,0);
                            txtpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        }else {
                            txtpassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_round_visibility_24,0);
                            txtpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        txtpassword.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        DB = new DBHelper(this);

        _forgotten_password_.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ForgotPassword.class);
                startActivity(intent);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String user = txtuname.getText().toString();
                String pass = txtpassword.getText().toString();

                if (TextUtils.isEmpty(txtuname.getText().toString())){
                    txtuname.setError("Email is Compalsory");
                    return;
                }

                if (TextUtils.isEmpty(txtpassword.getText().toString())){
                    txtpassword.setError("Password is Compalsory");
                    return;
                }

                if (user.equals("") || pass.equals("")) {
                    Toast.makeText(MainActivity.this, "Please Enter the Credential", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkuserpass = DB.checkusernamepass(user, pass);

                    if (checkuserpass == true) {
                        String uname=txtuname.getText().toString();
                        boolean checked = mRemember.isChecked();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("UName",uname);
                        editor.putBoolean("CHECKBOX",checked);
                        editor.apply();
                        Toast.makeText(MainActivity.this, "Sign in succesfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Home_Page.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, "Invalid Credatial", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        _sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),signup.class);
                startActivity(intent);

            }
        });
    }
}