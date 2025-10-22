package com.tecdes.aluguel.controller;

import java.util.List;

import com.tecdes.aluguel.model.Aluguel;
import com.tecdes.aluguel.repository.AluguelRepository;

public class AluguelController {
    private AluguelRepository repository;

    public AluguelController() {
        // Injeção de dependência do repository
        this.repository = new AluguelRepository();
    }

    public String processarAluguel(Aluguel aluguel) {
        String registro = aluguel.calcular();
        repository.salvarRegistro(registro);
        System.out.println("Registro adicinado: " + registro); // Debug no terminal
        return registro;
    }

    public List<String> listarAlugueis() {
        List<String> alugueis = repository.lerRegistros();
        System.out.println("Lista de alugueis: " + alugueis); // Debug no terminal
        return alugueis;
    }

    // Método extra para funcionalidade de limpar histórico do txt pela interface
    public void limparHistorico() {
        repository.limparHistorico();
    }
}
