class Pessoa {
    String nome;
    int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}

public class Aluno extends Pessoa {
    int matricula;

    public Aluno(String nome, int idade, int matricula) {
        // Chama o construtor da classe pai (Pessoa)
        super(nome, idade);
        
        this.matricula = matricula;
    }

    public void mostrarInformacoes() {
        System.out.println("Aluno: " + nome + " | Idade: " + idade + " | Matrícula: " + matricula);
    }

    public static void main(String[] args) {
        Aluno aluno = new Aluno("Carlos Andrade", 21, 2026001);
        
        aluno.mostrarInformacoes();
    }
}