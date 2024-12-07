package lista_valendo_nota_poo;
import java.util.ArrayList;
import java.util.List;

// Classe abstrata Agregador
abstract class Agregador<T extends Item> {
    protected List<T> itens = new ArrayList<>();

    public void adicionarItem(T item) {
        itens.add(item);
    }

    public void removerItem(T item) {
        itens.remove(item);
    }

    public List<T> obterItens() {
        return itens;
    }

    // Método abstrato para calcular o total
    public abstract double calcularTotal();
}

// Classe abstrata Item
abstract class Item {
    public abstract double getValor(); // Retorna o valor do item
}

// Implementação concreta: Pedido
class Pedido extends Agregador<ItemPedido> {
    @Override
    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getValor();
        }
        return total;
    }
}

// Implementação concreta: ItemPedido
class ItemPedido extends Item {
    private double valorUnitario;
    private int quantidade;

    public ItemPedido(double valorUnitario, int quantidade) {
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    @Override
    public double getValor() {
        return valorUnitario * quantidade;
    }
}
