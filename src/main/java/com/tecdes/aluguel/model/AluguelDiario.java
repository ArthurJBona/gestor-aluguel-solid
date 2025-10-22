package com.tecdes.aluguel.model;

public abstract class AluguelDiario implements Aluguel{
    private int diasAluguel;
    private double valorDiario;

    
    public AluguelDiario(int diasAluguel, double valorDiario) {
        this.diasAluguel = diasAluguel;
        this.valorDiario = valorDiario;
    }


    public int getDiasAluguel() {
        return diasAluguel;
    }


    public void setDiasAluguel(int diasAluguel) {
        this.diasAluguel = diasAluguel;
    }


    public double getValorDiario() {
        return valorDiario;
    }


    public void setValorDiario(double valorDiario) {
        this.valorDiario = valorDiario;
    }

    
}
