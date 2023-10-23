package edu.fatec.paises.interfaces.new_vizinho;

import javax.swing.*;

import static edu.fatec.paises.MainApp.newVizinhoService;
import static edu.fatec.paises.MainApp.telas;

public class NewVizinho {
    private JPanel newVizinhosPanel;
    private JComboBox<String> selPais;
    private JComboBox<String> selVizinhos;
    private JButton btnSalvar;
    private JButton btnMenu;
    private JButton selecionarButton;
    private JLabel labelAddVizinho;

    public NewVizinho() {
        newVizinhoService.updateComboVizinhos(this);
        btnMenu.addActionListener(e -> telas.telaMenu(btnMenu));
        btnSalvar.addActionListener(e -> newVizinhoService.salvarVizinho(this));
        selPais.addActionListener(e -> newVizinhoService.selecionarPais(this));
        selecionarButton.addActionListener(e -> newVizinhoService.selecionarVizinhos(this));
    }

    public JLabel getLabelAddVizinho() {return labelAddVizinho;}

    public JPanel getNewVizinhosPanel() {
        return newVizinhosPanel;
    }

    public JComboBox<String> getSelPais() {return selPais;}

    public JComboBox<String> getSelVizinhos() {
        return selVizinhos;
    }
}
