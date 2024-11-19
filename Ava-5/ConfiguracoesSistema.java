import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    Classe para configurações globais do sistema.
    Declara variáveis `static final` (constantes).
    Variáveis e objetos ficam acessíveis em qualquer lugar do programa sem precisar instanciar a classe.
*/
public class ConfiguracoesSistema {
    public static final String VERSAO_SISTEMA = "12.1.2024";
    public static final String NOME_USUARIO = "denys.silva";
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yy HH:mm");
    public static final String DATA_ACESSO = DATE_FORMAT.format(new Date());
}