public class Trapezio extends Forma {
    private double b_Menor;
    private double b_Maior;
    private double altura;

    public Trapezio(double baseMenor, double baseMaior, double altura) {
        // verifica se os valores são validos
        if(baseMenor< 0 || baseMaior < 0 || altura < 0 ){
            throw new IllegalArgumentException("Os valores informados não podem ser negativos.\n");
        }
        this.b_Maior = baseMaior;
        this.b_Menor = baseMenor;
        this.altura = altura;
    }

    @Override 
    // calcula a área do trapezeio
    public double calcularArea() {
        return (b_Maior + b_Menor) * altura / 2;
    }
}