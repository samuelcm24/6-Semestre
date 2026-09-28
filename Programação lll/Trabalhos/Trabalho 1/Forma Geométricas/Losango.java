public class Losango extends Forma {
    private double d_Maior;
    private double d_Menor;

    public Losango(double diagonalMaior, double diagonalMenor) {
        // verificamos se os valores das diagonais são válidos
        if(diagonalMaior < 0 || diagonalMenor < 0){
            throw new IllegalArgumentException("O valor informado não pode ser negativo.\n");
        }

        this.d_Maior = diagonalMaior;
        this.d_Menor = diagonalMenor;
    }

    @Override 
    // formula para calcularmos a area do losangulo
    public double calcularArea() {
        return (d_Maior * d_Menor) / 2;
    }
}