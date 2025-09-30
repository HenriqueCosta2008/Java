package Escola.Sistema_de_Estoque_Simples;

// 1. CORREÇÃO: Adicionamos a importação que estava faltando
import java.util.Scanner; 
import java.util.HashMap;
import java.util.Map;


public class Estoque {
    private Map<String, Produto> produtos;

    public Estoque() {
        this.produtos = new HashMap<>();
    }

    // O Main.java chama este método, então ele deve ser público
    public void adicionarProduto(Produto produto) {
        produtos.put(produto.getNome(), produto);
        System.out.println("Produto '" + produto.getNome() + "' adicionado/atualizado com sucesso!");
    }

    // O Main.java chama este método, então ele deve ser público
    public void removerProduto() {
        // Esta linha agora funciona por causa do import adicionado acima
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do produto que deseja remover: ");
        String nomeParaRemover = scanner.nextLine();

        if (produtos.containsKey(nomeParaRemover)) {
            produtos.remove(nomeParaRemover);
            System.out.println("Produto '" + nomeParaRemover + "' removido com sucesso!");
        } else {
            System.out.println("Erro: Produto não encontrado no estoque.");
        }
    }

    // O Main.java chama este método, então ele deve ser público
    public void exibirEstoque() {
        System.out.println("\n--- ESTOQUE ATUAL ---");
        if (produtos.isEmpty()) {
            System.out.println("O estoque está vazio.");
        } else {
            for (Produto p : produtos.values()) {
                System.out.println(p.toString());
            }
        }
        System.out.println("----------------------\n");
    }
}