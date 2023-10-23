package edu.fatec.paises.interfaces.menu;

import javax.swing.*;

import static edu.fatec.paises.MainApp.menuPaisesService;

public class MenuPaises {
    private JComboBox<String> selOpcao;
    private JButton btnAvancar;
    private JPanel menuPanel;

    public MenuPaises() {
        menuPaisesService.menuOptions(selOpcao);
        btnAvancar.addActionListener(e -> menuPaisesService.btnAvancar(selOpcao, btnAvancar));
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }
}
