import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// Questão 1 — Leitura de arquivo de texto
public class exe1 {
    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Digite o caminho do arquivo de texto:");
            if (!teclado.hasNextLine()) return;
            String caminho = teclado.nextLine();

            try (FileInputStream entrada = new FileInputStream(caminho);
                 InputStreamReader conversor = new InputStreamReader(entrada, "UTF-8");
                 BufferedReader leitor = new BufferedReader(conversor)) {
                String linha = leitor.readLine();
                while (linha != null) {
                    System.out.println(linha);
                    linha = leitor.readLine();
                }
            } catch (FileNotFoundException e) {
                System.out.println("Não foi possível abrir o arquivo: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            }
        }
    }
}
