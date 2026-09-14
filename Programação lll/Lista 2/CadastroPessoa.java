import java.util.ArrayList;
import java.util.Iterator;

public class CadastroPessoa {

    public static boolean validarNome(String nome) {
        // Retorna true apenas se não for nulo, não estiver vazio e tiver pelo menos 3 caracteres
        if (nome != null && !nome.trim().isEmpty() && nome.trim().length() >= 3) {
            return true;
        }
        return false;
    }

    public static boolean buscarUsuario(ArrayList<String> lista, String termoBusca) {
        Iterator<String> iterator = lista.iterator();
        
        while (iterator.hasNext()) {
            String nomeAtual = iterator.next();
            if (nomeAtual.equalsIgnoreCase(termoBusca)) {
                return true; // Encontrou o usuário
            }
        }
        return false; // Não encontrou
    }

    public static void main(String[] args) {
        ArrayList<String> usuarios = new ArrayList<>();

        String[] candidatos = {"Samuel", "Gabriel", "  Lu  ", "Isabela", "Fernanda"};
        
        for (String candidato : candidatos) {
            if (validarNome(candidato)) {
                usuarios.add(candidato.trim());
            } else {
                System.out.println("Nome inválido ignorado: '" + candidato + "'");
            }
        }

        System.out.println("\nLista de usuários cadastrados: " + usuarios);

        System.out.println("\nBuscando por 'gabriel': " + buscarUsuario(usuarios, "gabriel")); // Deve ser true
        System.out.println("Buscando por 'lucas': " + buscarUsuario(usuarios, "lucas"));     // Deve ser false
    }
}