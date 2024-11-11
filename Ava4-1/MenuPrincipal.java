import javax.swing.*;
import javax.swing.event.MenuListener;

public class MenuPrincipal {
    private JMenuBar menuPrincipal;

    public MenuPrincipal() {
        menuPrincipal = new JMenuBar();
        criarMenu();
    }

    public JMenuBar getMenuPrincipal() {
        return menuPrincipal;
    }

    private void criarMenu() {
        // Menu Cadastro
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenuItem itemMenuCadastroUsuarios = new JMenuItem("Usuários");
        JMenuItem itemMenuCadastroPessoas = new JMenuItem("Pessoas");
        menuCadastro.add(itemMenuCadastroUsuarios);
        menuCadastro.add(itemMenuCadastroPessoas);

        // Menu Visualização
        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenuItem itemMenuVisualizacaoListaUsuarios = new JMenuItem("Lista de usuários");
        JMenuItem itemMenuVisualizacaoListaPessoas = new JMenuItem("Lista de pessoas");
        menuVisualizacao.add(itemMenuVisualizacaoListaUsuarios);
        menuVisualizacao.add(itemMenuVisualizacaoListaPessoas);

        // Menu Sair
        JMenu menuSair = new JMenu("Sair");
        menuSair.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(javax.swing.event.MenuEvent e) {
                System.exit(0); // Sai do sistema
            }

            @Override
            public void menuDeselected(javax.swing.event.MenuEvent e) {}
            @Override
            public void menuCanceled(javax.swing.event.MenuEvent e) {}
        });

        // Adiciona os menus à barra
        menuPrincipal.add(menuCadastro);
        menuPrincipal.add(menuVisualizacao);
        menuPrincipal.add(menuSair);
    }
}