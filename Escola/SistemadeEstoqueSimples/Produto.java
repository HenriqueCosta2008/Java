package Escola.SistemadeEstoqueSimples;

public class Produto {
    private String nome;
    private int quantidade;
    private double preco;

    public Produto(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto: " + nome + ", Quantidade: " + quantidade + ", Preço: R$" + String.format("%.2f", preco);
    }
}
