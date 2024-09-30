package lista_valendo_nota;
//QUESTAO 1 - Implemente a classe Fila adicionando os métodos push e pop.
public class Fila {
    Lista lista = new Lista();
    public void push(int valor) {
        lista.addElemento(valor, false);
    }


    public Elemento pop() {
        return lista.removerElementoInicio();
    }
    // Questão 6 - Defina um método em Fila que retorna uma Pilha equivalente.
    public Pilha paraPilha() {
        Pilha pilha = new Pilha();

        while (!this.lista.isVazia()) {
            pilha.push(this.pop().getValor());
        }

        return pilha;
    }

    public void mostraFila() {
        //Elemento aux = this.lista.inicio;
        this.lista.mostraLista(this.lista.inicio);
        // int cont=0;

    }
}
