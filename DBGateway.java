package com.example.sanso.projetofinal1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sanso on 17/04/2018.
 */

public class DBGateway{

    private static DBGateway dbGateway;
    private SQLiteDatabase sqLiteDatabase;


    private DBGateway(Context context){
        DBHelper helper = new DBHelper(context);
        sqLiteDatabase = helper.getWritableDatabase();
    }

    public static DBGateway getInstance(Context context){
        if(dbGateway == null){
            dbGateway = new DBGateway(context);
        }
        return  dbGateway;
    }

    public SQLiteDatabase getDataBase(){
        return this.sqLiteDatabase;
    }


}
