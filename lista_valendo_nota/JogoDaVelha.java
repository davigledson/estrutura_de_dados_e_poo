package lista_valendo_nota;
 //Questão 20 - Tipicamente os jogos da velha são implementados através de matrizes, porém o desafio aqui é implementar utilizando uma única lista.

import java.util.Scanner;

import java.util.Scanner;

import java.util.Scanner;

import java.util.Scanner;

import java.util.Scanner;

public class JogoDaVelha {
    private Lista tabuleiro; // Lista para armazenar o estado do tabuleiro
    private final int VAZIO = 11; // Representa uma posição vazia
    private final int TAMANHO = 9; // Tamanho do tabuleiro (3x3)

    public JogoDaVelha() {
        tabuleiro = new Lista();
        // Inicializa o tabuleiro com posições vazias
        for (int i = 0; i < TAMANHO; i++) {
            tabuleiro.addElemento(VAZIO, false);
        }
    }

    public void exibirTabuleiro() {
        System.out.println(" 88 == X   | 88 == O");
        for (int i = 0; i < TAMANHO; i++) {
            System.out.print("[" + tabuleiro.localizarElemento(i).getValor() + "]");
            if ((i + 1) % 3 == 0) {
                System.out.println();
            }
        }
    }

    public boolean fazerJogada(int posicao, char jogador) {
        if (posicao < 0 || posicao >= TAMANHO || (int) tabuleiro.localizarElemento(posicao).getValor() != VAZIO) {
            return false; // Jogada inválida
        }
        tabuleiro.localizarElemento(posicao).setValor((int) jogador); // Define a jogada
        return true; // Jogada válida
    }

    public boolean verificarVencedor(char jogador) {
        int[][] combinacoes = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Linhas
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Colunas
                {0, 4, 8}, {2, 4, 6}            // Diagonais
        };

        for (int[] combinacao : combinacoes) {
            if ((int) tabuleiro.localizarElemento(combinacao[0]).getValor() == (int) jogador &&
                    (int) tabuleiro.localizarElemento(combinacao[1]).getValor() == (int) jogador &&
                    (int) tabuleiro.localizarElemento(combinacao[2]).getValor() == (int) jogador) {
                return true; // Jogador venceu
            }
        }
        return false; // Nenhum vencedor
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JogoDaVelha jogo = new JogoDaVelha();
        char jogadorAtual = 'X';
        boolean jogoAtivo = true;

        while (jogoAtivo) {
            jogo.exibirTabuleiro();
            System.out.println("Jogador " + jogadorAtual + ", digite a posição (0-8): ");
            int posicao = scanner.nextInt();

            if (jogo.fazerJogada(posicao, jogadorAtual)) {
                if (jogo.verificarVencedor(jogadorAtual)) {
                    jogo.exibirTabuleiro();
                    System.out.println("Jogador " + jogadorAtual + " venceu!");
                    jogoAtivo = false;
                } else {
                    // Alterna o jogador
                    jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Jogada inválida, tente novamente.");
            }
        }

        scanner.close();
    }
}
