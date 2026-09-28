public class Retangulo extends Forma {
    private double base;
    private double altura;

    public Retangulo(double base, double altura) {
        // verifica se os valores da base e da altura são validos
        if(base < 0 || altura < 0){
            throw new IllegalArgumentException("O valor do retangulo não pode ser negativo.\n");
        }
        this.base = base;
        this.altura = altura;
    }

    @Override
    //calculamos a área do retãngulo
    public double calcularArea() {
        return base * altura;
    }
}