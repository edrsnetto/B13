import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroWindows extends JFrame {
    private static final int LIM_REG = 100;
    private static String[][] registros = new String[LIM_REG][3];
    private static int totalRegistros = 0;

    private JTextField cpfField;
    private JTextField nomeField;
    private JTextField telefoneField;
    private JPanel inputPanel;

    public CadastroWindows() {
        setTitle("Cadastro de Nomes");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenuItem menuItemCadastroNome = new JMenuItem("Cadastro de Nome");
        JMenuItem menuItemListaNome = new JMenuItem("Lista de Nomes");

        menuCadastro.add(menuItemCadastroNome);
        menuCadastro.add(menuItemListaNome);
        menuBar.add(menuCadastro);
        setJMenuBar(menuBar);

        // Painel de entrada
        inputPanel = new JPanel(new GridLayout(4, 2, 10, 10)); // Espaçamento entre os componentes
        cpfField = new JTextField();
        nomeField = new JTextField();
        telefoneField = new JTextField();

        // Definir tamanho preferido dos campos
        cpfField.setPreferredSize(new Dimension(200, 25));
        nomeField.setPreferredSize(new Dimension(200, 25));
        telefoneField.setPreferredSize(new Dimension(200, 25));

        inputPanel.add(new JLabel("CPF:"));
        inputPanel.add(cpfField);
        inputPanel.add(new JLabel("Nome:"));
        inputPanel.add(nomeField);
        inputPanel.add(new JLabel("Telefone:"));
        inputPanel.add(telefoneField);
        inputPanel.add(new JLabel("")); // Para completar o layout

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton incluirButton = new JButton("Incluir");
        JButton alterarButton = new JButton("Alterar");

        buttonPanel.add(incluirButton);
        buttonPanel.add(alterarButton);
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        incluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incluirRegistro();
            }
        });

        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alterarRegistro();
            }
        });

        menuItemCadastroNome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCadastro();
            }
        });

        menuItemListaNome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarRegistros();
            }
        });
    }

    private void mostrarCadastro() {
        limparCampos(); // Limpa os campos
        // Não é necessário alterar a visibilidade dos campos
        // Eles já estão visíveis, apenas garante que os campos estão limpos
    }

    private void incluirRegistro() {
        if (totalRegistros >= LIM_REG) {
            JOptionPane.showMessageDialog(this, "Cadastro cheio!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        registros[totalRegistros][0] = cpfField.getText();
        registros[totalRegistros][1] = nomeField.getText();
        registros[totalRegistros][2] = telefoneField.getText();
        totalRegistros++;
        JOptionPane.showMessageDialog(this, "Registro incluído com sucesso!");
        limparCampos();
    }

    private void alterarRegistro() {
        String cpf = cpfField.getText();
        int indice = buscarRegistroPorCPF(cpf);
        if (indice == -1) {
            JOptionPane.showMessageDialog(this, "Registro não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        registros[indice][1] = nomeField.getText();
        registros[indice][2] = telefoneField.getText();
        JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
        limparCampos();
    }

    private void listarRegistros() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < totalRegistros; i++) {
            sb.append("CPF: ").append(registros[i][0])
                    .append(", Nome: ").append(registros[i][1])
                    .append(", Telefone: ").append(registros[i][2]).append("\n");
        }

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Lista de Nomes",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private int buscarRegistroPorCPF(String cpf) {
        for (int i = 0; i < totalRegistros; i++) {
            if (registros[i][0].equals(cpf)) {
                return i;
            }
        }
        return -1;
    }

    private void limparCampos() {
        cpfField.setText("");
        nomeField.setText("");
        telefoneField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CadastroWindows app = new CadastroWindows();
            app.setVisible(true);
        });
    }
}
