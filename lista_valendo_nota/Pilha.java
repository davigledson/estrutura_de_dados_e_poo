package lista_valendo_nota;

public class Pilha {
    
    Lista lista = new Lista();

    public void push(int valor) {

        this.lista.addElemento(valor,true);

    }

    public Elemento pop() {

        return  this.lista.removerElementoFim();
    }

    //questão 2 - Adicione o método “topo” na classe Pilha que retorna o topo da Pilha.
    public Elemento topo() {
        return lista.localizarElemento(lista.tamanho()); // Retorna o último elemento
    }

    public void mostraPilha() {
        //Elemento aux = this.lista.inicio;
        this.lista.mostraLista(this.lista.inicio);
       // int cont=0;

    }
    //Questão 5 - Defina um método em Pilha que retorna uma Fila equivalente.
    public Fila paraFila() {
        Fila fila = new Fila();
        Pilha tempPilha = new Pilha();

        while (!this.lista.isVazia()) {
            tempPilha.push(this.pop().getValor());
        }
        while (!tempPilha.lista.isVazia()) {
            fila.push(tempPilha.pop().getValor());
        }

        return fila;
    }
}
