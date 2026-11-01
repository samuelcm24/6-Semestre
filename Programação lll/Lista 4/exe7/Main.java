enum NivelAtleta {
    NOVATO, AMADOR, PROFISSIONAL
}

interface Corredor {
    void correr();
}

interface Nadador {
    void nadar();
}

interface Ciclista {
    void pedalar();
}

abstract class Atleta {
    private String nome;
    private int idade;
    private NivelAtleta nivel;

    public Atleta(String nome, int idade, NivelAtleta nivel) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode estar vazio.");
        }
        if (idade < 0) {
            throw new IllegalArgumentException("A idade não pode ser negativa.");
        }
        if (nivel == null) {
            throw new IllegalArgumentException("O nível deve ser informado.");
        }
        this.nome = nome;
        this.idade = idade;
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public void mostrarDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Nível: " + nivel);
    }

    public abstract void exibirModalidades();
}

class CorredorProfissional extends Atleta implements Corredor {
    public CorredorProfissional(String nome, int idade, NivelAtleta nivel) {
        super(nome, idade, nivel);
    }

    @Override
    public void correr() {
        System.out.println(getNome() + " está correndo.");
    }

    @Override
    public void exibirModalidades() {
        System.out.println("Modalidades: Corrida");
    }
}

class NadadorProfissional extends Atleta implements Nadador {
    public NadadorProfissional(String nome, int idade, NivelAtleta nivel) {
        super(nome, idade, nivel);
    }

    @Override
    public void nadar() {
        System.out.println(getNome() + " está nadando.");
    }

    @Override
    public void exibirModalidades() {
        System.out.println("Modalidades: Natação");
    }
}

class Triatleta extends Atleta implements Corredor, Nadador, Ciclista {
    public Triatleta(String nome, int idade, NivelAtleta nivel) {
        super(nome, idade, nivel);
    }

    @Override
    public void correr() {
        System.out.println(getNome() + " está correndo.");
    }

    @Override
    public void nadar() {
        System.out.println(getNome() + " está nadando.");
    }

    @Override
    public void pedalar() {
        System.out.println(getNome() + " está pedalando.");
    }

    @Override
    public void exibirModalidades() {
        System.out.println("Modalidades: Corrida, Natação e Ciclismo");
    }
}

public class Main {
    public static void main(String[] args) {
        Atleta[] atletas = {
            new CorredorProfissional("Ana", 24, NivelAtleta.PROFISSIONAL),
            new NadadorProfissional("Carlos", 28, NivelAtleta.PROFISSIONAL),
            new Triatleta("Maria", 21, NivelAtleta.AMADOR),
            new Triatleta("João", 19, NivelAtleta.NOVATO)
        };

        for (Atleta atleta : atletas) {
            atleta.mostrarDados();
            atleta.exibirModalidades();

            // Referências das interfaces: polimorfismo
            if (atleta instanceof Corredor) {
                Corredor corredor = (Corredor) atleta;
                corredor.correr();
            }
            if (atleta instanceof Nadador) {
                Nadador nadador = (Nadador) atleta;
                nadador.nadar();
            }
            if (atleta instanceof Ciclista) {
                Ciclista ciclista = (Ciclista) atleta;
                ciclista.pedalar();
            }
            System.out.println("----------------------------");
        }

        // Testes das validações adicionais
        try {
            new Triatleta("", 20, NivelAtleta.AMADOR);
        } catch (IllegalArgumentException erro) {
            System.out.println("Cadastro rejeitado: " + erro.getMessage());
        }

        try {
            new Triatleta("Pedro", -2, NivelAtleta.NOVATO);
        } catch (IllegalArgumentException erro) {
            System.out.println("Cadastro rejeitado: " + erro.getMessage());
        }
    }
}
