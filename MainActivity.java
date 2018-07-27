package com.example.sanso.projetofinal1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView rclPranchas = findViewById(R.id.rclPranchas);
        final Button btnAddPrancha = findViewById(R.id.btnAddPrancha);

        if(ListaPranchas.getTamanhoListaPranchas() > 0 ){
            ListaPranchas.getListaPranchas().clear();
        }

        PranchaDAO dao = new PranchaDAO(getApplicationContext());
        dao.carregarPranchas();

        PranchasAdapter pranchasAdapter = new PranchasAdapter(ListaPranchas.getListaPranchas(),getApplicationContext());

        rclPranchas.setAdapter(pranchasAdapter);

        RecyclerView.LayoutManager meuLayout = new LinearLayoutManager(
                getApplicationContext(),LinearLayoutManager.VERTICAL,
                false);

        rclPranchas.setLayoutManager(meuLayout);

        btnAddPrancha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),CadastrarActivity.class));
            }
        });
    }
}
