

public class ContaBancaria {
    int num;

    public ContaBancaria(int num){
        this.num = num;
    }

    @Override 
    public String toString(){
        return "Conta bancaria de número: " + this.num;
    }

    @Override 
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }

        if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }

        ContaBancaria outraConta = (ContaBancaria) obj;

        return this.num == outraConta.num;
    }

    public static void main(String[] args){
        ContaBancaria c1 = new ContaBancaria(123);
        ContaBancaria c2 = new ContaBancaria(123);

        System.out.println("A conta c1 é igual a conta c2? " + c1.equals(c2));
        System.out.println("-- Teste do toString() --");
        System.out.println("Imprimindo c1 direto: " + c1);
    }
    

}
