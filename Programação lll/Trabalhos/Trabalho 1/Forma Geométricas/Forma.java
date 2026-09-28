public abstract class Forma {
    // metodo abstrato qyue vai ser implementados pelas classes filhas
    // para calcular a área de cada forma
    public abstract double calcularArea();

    @Override
    public String toString() {
        // retorna o nome da classe e o valor da área 
        return String.format("%-12s -> area = %.2f", getClass().getSimpleName(), calcularArea());
    }
}