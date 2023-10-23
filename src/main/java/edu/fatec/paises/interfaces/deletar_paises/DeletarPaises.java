package edu.fatec.paises.interfaces.deletar_paises;

import javax.swing.*;

import static edu.fatec.paises.MainApp.deletarPaisesService;
import static edu.fatec.paises.MainApp.telas;

public class DeletarPaises {
    private JPanel deletarPaisesPanel;
    private JComboBox<String> selPaises;
    private JButton btnDeletar;
    private JButton btnMenu;
    private JButton btnSelectedPais;
    private JLabel labelPaisSelected;

    public DeletarPaises() {
        deletarPaisesService.updatePaises(this);
        btnMenu.addActionListener(e -> telas.telaMenu(btnMenu));
        btnSelectedPais.addActionListener(e -> deletarPaisesService.setPaisesSelected(this));
        btnDeletar.addActionListener(e -> deletarPaisesService.deletarPais(this));
    }

    public JLabel getLabelPaisSelected() {return labelPaisSelected;}

    public JPanel getDeletarPaisesPanel() {
        return deletarPaisesPanel;
    }

    public JComboBox<String> getSelPaises() {
        return selPaises;
    }
}
