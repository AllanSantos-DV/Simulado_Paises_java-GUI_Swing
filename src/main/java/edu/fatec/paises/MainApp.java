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

    /**
     * The main method of the application.
     * It initializes the GUI by calling the telaApp method from the telas class and passing the "Menu" string as the title and the MenuPaises object's menuPanel as the content.
     * @param args The command line arguments passed to the application.
     */
    public static void main(String[] args) {
        telas.telaApp("Menu", new MenuPaises().getMenuPanel());
    }
}
