package com.tecdes.aluguel.model;

// Classe abstrata que implementa interface de Aluguel, permite existir aluguel diário e outros tipos de aluguel
public abstract class AluguelMensal implements Aluguel{
    // Atributos utilizados na função de cálculo ao invés de parâmetros
    private double valorMensal;
    private int qntMeses;


    public AluguelMensal(double valorMensal, int qntMeses) {
        this.valorMensal = valorMensal;
        this.qntMeses = qntMeses;
    }


    public double getValorMensal() {
        return valorMensal;
    }


    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }


    public int getQntMeses() {
        return qntMeses;
    }


    public void setQntMeses(int qntMeses) {
        this.qntMeses = qntMeses;
    }
}
