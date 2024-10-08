import java.util.Scanner;

public class Cardapio {

    private static final int LIM_REG = 100;
    private static final String[][] produtos = new String[LIM_REG][4];
    private static int totalProdutos = 0;
    private static Scanner entradaDados = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenuPrincipal();
            opcao = entradaDados.nextInt();
            entradaDados.nextLine();

            switch (opcao) {
                case 1:
                    menuCadastroProduto();
                    break;
                case 2:
                    imprimirCardapio();
                    break;
                case 3:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 3);
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\nMenu Principal:");
        System.out.println("1. Cadastro de Produtos");
        System.out.println("2. Imprimir Cardápio");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void menuCadastroProduto() {
        System.out.println("\nCadastro de Produtos:");
        System.out.println("1. Incluir Produto");
        System.out.println("2. Alterar Produto");
        System.out.println("3. Excluir Produto");
        System.out.println("4. Consultar Produto");
        System.out.print("Escolha uma opção: ");
        int opcao = entradaDados.nextInt();
        entradaDados.nextLine();

        switch (opcao) {
            case 1:
                incluirProduto();
                break;
            case 2:
                alterarProduto();
                break;
            case 3:
                excluirProduto();
                break;
            case 4:
                consultarProduto();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void incluirProduto() {
        if (totalProdutos >= LIM_REG) {
            System.out.println("Cadastro de produtos cheio.");
            return;
        }

        String codigo;
        do {
            System.out.print("Código (6 caracteres alfanuméricos): ");
            codigo = entradaDados.nextLine().toUpperCase();
            if (codigo.length() != 6) {
                System.out.println("Código inválido! Deve conter exatamente 6 caracteres.");
            }
        } while (codigo.length() != 6);

        String produto;
        do {
            System.out.print("Produto (min 3, max 60 caracteres): ");
            produto = entradaDados.nextLine().toUpperCase();
            if (produto.length() < 3 || produto.length() > 60) {
                System.out.println("Descrição do produto inválida!");
            }
        } while (produto.length() < 3 || produto.length() > 60);

        double preco;
        do {
            System.out.print("Preço (formato 0.00): ");
            preco = entradaDados.nextDouble();
            entradaDados.nextLine();

            if (preco < 0) {
                System.out.println("O preço deve ser positivo.");
            }
        } while (preco < 0);

        String ativo;
        do {
            System.out.print("Ativo (true para ativo, false para desativado): ");
            ativo = entradaDados.nextLine().toUpperCase();

            if (!ativo.equals("TRUE") && !ativo.equals("FALSE")) {
                System.out.println("Valor inválido! Informe true ou false.");
            }
        } while (!ativo.equals("TRUE") && !ativo.equals("FALSE"));

        produtos[totalProdutos][0] = codigo;
        produtos[totalProdutos][1] = produto;
        produtos[totalProdutos][2] = ativo;
        produtos[totalProdutos][3] = String.format("%.2f", preco);
        totalProdutos++;

        System.out.println("Produto cadastrado com sucesso.");
    }

    private static void alterarProduto() {
        System.out.print("Digite o código do produto a alterar: ");
        String codigo = entradaDados.nextLine().toUpperCase();

        int indice = buscarProdutoPorCodigo(codigo);
        if (indice == -1) {
            System.out.println("Produto não existe no cadastro.");
            return;
        }

        System.out.println("Código atual: " + produtos[indice][0]);
        System.out.println("Produto atual: " + produtos[indice][1]);
        System.out.println("Preço atual: " + produtos[indice][3]);
        System.out.println("Ativo atual: " + produtos[indice][2]);

        String novoProduto;
        do {
            System.out.print("Novo Produto (min 3, max 60 caracteres) [Enter para manter o atual]: ");
            novoProduto = entradaDados.nextLine().toUpperCase();
            if (novoProduto.isEmpty()) {
                novoProduto = produtos[indice][1];
            } else if (novoProduto.length() < 3 || novoProduto.length() > 60) {
                System.out.println("Descrição do produto inválida!");
                novoProduto = null;
            }
        } while (novoProduto == null);

        String novoPrecoStr;
        double novoPreco = 0;
        do {
            System.out.print("Novo Preço (formato 0.00) [Enter para manter o atual]: ");
            novoPrecoStr = entradaDados.nextLine();
            if (!novoPrecoStr.isEmpty()) {
                novoPreco = Double.parseDouble(novoPrecoStr);
                if (novoPreco < 0) {
                    System.out.println("O preço deve ser positivo.");
                    novoPreco = -1;
                }
            }
        } while (novoPreco < 0);

        String novoAtivo;
        do {
            System.out.print("Novo Ativo (true para ativo, false para desativado) [Enter para manter o atual]: ");
            novoAtivo = entradaDados.nextLine().toUpperCase();
            if (novoAtivo.isEmpty()) {
                novoAtivo = produtos[indice][2];
            } else if (!novoAtivo.equals("TRUE") && !novoAtivo.equals("FALSE")) {
                System.out.println("Valor inválido! Informe true ou false.");
                novoAtivo = null;
            }
        } while (novoAtivo == null);

        produtos[indice][1] = novoProduto;
        produtos[indice][3] = String.format("%.2f", novoPreco);
        produtos[indice][2] = novoAtivo.equals("TRUE") ? "TRUE" : "FALSE";

        System.out.println("Produto alterado com sucesso.");
    }

    private static void excluirProduto() {
        System.out.print("Digite o código do produto a excluir: ");
        String codigo = entradaDados.nextLine().toUpperCase();

        int indice = buscarProdutoPorCodigo(codigo);
        if (indice == -1) {
            System.out.println("Produto não existe no cadastro.");
            return;
        }

        for (int i = indice; i < totalProdutos - 1; i++) {
            produtos[i] = produtos[i + 1];
        }
        totalProdutos--;
        System.out.println("Produto excluído com sucesso.");
    }

    private static void consultarProduto() {
        System.out.print("Digite o código do produto: ");
        String codigo = entradaDados.nextLine().toUpperCase();

        int indice = buscarProdutoPorCodigo(codigo);
        if (indice == -1) {
            System.out.println("Produto não existe no cadastro.");
            return;
        }

        System.out.println("Código: " + produtos[indice][0]);
        System.out.println("Produto: " + produtos[indice][1]);
        System.out.println("Ativo: " + produtos[indice][2]);
        System.out.println("Preço: R$" + produtos[indice][3]);
    }

    private static int buscarProdutoPorCodigo(String codigo) {
        for (int i = 0; i < totalProdutos; i++) {
            if (produtos[i][0].equals(codigo)) {
                return i;
            }
        }
        return -1;
    }

    private static void imprimirCardapio() {
        System.out.println(
                "-------------------------------------------------------------------------------------------------");
        System.out.println(
                "CÓDIGO PRODUTO                                                                              VALOR");
        System.out.println(
                "-------------------------------------------------------------------------------------------------");

        for (int i = 0; i < totalProdutos; i++) {
            if (produtos[i][2].equals("TRUE")) {
                System.out.printf("%-7s %-80s %6s\n", produtos[i][0], produtos[i][1], produtos[i][3]);
            }
        }
        System.out.println(
                "-------------------------------------------------------------------------------------------------");
    }
}
