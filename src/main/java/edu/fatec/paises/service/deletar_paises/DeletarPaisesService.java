package edu.fatec.paises.service.deletar_paises;

import edu.fatec.paises.interfaces.deletar_paises.DeletarPaises;
import edu.fatec.paises.models.Pais;

import java.util.ArrayList;
import java.util.List;

import static edu.fatec.paises.MainApp.paisDAO;

public class DeletarPaisesService {

    private final List<Pais> paisesSelected = new ArrayList<>();
    private List<Pais> paisList = new ArrayList<>(paisDAO.getPaises());

    public void updatePaises(DeletarPaises deletarPaises) {
        deletarPaises.getSelPaises().removeAllItems();
        paisList = new ArrayList<>(paisDAO.getPaises());
        for (Pais pais : paisList) deletarPaises.getSelPaises().addItem(pais.getNome());
    }

    public void updateComboPaises(DeletarPaises deletarPaises) {
        deletarPaises.getSelPaises().removeAllItems();
        for (Pais pais : paisList) deletarPaises.getSelPaises().addItem(pais.getNome());
    }

    public void setPaisesSelected(DeletarPaises deletarPaises) {
        int index = deletarPaises.getSelPaises().getSelectedIndex();
        if (index < 0) {
            labelMaxPaises(deletarPaises);
            return;
        }
        Pais paisSelected = paisList.get(index);
        paisesSelected.add(paisSelected);
        paisList.remove(paisSelected);
        updateComboPaises(deletarPaises);
        labelPaisSelected(deletarPaises, paisSelected);
    }

    public void labelPaisSelected(DeletarPaises deletarPaises, Pais pais) {
        deletarPaises.getLabelPaisSelected().setText("Pais selecionado: " + pais.getNome());
    }

    public void labelMaxPaises(DeletarPaises deletarPaises) {
        deletarPaises.getLabelPaisSelected().setText("Número máximo de paises atingido.");
    }

    public void deletarPais(DeletarPaises deletarPaises) {
        for (Pais pais : paisesSelected) paisDAO.getPaises().remove(pais);
        deletVizinhos();
        paisesSelected.clear();
        updateComboPaises(deletarPaises);
        labelPaisSelected(deletarPaises);
    }

    public void labelPaisSelected(DeletarPaises deletarPaises) {
        deletarPaises.getLabelPaisSelected().setText("Paises deletado.");
    }

    public void deletVizinhos() {
        List<Pais> paisArrayList = new ArrayList<>();
        for(Pais pais : paisesSelected)
            if(pais.getFronteira() != null)
                for(Pais vizinho: pais.getFronteira())
                    if(vizinho.getFronteira().size() == 1) {
                        vizinho.setFronteira(paisArrayList);
                        vizinho.getFronteira().remove(pais);
                    }
                    else vizinho.getFronteira().remove(pais);
    }


}
