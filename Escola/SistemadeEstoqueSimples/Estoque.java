package Escola.SistemadeEstoqueSimples;

public class Estoque {
    private Produto produto;

    public void adicionarProduto(Produto produtoParaAdicionar) {
        this.produto = produtoParaAdicionar;
        System.out.println("\nProduto adicionado/editado com sucesso!\n");
    }

    public void removerProduto() {
        this.produto = null;
        System.out.println("\nProduto removido com sucesso!\n");
    }

    public void exibirEstoque() {
        System.out.println("\n--- Informações do Estoque ---");
        if (this.produto == null) {
            System.out.println("O estoque está vazio.");
        } else {
            System.out.println(this.produto);
        }
        System.out.println("----------------------------\n");
    }
}