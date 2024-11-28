package lista_valendo_nota_3;
import java.util.ArrayList;
//10. Utilize listas para simular uma matriz.
public class Matriz {

    private ArrayList<ArrayList<Integer>> matriz; // Lista de listas para representar a matriz

    public Matriz(int linhas, int colunas) {
        matriz = new ArrayList<>();

        // Inicializa a matriz com zeros
        for (int i = 0; i < linhas; i++) {
            ArrayList<Integer> linha = new ArrayList<>();
            for (int j = 0; j < colunas; j++) {
                linha.add(0); // Inicializa cada posição com 0
            }
            matriz.add(linha);
        }
    }

    // Define um valor em uma posição específica
    public void setValor(int linha, int coluna, int valor) {
        if (linha < 0 || linha >= matriz.size() || coluna < 0 || coluna >= matriz.get(linha).size()) {
            throw new IndexOutOfBoundsException("Índice fora do intervalo válido.");
        }
        matriz.get(linha).set(coluna, valor);
    }

    // Retorna o valor de uma posição específica
    public int getValor(int linha, int coluna) {
        if (linha < 0 || linha >= matriz.size() || coluna < 0 || coluna >= matriz.get(linha).size()) {
            throw new IndexOutOfBoundsException("Índice fora do intervalo válido.");
        }
        return matriz.get(linha).get(coluna);
    }

    // Exibe a matriz
    public void exibirMatriz() {
        for (ArrayList<Integer> linha : matriz) {
            System.out.println(linha);
        }
    }

    // Adiciona uma linha à matriz
    public void adicionarLinha(ArrayList<Integer> novaLinha) {
        if (novaLinha.size() != matriz.get(0).size()) {
            throw new IllegalArgumentException("A nova linha deve ter o mesmo número de colunas da matriz.");
        }
        matriz.add(novaLinha);
    }

    // Adiciona uma coluna à matriz
    public void adicionarColuna(ArrayList<Integer> novaColuna) {
        if (novaColuna.size() != matriz.size()) {
            throw new IllegalArgumentException("A nova coluna deve ter o mesmo número de linhas da matriz.");
        }
        for (int i = 0; i < matriz.size(); i++) {
            matriz.get(i).add(novaColuna.get(i));
        }
    }

    // Retorna o número de linhas
    public int getLinhas() {
        return matriz.size();
    }

    // Retorna o número de colunas
    public int getColunas() {
        return matriz.isEmpty() ? 0 : matriz.get(0).size();
    }
}