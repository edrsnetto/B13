import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SistemaPessoa {
    public static void main(String args[]) {
        // Instancia e exibe a janela principal
        SistemaPessoa sistema = new SistemaPessoa();
        sistema.criarFrame();
    }

    private void criarFrame() {
        // Cria o frame principal
        JFrame principal = new JFrame("Sistema Pessoa");
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setSize(800, 800);
       
        // Cria os componentes da interface
        MenuPrincipal menu = new MenuPrincipal();
        JTextArea areaTrabalho = new JTextArea();
        Rodape rodape = new Rodape();

        // Adiciona os componentes ao frame
        principal.getContentPane().add(BorderLayout.NORTH, menu.getMenuPrincipal());
        principal.getContentPane().add(BorderLayout.CENTER, areaTrabalho);
        principal.getContentPane().add(BorderLayout.SOUTH, rodape.getPainelRodape());

        // Centraliza e exibe a janela
        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
    }
}
