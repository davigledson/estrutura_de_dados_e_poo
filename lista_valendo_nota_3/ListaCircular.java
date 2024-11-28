package lista_valendo_nota_3;

//2. Desenvolva uma lista circular.
//3. Desenvolva uma lista circular destacando o Head e o Tail.

//4. Adicione dados de estatística na lista anterior. Adicione, por exemplo, o valor médio, o
//menor e o maior valor, etc
public class ListaCircular {

    private Elemento head; // Referência para o início da lista (cabeça)
    private Elemento tail; // Referência para o final da lista (cauda)
    private int tamanho;   // Número de elementos na lista

    public ListaCircular() {
        this.head = null;
        this.tail = null;
        this.tamanho = 0;
    }

    // Adiciona um elemento no início ou no final, com base no parâmetro `posicaoInicio`
    public Elemento addElemento(int valor, boolean posicaoInicio) {
        if (posicaoInicio) {
            return this.addElementoInicio(valor);
        } else {
            return this.addElementoFim(valor);
        }
    }

    // Adiciona um elemento no início da lista
    private Elemento addElementoInicio(int valor) {
        Elemento novo = new Elemento(valor);

        if (tamanho == 0) { // Lista vazia
            head = tail = novo;
            tail.prox = head; // Torna a lista circular
        } else {
            novo.prox = head;
            head = novo;
            tail.prox = head; // Atualiza a cauda para apontar para o novo head
        }

        tamanho++;
        return novo;
    }

    // Adiciona um elemento no final da lista
    private Elemento addElementoFim(int valor) {
        Elemento novo = new Elemento(valor);

        if (tamanho == 0) { // Lista vazia
            head = tail = novo;
            tail.prox = head; // Torna a lista circular
        } else {
            tail.prox = novo;
            tail = novo;
            tail.prox = head; // Fecha o ciclo
        }

        tamanho++;
        return novo;
    }

    // Remove o elemento no início da lista
    public Elemento removerElementoInicio() {
        if (tamanho == 0) { // Lista vazia
            return null;
        }

        Elemento removido = head;

        if (tamanho == 1) { // Apenas um elemento
            head = tail = null;
        } else {
            head = head.prox;
            tail.prox = head; // Atualiza a cauda para apontar para o novo head
        }

        tamanho--;
        return removido;
    }

    // Remove o elemento no final da lista
    public Elemento removerElementoFim() {
        if (tamanho == 0) { // Lista vazia
            return null;
        }

        Elemento removido = tail;

        if (tamanho == 1) { // Apenas um elemento
            head = tail = null;
        } else {
            Elemento atual = head;

            // Percorre até o penúltimo elemento
            while (atual.prox != tail) {
                atual = atual.prox;
            }

            tail = atual;
            tail.prox = head; // Atualiza o tail para manter a circularidade
        }

        tamanho--;
        return removido;
    }

    // Mostra os elementos da lista, começando pelo head
    public void mostraLista() {
        if (tamanho == 0) {
            System.out.println("A lista está vazia.");
            return;
        }

        Elemento atual = head;
        int posicao = 0;

        do {
            System.out.println("Posição: " + posicao + " Valor: " + atual.valor);
            atual = atual.prox;
            posicao++;
        } while (atual != head); // Continua até voltar ao início
    }

    // Retorna o tamanho da lista
    public int tamanho() {
        return tamanho;
    }

    // Inverte a lista circular e retorna uma nova lista
    public ListaCircular inverte() {
        ListaCircular listaInvertida = new ListaCircular();

        if (tamanho > 0) {
            Elemento atual = tail; // Começa pelo tail e segue até head

            do {
                listaInvertida.addElemento(atual.valor, true); // Adiciona sempre no início
                atual = encontrarAnterior(atual); // Encontra o elemento anterior
            } while (atual != tail); // Continua até percorrer a lista inteira
        }

        return listaInvertida;
    }

    // Encontra o elemento anterior a um dado elemento
    private Elemento encontrarAnterior(Elemento elemento) {
        Elemento atual = head;

        while (atual.prox != elemento) {
            atual = atual.prox;
        }

        return atual;
    }

    // Remove elementos duplicados
    public void removeDuplicados() {
        if (tamanho == 0) {
            return;
        }

        Elemento atual = head;

        do {
            Elemento comparador = atual;

            while (comparador.prox != head) {
                if (comparador.prox.valor == atual.valor) {
                    comparador.prox = comparador.prox.prox;

                    if (comparador.prox == head) {
                        tail = comparador; // Atualiza o tail, se necessário
                    }

                    tamanho--;
                } else {
                    comparador = comparador.prox;
                }
            }

            atual = atual.prox;
        } while (atual != head);
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


    // Retorna o menor valor da lista
    public int menorValor() {
        if (tamanho == 0) {
            throw new IllegalStateException("Lista vazia");
        }

        Elemento atual = head;
        int menor = atual.valor;

        do {
            if (atual.valor < menor) {
                menor = atual.valor;
            }
            atual = atual.prox;
        } while (atual != head);

        return menor;
    }

    // Retorna o maior valor da lista
    public int maiorValor() {
        if (tamanho == 0) {
            throw new IllegalStateException("Lista vazia");
        }

        Elemento atual = head;
        int maior = atual.valor;

        do {
            if (atual.valor > maior) {
                maior = atual.valor;
            }
            atual = atual.prox;
        } while (atual != head);

        return maior;
    }

    // Retorna o valor médio dos elementos da lista
    public double valorMedio() {
        if (tamanho == 0) {
            throw new IllegalStateException("Lista vazia");
        }

        Elemento atual = head;
        int soma = 0;

        do {
            soma += atual.valor;
            atual = atual.prox;
        } while (atual != head);

        return (double) soma / tamanho;
    }

}

