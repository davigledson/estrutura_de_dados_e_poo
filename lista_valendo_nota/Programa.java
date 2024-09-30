package lista_valendo_nota;

public class Programa {

	public static void main(String[] args) {
//		System.out.println("======== LISTA ==========");
//		Lista l = new Lista();
//		for(int i= 0; i < 5; i++) {
//			l.addElemento(i,true);
//		}
//		l.mostraLista();
//		System.out.println();


		System.out.println("======== PILHA ==========");
		Pilha p = new Pilha();
		for(int i= 0; i < 5; i++) {
			p.push(i);
		}
		p.mostraPilha();
		System.out.println();

		p.push(10);
		p.mostraPilha();
		System.out.println("tamanho:" + p.lista.tamanho());
		System.out.println("TOPO" + p.topo().valor);

		System.out.println("======== PILHA PARA FILA ==========");
		Pilha p1 = new Pilha();
		for (int i = 0; i < 5; i++) {
			p1.push(i);  // Adiciona elementos: 0, 1, 2, 3, 4
		}

		// Mostrando a pilha original
		System.out.println("Pilha original:");
		p1.mostraPilha();  // e para mostrar: 4, 3, 2, 1, 0

		// Convertendo Pilha para Fila
		Fila pilha_para_fila = p1.paraFila();

		// Mostrando a fila convertida
		System.out.println("Fila convertida da Pilha:");
		pilha_para_fila.mostraFila();  // e para  mostrar: 0, 1, 2, 3, 4

		// Testando a conversão de Fila para Pilha
		System.out.println("======== FILA PARA PILHA ==========");
		Fila f = new Fila();
		for (int i = 0; i < 5; i++) {
			f.push(i);
		}

		// Mostrando a fila original
		System.out.println("Fila original:");
		f.mostraFila();  // Deve mostrar: 0, 1, 2, 3, 4

		// Convertendo Fila para Pilha
		Pilha fila_para_pilha = f.paraPilha();

		// Mostrando a pilha convertida
		System.out.println("Pilha convertida da Fila:");
		fila_para_pilha.mostraPilha();

//		System.out.println(" ===== LISTA INVERTIDA ====");
//		Lista l = new Lista();
//		for(int i= 0; i < 5; i++) {
//			l.addElemento(i,false);
//		}
//		l.mostraLista();
//		System.out.println();
//		l.inverte();
//		l.mostraLista();
//		System.out.println();
		System.out.println(" ===== LISTA -add elemento na posição ====");
		Lista l = new Lista();
		for(int i= 0; i < 5; i++) {
			l.addElemento(i,false);
		}
		l.addElemento(25,3);
		l.mostraLista();
		System.out.println();

		System.out.println(" ===== LISTA DUPLA ====");
		ListaDupla ld = new ListaDupla();
		for(int i= 0; i < 5; i++) {
			ld.addBlocoInicio(i);
		}
		ld.addBlocoFim(25);
		ld.addBlocoInicio(99);
		ld.mostraLista();
		System.out.println();

		System.out.println("=== LISTA ARRAY ===");
		ListaArray lista = new ListaArray(5);
		// Cria uma lista com capacidade  de 5

		// Adicionando elementos
		lista.addElemento(10);
		lista.addElemento(20);
		lista.addElemento(30);

		// Exibindo a lista
		System.out.println("Lista após adicionar elementos:");
		lista.mostraLista();

		// Adicionando elemento em uma posição específica
		lista.addElemento(15, 1);
		System.out.println("Lista após adicionar o elemento 15 na posição 1:");
		lista.mostraLista();

		// Removendo elemento do fim
		lista.removerElementoFim();
		System.out.println("Lista após remover o último elemento:");
		lista.mostraLista();

		// Removendo elemento de uma posição específica
		lista.removerElemento(1);
		System.out.println("Lista após remover o elemento da posição 1:");
		lista.mostraLista();

	}

	
	}

