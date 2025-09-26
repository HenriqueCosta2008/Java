package Escola.SistemadeEstoqueSimples;

import java.util.Scanner; // 1. Importa a classe Scanner

public class Main {

    public static void main(String[] args) {
        // 2. Cria os objetos que vamos usar
        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque();

        boolean continuar = true; // 3. Variável para controlar o laço while

        // 4. Inicia o laço de repetição do menu
        while (continuar) {
            System.out.println("--- MENU DE ESTOQUE ---");
            System.out.println("1. Adicionar/Editar produto");
            System.out.println("2. Remover produto");
            System.out.println("3. Exibir estoque");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt(); // 5. Lê a escolha do usuário
            scanner.nextLine(); // Limpa o buffer do scanner

            // 6. Estrutura switch para tratar a opção escolhida
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    
                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();
                    
                    System.out.print("Digite o preço: ");
                    double preco = scanner.nextDouble();
                    
                    // Cria um novo objeto Produto com os dados informados
                    Produto novoProduto = new Produto(nome, quantidade, preco);
                    
                    // Adiciona o produto ao estoque
                    estoque.adicionarProduto(novoProduto);
                    break;
                    
                case 2:
                    estoque.removerProduto();
                    break;
                    
                case 3:
                    estoque.exibirEstoque();
                    break;
                    
                case 4:
                    continuar = false; // 7. Altera a variável para sair do laço
                    System.out.println("Saindo do sistema...");
                    break;
                    
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
        
        scanner.close(); // 8. Fecha o scanner ao final do programa
    }
}