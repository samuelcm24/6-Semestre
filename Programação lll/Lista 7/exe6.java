import java.io.File;
import java.io.IOException;
import java.util.Scanner;

// Questão 6 — Organização de arquivos com a classe File
public class exe6 {
    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Digite o caminho do diretório:");
            if (!teclado.hasNextLine()) return;
            String caminho = teclado.nextLine();
            if (caminho.trim().isEmpty()) {
                System.out.println("Informe um caminho de diretório.");
                return;
            }
            File diretorio = new File(caminho);

            while (true) {
                System.out.println("\n1 - Verificar diretório\n2 - Criar diretório\n3 - Listar conteúdo");
                System.out.println("4 - Exibir caminhos e tamanhos\n5 - Criar arquivo de texto\n0 - Sair");
                if (!teclado.hasNextLine()) return;
                String opcao = teclado.nextLine().trim();

                switch (opcao) {
                    case "0":
                        return;
                    case "1":
                        if (diretorio.isDirectory()) {
                            System.out.println("O diretório existe.");
                        } else if (diretorio.exists()) {
                            System.out.println("O caminho existe, mas aponta para um arquivo.");
                        } else {
                            System.out.println("O diretório não existe.");
                        }
                        break;
                    case "2":
                        if (diretorio.isDirectory()) {
                            System.out.println("O diretório já existe.");
                        } else if (diretorio.mkdirs()) {
                            System.out.println("Diretório criado.");
                        } else {
                            System.out.println("Não foi possível criar o diretório.");
                        }
                        break;
                    case "3":
                    case "4":
                        listar(diretorio, opcao.equals("4"));
                        break;
                    case "5":
                        criarArquivo(diretorio, teclado);
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            }
        }
    }

    private static void listar(File diretorio, boolean mostrarDetalhes) {
        if (!diretorio.isDirectory()) {
            System.out.println("Informe um diretório válido. Use a opção 2 para criá-lo se necessário.");
            return;
        }
        File[] itens = diretorio.listFiles();
        if (itens == null) {
            System.out.println("Não foi possível listar o diretório.");
        } else if (itens.length == 0) {
            System.out.println("Diretório vazio.");
        } else {
            for (File item : itens) {
                String nome = mostrarDetalhes ? item.getAbsolutePath() : item.getName();
                if (item.isDirectory()) {
                    System.out.println("Diretório: " + nome);
                } else if (mostrarDetalhes && item.isFile()) {
                    System.out.println("Arquivo: " + nome + " (" + item.length() + " bytes)");
                } else {
                    System.out.println("Arquivo: " + nome);
                }
            }
        }
    }

    private static void criarArquivo(File diretorio, Scanner teclado) {
        if (!diretorio.isDirectory()) {
            System.out.println("É preciso ter um diretório válido antes de criar o arquivo.");
            return;
        }
        System.out.println("Nome do novo arquivo de texto (ex.: resumo.txt):");
        if (!teclado.hasNextLine()) return;
        String nome = teclado.nextLine().trim();
        if (nome.isEmpty() || nome.equals(".") || nome.equals("..") || !nome.equals(new File(nome).getName())) {
            System.out.println("Digite apenas um nome de arquivo dentro do diretório escolhido.");
            return;
        }
        if (!nome.toLowerCase().endsWith(".txt")) {
            nome += ".txt";
        }
        File novo = new File(diretorio, nome);
        try {
            if (novo.createNewFile()) {
                System.out.println("Arquivo criado: " + novo.getAbsolutePath());
            } else {
                System.out.println("Já existe um item com esse nome.");
            }
        } catch (IOException e) {
            System.out.println("Não foi possível criar o arquivo: " + e.getMessage());
        }
    }
}
