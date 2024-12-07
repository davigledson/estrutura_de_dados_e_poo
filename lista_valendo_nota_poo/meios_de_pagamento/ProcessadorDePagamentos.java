package lista_valendo_nota_poo.meios_de_pagamento;

import java.util.ArrayList;
import java.util.List;

public class ProcessadorDePagamentos {
    private List<MeioDePagamento> meios = new ArrayList<>();

    public void adicionarMeio(MeioDePagamento meio) {
        meios.add(meio);
    }

    public boolean autorizar(double valor, MeioDePagamento meio) {
        return meio.autorizarPagamento(valor);
    }

    public void processar(double valor, MeioDePagamento meio) {
        meio.processarPagamento(valor);
    }
}
