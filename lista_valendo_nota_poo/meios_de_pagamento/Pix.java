package lista_valendo_nota_poo.meios_de_pagamento;

public class Pix implements MeioDePagamento {
    private String chave;

    public Pix(String chave) {
        this.chave = chave;
    }

    @Override
    public boolean autorizarPagamento(double valor) {
        return true; // Assume que sempre pode processar
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Pagamento de R$" + valor + " via Pix enviado para a chave " + chave);
    }
}

