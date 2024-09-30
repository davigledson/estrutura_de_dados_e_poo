package lista_valendo_nota;
//Questão 11 - Implemente a classe ListaRecursiva que define métodos recursivos de localizar e de tamanha. Lembre-se que os métodos devem ser declarados como private para não ficarem disponíveis para o usuário programador.
public class ListaRecursiva {

    private Elemento inicio;

    public ListaRecursiva() {
        this.inicio = null;
    }


    public void addElemento(int valor) {
        Elemento novo = new Elemento();
        novo.valor = valor;
        novo.prox = this.inicio;
        this.inicio = novo;
    }

    public Elemento localizarElemento(int pos) {
        return localizarElementoRecursivo(this.inicio, pos, 0);
    }

    public int tamanho() {
        return tamanhoRecursivo(this.inicio);
    }

    private Elemento localizarElementoRecursivo(Elemento atual, int pos, int index) {
        if (atual == null || index > pos) {
            return null;
        }
        if (index == pos) {
            return atual;
        }
        return localizarElementoRecursivo(atual.prox, pos, index + 1);
    }


    private int tamanhoRecursivo(Elemento atual) {
        if (atual == null) {
            return 0; // Caso base: fim da lista
        }
        return 1 + tamanhoRecursivo(atual.prox); // Soma 1 e avança recursivamente
    }

    public void mostraLista() {
        Elemento aux = this.inicio;
        int cont = 0;
        while (aux != null) {
            System.out.println("Posição: " + cont + " valor: " + aux.valor);
            aux = aux.prox;
            cont++;
        }
    }


}
