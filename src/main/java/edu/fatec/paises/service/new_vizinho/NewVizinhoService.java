package edu.fatec.paises.service.new_vizinho;

import edu.fatec.paises.interfaces.new_vizinho.NewVizinho;
import edu.fatec.paises.models.Pais;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static edu.fatec.paises.MainApp.paisDAO;

public class NewVizinhoService {

    private final List<Pais> paises = new ArrayList<>();

    private final List<Pais> vizinhos = new LinkedList<>();

    public void addPaises(NewVizinho newVizinho) {
        newVizinho.getSelVizinhos().removeAllItems();
        paises.clear();
        int index = newVizinho.getSelPais().getSelectedIndex();
        if (index < 0) return;
        Pais paisSelected = paisDAO.getPaises().get(index);
        for (Pais pais : paisDAO.getPaises()) if (!pais.equals(paisSelected)) paises.add(pais);
        paises.removeAll(vizinhos);
        if (paisSelected.getFronteira() != null) paises.removeAll(paisSelected.getFronteira());
        for (Pais pais : paises) newVizinho.getSelVizinhos().addItem(pais.getNome());
    }

    public void selecionarPais(NewVizinho newVizinho) {
        vizinhos.clear();
        addPaises(newVizinho);
        labelSelecaoVaia(newVizinho);
    }

    public void labelSelecaoVaia(NewVizinho newVizinho) {
        newVizinho.getLabelAddVizinho().setText("Seleção de paises limpa.");
    }

    public void selecionarVizinhos(NewVizinho newVizinho) {
        int index = newVizinho.getSelVizinhos().getSelectedIndex();
        if (index < 0) {
            labelMaxVizinhos(newVizinho);
            return;
        }
        Pais pais = paises.get(index);
        vizinhos.add(pais);
        addPaises(newVizinho);
        labelAddVizinho(newVizinho, pais);
    }

    public void labelAddVizinho(NewVizinho newVizinho, Pais pais) {
        newVizinho.getLabelAddVizinho().setText("Vizinho selecionado: " + pais.getNome());
    }

    public void labelMaxVizinhos(NewVizinho newVizinho) {
        newVizinho.getLabelAddVizinho().setText("Número máximo de vizinhos atingido.");
    }

    public void updateComboVizinhos(NewVizinho newVizinho) {
        newVizinho.getSelPais().removeAllItems();
        for (Pais pais : paisDAO.getPaises()) newVizinho.getSelPais().addItem(pais.getNome());
        addPaises(newVizinho);
    }

    public void salvarVizinho(NewVizinho newVizinho) {
        List<Pais> paisList = new ArrayList<>(this.vizinhos);
        int index = newVizinho.getSelPais().getSelectedIndex();
        if (index < 0) {
            labelMinVizinhos(newVizinho);
            return;
        }
        Pais pais = paisDAO.getPaises().get(index);
        pais.setFronteira(paisList);
        setVizinhos(paisList, pais);
        labelAddVizinho(newVizinho);
    }

    public void labelAddVizinho(NewVizinho newVizinho) {
        newVizinho.getLabelAddVizinho().setText("Vizinhos adicionado com sucesso.");
    }

    public void labelMinVizinhos(NewVizinho newVizinho) {
        newVizinho.getLabelAddVizinho().setText("Selecione ao menos um 'Pais' e um 'Vizinho'.");
    }

    public void setVizinhos(List<Pais> vizinhos, Pais pais) {
        for (Pais vizinho : vizinhos) vizinho.setFronteira(List.of(pais));
        this.vizinhos.clear();
    }
}
