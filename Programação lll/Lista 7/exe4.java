import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class exe4 {
    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Caminho do arquivo de origem:");
            if (!teclado.hasNextLine()) return;
            File origem = new File(teclado.nextLine());
            System.out.println("Caminho do arquivo de destino:");
            if (!teclado.hasNextLine()) return;
            File destino = new File(teclado.nextLine());

            copiar(origem, destino);
            System.out.println("Cópia concluída: " + destino.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Não foi possível copiar: " + e.getMessage());
        }
    }

    private static void copiar(File origem, File destino) throws IOException {
        if (!origem.isFile()) {
            throw new IOException("A origem não é um arquivo existente.");
        }
        if (origem.getCanonicalFile().equals(destino.getCanonicalFile())) {
            throw new IOException("A origem e o destino apontam para o mesmo arquivo.");
        }
        if (destino.isDirectory()) {
            throw new IOException("O destino é um diretório. Informe o nome do arquivo de destino.");
        }
        if (destino.exists() && !destino.isFile()) {
            throw new IOException("O destino não é um arquivo comum.");
        }

        // Mantém o destino anterior intacto enquanto os bytes são copiados.
        File pasta = destino.getAbsoluteFile().getParentFile();
        File temporario = File.createTempFile("copia-", ".tmp", pasta);
        try {
            try (FileInputStream entrada = new FileInputStream(origem);
                 FileOutputStream saida = new FileOutputStream(temporario)) {
                byte[] bloco = new byte[4096];
                int lidos = entrada.read(bloco);
                while (lidos != -1) {
                    saida.write(bloco, 0, lidos);
                    lidos = entrada.read(bloco);
                }
            }
            // A cópia já terminou. Aqui apenas colocamos o arquivo no nome definitivo.
            Files.move(temporario.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } finally {
            Files.deleteIfExists(temporario.toPath());
        }
    }
}
