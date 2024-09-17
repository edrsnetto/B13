import java.util.Scanner;

public class SwitchLab {
    public static void main(String[] args) {
        // Declaração de variável
        int opcao;

        // Cria objeto para entrada da opção do cardápio
        Scanner leitorOpcao = new Scanner(System.in);

        // Apresenta o cardápio
        System.out.println("1 - Pastel de carne");
        System.out.println("2 - Coxinha de frango");
        System.out.println("3 - Kibe com queijo");

        // Entrada da opção do cardápio
        System.out.print("Escolha uma opção: ");
        opcao = leitorOpcao.nextInt();

        // Seleção da opção
        switch (opcao) {
            case 1:
                System.out.println("Você escolheu o Pastel de carne.");
                break;
            case 2:
                System.out.println("Você escolheu a Coxinha de frango.");
                break;
            case 3:
                System.out.println("Você escolheu o Kibe com queijo.");
                break;
            default:
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                break;
        }

        // Fecha o Scanner para evitar vazamento de recursos
        leitorOpcao.close();
    }
}
