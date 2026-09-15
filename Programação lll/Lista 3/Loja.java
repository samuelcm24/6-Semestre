

public import java.util.Arrays;

public class Loja {

    public static void buscarProduto(Produto alvo, Produto[] vetor) {
        boolean encontrado = false;
        
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].equals(alvo)) {
                System.out.println("-> Produto encontrado no índice [" + i + "]: " + vetor[i].nome);
                encontrado = true;
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println("-> Produto especificado não foi encontrado no vetor.");
        }
    }

    public static void main(String[] args) {
        Produto[] produtos = new Produto[5];
        produtos[0] = new Livro("O Senhor dos Anéis", 89.90, "LIV-001", "J.R.R. Tolkien");
        produtos[1] = new CD("Abbey Road", 45.00, "CD-001", 17);
        produtos[2] = new DVD("Matrix", 29.90, "DVD-001", 136);
        produtos[3] = new Livro("Clean Code", 120.00, "LIV-002", "Robert C. Martin");
        produtos[4] = new CD("Dark Side of the Moon", 55.50, "CD-002", 10);

        System.out.println("=== ESTADO INICIAL DO VETOR (Ex 7) ===");
        for (Produto p : produtos) {
            System.out.println(p); // Chama automaticamente o toString()
        }

        System.out.println("\n=== TESTE DE BUSCA (Ex 8) ===");
        // Escolhemos o "Matrix" (índice 2) como base
        
        Produto dvdBuscaVerdadeiro = new DVD("Matrix Edição Especial", 50.00, "DVD-001", 140);
        System.out.println("Buscando cópia com código igual (DVD-001):");
        buscarProduto(dvdBuscaVerdadeiro, produtos);
        
        Produto dvdBuscaFalso = new DVD("Matrix", 29.90, "DVD-099", 136);
        System.out.println("Buscando cópia com código diferente (DVD-099):");
        buscarProduto(dvdBuscaFalso, produtos);

        System.out.println("\n=== VETOR ORDENADO (Ex 9) ===");
        Arrays.sort(produtos); 
        
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }
} Loja {
    
}
