import java.util.ArrayList;
import java.util.Iterator;

public class ContaBancaria {
    int numero;
    String titular;
    double saldo;

    public ContaBancaria(int numero, String titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public static void main(String[] args) {
        ArrayList<ContaBancaria> listaContas = new ArrayList<>();

        listaContas.add(new ContaBancaria(1001, "Alice Souza", 2500.50));
        listaContas.add(new ContaBancaria(1002, "Bruno Costa", 1340.00));
        listaContas.add(new ContaBancaria(1003, "Carla Dias", 450.75));

        double saldoAcumulado = 0;

        System.out.println("Contas Registradas:");
        
        Iterator<ContaBancaria> iterator = listaContas.iterator();
        while (iterator.hasNext()) {
            ContaBancaria contaAtual = iterator.next();
            
            System.out.println("- Número: " + contaAtual.numero + " | Titular: " + contaAtual.titular);
            
            saldoAcumulado += contaAtual.saldo;
        }

        System.out.println("\nSaldo total no banco: R$ " + saldoAcumulado);
    }
}