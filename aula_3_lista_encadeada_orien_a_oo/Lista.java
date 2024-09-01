package aula_3_lista_encadeada_orien_a_oo;

public class Lista {
	
	
	public Bloco inicio;
	
	public void addBloco(int valor) {
		
		Bloco novo = new Bloco();
		novo.setValor(valor);
		
		novo.prox = inicio;
		inicio = novo;
		
	}


	public void addBloco(int valor, int pos) {
		Bloco novo = new Bloco();
		novo.setValor(valor);


		if (pos == 0) {
			novo.prox = inicio;
			inicio = novo;
			return;
		}

		Bloco aux = this.inicio;
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

	public void addBlocoApos(int valor,int pos) {
		Bloco novo = new Bloco();
		novo.setValor(valor);

		Bloco aux = this.inicio;
		int cont = 0;

		while(aux != null && cont < pos) {
			aux = aux.prox;
			cont++;

		}

		if(aux != null) {
			novo.prox = aux.prox;
			aux.prox = novo;
		} else {

			System.out.println("Posição inválida");
		}

	}
	
	
	public void mostraLista() {
		Bloco aux = this.inicio;
		
		while(aux != null) {
			System.out.println(aux.getValor());
			aux = aux.prox;
		}
		
	}
	
	public Bloco localizaBloco(int i) {
		Bloco aux = this.inicio;
		int cont = 0;
		
		while(aux != null && cont < i) {
			aux = aux.prox; 
			cont++;
		}
		
		return aux;
		
	}
	
	
}
