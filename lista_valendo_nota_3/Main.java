package lista_valendo_nota_3;

public class Main {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

        lista.addElemento(10, false); // Adiciona no fim
        lista.addElemento(20, false); // Adiciona no fim
        lista.addElemento(5, true);   // Adiciona no início

        System.out.println("Lista original:");
        lista.mostraLista();

        System.out.println("Lista invertida:");
        lista.mostraListaInvertida();

        lista.removeDuplicados();
        System.out.println("Após remover duplicados:");
        lista.mostraLista();

        ListaDuplamenteEncadeada clonada = lista.clone();
        System.out.println("Lista clonada:");
        clonada.mostraLista();

        //Lista circular
        System.out.println("=========Lista circular =======");
        ListaCircular lista_cicular = new ListaCircular();

        lista_cicular.addElemento(10, false); // Adiciona no fim
        lista_cicular.addElemento(20, false); // Adiciona no fim
        lista_cicular.addElemento(5, true);
        lista_cicular.addElemento(50, true);
        lista_cicular.addElemento(30, true); // Adiciona no início

        System.out.println("Lista original:");
        lista_cicular.mostraLista();

        lista_cicular.removeDuplicados();
        System.out.println("Após remover duplicados:");
        lista_cicular.mostraLista();

        ListaCircular listaInvertida = lista_cicular.inverte();
        System.out.println("Lista invertida:");
        listaInvertida.mostraLista();

        System.out.println("Removendo elemento do início:");
        lista_cicular.removerElementoInicio();
        lista_cicular.mostraLista();

        System.out.println("Removendo elemento do fim:");
        lista_cicular.removerElementoFim();
        lista_cicular.mostraLista();

        System.out.println("Menor valor: " + lista_cicular.menorValor());
        System.out.println("Maior valor: " + lista_cicular.maiorValor());
        System.out.println("Valor médio: " + lista_cicular.valorMedio());

        //lista simplesmete encadeada
        System.out.println("====== Lista simplesmente encadeada =======:");
        ListaSimplementeEncadeada lista_se = new ListaSimplementeEncadeada();

        // Adicionando elementos na lista_se
        ListaSimplementeEncadeada.Elemento e1 = lista_se.addElementoFim(10);
        ListaSimplementeEncadeada.Elemento e2 = lista_se.addElementoFim(20);
        ListaSimplementeEncadeada.Elemento e3 = lista_se.addElementoFim(30);

        // Mostra a lista_se completa
        System.out.println("Lista completa:");
        lista_se.mostraLista();

        // Testando getAnt()
        ListaSimplementeEncadeada.Elemento anterior = lista_se.getAnt(e2);
        if (anterior != null) {
            System.out.println("O elemento anterior a " + e2.getValor() + " é " + anterior.getValor());
        } else {
            System.out.println("Não há elemento anterior ao " + e2.getValor());
        }

        anterior = lista_se.getAnt(e1);
        if (anterior != null) {
            System.out.println("O elemento anterior a " + e1.getValor() + " é " + anterior.getValor());
        } else {
            System.out.println("Não há elemento anterior ao " + e1.getValor());
        }
    }
}
