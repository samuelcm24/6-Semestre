import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // cria uma lista para colocarmos cada forma
        List<Forma> formas = new ArrayList<>();
        double somaTotal = 0;

        System.out.println("=== Formas Geometricas ===");

        try {
            // adicionamos as formas
            formas.add(new Circulo(3));
            formas.add(new Quadrado(5));
            formas.add(new Retangulo(4, 6));
            formas.add(new Triangulo(8, 5));
            formas.add(new Losango(10, 4)); 
            formas.add(new Hipercubo(2));
            formas.add(new Paraboloide(3, 4));
            formas.add(new Trapezio(3, 7, 4));

            // adicionando um valor negativo pra circulo para verifcar as condições
            System.out.println("Adicionando para Círculo um valor negativo");
            formas.add(new Circulo(-3)); 

        } catch (IllegalArgumentException erro) {
            // mostrando o erro gerado pelo valor negativo
            System.err.println("-> ERRO: " + erro.getMessage());
            
        } finally {
            // executamos o processo final, independete se occoreu um erro
            System.out.println("-> Valores das formas adicionadas com sucesso.\n");
        }

        System.out.println("=== Soma Das Áreas ===");
        
        // percorremos a lista para calcula a area de cada uma das formas
        for (Forma f : formas) {
            System.out.println(f);
            somaTotal += f.calcularArea();
        

        }

        System.out.printf("\n");
        System.out.printf("Soma total das areas: %.2f%n", somaTotal);
    }
}