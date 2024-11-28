package lista_valendo_nota_3;
//1. Desenvolva uma lista duplamente encadeada
public class ListaDuplamenteEncadeada {

    Elemento inicio;
    Elemento fim;

    // Adiciona elemento no início ou no final, dependendo do valor de `posicaoInicio`
    public Elemento addElemento(int valor, boolean posicaoInicio) {
        if (posicaoInicio) {
            return this.addElementoInicio(valor);
        } else {
            return this.addElementoFim(valor);
        }
    }

    private Elemento addElementoInicio(int valor) {
        Elemento novo = new Elemento();
        novo.valor = valor;

        if (inicio == null) {
            inicio = fim = novo;
        } else {
            novo.prox = inicio;
            inicio.ant = novo;
            inicio = novo;
        }

        return novo;
    }

    private Elemento addElementoFim(int valor) {
        Elemento novo = new Elemento();
        novo.valor = valor;

        if (fim == null) {
            inicio = fim = novo;
        } else {
            fim.prox = novo;
            novo.ant = fim;
            fim = novo;
        }

        return novo;
    }

    // Remove o elemento no início da lista
    public Elemento removerElementoInicio() {
        if (inicio == null) {
            return null;
        }

        Elemento removido = inicio;
        inicio = inicio.prox;

        if (inicio != null) {
            inicio.ant = null;
        } else {
            fim = null; // Lista ficou vazia
        }

        return removido;
    }

    // Remove o elemento no final da lista
    public Elemento removerElementoFim() {
        if (fim == null) {
            return null;
        }

        Elemento removido = fim;
        fim = fim.ant;

        if (fim != null) {
            fim.prox = null;
        } else {
            inicio = null; // Lista ficou vazia
        }

        return removido;
    }

    // Mostra a lista do início para o fim
    public void mostraLista() {
        Elemento aux = inicio;
        int cont = 0;

        while (aux != null) {
            System.out.println("Posição: " + cont + " Valor: " + aux.valor);
            aux = aux.prox;
            cont++;
        }
    }

    // Mostra a lista do fim para o início
    public void mostraListaInvertida() {
        Elemento aux = fim;
        int cont = tamanho() - 1;

        while (aux != null) {
            System.out.println("Posição: " + cont + " Valor: " + aux.valor);
            aux = aux.ant;
            cont--;
        }
    }

    // Retorna o tamanho da lista
    public int tamanho() {
        int cont = 0;
        Elemento aux = inicio;

        while (aux != null) {
            cont++;
            aux = aux.prox;
        }

        return cont;
    }

    // Inverte a lista
    public ListaDuplamenteEncadeada inverte() {
        ListaDuplamenteEncadeada listaInvertida = new ListaDuplamenteEncadeada();
        Elemento aux = fim;

        while (aux != null) {
            listaInvertida.addElemento(aux.valor, false);
            aux = aux.ant;
        }

        return listaInvertida;
    }

    // Remove elementos duplicados
    public void removeDuplicados() {
        Elemento atual = inicio;

        while (atual != null) {
            Elemento comparador = atual.prox;

            while (comparador != null) {
                if (comparador.valor == atual.valor) {
                    if (comparador.prox != null) {
                        comparador.prox.ant = comparador.ant;
                    }

                    if (comparador.ant != null) {
                        comparador.ant.prox = comparador.prox;
                    }

                    if (comparador == fim) {
                        fim = comparador.ant;
                    }
                }
                comparador = comparador.prox;
            }
            atual = atual.prox;
        }
    }

    // Retorna uma lista clonada
    public ListaDuplamenteEncadeada clone() {
        ListaDuplamenteEncadeada novaLista = new ListaDuplamenteEncadeada();
        Elemento aux = this.inicio;

        while (aux != null) {
            novaLista.addElemento(aux.valor, false);
            aux = aux.prox;
        }

        return novaLista;
    }

    // Classe interna para representar um nó
    static class Elemento {
        int valor;
        Elemento prox;
        Elemento ant;

        public int getValor() {
            return valor;
        }
    }
}
