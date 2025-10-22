package com.tecdes.aluguel.model;

public class AluguelTemporada extends AluguelDiario{

    public AluguelTemporada(int diasAluguel, double valorDiario) {
        super(diasAluguel, valorDiario);
    }

    @Override
    public String calcular() {
        // Cálculo do total do aluguel de acordo com o valor e os meses
        double totalAluguel = getValorDiario() * getDiasAluguel();

        // String formatada para a mensagem de exibição do aluguel
        String msg = String.format("Aluguel em temporada de %d dias realizado no valor de R$%.2f/dia, resultado no total de R$%.2f.", getDiasAluguel(), getValorDiario(), totalAluguel);

        // Retorno da mensagem formatada
        return msg;
    }

}
