class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getnome(){
        return nome;
    }

    public int getIdade(){
        return idade;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }
}

public class Aluno_modificado extends Pessoa{
    private int matricula;

    public Aluno_modificado(String nome, int idade, int matricula){
        super(nome, idade);
        this.matricula = matricula;
    }

    public int getMatricula(){
        return matricula;
    }

    public void setMatricula(int matricula){
        this.matricula = matricula;
    }

    public static void main(String[] args){
        Aluno_modificado aluno = new Aluno_modificado("Ana sofia", 20, 2026001);
        
        System.out.println("========= Dados do Aluno =========");
        System.out.println("Nome: " + aluno.getnome());
        System.out.println("Idade: " + aluno.getIdade());
        System.out.println("Matrícula: " + aluno.getMatricula());

        aluno.setNome("Maria Joana");
        aluno.setIdade(22);
        aluno.setMatricula(20260032);

        //testando modificações
        System.out.println("========= Dados do aluno modificados =========");
        System.out.println("Nome: " + aluno.getnome());
        System.out.println("Idade: " + aluno.getIdade());
        System.out.println("Matrícula: " + aluno.getMatricula());
    }
}