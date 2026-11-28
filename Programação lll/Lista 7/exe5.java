import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class exe5 {
    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Digite o caminho do arquivo de texto:");
            if (!teclado.hasNextLine()) return;
            String caminho = teclado.nextLine();

            long linhas = 0;
            long palavras = 0;
            long caracteres = 0;
            long numeroDaMaior = 0;
            String maiorLinha = "";

            try (BufferedReader leitor = new BufferedReader(
                    new InputStreamReader(new FileInputStream(caminho), "UTF-8"))) {
                String linha = leitor.readLine();
                while (linha != null) {
                    linhas++;
                    caracteres += linha.length();
                    try (Scanner palavrasDaLinha = new Scanner(linha)) {
                        while (palavrasDaLinha.hasNext()) {
                            palavrasDaLinha.next();
                            palavras++;
                        }
                    }
                    if (linhas == 1 || linha.length() > maiorLinha.length()) {
                        maiorLinha = linha;
                        numeroDaMaior = linhas;
                    }
                    linha = leitor.readLine();
                }
            }

            System.out.println("Linhas: " + linhas);
            System.out.println("Palavras: " + palavras);
            System.out.println("Caracteres: " + caracteres);
            if (linhas == 0) {
                System.out.println("Arquivo vazio. Não há linha mais longa.");
            } else {
                System.out.println("Maior linha: " + numeroDaMaior + " (" + maiorLinha.length() + " caracteres)");
                System.out.println(maiorLinha);
            }
        } catch (IOException e) {
            System.out.println("Não foi possível ler o arquivo: " + e.getMessage());
        }
    }
}
