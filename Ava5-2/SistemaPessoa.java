import javax.swing.*;

public class SistemaPessoa {

    public static void main(String[] args) {
        JFrame principal = new JFrame("Sistema Pessoa");
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setSize(800, 800);

        JMenuBar menuPrincipal = new JMenuBar();
        JMenu menuCadastro = new JMenu("Cadastro");

        JMenuItem itemMenuCadastroUsuarios = new JMenuItem("Usuários");
        JMenuItem itemMenuCadastroPessoas = new JMenuItem("Pessoas");

        itemMenuCadastroUsuarios.addActionListener(e -> {
            CadastroBase cadastro = new CadastroUsuarios(principal);
            cadastro.exibir(); // Polimorfismo em ação
        });

        itemMenuCadastroPessoas.addActionListener(e -> {
            CadastroBase cadastro = new CadastroPessoas(principal);
            cadastro.exibir(); // Polimorfismo em ação
        });

        menuCadastro.add(itemMenuCadastroUsuarios);
        menuCadastro.add(itemMenuCadastroPessoas);

        menuPrincipal.add(menuCadastro);

        principal.setJMenuBar(menuPrincipal);
        principal.setVisible(true);
    }
}