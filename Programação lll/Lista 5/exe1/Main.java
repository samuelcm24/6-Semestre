import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        for(int i = 1; i <= 3; i++){
        System.out.println("Teste " + i);

        System.out.print("Digite o primeiro numero: ");
        int num1 = entrada.nextInt();

        System.out.print("Digite o segundo numero: ");
        int num2 = entrada.nextInt();

        try{
            int resultado = num1 / num2;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException erro){
            System.out.println("Erro: Divisão por zero não é permitida.");
        }

        }

        entrada.close();
    }
}