public class Produto {
    int id;
    String nome;
    double preco;

    // Construtor para facilitar a criação do objeto
    public Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    // Atualiza o preço subtraindo a porcentagem informada
    public void aplicarDesconto(double porcentagem) {
        double valorDesconto = this.preco * (porcentagem / 100);
        this.preco = this.preco - valorDesconto;
    }

    // Mostra o id, nome e preço
    public void exibirDetalhes() {
        System.out.println("ID: " + id + " | Produto: " + nome + " | Preço Atual: R$ " + preco);
    }

    public static void main(String[] args) {
        // Criação de dois objetos Produto
        Produto p1 = new Produto(1, "Teclado Mecânico", 250.00);
        Produto p2 = new Produto(2, "Monitor 24 Pol", 900.00);

        // Aplica descontos de 10% e 15%
        p1.aplicarDesconto(10);
        p2.aplicarDesconto(15);

        // Exibe os detalhes atualizados
        p1.exibirDetalhes();
        p2.exibirDetalhes();
    }
}