package com.tecdes.aluguel.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.tecdes.aluguel.controller.AluguelController;
import com.tecdes.aluguel.model.Aluguel;
import com.tecdes.aluguel.model.AluguelCasa;
import com.tecdes.aluguel.model.AluguelComercial;
import com.tecdes.aluguel.model.AluguelTemporada;

public class AluguelForm extends JFrame{
    private AluguelController controller;

    private JTextArea jtaResultados;

    // Adição extra na string das opções
    private String[] opcoesTipoAluguel = {"Apartamento", "Casa", "Comercial", "Temporada"};

    public AluguelForm() {
        setSize(420,520);
        setTitle("Gestor de Aluguel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.controller = new AluguelController();
        initComponents();
        recarregarHistorico();
    }

    private void initComponents() {

        Font font = new Font("Serif", Font.BOLD, 14);

        // Painel principal com BoxLayout vertical
        JPanel pnlPrincipal = new JPanel();
        pnlPrincipal.setLayout(new GridLayout(3,1,10,10));
        pnlPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // margem interna
        
        JPanel pnlEntrada = new JPanel();
        pnlEntrada.setLayout(new GridLayout(3,2,10,10)); // 3 linhas, 2 colunas, espaçamento 10px
        pnlEntrada.setBorder(BorderFactory.createTitledBorder("Informações do Aluguel"));

        JLabel lblValor = new JLabel("Valor por período");
        JTextField jtfValor = new JTextField();

        JLabel lblMeses = new JLabel("Quantidade de períodos");
        JTextField jtfMeses = new JTextField();

        JLabel lblAluguel = new JLabel("Tipo do aluguel");
        JComboBox<String> cmbAluguel = new JComboBox<>(opcoesTipoAluguel);

        pnlEntrada.add(lblValor);
        pnlEntrada.add(jtfValor);
        pnlEntrada.add(lblMeses);
        pnlEntrada.add(jtfMeses);
        pnlEntrada.add(lblAluguel);
        pnlEntrada.add(cmbAluguel);

        JPanel pnlBotoes = new JPanel();
        pnlBotoes.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        pnlBotoes.setBorder(BorderFactory.createTitledBorder("Ações"));

        JButton btnProcessar = new JButton("Processar");
        JButton btnSalvarHistorico = new JButton("Salvar Histórico");
        JButton btnRecarregarHistorico = new JButton("Recarregar Histórico");
        JButton btnLimparPainel = new JButton("Limpar Painel");
        JButton btnLimparHistorico = new JButton("Limpar Histórico");

        pnlBotoes.add(btnProcessar);
        pnlBotoes.add(btnSalvarHistorico);
        pnlBotoes.add(btnRecarregarHistorico);
        pnlBotoes.add(btnLimparPainel);
        pnlBotoes.add(btnLimparHistorico);

        JPanel pnlSaida = new JPanel();
        pnlSaida.setLayout(new BorderLayout());
        pnlSaida.setBorder(BorderFactory.createTitledBorder("Resultados"));
        
        jtaResultados = new JTextArea();
        JScrollPane scroll = new JScrollPane(jtaResultados);
        jtaResultados.setEditable(false);
        jtaResultados.setFont(font);

        pnlSaida.add(scroll);

        pnlPrincipal.add(pnlEntrada);
        pnlPrincipal.add(pnlBotoes);
        pnlPrincipal.add(pnlSaida);


        for (Component p : pnlPrincipal.getComponents()) {
            if (p instanceof JPanel) {
                p.setBackground(new Color(220, 240, 255));
                for (Component c : ((JPanel) p).getComponents()) {
                    c.setFont(font);
                }
            }
        }

        add(pnlPrincipal);

        btnProcessar.addActionListener(e -> {
            try {
                double valor = Double.parseDouble(jtfValor.getText());
                int meses = Integer.parseInt(jtfMeses.getText());
                String tipoAluguel = (String)cmbAluguel.getSelectedItem();

                Aluguel aluguel = getAluguel(tipoAluguel, valor, meses);
                String mensagem = controller.processarAluguel(aluguel);
                jtaResultados.append(mensagem + "\n");
            } catch (Exception ex) {
                // Caso algum campo esteja vazio ou inválido
                JOptionPane.showMessageDialog(
                    null,
                    "Por favor, preencha os campos com valores válidos.",
                    "Erro de Entrada",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        });
        
        btnSalvarHistorico.addActionListener(e -> {
            try {
                double valor = Double.parseDouble(jtfValor.getText());
                int meses = Integer.parseInt(jtfMeses.getText());
                String tipoAluguel = (String)cmbAluguel.getSelectedItem();

                Aluguel aluguel = getAluguel(tipoAluguel, valor, meses);
                String mensagem = controller.processarAluguel(aluguel);
                jtaResultados.append(mensagem + "\n");
            } catch (Exception ex) {
                // Caso algum campo esteja vazio ou inválido
                JOptionPane.showMessageDialog(
                    null,
                    "Por favor, preencha os campos com valores válidos.",
                    "Erro de Entrada",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        });
        
        btnRecarregarHistorico.addActionListener(e -> {
            recarregarHistorico();
        });

        btnLimparPainel.addActionListener(e -> {
            jtaResultados.setText("");
        });

        btnLimparHistorico.addActionListener(e -> {
            int opc = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja limpar o histórico de alugueis?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (opc == JOptionPane.YES_OPTION) {
                controller.limparHistorico();
                jtaResultados.setText("");
            }
        });
    }

    private Aluguel getAluguel(String tipo, double valor, int tempo) {
        switch (tipo) {
            case "Apartamento": return new AluguelCasa(valor, tempo);
            case "Casa": return new AluguelCasa(valor, tempo);
            case "Comercial": return new AluguelComercial(valor, tempo);
            case "Temporada": return new AluguelTemporada(tempo, valor); // Adição extra desse case
            default: 
            JOptionPane.showMessageDialog(null, "Erro ao obter tipo de aluguel.");
            return null;
        }
    }

    private void recarregarHistorico() {
        List<String> alugueis = controller.listarAlugueis();
        String mensagem = "";
        for (String aluguel : alugueis) {
            mensagem += aluguel + "\n";
        }
        jtaResultados.setText(mensagem);
    }
}
