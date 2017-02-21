package com.king.sqlitedemo.utils;

import android.content.Context;

/**
 * Created by 16230 on 2017/2/21.
 */

public class DBManger {
    private static SQLiteHelper helper;
    public static SQLiteHelper getIntance(Context context){
        if(helper == null){
            helper = new SQLiteHelper(context);
        }
        return helper;
    }
}
