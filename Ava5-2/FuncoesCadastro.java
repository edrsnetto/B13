import javax.swing.*;
import java.awt.*;

/*
    Classe responsável pelas funcionalidades de Cadastro e Visualização.
*/
public class FuncoesCadastro {

    // Método para abrir o cadastro de Usuários
    public static void abrirCadastroUsuarios(JFrame principal) {
        JDialog cadastroUsuarios = new JDialog(principal, "Cadastro de Usuários", true);
        cadastroUsuarios.setSize(600, 300);
        cadastroUsuarios.setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Cadastro de Usuários", SwingConstants.CENTER);
        cadastroUsuarios.add(titulo, BorderLayout.NORTH);

        JPanel painelCampos = new JPanel(new GridLayout(4, 2, 5, 5));
        painelCampos.add(new JLabel("Usuário:"));
        painelCampos.add(new JTextField(25));
        painelCampos.add(new JLabel("Senha:"));
        painelCampos.add(new JPasswordField(15));
        painelCampos.add(new JLabel("Email:"));
        painelCampos.add(new JTextField(30));
        painelCampos.add(new JLabel("Ativo:"));
        JRadioButton radioAtivo = new JRadioButton();
        painelCampos.add(radioAtivo);

        JPanel painelBotoes = criarPainelBotoes(cadastroUsuarios);

        cadastroUsuarios.add(painelCampos, BorderLayout.CENTER);
        cadastroUsuarios.add(painelBotoes, BorderLayout.SOUTH);
        cadastroUsuarios.setLocationRelativeTo(principal);
        cadastroUsuarios.setVisible(true);
    }

    // Método para criar o painel de botões
    private static JPanel criarPainelBotoes(JDialog dialog) {
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

    // Método para abrir a lista de usuários
    public static void abrirListaUsuarios(JFrame principal) {
        JDialog listaUsuarios = new JDialog(principal, "Lista de Usuários", true);
        listaUsuarios.setSize(750, 650);
        listaUsuarios.setLayout(new BorderLayout());

        listaUsuarios.add(new JLabel("Lista de Usuários", SwingConstants.CENTER), BorderLayout.NORTH);
        listaUsuarios.add(new JTextArea("Exemplo de lista de usuários..."), BorderLayout.CENTER);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> listaUsuarios.setVisible(false));
        listaUsuarios.add(btnFechar, BorderLayout.SOUTH);

        listaUsuarios.setLocationRelativeTo(principal);
        listaUsuarios.setVisible(true);
    }
}