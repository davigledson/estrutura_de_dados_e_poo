package lista_valendo_nota_3;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

        lista.addElemento(10, false); // Adiciona no fim
        lista.addElemento(20, false); // Adiciona no fim
        lista.addElemento(5, true);   // Adiciona no início

        System.out.println("Lista original:");
        lista.mostraLista();

        System.out.println("Lista invertida:");
        lista.mostraListaInvertida();

        lista.removeDuplicados();
        System.out.println("Após remover duplicados:");
        lista.mostraLista();

        ListaDuplamenteEncadeada clonada = lista.clone();
        System.out.println("Lista clonada:");
        clonada.mostraLista();

        //Lista circular
        System.out.println("=========Lista circular =======");
        ListaCircular lista_cicular = new ListaCircular();

        lista_cicular.addElemento(10, false); // Adiciona no fim
        lista_cicular.addElemento(20, false); // Adiciona no fim
        lista_cicular.addElemento(5, true);
        lista_cicular.addElemento(50, true);
        lista_cicular.addElemento(30, true); // Adiciona no início

        System.out.println("Lista original:");
        lista_cicular.mostraLista();

        lista_cicular.removeDuplicados();
        System.out.println("Após remover duplicados:");
        lista_cicular.mostraLista();

        ListaCircular listaInvertida = lista_cicular.inverte();
        System.out.println("Lista invertida:");
        listaInvertida.mostraLista();

        System.out.println("Removendo elemento do início:");
        lista_cicular.removerElementoInicio();
        lista_cicular.mostraLista();

        System.out.println("Removendo elemento do fim:");
        lista_cicular.removerElementoFim();
        lista_cicular.mostraLista();

        System.out.println("Menor valor: " + lista_cicular.menorValor());
        System.out.println("Maior valor: " + lista_cicular.maiorValor());
        System.out.println("Valor médio: " + lista_cicular.valorMedio());

        //lista simplesmete encadeada
        System.out.println("====== Lista simplesmente encadeada =======:");
        ListaSimplementeEncadeada lista_se = new ListaSimplementeEncadeada();

        // Adicionando elementos na lista_se
        ListaSimplementeEncadeada.Elemento e1 = lista_se.addElementoFim(10);
        ListaSimplementeEncadeada.Elemento e2 = lista_se.addElementoFim(20);
        ListaSimplementeEncadeada.Elemento e3 = lista_se.addElementoFim(30);

        // Mostra a lista_se completa
        System.out.println("Lista completa:");
        lista_se.mostraLista();

        // Testando getAnt()
        ListaSimplementeEncadeada.Elemento anterior = lista_se.getAnt(e2);
        if (anterior != null) {
            System.out.println("O elemento anterior a " + e2.getValor() + " é " + anterior.getValor());
        } else {
            System.out.println("Não há elemento anterior ao " + e2.getValor());
        }

        anterior = lista_se.getAnt(e1);
        if (anterior != null) {
            System.out.println("O elemento anterior a " + e1.getValor() + " é " + anterior.getValor());
        } else {
            System.out.println("Não há elemento anterior ao " + e1.getValor());
        }

        //Arvore Naria
        // Cria uma árvore N-ária com no máximo 3 filhos por nó

        System.out.println("====== Arvore Naria =======:");
        // Cria uma árvore N-ária com no máximo 3 filhos por nó
        ArvoreNaria<Integer> arvore = new ArvoreNaria<>(3);

        // Adiciona a raiz
        arvore.adicionarRaiz(1);

        // Adiciona nós com critério de nível
        arvore.adicionarPorNivel(2);
        arvore.adicionarPorNivel(3);
        arvore.adicionarPorNivel(4);
        arvore.adicionarPorNivel(5);
        arvore.adicionarPorNivel(6);
        arvore.adicionarPorNivel(7);

        // Percorre a árvore em ordem pré-fixada
        System.out.println("Percurso pré-ordem:");
        arvore.percorrerPreOrder(arvore.getRaiz());

        System.out.println("Árvore antes do balanceamento:");
        arvore.percorrerPreOrder(arvore.getRaiz());
        System.out.println();

        // Exibe a altura
        System.out.println("Altura da árvore: " + arvore.altura());

        // Balanceia a árvore
        arvore.balancear();

        System.out.println("Árvore após o balanceamento:");
        arvore.percorrerPreOrder(arvore.getRaiz());
        System.out.println();

        // Remove um nó
        arvore.remover(3);
        System.out.println("Árvore após remover o nó 3:");
        arvore.percorrerPreOrder(arvore.getRaiz());


        System.out.println("====== HashTableComListas =======:");
        HashTableComListas.HashTable hashTable = new HashTableComListas.HashTable(5); // Cria uma tabela hash com 5 posições

        // Inserções
        hashTable.inserir(10); // Vai para índice 0
        hashTable.inserir(15); // Vai para índice 0 (colisão)
        hashTable.inserir(20); // Vai para índice 0 (colisão)
        hashTable.inserir(3);  // Vai para índice 3
        hashTable.inserir(7);  // Vai para índice 2

        System.out.println("Tabela Hash após inserções:");
        hashTable.exibirTabela();

        // Verifica a existência de valores
        System.out.println("Valor 15 existe? " + hashTable.existe(15)); // true
        System.out.println("Valor 5 existe? " + hashTable.existe(5));   // false

        // Remove um valor
        System.out.println("Removendo valor 15...");
        hashTable.remover(15);

        System.out.println("Tabela Hash após remoção:");
        hashTable.exibirTabela();

        Matriz matriz = new Matriz(3, 3);

        // Define valores na matriz
        matriz.setValor(0, 0, 1);
        matriz.setValor(0, 1, 2);
        matriz.setValor(0, 2, 3);
        matriz.setValor(1, 0, 4);
        matriz.setValor(1, 1, 5);
        matriz.setValor(1, 2, 6);
        matriz.setValor(2, 0, 7);
        matriz.setValor(2, 1, 8);
        matriz.setValor(2, 2, 9);

        // Exibe a matriz
        System.out.println("Matriz inicial:");
        matriz.exibirMatriz();

        // Adiciona uma nova linha
        ArrayList<Integer> novaLinha = new ArrayList<>();
        novaLinha.add(10);
        novaLinha.add(11);
        novaLinha.add(12);
        matriz.adicionarLinha(novaLinha);
        System.out.println("\nApós adicionar uma linha:");
        matriz.exibirMatriz();

        // Adiciona uma nova coluna
        ArrayList<Integer> novaColuna = new ArrayList<>();
        novaColuna.add(13);
        novaColuna.add(14);
        novaColuna.add(15);
        novaColuna.add(16);
        matriz.adicionarColuna(novaColuna);
        System.out.println("\nApós adicionar uma coluna:");
        matriz.exibirMatriz();




    }
}
