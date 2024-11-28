package lista_valendo_nota_3;
import java.util.LinkedList;
//9. Desenvolva uma solução para resolver colisões da inserção de números em um array.
//Sempre que a posição escolhida já estiver ocupada por algum valor, uma colisão ocorre.
//Para resolver esse problema, crie uma lista que se forma sempre que há uma colisão e
//nela deve estar o novo valor que está sendo inserido.
public class HashTableComListas {

    // Classe que representa a tabela hash com listas para tratar colisões
    static class HashTable {
        private LinkedList<Integer>[] tabela; // Array de listas encadeadas
        private int tamanho; // Tamanho da tabela

        @SuppressWarnings("unchecked")
        public HashTable(int tamanho) {
            this.tamanho = tamanho;
            this.tabela = new LinkedList[tamanho];

            // Inicializa cada posição com uma lista vazia
            for (int i = 0; i < tamanho; i++) {
                tabela[i] = new LinkedList<>();
            }
        }

        // Calcula o índice baseado no valor (hash simples usando módulo)
        private int calcularIndice(int valor) {
            return valor % tamanho;
        }

        // Insere um valor na tabela
        public void inserir(int valor) {
            int indice = calcularIndice(valor);

            // Adiciona o valor na lista correspondente ao índice
            if (!tabela[indice].contains(valor)) { // Evita duplicatas
                tabela[indice].add(valor);
            }
        }

        // Exibe a tabela hash
        public void exibirTabela() {
            for (int i = 0; i < tamanho; i++) {
                System.out.print("Posição " + i + ": " + tabela[i]);
                System.out.println();
            }
        }

        // Verifica se um valor existe na tabela
        public boolean existe(int valor) {
            int indice = calcularIndice(valor);
            return tabela[indice].contains(valor);
        }

        // Remove um valor da tabela
        public boolean remover(int valor) {
            int indice = calcularIndice(valor);
            return tabela[indice].remove((Integer) valor);
        }
    }

    // Teste da Tabela Hash
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(5); // Cria uma tabela hash com 5 posições

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
    }
}
