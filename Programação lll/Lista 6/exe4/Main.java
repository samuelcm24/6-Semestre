import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<String> livros = new ArrayList<>();
        int opcao = -1;

        do {
            System.out.println("\n=== CATALOGO DE LIVROS ===");
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Pesquisar titulo");
            System.out.println("4 - Remover por indice");
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
                    System.out.print("Titulo do livro: ");
                    String titulo = entrada.nextLine().trim();
                    if (titulo.isEmpty()) {
                        System.out.println("Titulo nao pode ser vazio.");
                    } else {
                        livros.add(titulo);
                        System.out.println("Livro adicionado com sucesso!");
                    }
                    break;
                case 2:
                    if (livros.isEmpty()) {
                        System.out.println("Nenhum livro cadastrado.");
                    } else {
                        for (int i = 0; i < livros.size(); i++) {
                            System.out.println(i + " - " + livros.get(i));
                        }
                        System.out.println("Listagem concluida.");
                    }
                    break;
                case 3:
                    System.out.print("Titulo para pesquisar: ");
                    String busca = entrada.nextLine().trim();
                    int indiceEncontrado = -1;
                    for (int i = 0; i < livros.size(); i++) {
                        if (livros.get(i).equalsIgnoreCase(busca)) {
                            indiceEncontrado = i;
                            break;
                        }
                    }
                    if (indiceEncontrado >= 0) {
                        System.out.println("Livro encontrado no indice " + indiceEncontrado + ".");
                    } else {
                        System.out.println("Livro nao encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Indice do livro a remover: ");
                    try {
                        int indice = Integer.parseInt(entrada.nextLine());
                        if (indice >= 0 && indice < livros.size()) {
                            String removido = livros.remove(indice);
                            System.out.println("Livro removido: " + removido);
                        } else {
                            System.out.println("Indice invalido.");
                        }
                    } catch (NumberFormatException erro) {
                        System.out.println("Indice deve ser um numero inteiro.");
                    }
                    break;
                case 0:
                    System.out.println("Encerrando catalogo...");
                    break;
                default:
                    System.out.println("Opcao inexistente.");
            }
        } while (opcao != 0);

        entrada.close();
    }
}
