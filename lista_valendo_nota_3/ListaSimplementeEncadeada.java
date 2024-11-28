package lista_valendo_nota_3;
//5. Desenvolva uma lista simplesmente encadeada que se comporta como se fosse uma
//lista duplamente encadeada. Nela, por exemplo, deve ter o método getAnt(), que
//retorna para o bloco anterior.
public class ListaSimplementeEncadeada {

    private Elemento head; // Início da lista
    private int tamanho;   // Número de elementos na lista

    public ListaSimplementeEncadeada() {
        this.head = null;
        this.tamanho = 0;
    }

    // Adiciona um elemento no início da lista
    public Elemento addElementoInicio(int valor) {
        Elemento novo = new Elemento(valor);

        if (head == null) { // Lista vazia
            head = novo;
        } else {
            novo.prox = head;
            head = novo;
        }

        tamanho++;
        return novo;
    }

    // Adiciona um elemento no final da lista
    public Elemento addElementoFim(int valor) {
        Elemento novo = new Elemento(valor);

        if (head == null) { // Lista vazia
            head = novo;
        } else {
            Elemento atual = head;

            // Percorre até o último elemento
            while (atual.prox != null) {
                atual = atual.prox;
            }

            atual.prox = novo;
        }

        tamanho++;
        return novo;
    }

    // Método getAnt() para retornar o bloco anterior
    public Elemento getAnt(Elemento blocoAtual) {
        if (head == null || head == blocoAtual) {
            return null; // Sem anterior (lista vazia ou o blocoAtual é o head)
        }

        Elemento atual = head;

        // Percorre até encontrar o anterior ao blocoAtual
        while (atual.prox != null && atual.prox != blocoAtual) {
            atual = atual.prox;
        }

        return atual.prox == blocoAtual ? atual : null; // Retorna o anterior ou null se não encontrar
    }

    // Mostra a lista completa
    public void mostraLista() {
        if (head == null) {
            System.out.println("A lista está vazia.");
            return;
        }

        Elemento atual = head;
        int posicao = 0;

        while (atual != null) {
            System.out.println("Posição: " + posicao + " Valor: " + atual.valor);
            atual = atual.prox;
            posicao++;
        }
    }

    // Tamanho da lista
    public int tamanho() {
        return tamanho;
    }

    // Classe interna para representar um nó
    static class Elemento {
        int valor;
        Elemento prox;

        public Elemento(int valor) {
            this.valor = valor;
            this.prox = null;
        }

        public int getValor() {
            return valor;
        }
    }
}
