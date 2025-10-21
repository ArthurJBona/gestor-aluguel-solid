package com.tecdes.aluguel.model;

public class AluguelComercial extends AluguelMensal{

    public AluguelComercial(double valorMensal, int qntMeses) {
            super(valorMensal, qntMeses);
        }
    
    // Implementação do método da interface Aluguel com particularidades de AluguelComercial
    @Override
    public String calcular() {
        // Cálculo do total do aluguel de acordo com o valor e os meses
        double valorAluguel = getValorMensal() * getQntMeses();

        // Cálculo do valor do IPTU, particularidade do aluguel de estabelecimento comercial
        double valorIptu = valorAluguel * 0.05; // O valor do IPTU corresponde a 5% do valor total

        // Total do aluguel, considerando o valor do condomínio
        double totalAluguel = valorAluguel + valorIptu;

        // String formatada para a mensagem de exibição do aluguel
        String msg = String.format("Aluguel comercial de %d meses realizado no valor de R$%.2f/mês, com adição de R$%.2f de IPTU, resultando no total de R$%.2f.", getQntMeses(), getValorMensal(), valorIptu, totalAluguel);

        // Retorno da mensagem formatada
        return msg;
    }
}
