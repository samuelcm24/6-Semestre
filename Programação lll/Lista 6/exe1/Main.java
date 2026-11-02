
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        ArrayList<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            System.out.print("Digite o numero " + (i + 1) + ": ");

            int numero = entrada.nextInt();

            numeros.add(numero);
        }

        System.out.println("\nNumeros cadastrados:");

        for (int numero : numeros) {
            System.out.println(numero);
        }

        int soma = 0;

        for (int numero : numeros) {
            soma += numero;
        }

        double media = (double) soma / numeros.size();

        System.out.println("\nSoma: " + soma);
        System.out.println("Media: " + media);

        numeros.removeIf(numero -> numero % 2 == 0);

        System.out.println("\nLista sem numeros pares:");

        for (int numero : numeros) {
            System.out.println(numero);
        }

        entrada.close();
    }
}
