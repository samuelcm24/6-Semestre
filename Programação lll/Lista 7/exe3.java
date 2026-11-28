import java.io.File;
import java.util.Scanner;

public class exe3 {
    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Digite o caminho de um arquivo ou diretório:");
            if (!teclado.hasNextLine()) return;
            File recurso = new File(teclado.nextLine());
            System.out.println("Caminho absoluto: " + recurso.getAbsolutePath());

            if (!recurso.exists()) {
                System.out.println("Esse caminho não existe.");
            } else if (recurso.isFile()) {
                System.out.println("O caminho existe e é um arquivo.");
                System.out.println("Tamanho: " + recurso.length() + " bytes");
            } else if (recurso.isDirectory()) {
                System.out.println("O caminho existe e é um diretório.");
                File[] itens = recurso.listFiles();
                if (itens == null) {
                    System.out.println("Não foi possível listar o diretório.");
                } else if (itens.length == 0) {
                    System.out.println("Diretório vazio.");
                } else {
                    for (File item : itens) {
                        String tipo = item.isDirectory() ? "Diretório" : "Arquivo";
                        System.out.println(tipo + ": " + item.getName());
                    }
                }
            } else {
                System.out.println("O caminho existe e aponta para outro tipo de recurso.");
            }
        }
    }
}
