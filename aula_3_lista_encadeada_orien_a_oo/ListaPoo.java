package aula_3_lista_encadeada_orien_a_oo;

public class ListaPoo {

	public static void main(String[] args) {
	
		Lista l = new Lista();
		
		for(int i= 0; i < 5; i++) {
			
			l.addBloco(i);
			
		}

		l.mostraLista();
		//l.addBlocoApos(15,3);

		System.out.println("==================");
		l.mostraLista();

		System.out.println("==================");
		l.addBloco(30,2);
		l.mostraLista();

		System.out.print("Valor Encontrado -> ");
		System.out.println(l.localizaBloco(2).getValor());
		
	
	}

}
