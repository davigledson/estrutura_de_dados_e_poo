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

    //Questão 13 - Implemente o método “concatena(Lista l2)” na classe Lista. O método deve concatenar os elementos da lista atual com os elementos da lista passada como parâmetro, retornando uma nova lista.
    public Lista concatena(Lista l2) {
        Lista novaLista = new Lista();

        // Adiciona elementos da lista atual
        Elemento atual = this.inicio;
        while (atual != null) {
            novaLista.addElementoInicio(atual.valor);
            atual = atual.prox;
        }

        // Adiciona elementos da lista l2
        atual = l2.inicio;
        while (atual != null) {
            novaLista.addElementoInicio(atual.valor);
            atual = atual.prox;
        }

        return novaLista;
    }
    //Questão 14 - Implemente um método “removeDuplicados” na classe Lista. Esse método deve percorrer a lista e remover todos os elementos duplicados, mantendo apenas a primeira ocorrência.
    public void removeDuplicados() {
        Elemento atual = inicio;
        while (atual != null) {
            Elemento verificador = atual;
            while (verificador.prox != null) {
                if (verificador.prox.valor == atual.valor) {
                    verificador.prox = verificador.prox.prox; // Remove o duplicado
                } else {
                    verificador = verificador.prox; // Avança no verificador
                }
            }
            atual = atual.prox; // Avança no elemento atual
        }
    }
    //Questão 15 - Crie um método “clone” na classe Lista. Esse método deve retornar uma nova instância de Lista com os mesmos elementos da lista original.
    public Lista clone() {
        Lista novaLista = new Lista();
        Elemento atual = this.inicio;

        // Percorre a lista original e adiciona elementos na nova lista
        while (atual != null) {
            novaLista.addElementoFim(atual.valor);
            atual = atual.prox;
        }

        return novaLista;
    }
    //Quesão 17 - Implemente o método “removeElemento(int pos)” na classe Lista. Esse método deve remover o elemento na posição especificada.
    public Elemento removeElemento(int pos) {
        if (pos < 0 || inicio == null) {
            return null;
        }
        Elemento removido;

        if (pos == 0) {
            removido = inicio;
            inicio = inicio.prox;
            return removido;
        }
        Elemento atual = inicio;
        Elemento anterior = null;
        int cont = 0;

        while (atual != null && cont < pos) {
            anterior = atual;
            atual = atual.prox;
            cont++;
        }

        if (atual == null) {
            return null;
        }

        // Remover o elemento na posição especificada
        anterior.prox = atual.prox;
        removido = atual;
        return removido;
    }

    //Questão 18 - Adicione o método “localizarMaior(int valor)” na classe Lista. Esse método deve retornar uma Lista com todos os blocos que contenham um valor maior do que o valor passado .
    public Lista localizarMaior(int valor) {
        Lista novaLista = new Lista();
        Elemento atual = inicio;

        // Percorre a lista original
        while (atual != null) {
            if (atual.getValor() > valor) {
                novaLista.addElemento(atual.getValor(), false);
            }
            atual = atual.prox;
        }

        return novaLista;
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