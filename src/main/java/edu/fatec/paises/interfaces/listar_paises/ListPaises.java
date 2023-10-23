package edu.fatec.paises.interfaces.listar_paises;

import javax.swing.*;

import static edu.fatec.paises.MainApp.listarPaisesService;
import static edu.fatec.paises.MainApp.telas;

public class ListPaises {
    private JPanel listPaisesPanel;
    private JTextArea textAreaListPaises;
    private JButton btnMenu;
    private JLabel numeroPaises;
    private JButton nomeButton;
    private JButton tamanhoButton;

    public ListPaises() {
        btnMenu.addActionListener(e -> telas.telaMenu(btnMenu));
        listarPaisesService.listarPaises(this);
        nomeButton.addActionListener(e -> listarPaisesService.listarPaisesOrdenado(this, nomeButton.getText()));
        tamanhoButton.addActionListener(e -> listarPaisesService.listarPaisesOrdenado(this, tamanhoButton.getText()));
    }

    public JPanel getListPaisesPanel() {
        return listPaisesPanel;
    }

    public JTextArea getTextAreaListPaises() {
        return textAreaListPaises;
    }

    public JLabel getNumeroPaises() {
        return numeroPaises;
    }
}
