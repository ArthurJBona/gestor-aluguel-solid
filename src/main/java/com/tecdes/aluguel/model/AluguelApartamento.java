package com.tecdes.aluguel.model;

public class AluguelApartamento extends AluguelMensal {

    public AluguelApartamento(double valorMensal, int qntMeses) {
            super(valorMensal, qntMeses);
        }
    
    // Implementação do método da interface Aluguel com particularidades de AluguelApartamento
    @Override
    public String calcular() {
        // Cálculo do total do aluguel de acordo com o valor e os meses
        double valorAluguel = getValorMensal() * getQntMeses();

        // Cálculo do valor do condomínio, particularidade do aluguel de apartamento
        double valorCondominio = valorAluguel * 0.1; // O valor do condomínio corresponde a 10% do valor total

        // Total do aluguel, considerando o valor do condomínio
        double totalAluguel = valorAluguel + valorCondominio;

        // String formatada para a mensagem de exibição do aluguel
        String msg = String.format("Aluguel de apartamento de %d meses realizado no valor de R$%.2f/mês, com adição de R$%.2f do condomínio, resultando no total de R$%.2f.", getQntMeses(), getValorMensal(), valorCondominio, totalAluguel);

        // Retorno da mensagem formatada
        return msg;
    }

}
