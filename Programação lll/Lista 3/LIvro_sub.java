public class Livro extends Produto {
    private String autor;

    public Livro(String nome, double preco, String codigoDeBarras, String autor) {
        super(nome, preco, codigoDeBarras); // Repassa os dados padrão para o Produto
        this.autor = autor;
    }

    @Override
    public String toString() {
        // Concatena a string do Produto com o atributo específico do Livro
        return "[Livro] " + super.toString() + " | Autor: " + autor;
    }
}

public class CD extends Produto {
    private int numeroDeFaixas;

    public CD(String nome, double preco, String codigoDeBarras, int numeroDeFaixas) {
        super(nome, preco, codigoDeBarras);
        this.numeroDeFaixas = numeroDeFaixas;
    }

    @Override
    public String toString() {
        return "[CD] " + super.toString() + " | Faixas: " + numeroDeFaixas;
    }
}

public class DVD extends Produto {
    private int duracao; // Em minutos

    public DVD(String nome, double preco, String codigoDeBarras, int duracao) {
        super(nome, preco, codigoDeBarras);
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "[DVD] " + super.toString() + " | Duração: " + duracao + " min";
    }
}