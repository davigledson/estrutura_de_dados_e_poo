package lista_valendo_nota;

//Questão 10 - Implemente a Lista com array ao invés de uma lista encadeada. No array, blocos também serão adicionados.
public class ListaArray {
    private int[] array;
    private int tamanho;

    // Construtor: Inicializa a lista com capacidade inicial
    public ListaArray(int capacidadeInicial) {
        this.array = new int[capacidadeInicial];
        this.tamanho = 0;
    }

    // Método para adicionar um elemento no fim da lista
    public void addElemento(int valor) {
        if (tamanho == array.length) {
            // Expande o array se o tamanho for atingido
            this.expandirCapacidade();
        }
        array[tamanho] = valor; // Adiciona o valor no final
        tamanho++;
    }

    // Método para adicionar um elemento em uma posição específica
    public void addElemento(int valor, int pos) {
        if (pos < 0 || pos > tamanho) {
            System.out.println("Posição inválida!");
            return;
        }

        if (tamanho == array.length) {
            // Expande o array se o tamanho for atingido
            this.expandirCapacidade();
        }

        // Desloca os elementos para a direita
        for (int i = tamanho; i > pos; i--) {
            array[i] = array[i - 1];
        }

        array[pos] = valor;
        tamanho++;
    }

    // Método para remover um elemento do final da lista
    public int removerElementoFim() {
        if (tamanho == 0) {
            System.out.println("Lista vazia!");
            return -1;
        }

        int valorRemovido = array[tamanho - 1];
        tamanho--;
        return valorRemovido;
    }

    // Método para remover um elemento de uma posição específica
    public int removerElemento(int pos) {
        if (pos < 0 || pos >= tamanho) {
            System.out.println("Posição inválida!");
            return -1;
        }

        int valorRemovido = array[pos];

        // Desloca os elementos para a esquerda
        for (int i = pos; i < tamanho - 1; i++) {
            array[i] = array[i + 1];
        }

        tamanho--;
        return valorRemovido;
    }

    // Método para exibir a lista
    public void mostraLista() {
        if (tamanho == 0) {
            System.out.println("Lista vazia!");
        } else {
            for (int i = 0; i < tamanho; i++) {
                System.out.println("Posição " + i + " valor: " + array[i]);
            }
        }
    }

    // Método para retornar o tamanho da lista
    public int tamanho() {
        return this.tamanho;
    }

    // Expande a capacidade do array quando necessário
    private void expandirCapacidade() {
        int[] novoArray = new int[array.length * 2];
        for (int i = 0; i < tamanho; i++) {
            novoArray[i] = array[i];
        }
        array = novoArray;
    }
}
