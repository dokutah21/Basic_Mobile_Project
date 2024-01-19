package com.example.quanlybansach;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    public static final String DBName = "CafeNos.db";

    public static final int DB_Version = 1;


    public DatabaseHelper(@Nullable Context context) {
        super(context, DBName, null, 1);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Account(username TEXT primary key, password TEXT)");
        sqLiteDatabase.execSQL("create table Cafe(CafeID TEXT primary key, CafeName TEXT)");
        sqLiteDatabase.execSQL("create table CafeSeed(SeedID TEXT primary key, SeedName TEXT)");
        sqLiteDatabase.execSQL("create table Employee(EmployeeID TEXT primary key, EmployeeName TEXT)");
        sqLiteDatabase.execSQL("create table SellTotal(SellTotalID TEXT primary key, CustomerName TEXT, TotalPrice TEXT, foreign key (EmployeeID) references Employee(EmployeeID))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Account");
        sqLiteDatabase.execSQL("drop table if exists Cafe");
        sqLiteDatabase.execSQL("drop table if exists CafeSeed");
        sqLiteDatabase.execSQL("drop table if exists Employee");
        sqLiteDatabase.execSQL("drop table if exists SellTotal");
    }
    public boolean insertDataAccount(String username, String password)
    {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = myDB.insert("Account", null, contentValues);
        if (result==-1) return false;
        else return true;
    }

    public boolean checkUsername(String username){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from Account where username = ?", new String[]{username});
        if (cursor.getCount()>0)
            return true;
        else return false;
    }

    public boolean checkUser(String Username, String Password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from Account where username = ? and password = ?", new String[]{Username, Password});
        if (cursor.getCount()>0)
            return true;
        else return false;
    }

    public void insert(String CafeID, String CafeName){
        try{
            SQLiteDatabase db = getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("CafeID", CafeID);
            contentValues.put("CafeName", CafeName);

            db.insert("Cafe", null, contentValues);
        }catch (Exception ignored){}
    }

    public void update(String CafeID, String CafeName){
        try{
            SQLiteDatabase db = getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("CafeName", CafeName);

            db.update("Cafe",contentValues, "CafeID = ?", new String[]{CafeID});
        }catch (Exception ex){}
    }

    public void delete(String CafeID){
        try{
            SQLiteDatabase db = getWritableDatabase();

            db.delete("Cafe", "CafeID = ?", new String[]{CafeID});
        }catch (Exception ex){}
    }

    public String search(String CafeID) {
        try {
            String value = "";
            SQLiteDatabase db = getReadableDatabase();

            Cursor cursor = db.query("Cafe",
                    new String[]{"CafeName"},
                    "CafeID = ?",
                    new String[]{CafeID},
                    null, null, null, null);

            if (cursor != null && cursor.moveToNext()) {
                cursor.moveToFirst();

                value = cursor.getString(0);

                cursor.close();
            }
            return value;
        } catch (Exception ex) {
        }

        return "";
    }

    public void insertSeed(String SeedID, String SeedName){
        try{
            SQLiteDatabase db = getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("SeedID", SeedID);
            contentValues.put("SeedName", SeedName);

            db.insert("CafeSeed", null, contentValues);
        }catch (Exception ignored){}
    }

    public void updateSeed(String SeedID, String SeedName){
        try{
            SQLiteDatabase db = getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("SeedName", SeedName);

            db.update("CafeSeed",contentValues, "SeedID = ?", new String[]{SeedID});
        }catch (Exception ex){}
    }

    public void deleteSeed(String SeedID){
        try{
            SQLiteDatabase db = getWritableDatabase();

            db.delete("CafeSeed", "SeedID = ?", new String[]{SeedID});
        }catch (Exception ex){}
    }

    public String searchSeed(String SeedID) {
        try {
            String value = "";
            SQLiteDatabase db = getReadableDatabase();

            Cursor cursor = db.query("CafeSeed",
                    new String[]{"SeedName"},
                    "SeedID = ?",
                    new String[]{SeedID},
                    null, null, null, null);

            if (cursor != null && cursor.moveToNext()) {
                cursor.moveToFirst();

                value = cursor.getString(0);

                cursor.close();
            }
            return value;
        } catch (Exception ex) {
        }
        return "";
    }

    public Cursor getAllDataCafe() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM Cafe";
        return db.rawQuery(selectQuery, null);
    }

    public Cursor getAllDataEmpl() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM Cafe";
        return db.rawQuery(selectQuery, null);
    }

    public void insertEmpl(String EmployeeID, String EmployeeName){
        try{
            SQLiteDatabase db = getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("EmployeeID", EmployeeID);
            contentValues.put("EmployeeName", EmployeeName);

            db.insert("Employee", null, contentValues);
        }catch (Exception ignored){}
    }

    public void updateEmpl(String EmployeeID, String EmployeeName){
        try{
            SQLiteDatabase db = getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("EmployeeName", EmployeeName);

            db.update("Employee",contentValues, "EmployeeID = ?", new String[]{EmployeeID});
        }catch (Exception ex){}
    }

    public void deleteEmpl(String EmployeeID){
        try{
            SQLiteDatabase db = getWritableDatabase();

            db.delete("Employee", "Employee = ?", new String[]{EmployeeID});
        }catch (Exception ex){}
    }

    public String searchEmpl(String EmployeeID) {
        try {
            String value = "";
            SQLiteDatabase db = getReadableDatabase();

            Cursor cursor = db.query("Employee",
                    new String[]{"EmployeeName"},
                    "EmployeeID = ?",
                    new String[]{EmployeeID},
                    null, null, null, null);

            if (cursor != null && cursor.moveToNext()) {
                cursor.moveToFirst();

                value = cursor.getString(0);

                cursor.close();
            }
            return value;
        } catch (Exception ex) {
        }
        return "";
    }

//    public void insertTotal(String SellTotalID, String CustomerName, String TotalPrice){
//        try{
//            SQLiteDatabase db = getWritableDatabase();
//
//            ContentValues contentValues = new ContentValues();
//            contentValues.put("SellTotalID", SellTotalID);
//            contentValues.put("CustomerName", CustomerName);
//            contentValues.put("TotalPrice", TotalPrice);
//
//            db.insert("SellTotal", null, contentValues);
//        }catch (Exception ignored){}
//    }
//
//    public void updateTotal(String SellTotalID, String CustomerName, String TotalPrice){
//        try{
//            SQLiteDatabase db = getWritableDatabase();
//
//            ContentValues contentValues = new ContentValues();
//            contentValues.put("CustomerName", CustomerName);
//            contentValues.put("TotalPrice", TotalPrice);
//
//            db.update("SellTotal",contentValues, "SellTotalID = ?", new String[]{SellTotalID});
//        }catch (Exception ex){}
//    }
//
//    public void deleteTotal(String SellTotalID){
//        try{
//            SQLiteDatabase db = getWritableDatabase();
//
//            db.delete("SellTotal", "SellTotalID = ?", new String[]{SellTotalID});
//        }catch (Exception ex){}
//    }
//
//    public String searchTotal(String SellTotalID) {
//        try {
//            String value = "";
//            SQLiteDatabase db = getReadableDatabase();
//
//            Cursor cursor = db.query("SellTotal",
//                    new String[]{"CustomerName", "TotalPrice"},
//                    "SellTotalID = ?",
//                    new String[]{SellTotalID},
//                    null, null, null, null);
//
//            if (cursor != null && cursor.moveToNext()) {
//                cursor.moveToFirst();
//
//                value = cursor.getString(0);
//
//                cursor.close();
//            }
//            return value;
//        } catch (Exception ex) {
//        }
//
//        return "";
//    }

}