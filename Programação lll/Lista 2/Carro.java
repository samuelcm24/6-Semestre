public class Carro{
    String marca;
    String modelo;
    int ano;

    public void exibir_info(){
        System.out.println("Marca " + marca + " Modelo " + modelo + " Ano " + ano);
    }

    public static void main(String[] args) {
        Carro carro1 = new Carro();
        carro1.marca = "Chevrolet";
        carro1.modelo = "Onix";
        carro1.ano = 2020;

        Carro carro2 = new Carro();
        carro2.marca = "Toyota";
        carro2.modelo = "Corolla";
        carro2.ano = 2022;



        System.out.println("Detalhes do carro Chevrolet: ");
        carro1.exibir_info();

        System.out.println("Detalhes do carro Toyota: ");
        carro2.exibir_info();
    }
}