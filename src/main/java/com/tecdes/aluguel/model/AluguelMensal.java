package com.tecdes.aluguel.model;

public abstract class AluguelMensal implements Aluguel{
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
