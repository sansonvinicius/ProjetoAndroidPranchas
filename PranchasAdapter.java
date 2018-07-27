package com.example.sanso.projetofinal1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by sanso on 17/04/2018.
 */

public class PranchasAdapter extends RecyclerView.Adapter {

    ArrayList<Prancha> listaPranchas;
    Context context;

    public PranchasAdapter(ArrayList<Prancha> listaPranchas, Context context) {
        this.listaPranchas = listaPranchas;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(context).inflate(R.layout.prancha_layout,parent,false);
        PranchasHolder holder = new PranchasHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        PranchasHolder pranchasHolder = (PranchasHolder)holder;
        pranchasHolder.txtMarca.setText(listaPranchas.get(position).getMarca());
        pranchasHolder.txtModelo.setText(listaPranchas.get(position).getModelo());
        pranchasHolder.txtVisualizar.setText("Visualizar");

        pranchasHolder.txtVisualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,DetalhesActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("index",position);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listaPranchas.size();
    }
}
