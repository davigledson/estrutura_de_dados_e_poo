/**
 * aula02 - assunto: lista encadeada
 * de estrutura de dados
 */
public class BlocoA {

    int valor;
    BlocoA prox;

    public static void main(String[] args) {

        BlocoA inicio = new BlocoA();
        inicio.valor = 10;

        BlocoA b1 = new BlocoA();
        b1.valor = 12;

        BlocoA b2 = new BlocoA();
        b2.valor = 33;

        BlocoA b3 = new BlocoA();
        b3.valor = 40;

        inicio.prox = b1;
        b1.prox = b2;
        b2.prox = b3;
        
        BlocoA aux = inicio;
        while (aux != null) {
            System.out.println(aux.valor);
            aux = aux.prox;
        }

        int contador = 0;
        int limite = 4;
        aux = inicio;
        while (aux != null && contador < limite-1) {
            contador++;
            aux = aux.prox;
        }

        BlocoA novo = new BlocoA();
        novo.valor = 7;

        if(aux!=null) {

            novo.prox = aux.prox;
            aux.prox = novo;
        }

        System.out.println("Nova lista");
        aux = inicio;
        while (aux != null) {
            System.out.println(aux.valor);
            aux = aux.prox;
        }

    }

}