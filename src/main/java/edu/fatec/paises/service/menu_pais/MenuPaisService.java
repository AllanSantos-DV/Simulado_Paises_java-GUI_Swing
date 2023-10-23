package edu.fatec.paises.service.menu_pais;

import edu.fatec.paises.interfaces.deletar_paises.DeletarPaises;
import edu.fatec.paises.interfaces.listar_paises.ListPaises;
import edu.fatec.paises.interfaces.new_pais.NewPais;
import edu.fatec.paises.interfaces.new_vizinho.NewVizinho;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import static edu.fatec.paises.MainApp.telas;

public class MenuPaisService {
    private final Map<String, JPanel> opcaoTelas = new LinkedHashMap<>();

    public void menuOptions(JComboBox<String> menuOptions) {
        opcaoTelas.put("Cadastrar Pais", new NewPais().getNewPaisPanel());
        opcaoTelas.put("Adcionar Vizinho", new NewVizinho().getNewVizinhosPanel());
        opcaoTelas.put("Listar Paises", new ListPaises().getListPaisesPanel());
        opcaoTelas.put("Excluir Paises", new DeletarPaises().getDeletarPaisesPanel());
        for (String opcao : opcaoTelas.keySet()) menuOptions.addItem(opcao);
    }

    public void btnAvancar(JComboBox<String> selOpcao, JButton btnAvancar){
        String tela = Objects.requireNonNull(selOpcao.getSelectedItem()).toString();
        JPanel panel = opcaoTelas.get(tela);
        telas.telaApp(tela.split(" ")[0], panel);
        telas.telaClose(btnAvancar);
    }
}
