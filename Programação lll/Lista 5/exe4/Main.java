import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String[] nomes = {"Ana", "Carlos", "Maria", "Joao", "Beatriz"};

        for (int i = 1; i <= 3; i++) {
            System.out.println("Teste " + i);
            System.out.print("Digite o indice (0 a 4): ");

            try {
                int indice = Integer.parseInt(entrada.nextLine());
                System.out.println("Nome encontrado: " + nomes[indice]);
            } catch (ArrayIndexOutOfBoundsException erro) {
                System.out.println("Erro: posicao inexistente! Use indices de 0 a 4.");
            } catch (NumberFormatException erro) {
                System.out.println("Erro: digite um indice inteiro valido.");
            }
            System.out.println("----------------------");
        }

        entrada.close();
    }
}
