package com.example.sanso.projetofinal1;

import java.util.ArrayList;

/**
 * Created by sanso on 17/04/2018.
 */

public class ListaPranchas {

    private static ArrayList<Prancha> listaPranchas = new ArrayList<>();

    public static void addPrancha(Prancha prancha){
        listaPranchas.add(prancha);
    }

    public static int getTamanhoListaPranchas(){
        return listaPranchas.size();
    }

    public static ArrayList<Prancha>getListaPranchas(){
        return listaPranchas;
    }
}
