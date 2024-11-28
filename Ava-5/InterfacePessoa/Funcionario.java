// Funcionario.java
public class Funcionario implements Pessoa {
    private String nome;
    private int idade;
    private String setor;
    private double salario;
    // Construtor
    public Funcionario(String nome, int idade, String setor, double salario) {
    this.nome = nome;
    this.idade = idade;
    this.setor = setor;
    this.salario = salario;
    }
    // Implementação dos métodos da interface
    @Override
    public String getNome() {
    return nome;
    }
    @Override
    public int getIdade() {
    return idade;
    }
    @Override
    public void exibirInfo() {
    System.out.println("Informações do Funcionário:");
    System.out.println("Nome: " + nome);
    System.out.println("Idade: " + idade);
    System.out.println("Setor: " + setor);
    System.out.println("Salário: R$" + salario);
    }
}