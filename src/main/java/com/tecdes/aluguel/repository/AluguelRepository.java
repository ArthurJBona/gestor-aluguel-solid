package com.tecdes.aluguel.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class AluguelRepository {
    
    private final File arquivo = new File("data/alugueis.txt");


    public synchronized void salvarRegistro(String registro) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true))) {
            bw.write(registro);
            bw.newLine();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public synchronized List<String> lerRegistros() {
        
        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
                
            }

            BufferedReader br = new BufferedReader(new FileReader(arquivo));


            List<String> linhas = new ArrayList<>();
            String linha;

            while ((linha = br.readLine()) != null) {
                linhas.add(linha);
            }

            br.close();
            return linhas;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo: " + e.getMessage());
            return null;
        }
    }

    public synchronized void limparHistorico() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            // Não escrevemos nada, apenas abrimos o arquivo, o que já apaga o conteúdo
            JOptionPane.showMessageDialog(null, "Histórico limpo com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao limpar o arquivo: " + e.getMessage());
        }
    }
}
