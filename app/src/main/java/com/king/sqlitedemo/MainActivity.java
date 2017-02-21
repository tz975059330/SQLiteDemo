package com.king.sqlitedemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.king.sqlitedemo.utils.Constant;
import com.king.sqlitedemo.utils.DBManger;
import com.king.sqlitedemo.utils.SQLiteHelper;

public class MainActivity extends AppCompatActivity {
    private SQLiteHelper helper;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = DBManger.getIntance(this);
    }

    /**
     * 创建数据库
     */
    public void createDb(View view){
        helper = DBManger.getIntance(this);
        helper.getReadableDatabase();
    }
    public void addData(View view){
        db = helper.getReadableDatabase();
        ContentValues values = null;
        long result = 0;
        for(int i = 1;i<=5;i++){
            values = new ContentValues();
            values.put(Constant._ID,i);
            values.put(Constant.NAME,"张三"+i);
            result = db.insert(Constant.TABLE_NAME,null,values);
            if(result >0){
                Log.d("tag","插入数据成功");
            }else{
                Log.d("tag","插入数据失败");
                break;
            }
        }
        db.close();
    }
    public void deleteData(View view){
        db = helper.getReadableDatabase();
        int result = db.delete(Constant.TABLE_NAME,"_id=1",null);
        if(result>0){
            Log.d("tag","删除数据成功");
        }else {
            Log.d("tag","删除数据失败");
        }
        db.close();
    }
    public void updateData(View view){
        db = helper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constant.NAME,"张四");
        int result = db.update(Constant.TABLE_NAME,values,"_id=3",null);
        if(result>0){
            Log.d("tag","修改成功");
        }else {
            Log.d("tag","修改失败");
        }
        db.close();
    }
    public void queryData(View view){
        db = helper.getReadableDatabase();
        Cursor cursor =db.rawQuery("select * from "+Constant.TABLE_NAME,null);
        while(cursor.moveToNext()){
            int id = cursor.getColumnIndex(Constant._ID);
            int name = cursor.getColumnIndex(Constant.NAME);
            Log.d("tag","id "+cursor.getInt(id)+" name "+cursor.getString(name));
        }
        db.close();
    }
    public void clearData(View view){
        db = helper.getReadableDatabase();
        int result = db.delete(Constant.TABLE_NAME,null,null);
        if(result>0){
            Log.d("tag","清空成功");
        }else {
            Log.d("tag","清空失败");
        }
        db.close();
    }
}
