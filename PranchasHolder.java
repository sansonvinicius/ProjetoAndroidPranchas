package com.example.sanso.projetofinal1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by sanso on 17/04/2018.
 */

public class PranchasHolder extends RecyclerView.ViewHolder {

    TextView txtMarca;
    TextView txtModelo;
    TextView txtVisualizar;

    public PranchasHolder(View itemView) {
        super(itemView);

        txtMarca = itemView.findViewById(R.id.txtMarca);
        txtModelo = itemView.findViewById(R.id.txtModelo);
        txtVisualizar = itemView.findViewById(R.id.txtVisualizar);
    }
}
