


// Conta Corrente
class ContaCorrente extends ContaBancaria {

    public ContaCorrente(String titular, double saldo) {
        super(titular, saldo);
    }

    @Override
    public boolean sacar(double valor) {

        double total = valor + 1.00;

        if (valor > 0 && saldo >= total) {
            saldo -= total;
            return true;
        }

        return false;
    }

    @Override
    public void depositar(double valor) {

        if (valor > 0) {
            saldo += valor;
        }
    }
}

// Conta Poupança
class ContaPoupanca extends ContaBancaria {

    public ContaPoupanca(String titular, double saldo) {
        super(titular, saldo);
    }

    @Override
    public boolean sacar(double valor) {

        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        }

        return false;
    }

    @Override
    public void depositar(double valor) {

        if (valor > 0) {
            saldo += valor;
        }
    }
}

// Classe principal
public class Main {

    public static void main(String[] args) {

        ContaBancaria corrente =
            new ContaCorrente("Ana", 100.00);

        ContaBancaria poupanca =
            new ContaPoupanca("Carlos", 100.00);

        // Depósitos
        corrente.depositar(50.00);
        poupanca.depositar(50.00);

        // Saques válidos
        System.out.println(
            "Saque corrente: " + corrente.sacar(40.00)
        );

        System.out.println(
            "Saque poupança: " + poupanca.sacar(40.00)
        );

        // Saques inválidos
        System.out.println(
            "Saque sem saldo: " + corrente.sacar(200.00)
        );

        System.out.println(
            "Saque negativo: " + poupanca.sacar(-10.00)
        );

        // Saldos finais
        System.out.println(
            "Saldo corrente: R$ " + corrente.getSaldo()
        );

        System.out.println(
            "Saldo poupança: R$ " + poupanca.getSaldo()
        );
    }
}
