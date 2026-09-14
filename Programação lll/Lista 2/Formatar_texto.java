public class Formatar_texto {
    public static void main(String[] args) {
        String frase = "  Programação Orientada a Objetos com Java  ";
        
        String fraseTratada = frase.trim();
        System.out.println("Frase tratada: '" + fraseTratada + "'");
        
        System.out.println("Total de caracteres: " + fraseTratada.length());
        
        System.out.println("Maiúsculas: " + fraseTratada.toUpperCase());
        
        System.out.println("Substituição: " + fraseTratada.replace("Java", "Linguagem Java"));
        
        
        System.out.println("Caractere no índice 5: " + fraseTratada.charAt(5));
    }
}