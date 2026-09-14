import java.util.ArrayList;
import java.util.Iterator;

public class Lista_de_alunos {
    public static void main(String[] args) {
        
        ArrayList<String> alunos = new ArrayList<>();
        
        alunos.add("Ana Oliveira");
        alunos.add("Bruno Costa");
        alunos.add("Carlos Silva");
        alunos.add("Diana Souza");
        alunos.add("Eduardo Mendes");
        
        System.out.println("Lista de alunos cadastrados:");
        
        Iterator<String> iterator = alunos.iterator();
        while (iterator.hasNext()) {
            String nome = iterator.next();
            System.out.println("- " + nome);
        }
        
        System.out.println("\nRemovendo o aluno 'Carlos Silva'...");
        alunos.remove("Carlos Silva"); 
        
        System.out.println("\nLista de alunos atualizada:");
        
        Iterator<String> iteradorAtualizado = alunos.iterator();
        while (iteradorAtualizado.hasNext()) {
            System.out.println("- " + iteradorAtualizado.next());
        }
    }
}