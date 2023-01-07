package com.example.my1stapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login1.db";
    private String username;

    public DBHelper(Context context) {
        super(context, "Login2.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create Table users(username Text primary key,password Text,mobile String)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {
        myDB.execSQL("drop Table if exists users");
    }
    public Boolean UpdatePassword(String username, String password){
        SQLiteDatabase myDb = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",username);
        values.put("password",password);
        Cursor cursor = myDb.rawQuery("select * from users where username=?",new String[]{username});
        if (cursor.getCount()>0)
        {
            long r = myDb.update("users",values,"username=?",new String[]{username});
            if (r == -1) return false;
            else
                return true;
        }
        else
        {
            return false;
        }
    }

    public Boolean UpdateMobile(String username, String password, String mobile){
        SQLiteDatabase myDb = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("password",password);
        values.put("mobile",mobile);
        Cursor cursor = myDb.rawQuery("select * from users where username=?",new String[]{username});
        if (cursor.getCount()>0)
        {
            long r = myDb.update("users",values,"username=?",new String[]{username});
            if (r == -1) return false;
            else
                return true;
        }
        else
        {
            return false;
        }
    }

    public Boolean deletedata(String username, String password, String mobile) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where username=?",new String[]{username} );
        if (cursor.getCount() > 0){
            long result = myDB.delete("users", "username=?", new String[]{username});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return false;
        }
    }


    public Boolean UpdatePasswordPhone(String mobile,String password){
        SQLiteDatabase myDb = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("mobile",mobile);
        values.put("password",password);
        Cursor cursor = myDb.rawQuery("select * from users where mobile=?",new String[]{mobile});
        if(cursor.getCount()>0)
        {
            long r = myDb.update("users",values,"mobile=?",new String[]{mobile});
            if (r==-1)return false;
            else
                return true;
        }
        else
        {
            return false;
        }
    }

    public Boolean insertData(String username, String password, String mobile) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("mobile", mobile);
        long result = myDB.insert("users", null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkusername(String username) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Cursor ViewData(){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where username = ?",new String[]{username});
        return cursor;
    }

//    public Boolean checkusernamepass (String username, String password) {
//        SQLiteDatabase myDB = this.getWritableDatabase();
//        Cursor cursor = myDB.rawQuery("select * from users where username = ? and password = ?", new String[]{username, password});
//        if (cursor.getCount() > 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//}

    public Boolean checkusernamepass(String username,String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where username = ? and password = ?",new String[] {username,password});
        if(cursor.getCount()> 0)
        {
            return true;
        }
        else {
            return false;
        }
    }

}
