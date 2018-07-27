package com.example.sanso.projetofinal1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * Created by sanso on 17/04/2018.
 */

public class PranchaDAO {

    private DBHelper helper;
    private DBGateway gateway;

    public PranchaDAO(Context context){
        gateway = DBGateway.getInstance(context);
    }

    public boolean salvarPrancha(Prancha prancha){

        ContentValues values = new ContentValues();
        long resultado;

        values.put(helper.MARCA, prancha.getMarca());
        values.put(helper.MODELO,prancha.getModelo());
        values.put(helper.COR,prancha.getCor());
        values.put(helper.TAMANHO,prancha.getTamanho());
        values.put(helper.PRECO,prancha.getPreco());
        values.put(helper.SITUACAO,prancha.getSituacao());
        values.put(helper.OBS,prancha.getObs());

        resultado = gateway.getDataBase().insert(helper.TABELA, null, values);

        if(resultado > 0){
            return true;
        }

        return false;
    }


    public void carregarPranchas(){

        Cursor cursor = gateway.getDataBase().rawQuery("SELECT * FROM " + helper.TABELA,null);

        try {

            cursor.moveToFirst();

            while (cursor !=null){

                int id = cursor.getInt(cursor.getColumnIndex(helper.ID));
                String marca = cursor.getString(cursor.getColumnIndex(helper.MARCA));
                String modelo = cursor.getString(cursor.getColumnIndex(helper.MODELO));
                String cor = cursor.getString(cursor.getColumnIndex(helper.COR));
                double tamanho = cursor.getDouble(cursor.getColumnIndex(helper.TAMANHO));
                double preco = cursor.getDouble(cursor.getColumnIndex(helper.PRECO));
                String situacao = cursor.getString(cursor.getColumnIndex(helper.SITUACAO));
                String obs = cursor.getString(cursor.getColumnIndex(helper.OBS));

                ListaPranchas.addPrancha(new Prancha(id,marca,modelo,cor,tamanho,preco,situacao,obs));
                cursor.moveToNext();
            }
            cursor.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public boolean excluirPrancha(int id){

        //Esse ? vai ser substituido por um dos valores que serão indicados depois.
        String where = helper.ID + " = ? ";
        //O Android pede que seja um vetor
        String[] args = {String.valueOf(id)};

        long resultado;

        resultado = gateway.getDataBase().delete(helper.TABELA,where,args);

        if (resultado > 0){
            return  true;
        }

        return false;

    }

    public boolean atualizarPrancha (Prancha pracha){

        String where = helper.ID + " = ? ";
        String[] args = {String.valueOf(pracha.getId())};
        ContentValues values = new ContentValues();

        values.put(helper.MARCA,pracha.getMarca());
        values.put(helper.MODELO, pracha.getModelo());
        values.put(helper.COR,pracha.getCor());
        values.put(helper.TAMANHO,pracha.getTamanho());
        values.put(helper.PRECO, pracha.getPreco());
        values.put(helper.SITUACAO,pracha.getSituacao());
        values.put(helper.OBS,pracha.getObs());

        long resultado;

        resultado = gateway.getDataBase().update(helper.TABELA,values,where,args);

        if (resultado > 0){
            return  true;
        }

        return false;
    }
}

