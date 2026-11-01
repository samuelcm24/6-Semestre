interface Pagamento {
    void processarPagamento(double valor);
    void cancelarPagamento();
}

class PagamentoCartao implements Pagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.printf("Cartão: pagamento de R$ %.2f processado.%n", valor);
    }

    @Override
    public void cancelarPagamento() {
        System.out.println("Cartão: cancelamento solicitado à operadora.");
    }
}

class PagamentoPix implements Pagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.printf("Pix: transferência de R$ %.2f realizada.%n", valor);
    }

    @Override
    public void cancelarPagamento() {
        System.out.println("Pix: solicitação de devolução registrada.");
    }
}

class PagamentoBoleto implements Pagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.printf("Boleto: cobrança de R$ %.2f emitida.%n", valor);
    }

    @Override
    public void cancelarPagamento() {
        System.out.println("Boleto: cobrança cancelada.");
    }
}

public class Main {
    public static void main(String[] args) {
        Pagamento[] pagamentos = {
            new PagamentoCartao(),
            new PagamentoPix(),
            new PagamentoBoleto()
        };

        for (Pagamento pagamento : pagamentos) {
            pagamento.processarPagamento(120.00);
            pagamento.cancelarPagamento();
            System.out.println("----------------------------");
        }
    }
}
