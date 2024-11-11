import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class SistemaPessoa {
    public static void main(String[] args) {
        JFrame principal = new JFrame("Sistema Pessoa");
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setSize(800, 800);

        // Configura o menu principal
        JMenuBar menuPrincipal = new JMenuBar();
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenu menuSair = new JMenu("Sair");

        menuSair.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent e) {
                System.exit(0);
            }
            public void menuDeselected(javax.swing.event.MenuEvent e) { }
            public void menuCanceled(javax.swing.event.MenuEvent e) { }
        });

        menuPrincipal.add(menuCadastro);
        menuPrincipal.add(menuVisualizacao);
        menuPrincipal.add(menuSair);

        // Opções de cadastro e visualização
        JMenuItem itemMenuCadastroUsuarios = new JMenuItem("Usuários");
        JMenuItem itemMenuCadastroPessoas = new JMenuItem("Pessoas");
        menuCadastro.add(itemMenuCadastroUsuarios);
        menuCadastro.add(itemMenuCadastroPessoas);

        JMenuItem itemMenuVisualizacaoListaUsuarios = new JMenuItem("Lista de usuários");
        JMenuItem itemMenuVisualizacaoListaPessoas = new JMenuItem("Lista de pessoas");
        menuVisualizacao.add(itemMenuVisualizacaoListaUsuarios);
        menuVisualizacao.add(itemMenuVisualizacaoListaPessoas);

        JTextArea areaTrabalho = new JTextArea();
        JPanel painelRodape = new JPanel();

        // Informações do usuário e data
        final String versaoSistema = "12.1.2024";
        String nomeUsuario = "denys.silva";
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
        String dataAcesso = dateFormat.format(new Date());
        JLabel labelRodape = new JLabel("Versão: " + versaoSistema + "    Usuário: " + nomeUsuario + "    Data de acesso: " + dataAcesso);
        
        painelRodape.add(labelRodape);

        principal.getContentPane().add(BorderLayout.NORTH, menuPrincipal);
        principal.getContentPane().add(BorderLayout.CENTER, areaTrabalho);
        principal.getContentPane().add(BorderLayout.SOUTH, painelRodape);

        // Ações dos menus para abrir as janelas de cadastro e lista
        itemMenuCadastroUsuarios.addActionListener(e -> CadastroUsuarios.abrir(principal));
        itemMenuCadastroPessoas.addActionListener(e -> CadastroPessoas.abrir(principal));
        itemMenuVisualizacaoListaUsuarios.addActionListener(e -> ListaUsuarios.abrir(principal));
        itemMenuVisualizacaoListaPessoas.addActionListener(e -> ListaPessoas.abrir(principal));

        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
    }

    // Método para criar o painel de botões dos diálogos
    public static JPanel criarPainelBotoes(JDialog dialog) {
        JPanel painelBotoes = new JPanel(new FlowLayout());
        String[] labels = {"Incluir", "Alterar", "Excluir", "Consultar", "Cancelar", "Sair"};
        for (String label : labels) {
            JButton button = new JButton(label);
            if (label.equals("Sair")) {
                button.addActionListener(e -> dialog.setVisible(false));
            } else {
                button.addActionListener(e -> JOptionPane.showMessageDialog(dialog, "Botão " + label + " clicado!"));
            }
            painelBotoes.add(button);
        }
        return painelBotoes;
    }
}
