package edu.fatec.paises;

import edu.fatec.paises.interfaces.menu.MenuPaises;
import edu.fatec.paises.repository.PaisDAO;
import edu.fatec.paises.service.deletar_paises.DeletarPaisesService;
import edu.fatec.paises.service.listar_paises.ListarPaisesService;
import edu.fatec.paises.service.menu_pais.MenuPaisService;
import edu.fatec.paises.service.new_pais.NewPaisService;
import edu.fatec.paises.service.new_vizinho.NewVizinhoService;
import edu.fatec.paises.service.telas_app.Telas;

public class MainApp{
    public static final PaisDAO paisDAO = new PaisDAO();
    public static final Telas telas = new Telas();
    public static final MenuPaisService menuPaisesService = new MenuPaisService();
    public static final NewPaisService newPaisService = new NewPaisService();
    public static final NewVizinhoService newVizinhoService = new NewVizinhoService();
    public static final ListarPaisesService listarPaisesService = new ListarPaisesService();
    public static final DeletarPaisesService deletarPaisesService = new DeletarPaisesService();

    public static void main(String[] args) {
        telas.telaApp("Menu", new MenuPaises().getMenuPanel());
    }
}
