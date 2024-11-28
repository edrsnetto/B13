// Main.java
import java.util.ArrayList;
import java.util.List;
public class Main {
public static void main(String[] args) {
// Lista de objetos que implementam a interface Pessoa
List<Pessoa> pessoas = new ArrayList<>();
// Adicionando objetos de diferentes tipos
pessoas.add(new Aluno("João", 20, "A12345", 8.5, 9.0));
pessoas.add(new Professor("Maria", 40, "Matemática"));
pessoas.add(new Funcionario("Carlos", 35, "Administração", 3500.00));
// Polimorfismo em ação: chamando exibirInfo para cada objeto
for (Pessoa pessoa : pessoas) {
pessoa.exibirInfo();
System.out.println();
}
}
}