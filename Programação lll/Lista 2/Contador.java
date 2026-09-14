/*Controle de Instâncias com Atributo Estático
Crie uma classe chamada Contador que contenha:
Um atributo estático totalObjetos (int) para contabilizar a quantidade total de instâncias criadas.
Um construtor que incremente automaticamente o valor de totalObjetos a cada nova instanciação.
Um método estático mostrarTotal() que exibe o valor atual do contador.
No método main , instancie 3 ou mais objetos do tipo Contador e, em seguida, chame o método estático
mostrarTotal() diretamente pela classe.
*/

public class Contador{
    static int total_objetos = 0;

    public Contador(){
        total_objetos++;
    }

    public static void mostrar_total(){
        System.out.println("Total de instâncias criadas: " + total_objetos);
    }

    public static void main(String[] args) {
        Contador c1 = new Contador();
        Contador c2 = new Contador();
        Contador c3 = new Contador();

        Contador c4 = new Contador();

        Contador.mostrar_total();
    }
}