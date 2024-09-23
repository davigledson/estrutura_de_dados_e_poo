package lista_encadeada_orien_a_oo;
//lista duplamente encadeada
public class ListaDupla {
    public Bloco inicio;
	public Head head = new Head();
	public Bloco fim;

    public void addBlocoInicio(int valor) {
		Bloco novo = new Bloco();
		novo.setValor(valor);
		this.head.tamanho++;
		if(this.head.inicio == null){
			this.head.inicio = novo;
			this.head.fim = novo;
			
		} else {
			novo.prox = this.head.inicio;
			this.head.inicio = novo;
			
		}
		//Bloco aux = this.inicio;


	}

    //Head
	public void addBlocoFim(int valor) {
		Bloco novo = new Bloco();
		novo.setValor(valor);
		this.head.tamanho++;
		if(this.head.inicio == null){
			this.head.inicio = novo;
			this.head.fim = novo;
			
		} else {
			this.head.fim.prox = novo;
			this.head.fim = novo;
			
		}
		//Bloco aux = this.inicio;


	}

    public void mostraListaDupla() {
		Bloco aux = this.head.inicio;
		int cont=0;
        System.out.println("TAMANHO DA LISTA DUPLA: " + this.head.tamanho);
		while(aux != null) {
            System.out.println("ola");
			System.out.println("posição:" + cont + " valor:"+ aux.getValor());
			aux = aux.prox;
			cont++;
		}
		
	}
}
