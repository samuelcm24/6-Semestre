
 
// Interface Corredor
interface Corredor {
    void correr();
}

// Interface Nadador
interface Nadador {
    void nadar();
}

// Interface Ciclista
interface Ciclista {
    void pedalar();
}

// Classe que implementa as três interfaces
class Triatleta implements Corredor, Nadador, Ciclista {

    private String nome;

    // Construtor
    public Triatleta(String nome) {
        this.nome = nome;
    }

    // Implementação do método correr
    @Override
    public void correr() {
        System.out.println(nome + " está correndo.");
    }

    // Implementação do método nadar
    @Override
    public void nadar() {
        System.out.println(nome + " está nadando.");
    }

    // Implementação do método pedalar
    @Override
    public void pedalar() {
        System.out.println(nome + " está pedalando.");
    }

    // Exibe as modalidades do triatleta
    public void mostrarModalidades() {
        System.out.println("Triatleta: " + nome);
        System.out.println("Modalidades: Corrida, Natação e Ciclismo.");
    }
}

public class Main {

    public static void main(String[] args) {

        Triatleta t1 = new Triatleta("Ana");
        Triatleta t2 = new Triatleta("Carlos");

        Triatleta[] atletas = {t1, t2};

        for (Triatleta atleta : atletas) {

            atleta.mostrarModalidades();

            atleta.correr();
            atleta.nadar();
            atleta.pedalar();

            System.out.println("------------------------");
        }
    }
}
