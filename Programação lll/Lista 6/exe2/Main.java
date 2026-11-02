

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        HashSet<String> palavras = new HashSet<>();

        System.out.println("Cadastro de palavras");
        System.out.println("Digite 'fim' para encerrar.");

        while (true) {

            System.out.print("Digite uma palavra: ");

            String palavra = entrada.nextLine().trim();

            if (palavra.equalsIgnoreCase("fim")) {
                break;
            }

            if (palavra.isEmpty()) {
                System.out.println("Digite uma palavra valida.");
                continue;
            }

            boolean adicionada = palavras.add(palavra);

            if (adicionada) {
                System.out.println("Palavra cadastrada!");
            } else {
                System.out.println("Palavra ja cadastrada!");
            }
        }

        System.out.println("\nPalavras unicas cadastradas:");

        for (String palavra : palavras) {
            System.out.println(palavra);
        }

        if (palavras.contains("Java")) {
            System.out.println("\nA palavra Java foi digitada.");
        } else {
            System.out.println("\nA palavra Java nao foi digitada.");
        }

        System.out.println(
            "Total de palavras distintas: " + palavras.size()
        );

        entrada.close();
    }
}
