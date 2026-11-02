
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        try {

            for (int i = 1; i <= 3; i++) {

                System.out.println("Teste " + i);

                System.out.print("Digite um número inteiro: ");

                String texto = entrada.nextLine();

                try {

                    int numero = Integer.parseInt(texto);

                    System.out.println(
                        "Número convertido: " + numero
                    );

                } catch (NumberFormatException erro) {

                    // Trata uma conversão inválida
                    System.out.println(
                        "Erro: o valor digitado não é um inteiro válido!"
                    );
                }

            }

        } finally {

            System.out.println("Encerrando programa...");
            entrada.close();
        }
    }
}
