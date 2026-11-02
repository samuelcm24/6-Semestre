import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    // Calcula a media das notas de um aluno.
    public static double calcularMedia(List<Double> notas) {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.size();
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Map<String, List<Double>> alunos = new HashMap<>();
        int opcao = -1;

        do {
            System.out.println("\n=== REGISTRO DE NOTAS ===");
            System.out.println("1 - Cadastrar aluno / adicionar nota");
            System.out.println("2 - Listar alunos e medias");
            System.out.println("3 - Consultar aluno");
            System.out.println("4 - Remover aluno");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(entrada.nextLine());
            } catch (NumberFormatException erro) {
                System.out.println("Opcao invalida: digite um numero.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Nome do aluno: ");
                    String nome = entrada.nextLine().trim();
                    if (nome.isEmpty()) {
                        System.out.println("Nome nao pode ser vazio.");
                        break;
                    }
                    System.out.print("Nota (0 a 10): ");
                    try {
                        String textoNota = entrada.nextLine().trim().replace(',', '.');
                        double nota = Double.parseDouble(textoNota);
                        if (Double.isNaN(nota) || Double.isInfinite(nota)
                                || nota < 0 || nota > 10) {
                            System.out.println("Nota deve estar entre 0 e 10.");
                            break;
                        }
                        List<Double> notas = alunos.get(nome);
                        if (notas == null) {
                            notas = new ArrayList<>();
                            alunos.put(nome, notas);
                        }
                        notas.add(nota);
                        System.out.println("Nota cadastrada!");
                    } catch (NumberFormatException erro) {
                        System.out.println("Nota invalida.");
                    }
                    break;
                case 2:
                    if (alunos.isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado.");
                    } else {
                        for (Map.Entry<String, List<Double>> aluno : alunos.entrySet()) {
                            System.out.printf(Locale.US, "%s | Notas: %s | Media: %.2f%n",
                                    aluno.getKey(), aluno.getValue(),
                                    calcularMedia(aluno.getValue()));
                        }
                    }
                    break;
                case 3:
                    System.out.print("Nome para consultar: ");
                    String consulta = entrada.nextLine().trim();
                    if (alunos.containsKey(consulta)) {
                        List<Double> notasAluno = alunos.get(consulta);
                        System.out.printf(Locale.US, "%s | Notas: %s | Media: %.2f%n",
                                consulta, notasAluno, calcularMedia(notasAluno));
                    } else {
                        System.out.println("Aluno nao encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Nome para remover: ");
                    String remover = entrada.nextLine().trim();
                    if (alunos.containsKey(remover)) {
                        alunos.remove(remover);
                        System.out.println("Aluno removido!");
                        System.out.println("Dados atualizados:");
                        if (alunos.isEmpty()) {
                            System.out.println("Nenhum aluno cadastrado.");
                        } else {
                            for (Map.Entry<String, List<Double>> aluno : alunos.entrySet()) {
                                System.out.printf(Locale.US, "%s | Notas: %s | Media: %.2f%n",
                                        aluno.getKey(), aluno.getValue(),
                                        calcularMedia(aluno.getValue()));
                            }
                        }
                    } else {
                        System.out.println("Aluno nao encontrado.");
                    }
                    break;
                case 0:
                    System.out.println("Encerrando registro...");
                    break;
                default:
                    System.out.println("Opcao inexistente.");
            }
        } while (opcao != 0);

        entrada.close();
    }
}
