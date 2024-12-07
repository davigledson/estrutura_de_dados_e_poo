package lista_valendo_nota_poo.meios_de_pagamento;
public class CartaoCredito implements MeioDePagamento {
    private double limite;

    public CartaoCredito(double limite) {
        this.limite = limite;
    }

    @Override
    public boolean autorizarPagamento(double valor) {
        return valor <= limite; // Autoriza apenas se dentro do limite
    }

    @Override
    public void processarPagamento(double valor) {
        if (autorizarPagamento(valor)) {
            limite -= valor; // Reduz o limite
            System.out.println("Pagamento de R$" + valor + " com Cartão de Crédito aprovado.");
        } else {
            System.out.println("Pagamento negado: limite insuficiente.");
        }
    }
}
