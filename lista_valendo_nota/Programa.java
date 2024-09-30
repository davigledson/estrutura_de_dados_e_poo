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

		lista.addElemento(10);
		lista.addElemento(20);
		lista.addElemento(30);

		System.out.println("Lista após adicionar elementos:");
		lista.mostraLista();

		lista.addElemento(15, 1);
		System.out.println("Lista após adicionar o elemento 15 na posição 1:");
		lista.mostraLista();

		lista.removerElementoFim();
		System.out.println("Lista após remover o último elemento:");
		lista.mostraLista();

		lista.removerElemento(1);
		System.out.println("Lista após remover o elemento da posição 1:");
		lista.mostraLista();


		System.out.println("=== LISTA RECURSIVA ===");
		ListaRecursiva lr = new ListaRecursiva();
		lr.addElemento(10);
		lr.addElemento(20);
		lr.addElemento(30);
		System.out.println("Lista:");
		lr.mostraLista();
		System.out.println("Tamanho da lista: " + lr.tamanho());

		Elemento elemento = lr.localizarElemento(1);
		if (elemento != null) {
			System.out.println("Elemento na posição 1: " + elemento.valor);
		} else {
			System.out.println("Elemento não encontrado!");
		}

		System.out.println("=== 12 - equação  ===");
		Lista lis_eq = new Lista();
		lis_eq.addElemento(1,false);

		lis_eq.addElemento(3,false);
		lis_eq.addElemento(4,false);
		lis_eq.addElemento(7,false);
		lis_eq.addElemento(35,false);

		//Questão 12 -
		lis_eq.mostraLista();
		int re1 = lis_eq.localizarElemento(1).getValor() + lis_eq.localizarElemento(2).getValor();
		int re2 = lis_eq.localizarElemento(2).getValor() + lis_eq.localizarElemento(3).getValor();
		int re3 = re1 * re2;
		int re4 = re3 + lis_eq.localizarElemento(4).getValor();
		int re5 = re1 * (re2 + lis_eq.localizarElemento(4).getValor()) /  lis_eq.localizarElemento(5).getValor();
		System.out.println("re1= " + re1 + " re2= " + re2+ " re3= " + re3 + " re4= " + re4  + " RESULTADO FINAL = " + re5);

		//Questão 13 -
		System.out.println("=== LISTA METODO CONCATENAR ===");
		Lista lista1 = new Lista();
		lista1.addElemento(1,true);
		lista1.addElemento(2,true);

		Lista lista2 = new Lista();
		lista2.addElemento(3,true);
		lista2.addElemento(4,true);

		Lista listaConcatenada = lista1.concatena(lista2);
		listaConcatenada.mostraLista(); //  1, 2, 3, 4


		System.out.println("=== ELEMENTOS DUPLICADOS ===");
		//QUESTÃO 14 -
		Lista ldup = new Lista();
		ldup.addElemento(1,false);
		ldup.addElemento(2,false);
		ldup.addElemento(2,false);
		ldup.addElemento(3,false);
		ldup.addElemento(1,false);
		ldup.addElemento(4,false);
		ldup.addElemento(3,false);

		System.out.println("Lista antes de remover duplicados:");
		ldup.mostraLista();

		ldup.removeDuplicados();

		System.out.println("Lista após remover duplicados:");
		ldup.mostraLista();

		System.out.println("=== LISTA CLONE ===");
		Lista listaClonada = ldup.clone();
		listaClonada.mostraLista();

		System.out.println("FILA PRIORITARIA");
		FilaPrioridade filaPrio = new FilaPrioridade();

		filaPrio.add(1, 2); // Valor 1 com prioridade 2
		filaPrio.add(2, 5); // Valor 2 com prioridade 5
		filaPrio.add(3, 1); // Valor 3 com prioridade 1
		filaPrio.add(4, 4); // Valor 4 com prioridade 4

		filaPrio.mostraFila();
		filaPrio.remove();
		System.out.println("removendo");
		filaPrio.mostraFila();

		System.out.println(" === REMOVER NA POSIÇAO ===");
		Lista liRemove = new Lista();
		liRemove.addElemento(1, false);
		liRemove.addElemento(2, false);
		liRemove.addElemento(3, false);
		liRemove.addElemento(4, false);

		System.out.println("Lista antes da remoção:");
		liRemove.mostraLista();

		System.out.println("Lista DEPOIS da remoção:");
		Elemento removido = liRemove.removeElemento(1);
		liRemove.mostraLista();


		System.out.println(" === LISTA localizarMaior ===");
		liRemove.addElemento(4,false);
		liRemove.addElemento(5,false);
		liRemove.addElemento(6,false);
		liRemove.addElemento(7,false);

		liRemove.mostraLista();
		System.out.println(" === localizarMaior 5 ===");
		Lista maiorque5 = liRemove.localizarMaior(5);
		maiorque5.mostraLista();

//
		System.out.println(" === BARALHO ===");
	}

	
	}

