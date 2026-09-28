public class Hipercubo extends Forma {
    private double lado;

    public Hipercubo(double lado) {
        // vrerificando se o valor é valido
        if(lado < 0){
            throw new IllegalArgumentException("O valor informado não pode ser negativo.\n");
        }
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        // formula para calcular a área do cubo
        return 8 * lado * lado * lado;
    }
}