// Professor.java
public class Professor implements Pessoa {
    private String nome;
    private int idade;
    private String disciplina;
    // Construtor
    public Professor(String nome, int idade, String disciplina) {
    this.nome = nome;
    this.idade = idade;
    this.disciplina = disciplina;
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
    System.out.println("Informações do Professor:");
    System.out.println("Nome: " + nome);
    System.out.println("Idade: " + idade);
    System.out.println("Disciplina: " + disciplina);
    }
}