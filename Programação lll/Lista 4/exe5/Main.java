enum StatusPedido {
    AGUARDANDO_PAGAMENTO,
    PAGO,
    ENVIADO,
    ENTREGUE,
    CANCELADO
}

class Pedido {
    private int numero;
    private double valor;
    private StatusPedido status;

    public Pedido(int numero, double valor) {
        this.numero = numero;
        this.valor = valor;
        this.status = StatusPedido.AGUARDANDO_PAGAMENTO;
    }

    public void alterarStatus(StatusPedido novoStatus) {
        if (novoStatus != null) {
            this.status = novoStatus;
        }
    }

    public void exibirSituacao() {
        System.out.printf("Pedido %d (R$ %.2f): ", numero, valor);

        switch (status) {
            case AGUARDANDO_PAGAMENTO:
                System.out.println("aguardando pagamento.");
                break;
            case PAGO:
                System.out.println("pagamento confirmado.");
                break;
            case ENVIADO:
                System.out.println("pedido enviado.");
                break;
            case ENTREGUE:
                System.out.println("pedido entregue.");
                break;
            case CANCELADO:
                System.out.println("pedido cancelado.");
                break;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Pedido p1 = new Pedido(101, 90.00);
        Pedido p2 = new Pedido(102, 150.00);
        Pedido p3 = new Pedido(103, 200.00);

        p2.alterarStatus(StatusPedido.PAGO);
        p3.alterarStatus(StatusPedido.ENVIADO);

        p1.exibirSituacao();
        p2.exibirSituacao();
        p3.exibirSituacao();

        System.out.println("--- Após atualização ---");
        p1.alterarStatus(StatusPedido.CANCELADO);
        p2.alterarStatus(StatusPedido.ENTREGUE);
        p1.exibirSituacao();
        p2.exibirSituacao();
    }
}
