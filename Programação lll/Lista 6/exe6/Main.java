import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        HashMap<String, Integer> estoque = new HashMap<>();
        int opcao = -1;

        do {
            System.out.println("\n=== CONTROLE DE ESTOQUE ===");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Consultar produto");
            System.out.println("3 - Atualizar quantidade");
            System.out.println("4 - Remover produto");
            System.out.println("5 - Exibir estoque");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(entrada.nextLine());
            } catch (NumberFormatException erro) {
                System.out.println("Opcao invalida: digite um numero.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String novo = entrada.nextLine().trim();
                    if (novo.isEmpty() || estoque.containsKey(novo)) {
                        System.out.println("Nome vazio ou produto ja cadastrado.");
                        break;
                    }
                    System.out.print("Quantidade: ");
                    try {
                        int qtd = Integer.parseInt(entrada.nextLine());
                        if (qtd < 0) {
                            System.out.println("Quantidade nao pode ser negativa.");
                        } else {
                            estoque.put(novo, qtd);
                            System.out.println("Produto cadastrado!");
                        }
                    } catch (NumberFormatException erro) {
                        System.out.println("Quantidade deve ser inteira.");
                    }
                    break;
                case 2:
                    System.out.print("Nome para consultar: ");
                    String consulta = entrada.nextLine().trim();
                    if (estoque.containsKey(consulta)) {
                        System.out.println("Quantidade: " + estoque.get(consulta));
                    } else {
                        System.out.println("Produto nao encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Nome para atualizar: ");
                    String atualizar = entrada.nextLine().trim();
                    if (!estoque.containsKey(atualizar)) {
                        System.out.println("Produto nao encontrado.");
                        break;
                    }
                    System.out.print("Nova quantidade: ");
                    try {
                        int qtdNova = Integer.parseInt(entrada.nextLine());
                        if (qtdNova < 0) {
                            System.out.println("Quantidade nao pode ser negativa.");
                        } else {
                            estoque.put(atualizar, qtdNova);
                            System.out.println("Quantidade atualizada!");
                        }
                    } catch (NumberFormatException erro) {
                        System.out.println("Quantidade deve ser inteira.");
                    }
                    break;
                case 4:
                    System.out.print("Nome para remover: ");
                    String remover = entrada.nextLine().trim();
                    if (estoque.containsKey(remover)) {
                        estoque.remove(remover);
                        System.out.println("Produto removido!");
                    } else {
                        System.out.println("Produto nao encontrado.");
                    }
                    break;
                case 5:
                    if (estoque.isEmpty()) {
                        System.out.println("Estoque vazio.");
                    } else {
                        for (Map.Entry<String, Integer> item : estoque.entrySet()) {
                            System.out.println(item.getKey() + ": " + item.getValue());
                        }
                    }
                    break;
                case 0:
                    System.out.println("Encerrando estoque...");
                    break;
                default:
                    System.out.println("Opcao inexistente.");
            }
        } while (opcao != 0);

        entrada.close();
    }
}
