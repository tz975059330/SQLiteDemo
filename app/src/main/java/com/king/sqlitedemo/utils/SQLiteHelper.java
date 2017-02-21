package com.king.sqlitedemo.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 16230 on 2017/2/21.
 * Sqlite数据库帮助类
 */

public class SQLiteHelper extends SQLiteOpenHelper{
    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public SQLiteHelper(Context context){
        super(context,Constant.DATABASE_NAME,null,Constant.DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table "+ Constant.TABLE_NAME+"("+Constant._ID+" Integer primary key,"+Constant.NAME+" varchar(20))";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
