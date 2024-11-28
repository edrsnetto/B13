// Aluno.java
public class Aluno implements Pessoa {
    private String nome;
    private int idade;
    private String matricula;
    private double mencao1;
    private double mencao2;
    // Construtor
    public Aluno(String nome, int idade, String matricula, double mencao1, double mencao2) {
    this.nome = nome;
    this.idade = idade;
    this.matricula = matricula;
    this.mencao1 = mencao1;
    this.mencao2 = mencao2;
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
    System.out.println("Informações do Aluno:");
    System.out.println("Nome: " + nome);
    System.out.println("Idade: " + idade);
    System.out.println("Matrícula: " + matricula);
    System.out.println("Menção 1: " + mencao1);
    System.out.println("Menção 2: " + mencao2);
    System.out.println("Média Final: " + ((mencao1 + mencao2) / 2));
    }
}
    