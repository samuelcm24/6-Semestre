public class Paraboloide extends Forma {
    private double raio;
    private double altura;

    public Paraboloide(double raio, double altura) {
        // veirfica se os valores são válidos
        if(raio < 0 || altura < 0){
            throw new IllegalArgumentException("O valor infomado não pode ser negativo.\n");
        }

        this.raio = raio;
        this.altura = altura;
    }

    @Override 
    public double calcularArea() {
        // calcula o fator utilizado na formula para a área
        double fator = (Math.PI * raio) / (6 * altura * altura);
        // aqui calculamos o termo principal da fórmula da área
        double termo = Math.pow(raio * raio + 4 * altura * altura, 1.5) - Math.pow(raio, 3);
        // mutliplicamos o fator pelo termo e retornamos o valor da área
        return fator * termo;
    }
}