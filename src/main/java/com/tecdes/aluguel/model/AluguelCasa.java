package com.tecdes.aluguel.model;

public class AluguelCasa extends AluguelMensal{

    public AluguelCasa(double valorMensal, int qntMeses) {
            super(valorMensal, qntMeses);
        }
    
    // Implementação do método da interface Aluguel com particularidades do AluguelCasa
    @Override
    public String calcular() {
        // Cálculo do total do aluguel de acordo com o valor e os meses
        double totalAluguel = getValorMensal() * getQntMeses();

        // String formatada para a mensagem de exibição do aluguel
        String msg = String.format("Aluguel de casa de %d meses realizado no valor de R$%.2f/mês, resultado no total de R$%.2f.", getQntMeses(), getValorMensal(), totalAluguel);

        // Retorno da mensagem formatada
        return msg;
    }

}
