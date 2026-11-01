
import java.util.Scanner;
import java.util.Locale;

abstract class Funcionario {

    private String nome;
    private String matricula;
    private double salarioBase;

    public Funcionario(String nome, String matricula,
                       double salarioBase) {
        this.nome = nome;
        this.matricula = matricula;
        this.salarioBase = salarioBase;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public abstract double calcularSalario();
}

// Funcionário CLT
class FuncionarioCLT extends Funcionario {

    public FuncionarioCLT(String nome, String matricula,
                          double salarioBase) {
        super(nome, matricula, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() * 1.10;
    }
}

class FuncionarioComissionado extends Funcionario {

    private double comissao;

    public FuncionarioComissionado(String nome, String matricula,
                                  double salarioBase, double comissao) {
        super(nome, matricula, salarioBase);
        this.comissao = comissao;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + comissao;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Locale brasil = Locale.forLanguageTag("pt-BR");
        entrada.useLocale(brasil);

        System.out.print("Informe a comissão: R$ ");
        double comissao = entrada.nextDouble();

        Funcionario f1 = new FuncionarioCLT(
            "Ana", "001", 3000.00
        );

        Funcionario f2 = new FuncionarioComissionado(
            "Carlos", "002", 2000.00, comissao
        );

        Funcionario[] funcionarios = {f1, f2};

    
        for (Funcionario f : funcionarios) {

            System.out.println("Nome: " + f.getNome());
            System.out.println("Matrícula: " + f.getMatricula());

            System.out.printf(
                brasil, "Salário final: R$ %,.2f%n",
                f.calcularSalario()
            );

            System.out.println("-------------------");
        }

        entrada.close();
    }
}
