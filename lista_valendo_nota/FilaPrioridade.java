package lista_valendo_nota;
//Questão 16 - Implemente a classe FilaPrioridade. os elementos serão retirados com base em sua prioridade (maior prioridade sai primeiro).
public class FilaPrioridade {

    private Elemento inicio;

    public void add(int valor, int prioridade) {
            Elemento novo = new Elemento();
            novo.setValor(valor);
            novo.prioridade = prioridade;


        if (inicio == null) {
            inicio = novo;
        } else {
            Elemento atual = inicio;
            Elemento anterior = null;

            while (atual != null && atual.prioridade >= prioridade) {
                anterior = atual;
                atual = atual.prox;
            }

            if (anterior == null) {
                novo.prox = inicio;
                inicio = novo;
            } else {
                novo.prox = atual;
                anterior.prox = novo;
            }
        }
    }

    public Elemento remove() {
        if (isVazia()) {
            return null;
        }
        Elemento removido = inicio;
        inicio = inicio.prox;
        return removido;
    }

    public boolean isVazia() {
        return inicio == null;
    }

    public void mostraFila() {
        Elemento atual = inicio;
        while (atual != null) {
            System.out.println("Valor: " + atual.valor + ", Prioridade: " + atual.prioridade);
            atual = atual.prox;
        }
    }



}
