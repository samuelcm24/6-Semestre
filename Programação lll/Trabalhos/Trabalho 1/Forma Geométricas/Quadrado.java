public class Quadrado extends Forma {
    private double lado;

    public Quadrado(double lado) {
        // verifica se os valores são validos
        if(lado < 0){
            throw new IllegalArgumentException("O valor informado não pode ser negativo.\n");
        }
        this.lado = lado;
    }

    @Override
    // calculamos o valor da área
    public double calcularArea() {
        return lado * lado;
    }
}