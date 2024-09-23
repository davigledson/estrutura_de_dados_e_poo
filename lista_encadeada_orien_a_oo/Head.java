package lista_encadeada_orien_a_oo;

public class Head {
    public Bloco inicio;
	public int tamanho;
	public Bloco fim;

    public void mostraInicio() {
		Bloco aux = this.inicio;
		int cont=0;
		// while(aux != null && cont <= quant) {
		// 	System.out.println("posição:" + cont + " valor:"+ aux.getValor());
		// 	aux = aux.prox;
		// 	cont++;

		// }
		System.out.println(" valor do bloco:"+ aux.getValor());
		
	 }
	
    public void mostraFim() {
		Bloco aux = this.fim;
		int cont=0;
		// while(aux != null) {
		// 	System.out.println("posição:" + cont + " valor:"+ aux.getValor());
		// 	aux = aux.prox;
		// 	cont++;
		// }
		System.out.println( " valor do bloco:"+ aux.getValor());
	 }
}
