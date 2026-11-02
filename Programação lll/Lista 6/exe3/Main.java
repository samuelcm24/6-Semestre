
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        HashMap<String, Integer> pessoas = new HashMap<>();

        System.out.println("=== CADASTRO DE PESSOAS ===");

        int i = 1;

        while (i <= 5) {

            System.out.println("\nPessoa " + i);

            System.out.print("Digite o nome: ");
            String nome = entrada.nextLine().trim();

            if (nome.isEmpty()) {
                System.out.println("Nome invalido!");
                continue;
            }

            if (pessoas.containsKey(nome)) {
                System.out.println("Pessoa ja cadastrada!");
                continue;
            }

            System.out.print("Digite a idade: ");

            try {

                int idade = Integer.parseInt(
                    entrada.nextLine()
                );

                if (idade < 0) {
                    System.out.println("Idade invalida!");
                    continue;
                }

                pessoas.put(nome, idade);

                System.out.println("Pessoa cadastrada!");

                i++;

            } catch (NumberFormatException erro) {

                System.out.println(
                    "Erro: digite uma idade inteira valida!"
                );
            }
        }

        System.out.println("\n=== PESSOAS CADASTRADAS ===");

        for (Map.Entry<String, Integer> pessoa : pessoas.entrySet()) {

            System.out.println(
                pessoa.getKey() + " - " +
                pessoa.getValue() + " anos"
            );
        }

        System.out.println("\n=== CONSULTAR PESSOA ===");

        System.out.print("Digite o nome para consultar: ");
        String consulta = entrada.nextLine().trim();

        if (pessoas.containsKey(consulta)) {

            int idade = pessoas.get(consulta);

            System.out.println(
                consulta + " possui " + idade + " anos."
            );

        } else {

            System.out.println("Pessoa nao cadastrada!");
        }

        System.out.println("\n=== REMOVER PESSOA ===");

        System.out.print("Digite o nome para remover: ");
        String remover = entrada.nextLine().trim();

        if (pessoas.containsKey(remover)) {

            pessoas.remove(remover);

            System.out.println("Pessoa removida com sucesso!");

        } else {

            System.out.println("Pessoa nao encontrada!");
        }

        System.out.println("\n=== MAPA ATUALIZADO ===");

        for (Map.Entry<String, Integer> pessoa : pessoas.entrySet()) {

            System.out.println(
                pessoa.getKey() + " - " +
                pessoa.getValue() + " anos"
            );
        }

        entrada.close();
    }
}
