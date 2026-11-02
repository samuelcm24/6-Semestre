import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        HashSet<String> participantes = new HashSet<>();

        System.out.println("=== CADASTRO DE PARTICIPANTES ===");
        while (true) {
            System.out.print("Nome (ou 'fim'): ");
            String nome = entrada.nextLine().trim();

            if (nome.equalsIgnoreCase("fim")) {
                break;
            }
            if (nome.isEmpty()) {
                System.out.println("Nome nao pode ser vazio.");
                continue;
            }
            if (participantes.add(nome)) {
                System.out.println("Participante registrado!");
            } else {
                System.out.println("Este participante ja foi registrado.");
            }
        }

        System.out.println("\nParticipantes unicos:");
        for (String nome : participantes) {
            System.out.println("- " + nome);
        }
        System.out.println("Total de participantes: " + participantes.size());

        System.out.print("Nome para verificar inscricao: ");
        String consulta = entrada.nextLine().trim();
        if (participantes.contains(consulta)) {
            System.out.println(consulta + " esta inscrito(a).");
        } else {
            System.out.println(consulta + " nao esta inscrito(a).");
        }
        entrada.close();
    }
}
