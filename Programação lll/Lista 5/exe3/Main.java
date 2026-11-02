
public class Main {

    public static double calcularRaiz(int numero)
            throws IllegalArgumentException {

        if (numero < 0) {

            throw new IllegalArgumentException(
                "Não é possível calcular a raiz de número negativo."
            );
        }

        return Math.sqrt(numero);
    }

    public static void main(String[] args) {

        // Valores que serão testados
        int[] numeros = {0, 25, -9};

        for (int numero : numeros) {

            System.out.println("Número: " + numero);

            try {

                double resultado = calcularRaiz(numero);

                System.out.println(
                    "Raiz quadrada: " + resultado
                );

            } catch (IllegalArgumentException erro) {

                System.out.println(
                    "Erro: " + erro.getMessage()
                );
            }

        }
    }
}
