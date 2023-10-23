package edu.fatec.paises.service.listar_paises;

import edu.fatec.paises.interfaces.listar_paises.ListPaises;
import edu.fatec.paises.models.Pais;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static edu.fatec.paises.MainApp.paisDAO;

public class ListarPaisesService {

    public void listarPaises(ListPaises listPaises) {
        listPaises.getNumeroPaises().setText(String.valueOf(paisDAO.getPaises().size()));
        listPaises.getTextAreaListPaises().setText("");
        for (Pais pais : paisDAO.getPaises()) listPaises.getTextAreaListPaises().append(pais.toString()+ "\n");
    }

    public void listarPaisesOrdenado(ListPaises listPaises, String nome) {
        listPaises.getTextAreaListPaises().setText("");
        List<Pais> paises = new ArrayList<>(paisDAO.getPaises());
        if(nome.equalsIgnoreCase("nome")) paises.sort(Comparator.comparing(Pais::getNome));
        else paises.sort(Comparator.comparing(Pais::getDimensao));
        for (Pais pais : paises) listPaises.getTextAreaListPaises().append(pais.toString()+ "\n");
    }
}
