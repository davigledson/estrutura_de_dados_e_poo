package lista_valendo_nota;
// Questão 4 -Implemente a classe FilaPilha que utiliza Pilhas para simular uma Fila.
    public class FilaPilha {
        Pilha pilha1 = new Pilha();
        Pilha pilha2 = new Pilha();

        public void push(int valor) {
            pilha1.push(valor);
        }

        public Elemento pop() {
            if (pilha2.lista.isVazia()) {
                while (!pilha1.lista.isVazia()) {
                    pilha2.push(pilha1.pop().getValor());
                }
            }
            return pilha2.pop();
        }

        public Elemento inicio() {
            if (pilha2.lista.isVazia()) {
                while (!pilha1.lista.isVazia()) {
                    pilha2.push(pilha1.pop().getValor());
                }
            }
            return pilha2.topo();
        }
    }


