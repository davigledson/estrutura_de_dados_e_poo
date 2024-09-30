package lista_valendo_nota;

//Questão 3 - Implemente a classe PilhaFila que utiliza Filas para simular uma Pilha.
public class PilhaFila {
    Fila fila1 = new Fila();
    Fila fila2 = new Fila();


    public void push(int valor) {

        fila2.push(valor);

        while (!fila1.lista.isVazia()) {
            fila2.push(fila1.pop().getValor());
        }


        Fila temp = fila1;
        fila1 = fila2;
        fila2 = temp;
    }


    public Elemento pop() {

        return fila1.pop();
    }


    public Elemento topo() {

        return fila1.lista.inicio;
    }
}
