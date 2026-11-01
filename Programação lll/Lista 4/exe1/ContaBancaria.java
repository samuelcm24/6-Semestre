abstract class ContaBancaria {

    protected String titular;
    protected double saldo;

    public ContaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public abstract boolean sacar(double valor);

    public abstract void depositar(double valor);

    public double getSaldo() {
        return saldo;
    }
}