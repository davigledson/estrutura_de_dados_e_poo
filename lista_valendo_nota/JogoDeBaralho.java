package lista_valendo_nota;
import java.util.Random;

//19 - Implemente um jogo de baralho com dois decks, um para cartas jogador. O jogador vencedor é o que retira as 5 primeiras cartas com a maior soma.
public class JogoDeBaralho {

    public static void main(String[] args) {
        Lista deck1 = criarDeck();
        Lista deck2 = criarDeck();

        // Embaralha os decks
        deck1 = embaralhar(deck1);
        deck2 = embaralhar(deck2);

        // Retira as 5 primeiras cartas de cada deck
        Lista maoJogador1 = retirarCartas(deck1, 5);
        Lista maoJogador2 = retirarCartas(deck2, 5);

        // Calcula as somas
        int somaJogador1 = calcularSoma(maoJogador1);
        int somaJogador2 = calcularSoma(maoJogador2);

        // Exibe as cartas e as somas
        System.out.println("Mão do Jogador 1:");
        maoJogador1.mostraLista();
        System.out.println("Soma: " + somaJogador1);

        System.out.println("Mão do Jogador 2:");
        maoJogador2.mostraLista();
        System.out.println("Soma: " + somaJogador2);

        // Determina o vencedor
        if (somaJogador1 > somaJogador2) {
            System.out.println("Jogador 1 é o vencedor!");
        } else if (somaJogador2 > somaJogador1) {
            System.out.println("Jogador 2 é o vencedor!");
        } else {
            System.out.println("É um empate!");
        }
    }

    // Método para criar um deck de cartas
    private static Lista criarDeck() {
        Lista deck = new Lista();
        String[] naipes = {"Copas", "Ouros", "Espadas", "Paus"};

        for (String naipe : naipes) {
            for (int valor = 1; valor <= 13; valor++) {
                deck.addElemento(valor, false);
            }
        }
        return deck;
    }

    // Método para retirar cartas do deck
    private static Lista retirarCartas(Lista deck, int quantidade) {
        Lista mao = new Lista();
        for (int i = 0; i < quantidade; i++) {
            Elemento carta = deck.removerElementoInicio(); // Retira a primeira carta
            if (carta != null) {
                mao.addElemento(carta.getValor(), false); // Adiciona à mão do jogador
            }
        }
        return mao;
    }
    private static Lista embaralhar(Lista deck) {
        // Cria uma nova lista para o deck embaralhado
        Lista deckEmbaralhado = new Lista();

        // Armazena os elementos do deck original em um array
        int tamanho = deck.tamanho();
        int[] valores = new int[tamanho];

        Elemento atual = deck.inicio;
        for (int i = 0; i < tamanho; i++) {
            valores[i] = atual.getValor();
            atual = atual.prox;
        }

        //  o algoritmo de Fisher-Yates
        Random random = new Random();
        for (int i = tamanho - 1; i > 0; i--) {
            int j = random.nextInt(i + 1); // Gera um índice aleatório
            int temp = valores[i];
            valores[i] = valores[j];
            valores[j] = temp;
        }

        for (int valor : valores) {
            deckEmbaralhado.addElemento(valor, false);
        }

        return deckEmbaralhado;
    }

    // Método para calcular a soma das cartas
    private static int calcularSoma(Lista mao) {
        int soma = 0;
        Elemento atual = mao.inicio;
        while (atual != null) {
            soma += atual.getValor();
            atual = atual.prox;
        }
        return soma;
    }
}
