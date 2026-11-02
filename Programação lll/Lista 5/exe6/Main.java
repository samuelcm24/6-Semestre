import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        for (int i = 1; i <= 3; i++) {
            System.out.println("Produto " + i);
            System.out.print("Descricao: ");
            String descricao = entrada.nextLine();
            System.out.print("Preco (use ponto decimal): ");
            String textoPreco = entrada.nextLine();
            System.out.print("Quantidade: ");
            String textoQuantidade = entrada.nextLine();

            try {
                double preco = Double.parseDouble(textoPreco);
                int quantidade = Integer.parseInt(textoQuantidade);

                if (descricao.trim().isEmpty()) {
                    throw new IllegalArgumentException("A descricao nao pode estar vazia.");
                }
                if (Double.isNaN(preco) || Double.isInfinite(preco)
                        || preco < 0 || quantidade < 0) {
                    throw new IllegalArgumentException(
                        "Preco e quantidade devem ser numeros nao negativos e finitos."
                    );
                }

                double total = preco * quantidade;
                System.out.println("Produto: " + descricao);
                System.out.printf("Valor total do estoque: R$ %.2f%n", total);
            } catch (NumberFormatException erro) {
                System.out.println("Erro: preco ou quantidade nao e um numero valido.");
            } catch (IllegalArgumentException erro) {
                System.out.println("Erro: " + erro.getMessage());
            } finally {
                System.out.println("Encerrando registro de produto...");
                System.out.println("----------------------");
            }
        }
        entrada.close();
    }
}
