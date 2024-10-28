import java.awt.*;
import javax.swing.*;

public class SistemaPessoa extends JFrame {

    public SistemaPessoa() {
        setTitle("Sistema de Pessoa");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuCadastro = new JMenu("Cadastro");
        JMenuItem menuItemUsuarios = new JMenuItem("Usuários");
        JMenuItem menuItemPessoas = new JMenuItem("Pessoas");

        menuCadastro.add(menuItemUsuarios);
        menuCadastro.add(menuItemPessoas);

        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenuItem menuItemListaUsuario = new JMenuItem("Lista de usuário");
        JMenuItem menuItemListaPessoas = new JMenuItem("Lista de Pessoas");

        menuVisualizacao.add(menuItemListaUsuario);
        menuVisualizacao.add(menuItemListaPessoas);

        JMenu menuSair = new JMenu("Sair");

        menuBar.add(menuCadastro);
        menuBar.add(menuVisualizacao);
        menuBar.add(menuSair);

        setJMenuBar(menuBar);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        add(mainPanel, BorderLayout.CENTER);

        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel footerLabel = new JLabel("Versão: 12.1.2024    Usuário: denys.silva    Data de acesso: 20/09/2024 10:58");
        footerPanel.add(footerLabel);
        add(footerPanel, BorderLayout.SOUTH);

        menuItemUsuarios.addActionListener(e -> abrirJanelaCadastroUsuarios());
        menuItemPessoas.addActionListener(e -> abrirJanelaCadastroPessoas());

        menuSair.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent e) {
                System.exit(0);
            }
            public void menuDeselected(javax.swing.event.MenuEvent e) {}
            public void menuCanceled(javax.swing.event.MenuEvent e) {}
        });
    }

    private void abrirJanelaCadastroUsuarios() {
        JFrame cadastroUsuariosFrame = new JFrame("Cadastro de Usuários");
        cadastroUsuariosFrame.setSize(400, 300);
        cadastroUsuariosFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cadastroUsuariosFrame.setLocationRelativeTo(null);

        JPanel cadastroPanel = new JPanel();
        cadastroPanel.setLayout(new GridLayout(5, 2, 5, 5));
        cadastroPanel.setBackground(Color.WHITE);

        cadastroPanel.add(new JLabel("Usuário:", SwingConstants.RIGHT));
        JTextField usuarioField = new JTextField();
        cadastroPanel.add(usuarioField);

        cadastroPanel.add(new JLabel("Senha:", SwingConstants.RIGHT));
        JPasswordField senhaField = new JPasswordField();
        cadastroPanel.add(senhaField);

        cadastroPanel.add(new JLabel("Email:", SwingConstants.RIGHT));
        JTextField emailField = new JTextField();
        cadastroPanel.add(emailField);

        cadastroPanel.add(new JLabel("Ativo:", SwingConstants.RIGHT));
        JCheckBox ativoCheckBox = new JCheckBox();
        cadastroPanel.add(ativoCheckBox);

        JPanel botoesPanel = new JPanel();
        botoesPanel.setLayout(new FlowLayout());

        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");
        JButton btnSair = new JButton("Sair");

        botoesPanel.add(btnSalvar);
        botoesPanel.add(btnCancelar);
        botoesPanel.add(btnSair);

        btnSalvar.addActionListener(e -> JOptionPane.showMessageDialog(cadastroUsuariosFrame, "Salvado com sucesso!"));
        btnCancelar.addActionListener(e -> JOptionPane.showMessageDialog(cadastroUsuariosFrame, "Botão clicado: Cancelar"));
        btnSair.addActionListener(e -> cadastroUsuariosFrame.dispose());

        cadastroUsuariosFrame.add(cadastroPanel, BorderLayout.CENTER);
        cadastroUsuariosFrame.add(botoesPanel, BorderLayout.SOUTH);

        cadastroUsuariosFrame.setVisible(true);
    }

    private void abrirJanelaCadastroPessoas() {
        JFrame cadastroPessoasFrame = new JFrame("Cadastro de Pessoas");
        cadastroPessoasFrame.setSize(500, 400);
        cadastroPessoasFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cadastroPessoasFrame.setLocationRelativeTo(null);

        JPanel cadastroPanel = new JPanel();
        cadastroPanel.setLayout(new GridLayout(8, 2, 5, 5));
        cadastroPanel.setBackground(Color.WHITE);

        cadastroPanel.add(new JLabel("Nome:", SwingConstants.RIGHT));
        JTextField nomeField = new JTextField();
        cadastroPanel.add(nomeField);

        cadastroPanel.add(new JLabel("Endereço:", SwingConstants.RIGHT));
        JTextField enderecoField = new JTextField();
        cadastroPanel.add(enderecoField);

        cadastroPanel.add(new JLabel("Cidade:", SwingConstants.RIGHT));
        JTextField cidadeField = new JTextField();
        cadastroPanel.add(cidadeField);

        cadastroPanel.add(new JLabel("UF:", SwingConstants.RIGHT));
        JTextField ufField = new JTextField();
        cadastroPanel.add(ufField);

        cadastroPanel.add(new JLabel("Email:", SwingConstants.RIGHT));
        JTextField emailField = new JTextField();
        cadastroPanel.add(emailField);

        cadastroPanel.add(new JLabel("Telefone:", SwingConstants.RIGHT));
        JTextField telefoneField = new JTextField();
        cadastroPanel.add(telefoneField);

        cadastroPanel.add(new JLabel("Sexo:", SwingConstants.RIGHT));
        String[] sexos = {"Masculino", "Feminino", "Outro"};
        JComboBox<String> sexoComboBox = new JComboBox<>(sexos);
        cadastroPanel.add(sexoComboBox);

        JPanel botoesPanel = new JPanel();
        botoesPanel.setLayout(new FlowLayout());

        JButton btnIncluir = new JButton("Incluir");
        JButton btnAlterar = new JButton("Alterar");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnConsultar = new JButton("Consultar");
        JButton btnCancelar = new JButton("Cancelar");
        JButton btnSair = new JButton("Sair");

        botoesPanel.add(btnIncluir);
        botoesPanel.add(btnAlterar);
        botoesPanel.add(btnExcluir);
        botoesPanel.add(btnConsultar);
        botoesPanel.add(btnCancelar);
        botoesPanel.add(btnSair);

        btnIncluir.addActionListener(e -> JOptionPane.showMessageDialog(cadastroPessoasFrame, "Botão clicado: Incluir"));
        btnAlterar.addActionListener(e -> JOptionPane.showMessageDialog(cadastroPessoasFrame, "Botão clicado: Alterar"));
        btnExcluir.addActionListener(e -> JOptionPane.showMessageDialog(cadastroPessoasFrame, "Botão clicado: Excluir"));
        btnConsultar.addActionListener(e -> JOptionPane.showMessageDialog(cadastroPessoasFrame, "Botão clicado: Consultar"));
        btnCancelar.addActionListener(e -> JOptionPane.showMessageDialog(cadastroPessoasFrame, "Botão clicado: Cancelar"));
        btnSair.addActionListener(e -> cadastroPessoasFrame.dispose());

        cadastroPessoasFrame.add(cadastroPanel, BorderLayout.CENTER);
        cadastroPessoasFrame.add(botoesPanel, BorderLayout.SOUTH);

        cadastroPessoasFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SistemaPessoa frame = new SistemaPessoa();
            frame.setVisible(true);
        });
    }
}