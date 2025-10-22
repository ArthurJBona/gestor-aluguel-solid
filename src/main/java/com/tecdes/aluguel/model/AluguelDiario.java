package com.tecdes.aluguel.model;

// Classe abstrata que implementa interface de Aluguel, permite existir aluguel mensal e outros tipos de aluguel
public abstract class AluguelDiario implements Aluguel{
    // Parâmetro que serão utilizados pelos diferentes tipos de aluguel, ao invés de ser utilizados parâmetros
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
