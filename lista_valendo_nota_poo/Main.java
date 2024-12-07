package lista_valendo_nota_poo;


import lista_valendo_nota_poo.meios_de_pagamento.CartaoCredito;
import lista_valendo_nota_poo.meios_de_pagamento.Cash;
import lista_valendo_nota_poo.meios_de_pagamento.Pix;
import lista_valendo_nota_poo.meios_de_pagamento.ProcessadorDePagamentos;

public class Main {
    public static void main(String[] args) {
        //1. Crie uma árvore que tem um atributo especial do tipo Criteria. Criteria uma classe
        //abstrata que tem um único método abstrato denominado apply. Esse método recebe um
        //nó de referência e um valor e retorna um nó filho do nó referência caso haja. Crie duas
        //classes que herdam da classe Criteria. Uma classe deve implementar o apply com o
        //critério clássico que é o de que o nó retornado será o da esquerda se o valor passado
        //for menor que o valor contido no nó. A outra classe deve implementar uma abordagem
        //contrária.

        //2. Adicione o atributo peso no nó. Esse atributo vai apoiar a decisão de descida na árvore.
        //Implemente a classe Neuro que herda de Criteria. Essa nova classe se comporta como
        //um neurônio artificial na medida em que utiliza o resultado de uma operação entre o
        //valor e o peso para decidir se retorna o nó direito ou esquerdo. Por exemplo, pode
        //utilizar a operação de multiplicação entre o peso e o valor
        System.out.println("Árvore com ClassicCriteria:");
        ArvoreComCriteria arvoreClassica = new ArvoreComCriteria(new ClassicCriteria());
        arvoreClassica.inserir(10, 2);
        arvoreClassica.inserir(5, 3);
        arvoreClassica.inserir(15, 4);
        arvoreClassica.inserir(3, 1);
        arvoreClassica.inserir(7, 5);
        arvoreClassica.exibirPreOrder();
        System.out.println("\n\n ===== Classe Agregadora =====:");
        System.out.println("\n\nÁrvore com Neuro Criteria:");
        ArvoreComCriteria arvoreNeuro = new ArvoreComCriteria(new Neuro());
        arvoreNeuro.inserir(10, 2);
        arvoreNeuro.inserir(5, 3);
        arvoreNeuro.inserir(15, 4);
        arvoreNeuro.inserir(3, 1);
        arvoreNeuro.inserir(7, 5);
        arvoreNeuro.exibirPreOrder();


        Pedido pedido = new Pedido();

        ItemPedido item1 = new ItemPedido(10.0, 2); // Valor total: 20.0
        ItemPedido item2 = new ItemPedido(15.5, 3); // Valor total: 46.5

        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);

        System.out.println("Itens no pedido:");
        for (ItemPedido item : pedido.obterItens()) {
            System.out.println("- Item: R$" + item.getValor());
        }

        System.out.println("Total do pedido: R$" + pedido.calcularTotal());

        System.out.println("=====  meios de pagamento =====");

        CartaoCredito cartaoCredito = new CartaoCredito(1000.0);
        Pix pix = new Pix("chave@pix.com");
        Cash cash = new Cash(500.0);

        ProcessadorDePagamentos processador = new ProcessadorDePagamentos();
        processador.adicionarMeio(cartaoCredito);
        processador.adicionarMeio(pix);
        processador.adicionarMeio(cash);

        double valorCompra = 300.0;

        // Tenta pagar com cartão de crédito
        if (processador.autorizar(valorCompra, cartaoCredito)) {
            processador.processar(valorCompra, cartaoCredito);
        }

        // Tenta pagar via Pix
        processador.processar(valorCompra, pix);

        // Tenta pagar em cash
        if (processador.autorizar(valorCompra, cash)) {
            processador.processar(valorCompra, cash);
        }



        System.out.println("===== Lista Duplamente Encadeada Circular =====");
        ListaDuplamenteEncadeadaCircular<Integer> lista = new ListaDuplamenteEncadeadaCircular<>();

        // Adicionar elementos
        lista.adicionar(10);
        lista.adicionar(20);
        lista.adicionar(30);

        // Exibir a lista
        System.out.println("Lista (sentido normal):");
        lista.exibir(); // Saída: 10 20 30

        System.out.println("Lista (sentido inverso):");
        lista.exibirReverso(); // Saída: 30 20 10

        // Adicionar no início
        lista.adicionarNoInicio(5);
        System.out.println("Após adicionar no início:");
        lista.exibir(); // Saída: 5 10 20 30

        // Remover do início
        System.out.println("Removido do início: " + lista.removerDoInicio()); // Saída: 5
        lista.exibir(); // Saída: 10 20 30

        // Remover do fim
        System.out.println("Removido do fim: " + lista.removerDoFim()); // Saída: 30
        lista.exibir(); // Saída: 10 20

        SistemaPesquisa.Enquete enquete = new SistemaPesquisa.Enquete("Pesquisa Eleitoral 2024");

        // Adicionar questões
        enquete.adicionarQuestao("Qual o maior problema do país?");
        enquete.adicionarQuestao("Qual o candidato que você prefere?");

        // Adicionar alternativas às questões
        SistemaPesquisa.Questao questao1 = enquete.getQuestoes().get(0);
        questao1.adicionarAlternativa("Educação");
        questao1.adicionarAlternativa("Saúde");
        questao1.adicionarAlternativa("Segurança");

        SistemaPesquisa.Questao questao2 = enquete.getQuestoes().get(1);
        questao2.adicionarAlternativa("Candidato A");
        questao2.adicionarAlternativa("Candidato B");
        questao2.adicionarAlternativa("Candidato C");

        // Participante responde à enquete
        SistemaPesquisa.Resposta resposta = new SistemaPesquisa.Resposta();
        resposta.responder(questao1, 1); // Escolheu "Saúde"
        resposta.responder(questao2, 0); // Escolheu "Candidato A"

        // Exibir resultados
        System.out.println("Resultados da Enquete: " + enquete.getTitulo());

        for (SistemaPesquisa.Questao questao : enquete.getQuestoes()) {
            System.out.println(questao.getPergunta());
            for (SistemaPesquisa.Alternativa alternativa : questao.getAlternativas()) {
                System.out.println("- " + alternativa.getTexto() + ": " + alternativa.getVotos() + " votos");
            }
        }
    }
}