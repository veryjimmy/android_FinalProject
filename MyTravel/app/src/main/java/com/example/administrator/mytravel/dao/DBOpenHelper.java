package com.example.administrator.mytravel.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBOpenHelper extends SQLiteOpenHelper{
    private static final int VERSION = 1;
    private static final String DBNAME = "travel.db";



    public DBOpenHelper(Context context) {
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tb_act (_id integer primary key ,username varchar(100) ,actTitle varchar(100), actAddress varchar(100), actNum varchar(100), actTime varchar(60), actContent varchar(100), actImageUri varchar(100))");
        db.execSQL("create table tb_strategy(_id integer primary key, username varchar(100) , strategyTitle varchar(100), strategyContent varchar(100), strategyImageUri varchar(100))");

//        db.execSQL("create table tb_outaccount (_id integer primary key,money decimal,time varchar(10),"
//                + "type varchar(10),address varchar(100),mark varchar(200))");// 创建支出信息表

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
