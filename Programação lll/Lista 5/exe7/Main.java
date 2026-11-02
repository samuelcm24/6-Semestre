import java.util.ArrayList;
import java.util.Scanner;

class Aluno {
    private String nome;
    private int idade;
    private double nota;

    public Aluno(String nome, int idade, double nota) {
        this.nome = nome;
        this.idade = idade;
        this.nota = nota;
    }

    @Override
    public String toString() {
        return nome + " | Idade: " + idade + " | Nota: " + nota;
    }
}

public class Main {
    public static void validarNome(String nome) throws IllegalArgumentException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome nao pode estar vazio.");
        }
    }

    public static void validarIdade(int idade) throws IllegalArgumentException {
        if (idade < 0) {
            throw new IllegalArgumentException("Idade nao pode ser negativa.");
        }
    }

    public static void validarNota(double nota) throws IllegalArgumentException {
        if (Double.isNaN(nota) || Double.isInfinite(nota) || nota < 0 || nota > 10) {
            throw new IllegalArgumentException("Nota deve estar entre 0 e 10.");
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Aluno> alunos = new ArrayList<>();
        int aceitos = 0;
        int rejeitados = 0;

        while (true) {
            System.out.print("Nome do aluno (ou 'fim' para encerrar): ");
            String nome = entrada.nextLine();
            if (nome.trim().equalsIgnoreCase("fim")) {
                break;
            }

            System.out.print("Idade: ");
            String textoIdade = entrada.nextLine();
            System.out.print("Nota (use ponto decimal): ");
            String textoNota = entrada.nextLine();

            try {
                int idade = Integer.parseInt(textoIdade);
                double nota = Double.parseDouble(textoNota);

                validarNome(nome);
                validarIdade(idade);
                validarNota(nota);

                alunos.add(new Aluno(nome, idade, nota));
                aceitos++;
                System.out.println("Cadastro aceito!");
            } catch (NumberFormatException erro) {
                rejeitados++;
                System.out.println("Cadastro rejeitado: idade ou nota invalida.");
            } catch (IllegalArgumentException erro) {
                rejeitados++;
                System.out.println("Cadastro rejeitado: " + erro.getMessage());
            } finally {
                System.out.println("Tentativa de cadastro finalizada.");
                System.out.println("----------------------");
            }
        }

        System.out.println("Total de aceitos: " + aceitos);
        System.out.println("Total de rejeitados: " + rejeitados);
        System.out.println("Alunos cadastrados:");
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
        entrada.close();
    }
}
