import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

// Questão 2 — Registro de texto em arquivo
public class exe2 {
    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            PrintStream arquivo = new PrintStream("anotacoes.txt", "UTF-8");
            try {
                System.out.println("Digite as anotações. Para encerrar, digite FIM em uma linha.");
                while (teclado.hasNextLine()) {
                    String linha = teclado.nextLine();
                    if (linha.equals("FIM")) {
                        break;
                    }
                    arquivo.println(linha);
                }
            } finally {
                arquivo.close();
            }

            // checkError() consulta as falhas de escrita registradas pelo PrintStream.
            if (arquivo.checkError()) {
                System.out.println("Falha ao gravar anotacoes.txt.");
            } else if (teclado.ioException() != null) {
                System.out.println("A leitura do teclado foi interrompida por um erro.");
            } else {
                System.out.println("Gravação concluída em anotacoes.txt.");
            }
        } catch (IOException e) {
            System.out.println("Não foi possível abrir anotacoes.txt: " + e.getMessage());
        }
    }
}
