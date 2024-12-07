package lista_valendo_nota_poo.meios_de_pagamento;

public interface MeioDePagamento {
    boolean autorizarPagamento(double valor); // Verifica se o pagamento pode ser autorizado
    void processarPagamento(double valor);   // Processa o pagamento
}