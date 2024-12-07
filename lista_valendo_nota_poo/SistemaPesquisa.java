package lista_valendo_nota_poo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaPesquisa {

    // Classe para representar uma alternativa
    static class Alternativa {
        private String texto;
        private int votos;

        public Alternativa(String texto) {
            this.texto = texto;
            this.votos = 0;
        }

        public String getTexto() {
            return texto;
        }

        public int getVotos() {
            return votos;
        }

        public void votar() {
            votos++;
        }
    }

    // Classe para representar uma questão
    static class Questao {
        private String pergunta;
        private List<Alternativa> alternativas;

        public Questao(String pergunta) {
            this.pergunta = pergunta;
            this.alternativas = new ArrayList<>();
        }

        public String getPergunta() {
            return pergunta;
        }

        public List<Alternativa> getAlternativas() {
            return alternativas;
        }

        public void adicionarAlternativa(String texto) {
            alternativas.add(new Alternativa(texto));
        }

        public void votarNaAlternativa(int indice) {
            if (indice < 0 || indice >= alternativas.size()) {
                throw new IllegalArgumentException("Índice de alternativa inválido.");
            }
            alternativas.get(indice).votar();
        }
    }

    // Classe para representar uma enquete
    static class Enquete {
        private String titulo;
        private List<Questao> questoes;

        public Enquete(String titulo) {
            this.titulo = titulo;
            this.questoes = new ArrayList<>();
        }

        public String getTitulo() {
            return titulo;
        }

        public List<Questao> getQuestoes() {
            return questoes;
        }

        public void adicionarQuestao(String pergunta) {
            questoes.add(new Questao(pergunta));
        }
    }

    // Classe para registrar as respostas de um participante
    static class Resposta {
        private Map<Questao, Integer> respostas;

        public Resposta() {
            this.respostas = new HashMap<>();
        }

        public void responder(Questao questao, int indiceAlternativa) {
            respostas.put(questao, indiceAlternativa);
            questao.votarNaAlternativa(indiceAlternativa);
        }

        public Map<Questao, Integer> getRespostas() {
            return respostas;
        }
    }


}
