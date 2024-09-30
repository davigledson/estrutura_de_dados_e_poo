package lista_valendo_nota;

//Questão 9 - Implemente uma classe ListaDupla que implementa o duplo encadeamento dos blocos. Sendo assim o Bloco precisa ser também modificado.
public class ListaDupla {
    Elemento inicio;
    Elemento fim;


    public void addBlocoInicio(int valor) {
        Elemento novo = new Elemento();
        novo.valor = valor;

        if (isVazia()) {
            inicio = novo;
            fim = novo;
        } else {
            novo.prox = inicio; // O próximo do novo é o atual início
            inicio.ant = novo;  // O anterior do atual início é o novo
            inicio = novo;      // O novo elemento agora é o início
        }
    }

    // Adiciona elemento no final
    public void addBlocoFim(int valor) {
        Elemento novo = new Elemento();
        novo.valor = valor;

        if (isVazia()) {
            inicio = novo;
            fim = novo;  // O novo elemento é também o fim
        } else {
            novo.ant = fim;    // O anterior do novo é o atual fim
            fim.prox = novo;   // O próximo do atual fim é o novo
            fim = novo;        // O novo elemento agora é o fim
        }
    }


    public Elemento removerElementoInicio() {
        if (isVazia()) return null;

        Elemento removido = inicio;
        inicio = inicio.prox; // Atualiza o início

        if (inicio != null) {
            inicio.ant = null;
        } else {
            fim = null; // A lista ficar vazia
        }

        return removido;
    }


    public Elemento removerElementoFim() {
        if (isVazia()) return null;

        Elemento removido = fim;
        fim = fim.ant; // Atualiza o fim

        if (fim != null) {
            fim.prox = null; // Remove a referência próxima do novo fim
        } else {
            inicio = null; // A lista ficou vazia
        }

        return removido;
    }

    // Verifica se a lista está vazia
    public boolean isVazia() {
        return inicio == null;
    }

    // Mostra a lista do início ao fim
    public void mostraLista() {
        Elemento aux = inicio;
        int cont = 0;

        while (aux != null) {
            System.out.println("posição: " + cont + " valor: " + aux.valor);
            aux = aux.prox;
            cont++;
        }
    }

    // Mostra a lista do fim ao início
    public void mostraListaReversa() {
        Elemento aux = fim;
        int cont = 0;

        while (aux != null) {
            System.out.println("posição: " + cont + " valor: " + aux.valor);
            aux = aux.ant;
            cont++;
        }
    }
}
