package edu.fatec.paises.service.new_pais;

import edu.fatec.paises.interfaces.new_pais.NewPais;

import static edu.fatec.paises.MainApp.paisDAO;

public class NewPaisService{

    public void limparCampos(NewPais newPais) {
        newPais.getFieldNamePais().setText("");
        newPais.getFieldCapitalPais().setText("");
        newPais.getSpinnerSizePais().setValue(0);
        newPais.getLabelCreatPais().setText("");
    }

    public void salvarPais(NewPais newPais) {
        String nome = newPais.getFieldNamePais().getText();
        String capital = newPais.getFieldCapitalPais().getText();
        int tamanho = (int) newPais.getSpinnerSizePais().getValue();
        if (camposCheck(newPais, nome, capital)||paisExistente(newPais, nome)) return;
        paisDAO.addPais(nome, capital, tamanho);
        limparCampos(newPais);
        labelsalvarPais(newPais, nome);
    }

    public void labelsalvarPais(NewPais newPais, String nome) {
        newPais.getLabelCreatPais().setText("Pais " + nome + " Criado com Sucesso!");
    }

    public boolean camposCheck(NewPais newPais, String nome, String capital) {
        if(nome.isEmpty() || capital.isEmpty()) {
            labelCamposVazios(newPais);
            return true;
        }
        return false;
    }

    public boolean paisExistente(NewPais newPais, String nome) {
        if (paisDAO.getPaises().stream().anyMatch(pais -> pais.getNome().equalsIgnoreCase(nome))) {
            labelPaisExistente(newPais);
            return true;
        }
        return false;
    }

    public void labelPaisExistente(NewPais newPais) {
        newPais.getLabelCreatPais().setText("Pais já existe.");
    }

    public void labelCamposVazios(NewPais newPais) {
        newPais.getLabelCreatPais().setText("Campos 'Nome' e 'Capital' são obrigatórios.");
    }
}
