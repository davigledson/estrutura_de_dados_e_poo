package aula_3_lista_encadeada_orien_a_oo;

public class ListaPoo {

	public static void main(String[] args) {
	
		Lista l = new Lista();
		
		for(int i= 0; i < 5; i++) {
			
			l.addBloco(i);
			
		}
	//l.removerBloco(3);
		l.mostraLista();
		
		//l.addBlocoApos(15,3);

		// System.out.println("==================");
		// l.mostraLista();

		// System.out.println("==================");
		// l.addBloco(30,2);
		// l.mostraLista();

		System.out.print("Valor Encontrado -> ");
		System.out.println(l.localizaBloco(2).getValor());
		System.out.println("==================");
		//l.addBlocoAposRecursivo(3,6);

		System.out.println(l.localizaBlocoRecursivo(2).getValor());
		l.mostraLista();

		System.out.println("=========LISTA DUPLA=========");
		ListaDupla ld = new ListaDupla();
		for(int i= 0; i < 10; i++) {	
			ld.addBlocoInicio(i);		
		}

		ld.mostraListaDupla();
		System.out.println("tamaho:" + ld.head.tamanho);
		System.out.println("======== INICIO ==========");
		ld.head.mostraInicio();
		System.out.println("======== FIM ==========");
		ld.head.mostraFim();

		for(int i= 10; i < 20; i++) {	
			ld.addBlocoFim(i);		
		}
		System.out.println("======== FIM DO MOSTRAFIM ==========");
		ld.head.mostraFim();
	
	}

}
