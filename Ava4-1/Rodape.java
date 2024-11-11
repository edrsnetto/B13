import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class Rodape {
    private JPanel painelRodape;
    private JLabel labelRodape;

    public Rodape() {
        painelRodape = new JPanel();
        criarRodape();
    }

    public JPanel getPainelRodape() {
        return painelRodape;
    }

    private void criarRodape() {
        // Informações do rodapé
        final String versaoSistema = "12.1.2024";
        String nomeUsuario = "denys.silva";
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
        String dataAcesso = dateFormat.format(new Date());

        // Configura o texto do rodapé
        labelRodape = new JLabel("Versão: " + versaoSistema + "               Usuário: " + nomeUsuario + "               Data de acesso: " + dataAcesso);
        painelRodape.add(labelRodape);
    }
}