
public class Sequencia_fib {
    public static void main(String[] args){
        int ant = 1; // variavel que armazena o termo anterior da sequência
        int idx_atual = 1; // variavel que armazena o termo atual da sequência
        
        System.out.println("30 primeiros elementos da sequência de Fibonacci: ");
        System.out.println(ant + " " + idx_atual); // imprime os dois primeiros termos da sequência
        
        // for para calcular os próximos 28 termos da sequência
        for(int i = 3; i <= 30; i++){
            int prox = ant + idx_atual; // calcula o próximo termo da sequência
            System.out.println(prox + " "); // imprime o próximo termo da sequência
            ant = idx_atual; // atualiza o termo anterior para o termo atual
            idx_atual = prox; // atualiza o termo atual para o próximo termo
        }
    }
}
