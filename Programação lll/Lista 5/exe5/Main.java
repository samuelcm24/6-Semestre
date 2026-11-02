public class Main {
    // throw: efetivamente lanca a excecao quando idade < 0.
    // throws: declara na assinatura a excecao que pode ser propagada.
    public static void validarIdade(int idade)
            throws IllegalArgumentException {
        if (idade < 0) {
            throw new IllegalArgumentException("A idade nao pode ser negativa.");
        }
    }

    // Este metodo chama outro e propaga uma possivel excecao.
    public static void cadastrarPessoa(int idade)
            throws IllegalArgumentException {
        validarIdade(idade);
        System.out.println("Cadastro aceito. Idade: " + idade);
    }

    public static void main(String[] args) {
        int[] idades = {20, -5, 0};

        for (int idade : idades) {
            try {
                cadastrarPessoa(idade);
            } catch (IllegalArgumentException erro) {
                System.out.println("Cadastro rejeitado: " + erro.getMessage());
            }
            System.out.println("----------------------");
        }
    }
}
