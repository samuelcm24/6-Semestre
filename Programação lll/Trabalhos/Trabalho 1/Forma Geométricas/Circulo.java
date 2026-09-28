
public class Circulo extends Forma {
    private double raio;

    public Circulo(double raio) {
        // verifica de o valor inserido e valido
        if(raio < 0){
            throw new IllegalArgumentException("O valor informado não pode ser negativo.\n");
        }
        this.raio = raio;
    }

    @Override
    // formula para calcular a área do circylo
    public double calcularArea() {
        return Math.PI * (raio * raio);
    }
}