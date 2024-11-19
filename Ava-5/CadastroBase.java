import javax.swing.*;

public abstract class CadastroBase {
    protected final JFrame principal;

    public CadastroBase(JFrame principal) {
        this.principal = principal;
    }

    public abstract void exibir(); // Método abstrato   
}