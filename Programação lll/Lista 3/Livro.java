
public class Livro {
    String titulo;
    String autor;

    // Construtor 1
    public Livro(){
        this.titulo = "Titulo 1";
        this.autor = "Autor 1";
    }

    // Construtor 2
    public Livro(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
    }

    public void Dados(){
        System.out.println("Livro: " + titulo + "| Autor: " + autor);
    }

    public static void main(String[] args){
        Livro livro1 = new Livro();
        
        Livro livro2 = new Livro("As crônicas de Gelo e Fogo","George R. R. Martin");

        System.out.println("--- Dados do Livro ----\n");
        livro1.Dados();
        livro2.Dados();
        System.out.println("-----------------------\n");
    }
}
