package com.tecdes.aluguel.controller;

import java.util.List;

import com.tecdes.aluguel.model.Aluguel;
import com.tecdes.aluguel.repository.AluguelRepository;

public class AluguelController {
    AluguelRepository repository;

    public AluguelController() {
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

    public void limparHistorico() {
        repository.limparHistorico();
    }
}
