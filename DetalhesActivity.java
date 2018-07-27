package com.example.sanso.projetofinal1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class DetalhesActivity extends AppCompatActivity {

    Prancha prancha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        final TextView textViewId = findViewById(R.id.textViewId);
        final TextView textViewMarca = findViewById(R.id.textViewMarca);
        final TextView textViewModelo = findViewById(R.id.textViewModelo);
        final TextView textViewCor = findViewById(R.id.textViewCor);
        final TextView textViewTamanho = findViewById(R.id.textViewTamanho);
        final TextView textViewPreco = findViewById(R.id.textViewPreco);
        final TextView textViewSituacao = findViewById(R.id.textViewSituacao);
        final TextView textViewObs = findViewById(R.id.textViewObs);
        final Button btnVoltar = findViewById(R.id.btnVoltar);
        final Button btnExcluir = findViewById(R.id.btnExcluir);
        final Button btnEditar = findViewById(R.id.btnEditar);

        Intent intent = getIntent();
        int index = intent.getIntExtra("index", -1);



        if (index != -1){

             prancha = ListaPranchas.getListaPranchas().get(index);

            textViewId.setText("ID: " + String.valueOf(prancha.getId()));
            textViewMarca.setText("Marca: " + prancha.getMarca().toString());
            textViewModelo.setText("Modelo: " + prancha.getModelo().toString());
            textViewCor.setText("Cor: " + prancha.getCor().toString());
            textViewTamanho.setText("Tamanho: " + String.valueOf(prancha.getTamanho()).replace(',',  '.'));
            textViewPreco.setText("Preço: " + formatarPreco(prancha.getPreco()).replace(',', '.'));
            textViewSituacao.setText("Situação: " + prancha.getSituacao().toString());
            textViewObs.setText("Observação: " + prancha.getObs().toString());

            btnVoltar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(DetalhesActivity.this,MainActivity.class));
                }
            });

            btnExcluir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    PranchaDAO dao = new PranchaDAO(getApplicationContext());

                    String msg;

                    if(dao.excluirPrancha(prancha.getId())){
                        msg = "Prancha excluida com sucesso";
                    }else{
                        msg = "Erro ao exluir prancha...";
                    }

                    Toast.makeText(DetalhesActivity.this,msg,Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));

                }
            });

            btnEditar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intentEditar = new Intent(getApplicationContext(),CadastrarActivity.class);

                    Bundle bundle = new Bundle();

                    bundle.putInt("id", prancha.getId());
                    bundle.putString("marca", prancha.getMarca());
                    bundle.putString("modelo", prancha.getModelo());
                    bundle.putString("cor", prancha.getCor());
                    bundle.putDouble("tamanho", prancha.getTamanho());
                    bundle.putDouble("preco", prancha.getPreco());
                    bundle.putString("situacao", prancha.getSituacao());
                    bundle.putString("obs", prancha.getObs());

                    intentEditar.putExtras(bundle);

                    startActivity(intentEditar);
                }
            });




        }else{
            Toast.makeText(this,"Erro ao Carregar dados da prancha",Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }


    }


    private String formatarPreco(double preco){
        return String.format(Locale.FRANCE, "%.2f",preco);
    }
}

