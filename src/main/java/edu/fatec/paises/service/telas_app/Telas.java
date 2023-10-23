package edu.fatec.paises.service.telas_app;

import edu.fatec.paises.interfaces.menu.MenuPaises;

import javax.swing.*;

public class Telas {
    public void telaApp(String name, JPanel tela) {
        JFrame frame = new JFrame(name);
        frame.setContentPane(tela);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void telaClose(JButton button) {
        button.getRootPane().getParent().setVisible(false);
    }

    public void telaMenu(JButton button) {
        telaClose(button);
        telaApp("Menu", new MenuPaises().getMenuPanel());
    }
}
