package com.example.sanso.projetofinal1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CadastrarActivity extends AppCompatActivity {

    int id;
    String marca;
    String modelo;
    String cor;
    double tamanho;
    double preco;
    String situacao;
    String obs;
    boolean atualizar;
    String radioSituacao;
    Prancha prancha;
    String msg;
    PranchaDAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        final EditText editTextMarca = findViewById(R.id.editTextMarca);
        final EditText editTextModelo = findViewById(R.id.editTextModelo);
        final EditText editTextCor = findViewById(R.id.editTextCor);
        final EditText editTextTamanho = findViewById(R.id.editTextTamanho);
        final EditText editTextPreco = findViewById(R.id.editTextPreco);
        final EditText editTextObs = findViewById(R.id.editTextObs);
        final RadioButton radioButtonNova = findViewById(R.id.radioButtonNova);
        final RadioButton radioButtonUsada = findViewById(R.id.radioButtonUsada);
        final RadioGroup radioG = findViewById(R.id.radioG);
        final Button btnSalvar = findViewById(R.id.btnSalvar);
        final Button btnVoltar = findViewById(R.id.btnVoltar);
        final TextView txtTitulo = findViewById(R.id.txtTitulo);






        dao = new PranchaDAO(getApplicationContext());
        final Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        atualizar = false;

        txtTitulo.setText("NOVA PRANCHA");

        if (bundle != null){

            txtTitulo.setText("ATUALIZAR PRANCHA");

            atualizar = true;

            // variáveis globais recebem valores do bundle:
            id = bundle.getInt("id");
            marca = bundle.getString("marca");
            modelo = bundle.getString("modelo");
            cor = bundle.getString("cor");
            tamanho = bundle.getDouble("tamanho");
            preco = bundle.getDouble("preco");
            situacao = bundle.getString("situacao");
            obs = bundle.getString("obs");

            editTextMarca.setText(marca.toString());
            editTextModelo.setText(modelo.toString());
            editTextCor.setText(cor.toString());
            editTextTamanho.setText(String.valueOf(tamanho));
            editTextPreco.setText(String.valueOf(preco));

            if (situacao.equals("Nova")){
                radioButtonNova.setChecked(true);
            }else {
                radioButtonUsada.setChecked(true);

            }
            editTextObs.setText(String.valueOf(obs));
        }

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                radioSituacao = ((RadioButton)findViewById(radioG.getCheckedRadioButtonId())).getText().toString();


                if(!editTextMarca.getText().toString().equals("") && !editTextModelo.getText().toString().equals("")
                        && !editTextCor.getText().toString().equals("") && !editTextTamanho.getText().toString().equals("")
                        && !editTextPreco.getText().toString().equals("")) {

                    try {


                        marca = editTextMarca.getText().toString();
                        modelo = editTextModelo.getText().toString();
                        cor = editTextCor.getText().toString();
                        tamanho = Double.parseDouble(editTextTamanho.getText().toString());
                        preco = Double.parseDouble(editTextPreco.getText().toString());
                        situacao = radioSituacao.toString();
                        obs = editTextObs.getText().toString();

                        if (atualizar){

                            prancha = new Prancha(id, marca, modelo, cor, tamanho, preco, situacao, obs);

                             if(dao.atualizarPrancha(prancha)){
                                 msg = "Prancha atualizada com sucesso!";
                            }else {
                                 msg = "Erro ao atualizar prancha...";
                             }

                        }else {


                            prancha = new Prancha(0,marca,modelo,cor,tamanho,preco,situacao,obs);


                            if (dao.salvarPrancha(prancha)){
                                msg= "Prancha cadastrada com sucesso!";
                            }else {
                                msg = "Erro ao cadastrar prancha...";
                            }
                        }

                        Toast.makeText(CadastrarActivity.this, msg, Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));

                    } catch (NullPointerException e) {
                        e.printStackTrace();
                        Toast.makeText(CadastrarActivity.this, "Erro ao cadastrar prancha...", Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(CadastrarActivity.this, "Alguns campos ainda não foram preenchidos", Toast.LENGTH_LONG).show();
                }



            }
        });



        btnVoltar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }

        });

    }

}

