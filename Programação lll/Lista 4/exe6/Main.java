import java.util.Locale;

enum NivelAcesso {
    BASICO, INTERMEDIARIO, ADMIN
}

class Usuario {
    private String nome;
    private NivelAcesso nivel;

    public Usuario(String nome, NivelAcesso nivel) {
        this.nome = nome;
        this.nivel = nivel;
    }

    public boolean verificarPermissao(String recurso) {
        if (recurso == null) {
            return false;
        }

        String acao = recurso.trim().toUpperCase(Locale.ROOT);

        switch (nivel) {
            case BASICO:
                return acao.equals("CONSULTAR");
            case INTERMEDIARIO:
                return acao.equals("CONSULTAR") || acao.equals("EDITAR");
            case ADMIN:
                return acao.equals("CONSULTAR")
                    || acao.equals("EDITAR")
                    || acao.equals("GERENCIAR_USUARIOS");
            default:
                return false;
        }
    }

    public String getNome() {
        return nome;
    }

    public NivelAcesso getNivel() {
        return nivel;
    }
}

public class Main {
    public static void main(String[] args) {
        Usuario[] usuarios = {
            new Usuario("Ana", NivelAcesso.BASICO),
            new Usuario("Carlos", NivelAcesso.INTERMEDIARIO),
            new Usuario("Maria", NivelAcesso.ADMIN)
        };

        String[] recursos = {
            "CONSULTAR", "EDITAR", "GERENCIAR_USUARIOS"
        };

        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getNome() + " (" + usuario.getNivel() + ")");
            for (String recurso : recursos) {
                boolean permitido = usuario.verificarPermissao(recurso);
                System.out.println(recurso + ": " + (permitido ? "PERMITIDO" : "NEGADO"));
            }
            System.out.println("----------------------------");
        }
    }
}
