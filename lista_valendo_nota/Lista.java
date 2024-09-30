package lista_valendo_nota;

import lista_encadeada_orien_a_oo.Bloco;

public class Lista {

    Elemento inicio;

    public Elemento addElemento(int valor,boolean posicaoIncio) {

        Elemento novo = null;

        if(posicaoIncio == true) {

            novo = this.addElementoInicio(valor);

        } else {

            novo = this.addElementoFim(valor);
        }

        return novo;
    }

    //Questão 8 - Implemente em Lista o método para addElemento(int valor, int pos) que adiciona um elemento na posição especificada. A posição pode ou não existir.

    public void addElemento(int valor, int pos) {
        Elemento novo = new Elemento();
        novo.setValor(valor);


        if (pos == 0) {
            novo.prox = inicio;
            inicio = novo;
            return;
        }

        Elemento aux = this.inicio;
        int cont = 0;


        while (aux != null && cont < pos - 1) {
            aux = aux.prox;
            cont++;
        }


        if (aux != null) {

            novo.prox = aux.prox;
            aux.prox = novo;

        } else {

            System.out.println("Posição inválida");
        }
    }
    public Elemento removerElementoFim() {

        Elemento result = null;

        if(this.isVazia()) {
            return result;
        }

        if(this.tamanho() == 1) {
            //this.inicio = null;
            result = this.removerElementoInicio();
        } else {

            Elemento target = this.localizarElemento(this.tamanho()-1);
    
            result = target.prox;
            target.prox = null;
        }

        return result;
    }

    public Elemento removerElementoInicio() {

        Elemento result = this.inicio;
        if(!this.isVazia()) {

            this.inicio = this.inicio.prox;
        }

        return result;
    }

    public boolean isVazia() {

        return this.inicio == null;
    }

    private Elemento addElementoInicio(int valor) {

        Elemento novo = new Elemento();
        novo.valor = valor;
        
        novo.prox = this.inicio;
        this.inicio = novo;

        return novo;
    }

    private Elemento addElementoFim(int valor) {

        Elemento novo = null;

        Elemento fim = this.localizarElemento(this.tamanho());

        if(fim == null) {

            novo = this.addElementoInicio(valor);
        } else {

            novo = new Elemento();
            novo.valor = valor;
    
            fim.prox = novo; 
        }

        return novo;
    }

    public Elemento localizarElemento(int pos) {

        Elemento aux = this.inicio;
        int cont =0;

        while(aux!= null && cont < pos -1) {

            cont++;
            aux = aux.prox;
        }

        return aux;
    }

    public int tamanho() {

        Elemento aux = this.inicio;
        int cont =0;

        while(aux!= null) {

            cont++;
            aux = aux.prox;
        }

        return cont;
    }
    //Questão 7 - Na classe Lista, implemente o método inverte que retorna uma Lista com os elementos em ordem invertida.
    public Lista inverte() {
        Lista listaInvertida = new Lista();
        Elemento aux = this.inicio;

        while (aux != null) {
            listaInvertida.addElemento(aux.getValor(), true);
            aux = aux.prox;  // Avança para o próximo elemento
        }

        return listaInvertida;  // Retorna a lista invertida
    }
    public void mostraLista() {
        mostraLista(this.inicio);
    }
    public void mostraLista(Elemento inicio) {
        Elemento aux = inicio;
        int cont=0;
        while(aux != null) {
            System.out.println("posição:" + cont + " valor:"+ aux.getValor());
            aux = aux.prox;
            cont++;
        }

    }
}