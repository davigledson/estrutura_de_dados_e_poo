package lista_valendo_nota_poo.meios_de_pagamento;

public class Cash implements MeioDePagamento {
    private double caixa;

    public Cash(double caixa) {
        this.caixa = caixa;
    }

    @Override
    public boolean autorizarPagamento(double valor) {
        return valor <= caixa; // Só autoriza se o valor estiver no caixa
    }

    @Override
    public void processarPagamento(double valor) {
        if (autorizarPagamento(valor)) {
            caixa -= valor; // Reduz o caixa
            System.out.println("Pagamento em Cash de R$" + valor + " processado.");
        } else {
            System.out.println("Pagamento negado: valor em caixa insuficiente.");
        }
    }
}
