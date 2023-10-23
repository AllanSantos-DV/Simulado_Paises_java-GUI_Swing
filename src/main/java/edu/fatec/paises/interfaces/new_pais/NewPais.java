package edu.fatec.paises.interfaces.new_pais;

import javax.swing.*;

import static edu.fatec.paises.MainApp.newPaisService;
import static edu.fatec.paises.MainApp.telas;

public class NewPais {
    private JTextField fieldNamePais;
    private JTextField fieldCapitalPais;
    private JSpinner spinnerSizePais;
    private JPanel newPaisPanel;
    private JButton btnLimpar;
    private JButton btnMenu;
    private JButton btnSalvar;
    private JLabel labelCreatPais;

    public NewPais() {
        btnMenu.addActionListener(e -> telas.telaMenu(btnMenu));
        btnSalvar.addActionListener(e -> newPaisService.salvarPais(this));
        btnLimpar.addActionListener(e -> newPaisService.limparCampos(this));
    }

    public JLabel getLabelCreatPais() {return labelCreatPais;}

    public JTextField getFieldNamePais() {
        return fieldNamePais;
    }

    public JTextField getFieldCapitalPais() {
        return fieldCapitalPais;
    }

    public JSpinner getSpinnerSizePais() {
        return spinnerSizePais;
    }

    public JPanel getNewPaisPanel() {
        return newPaisPanel;
    }
}
