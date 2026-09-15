public abstract class Produto implements Comparable<Produto> {
    protected String nome;
    protected double preco;
    protected String codigoDeBarras; // Exigência do Exercício 8

    public Produto(String nome, double preco, String codigoDeBarras) {
        this.nome = nome;
        this.preco = preco;
        this.codigoDeBarras = codigoDeBarras;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | Preço: R$ " + preco + " | Cód: " + codigoDeBarras;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        
        Produto outroProduto = (Produto) obj;
        return this.codigoDeBarras.equals(outroProduto.codigoDeBarras);
    }

    @Override
    public int compareTo(Produto outro) {
        //return this.nome.compareToIgnoreCase(outro.nome);
        
        return Double.compare(this.preco, outro.preco);
    }
}