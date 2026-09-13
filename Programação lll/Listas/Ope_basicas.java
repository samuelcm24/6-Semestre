
import java.util.Scanner;

public class Ope_basicas {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        double n1 = sc.nextDouble();

        System.out.print("Digite o segundo número: ");
        double n2 = sc.nextDouble();

        System.out.println("\nEscolha a operação desejada (+, -, * /");
        System.out.println("1 - Adição (+)");
        System.out.println("2 - Subtração (-)");
        System.out.println("3 - MUltiplicação (*)");
        System.out.println("4 - Divisão (/)");

        System.out.print("\nOpção: ");
        
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Resultado da soma: " + (n1 + n2));
                break;
                
            case 2:
                System.out.println("Resultado da subtração: " + (n1 - n2));
                break;
            case 3:
                System.out.println("Resultado da multiplicação: " + (n1 * n2));
                break;
            case 4:
                System.out.println("Resultado da divisão: " + (n1 / n2));
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

        sc.close();

    }    
}
