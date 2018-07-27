package com.example.sanso.projetofinal1;

/**
 * Created by sanso on 17/04/2018.
 */

public class Prancha {

    private int id;
    private String marca;
    private String modelo;
    private String cor;
    private double tamanho;
    private double preco;
    private String situacao;
    private String obs;

    public Prancha(int id, String marca, String modelo, String cor, double tamanho, double preco, String situacao, String obs) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.tamanho = tamanho;
        this.preco = preco;
        this.situacao = situacao;
        this.obs = obs;
    }

    public int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public double getTamanho() {
        return tamanho;
    }

    public double getPreco() {
        return preco;
    }

    public String getSituacao() {
        return situacao;
    }

    public String getObs() {
        return obs;
    }

    @Override
    public String toString() {
        return this.marca;
    }
}
