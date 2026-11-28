import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

// Questão 7 — Cadastro de alunos com persistência em alunos.txt
public class exe7 {
    private static final File ARQUIVO = new File("alunos.txt");
    private static final Locale PORTUGUES = Locale.forLanguageTag("pt-BR");

    private static class Aluno {
        final String nome;
        final String curso;
        final double nota;

        Aluno(String nome, String curso, double nota) {
            this.nome = nome;
            this.curso = curso;
            this.nota = nota;
        }
    }

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n1 - Cadastrar aluno\n2 - Listar alunos\n3 - Calcular média\n0 - Sair");
                if (!teclado.hasNextLine()) return;
                String opcao = teclado.nextLine().trim();
                try {
                    switch (opcao) {
                        case "0":
                            return;
                        case "1":
                            cadastrar(teclado);
                            break;
                        case "2":
                            for (Aluno aluno : lerAlunos()) {
                                System.out.printf(PORTUGUES, "Nome: %s | Curso: %s | Nota: %.2f%n",
                                        aluno.nome, aluno.curso, aluno.nota);
                            }
                            break;
                        case "3":
                            calcularMedia(lerAlunos());
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                } catch (IOException e) {
                    System.out.println("Não foi possível concluir a operação: " + e.getMessage());
                }
            }
        }
    }

    private static String lerCampo(Scanner teclado, String pergunta) throws IOException {
        while (true) {
            System.out.println(pergunta);
            if (!teclado.hasNextLine()) {
                throw new IOException("A entrada do teclado foi interrompida.");
            }
            String valor = teclado.nextLine().trim();
            if (!valor.isEmpty()) return valor;
            System.out.println("Preencha este campo.");
        }
    }

    private static double converterNota(String texto) {
        double nota = Double.parseDouble(texto.trim().replace(',', '.'));
        if (!Double.isFinite(nota)) {
            throw new NumberFormatException("A nota deve ser um número finito.");
        }
        return nota;
    }

    private static void cadastrar(Scanner teclado) throws IOException {
        String nome = lerCampo(teclado, "Nome do aluno:");
        String curso = lerCampo(teclado, "Curso:");
        double nota;
        while (true) {
            String texto = lerCampo(teclado, "Nota:");
            try {
                nota = converterNota(texto);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Nota inválida. Digite um número, como 8,5.");
            }
        }

        // O segundo argumento true acrescenta o registro ao fim de alunos.txt.
        PrintStream saida = new PrintStream(new FileOutputStream(ARQUIVO, true), false, "UTF-8");
        try {
            saida.println(nome);
            saida.println(curso);
            saida.println(nota);
        } finally {
            saida.close();
        }
        if (saida.checkError()) {
            throw new IOException("Houve uma falha na gravação de alunos.txt.");
        }
        System.out.println("Aluno cadastrado.");
    }

    private static ArrayList<Aluno> lerAlunos() throws IOException {
        ArrayList<Aluno> alunos = new ArrayList<>();
        if (!ARQUIVO.exists()) {
            System.out.println("O arquivo alunos.txt ainda não existe.");
            return alunos;
        }
        try (BufferedReader leitor = new BufferedReader(
                new InputStreamReader(new FileInputStream(ARQUIVO), "UTF-8"))) {
            String nome = leitor.readLine();
            while (nome != null) {
                String curso = leitor.readLine();
                String textoNota = leitor.readLine();
                int numero = alunos.size() + 1;
                if (nome.trim().isEmpty() || curso == null || curso.trim().isEmpty() || textoNota == null) {
                    throw new IOException("O registro " + numero + " está incompleto em alunos.txt.");
                }
                try {
                    alunos.add(new Aluno(nome, curso, converterNota(textoNota)));
                } catch (NumberFormatException e) {
                    throw new IOException("A nota do registro " + numero + " é inválida em alunos.txt.", e);
                }
                nome = leitor.readLine();
            }
        }
        if (alunos.isEmpty()) {
            System.out.println("O arquivo alunos.txt está vazio.");
        }
        return alunos;
    }

    private static void calcularMedia(ArrayList<Aluno> alunos) {
        if (alunos.isEmpty()) return;
        double soma = 0;
        for (Aluno aluno : alunos) {
            soma += aluno.nota;
        }
        System.out.printf(PORTUGUES, "Média das notas: %.2f%n", soma / alunos.size());
    }
}
