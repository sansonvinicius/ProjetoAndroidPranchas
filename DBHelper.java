package com.example.sanso.projetofinal1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sanso on 17/04/2018.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB = "estoque";
    public static final String TABELA = "pranchas";
    public static final String ID = "id";
    public static final String MARCA = "marca";
    public static final String MODELO = "modelo";
    public static final String COR = "cor";
    public static final String TAMANHO = "tamanho" ;
    public static final String PRECO ="preco";
    public static final String SITUACAO = "situacao";
    public static final String OBS = "obs";
    public static final int VERSAO = 1;


    public DBHelper(Context context){
        super(context, DB, null, VERSAO);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + TABELA +
                "( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MARCA + " VARCHAR, " + MODELO + " VARCHAR, " + COR + " VARCHAR, " +
                TAMANHO + " double," + PRECO  + " double," + SITUACAO + " VARCHAR," + OBS +" VARCHAR);" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABELA);
        onCreate(sqLiteDatabase);

    }
}
