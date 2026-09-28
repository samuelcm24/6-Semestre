public class Triangulo extends Forma {
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        // verifica se os valores são validos
        if(base < 0 || altura < 0){
            throw new IllegalArgumentException("O valor informado não pode ser negativo.\n");
        }
        this.base = base;
        this.altura = altura;
    }

    @Override
    // formula para calcular a area do triangulo
    public double calcularArea() {
        return (base * altura) / 2;
    }
}