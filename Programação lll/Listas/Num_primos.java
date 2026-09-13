import java.util.Scanner;

public class Num_primos {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Digite o número inicial do intervalo: ");
        int inicio = scan.nextInt();
        
        System.out.print("Digite o número final do intervalo: ");
        int fim = scan.nextInt();
        
        System.out.println("\nNúmeros primos encontrados entre " + inicio + " e " + fim + ":");
        
        for (int atual = inicio; atual <= fim; atual++) {
            
            if (atual <= 1) {
                continue;
            }
            
            boolean ehPrimo = true;
            
            for (int divisor = 2; divisor < atual; divisor++) {
                if (atual % divisor == 0) {
                    ehPrimo = false; 
                    break;
                }
            }
            
            if (ehPrimo) {
                System.out.print(atual + " ");
            }
        }
        
        scan.close();
    }
}