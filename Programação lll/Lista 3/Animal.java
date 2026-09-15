public class Animal {
    public void emitir_som(){
        System.out.println("Som testando 123....");
    }
}

class Cachorro extends Animal{
        @Override 
        public void emitir_som(){
            System.out.println("Au au!");
        }
}

class Gato extends Animal{
    @Override 
    public void emitir_som(){
        System.out.println("Miau miau!");
    }
}

class Animal_teste{
    public static void main(String[] args){
        Animal[] animais = new Animal[2];
        animais[0] = new Cachorro();
        animais[1] = new Gato();

        System.out.println("Percorrendo vetor de animais...");
        for(int i = 0; i < animais.length; i++){
            animais[i].emitir_som();
        }
    }
}