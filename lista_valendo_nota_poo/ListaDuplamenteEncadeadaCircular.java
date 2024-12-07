package lista_valendo_nota_poo;
//Considere o problema da lista duplamente encadeada circular em que há um Head e
//um Tail. Implemente para que haja a máxima coesão das classes.
public class ListaDuplamenteEncadeadaCircular<T> {

    // Classe interna para representar os nós da lista
    private static class No<T> {
        T valor;
        No<T> anterior;
        No<T> proximo;

        public No(T valor) {
            this.valor = valor;
        }
    }

    private No<T> head; // Primeiro nó da lista
    private No<T> tail; // Último nó da lista
    private int tamanho; // Tamanho da lista

    // Construtor
    public ListaDuplamenteEncadeadaCircular() {
        this.head = null;
        this.tail = null;
        this.tamanho = 0;
    }

    // Adicionar no final da lista
    public void adicionar(T valor) {
        No<T> novoNo = new No<>(valor);

        if (tamanho == 0) {
            // Lista vazia: head e tail apontam para o novo nó
            head = novoNo;
            tail = novoNo;
            head.proximo = head; // Aponta para si mesmo
            head.anterior = head; // Aponta para si mesmo
        } else {
            // Adiciona ao final da lista
            novoNo.anterior = tail;
            novoNo.proximo = head;
            tail.proximo = novoNo;
            head.anterior = novoNo;
            tail = novoNo;
        }

        tamanho++;
    }

    // Adicionar no início da lista
    public void adicionarNoInicio(T valor) {
        adicionar(valor); // Adiciona como último
        head = tail; // Atualiza o head para o último
    }

    // Remover do início
    public T removerDoInicio() {
        if (tamanho == 0) {
            throw new IllegalStateException("A lista está vazia.");
        }

        T valor = head.valor;

        if (tamanho == 1) {
            // Apenas um elemento na lista
            head = null;
            tail = null;
        } else {
            // Remove o head e ajusta os ponteiros
            head = head.proximo;
            head.anterior = tail;
            tail.proximo = head;
        }

        tamanho--;
        return valor;
    }

    // Remover do final
    public T removerDoFim() {
        if (tamanho == 0) {
            throw new IllegalStateException("A lista está vazia.");
        }

        T valor = tail.valor;

        if (tamanho == 1) {
            // Apenas um elemento na lista
            head = null;
            tail = null;
        } else {
            // Remove o tail e ajusta os ponteiros
            tail = tail.anterior;
            tail.proximo = head;
            head.anterior = tail;
        }

        tamanho--;
        return valor;
    }

    // Exibir a lista (sentido normal)
    public void exibir() {
        if (tamanho == 0) {
            System.out.println("A lista está vazia.");
            return;
        }

        No<T> atual = head;
        for (int i = 0; i < tamanho; i++) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    // Exibir a lista (sentido inverso)
    public void exibirReverso() {
        if (tamanho == 0) {
            System.out.println("A lista está vazia.");
            return;
        }

        No<T> atual = tail;
        for (int i = 0; i < tamanho; i++) {
            System.out.print(atual.valor + " ");
            atual = atual.anterior;
        }
        System.out.println();
    }

    // Obter o tamanho da lista
    public int tamanho() {
        return tamanho;
    }
}
