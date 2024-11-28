package lista_valendo_nota_3;
//6. Considere uma árvore cujos nós têm uma quantidade máxima de nós filhos.Essa árvore
//tem como caso o especial a árvore binária, quando a quantidade máxima de nós é igual
//a 2

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
public class ArvoreNaria<T> {

    // Representação de um nó na árvore
    static class No<T> {
        T valor;
        List<No<T>> filhos;

        public No(T valor, int maxFilhos) {
            this.valor = valor;
            this.filhos = new ArrayList<>(maxFilhos);
        }
    }

    private final int maxFilhos; // Número máximo de filhos por nó
    private No<T> raiz; // Nó raiz da árvore

    public ArvoreNaria(int maxFilhos) {
        if (maxFilhos < 1) {
            throw new IllegalArgumentException("O número máximo de filhos deve ser pelo menos 1.");
        }
        this.maxFilhos = maxFilhos;
        this.raiz = null;
    }

    // Adiciona a raiz
    public void adicionarRaiz(T valor) {
        if (raiz == null) {
            raiz = new No<>(valor, maxFilhos);
        } else {
            throw new IllegalStateException("A árvore já possui uma raiz.");
        }
    }

    // Adiciona um nó de acordo com o critério da primeira posição disponível
    public void adicionarPorNivel(T valor) {
        No<T> novoNo = new No<>(valor, maxFilhos);

        if (raiz == null) {
            raiz = novoNo; // Adiciona a raiz se ela não existir
            return;
        }

        // Utiliza uma fila para percorrer a árvore por nível
        Queue<No<T>> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No<T> atual = fila.poll();

            // Se o nó atual tem espaço para mais filhos, adiciona o novo nó
            if (atual.filhos.size() < maxFilhos) {
                atual.filhos.add(novoNo);
                return;
            }

            // Adiciona os filhos do nó atual à fila
            fila.addAll(atual.filhos);
        }
    }

    // Calcula a altura da árvore
    public int altura() {
        return calcularAltura(raiz);
    }

    private int calcularAltura(No<T> no) {
        if (no == null) {
            return 0;
        }

        int alturaMaxima = 0;
        for (No<T> filho : no.filhos) {
            alturaMaxima = Math.max(alturaMaxima, calcularAltura(filho));
        }

        return alturaMaxima + 1;
    }

    // Balanceia a árvore redistribuindo nós entre os níveis
    public void balancear() {
        if (raiz == null) {
            return;
        }

        // Coleta todos os nós da árvore
        List<T> valores = new ArrayList<>();
        coletarValores(raiz, valores);

        // Cria uma nova árvore balanceada
        raiz = null;
        for (T valor : valores) {
            adicionarPorNivel(valor);
        }
    }

    private void coletarValores(No<T> no, List<T> valores) {
        if (no == null) {
            return;
        }

        valores.add(no.valor);
        for (No<T> filho : no.filhos) {
            coletarValores(filho, valores);
        }
    }

    // Remove um nó específico e reorganiza seus filhos
    public boolean remover(T valor) {
        if (raiz == null) {
            return false;
        }

        if (raiz.valor.equals(valor)) {
            // Se a raiz for removida, a árvore é esvaziada
            raiz = null;
            return true;
        }

        // Busca o nó a ser removido e reorganiza os filhos
        Queue<No<T>> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No<T> atual = fila.poll();

            for (int i = 0; i < atual.filhos.size(); i++) {
                No<T> filho = atual.filhos.get(i);
                if (filho.valor.equals(valor)) {
                    // Reorganiza os filhos do nó removido
                    atual.filhos.remove(i);
                    fila.addAll(filho.filhos);
                    return true;
                }
            }

            fila.addAll(atual.filhos);
        }

        return false; // Valor não encontrado
    }

    // Localiza um nó na árvore pelo valor
    public No<T> localizar(T valor) {
        if (raiz == null) {
            return null;
        }

        // Realiza busca em largura (BFS)
        Queue<No<T>> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No<T> atual = fila.poll();

            if (atual.valor.equals(valor)) {
                return atual;
            }

            fila.addAll(atual.filhos);
        }

        return null; // Valor não encontrado
    }

    // Percorre a árvore em ordem pré-fixada (preorder)
    public void percorrerPreOrder(No<T> no) {
        if (no == null) {
            return;
        }

        // Exibe o valor do nó atual
        System.out.print(no.valor + " ");

        // Percorre os filhos
        for (No<T> filho : no.filhos) {
            percorrerPreOrder(filho);
        }
    }

    public No<T> getRaiz() {
        return raiz;
    }
}