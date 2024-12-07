package lista_valendo_nota_poo;

abstract class Criteria {
    public abstract No apply(No referencia, int valor);
}

class ClassicCriteria extends Criteria {
    @Override
    public No apply(No referencia, int valor) {
        if (valor < referencia.valor) {
            return referencia.esquerda;
        } else {
            return referencia.direita;
        }
    }
}

class ReverseCriteria extends Criteria {
    @Override
    public No apply(No referencia, int valor) {
        if (valor < referencia.valor) {
            return referencia.direita;
        } else {
            return referencia.esquerda;
        }
    }
}

class Neuro extends Criteria {
    @Override
    public No apply(No referencia, int valor) {
        // Multiplicação entre valor e peso decide a direção
        int resultado = valor * referencia.peso;
        if (resultado < referencia.valor) {
            return referencia.esquerda;
        } else {
            return referencia.direita;
        }
    }
}

class No {
    int valor;
    int peso; // Novo atributo peso
    No esquerda;
    No direita;

    public No(int valor, int peso) {
        this.valor = valor;
        this.peso = peso;
        this.esquerda = null;
        this.direita = null;
    }
}

class ArvoreComCriteria {
    private No raiz;
    private final Criteria criterio;

    public ArvoreComCriteria(Criteria criterio) {
        this.raiz = null;
        this.criterio = criterio;
    }

    public void inserir(int valor, int peso) {
        if (raiz == null) {
            raiz = new No(valor, peso);
        } else {
            inserirRecursivo(raiz, valor, peso);
        }
    }

    private void inserirRecursivo(No atual, int valor, int peso) {
        No proximo = criterio.apply(atual, valor);
        if (proximo == null) {
            if (criterio instanceof Neuro) {
                // Critério Neuro utiliza o resultado do peso * valor
                if (valor * atual.peso < atual.valor) {
                    atual.esquerda = new No(valor, peso);
                } else {
                    atual.direita = new No(valor, peso);
                }
            } else {
                if (valor < atual.valor) {
                    atual.esquerda = new No(valor, peso);
                } else {
                    atual.direita = new No(valor, peso);
                }
            }
        } else {
            inserirRecursivo(proximo, valor, peso);
        }
    }

    public void exibirPreOrder() {
        exibirPreOrderRecursivo(raiz);
    }

    private void exibirPreOrderRecursivo(No atual) {
        if (atual != null) {
            System.out.print("(Valor: " + atual.valor + ", Peso: " + atual.peso + ") ");
            exibirPreOrderRecursivo(atual.esquerda);
            exibirPreOrderRecursivo(atual.direita);
        }
    }
}

