package Escola.Sistema_de_Estoque_Simples;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque();
        boolean continuar = true;

        while (continuar) {
            System.out.println("--- MENU DE ESTOQUE ---");
            System.out.println("1. Adicionar/Editar produto");
            System.out.println("2. Remover produto");
            System.out.println("3. Exibir estoque");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Digite o preço: ");
                    double preco = scanner.nextDouble();
                    Produto novoProduto = new Produto(nome, quantidade, preco);
                    estoque.adicionarProduto(novoProduto); // Esta linha chama o método em Estoque
                    break;
                case 2:
                    estoque.removerProduto(); // Esta linha chama o método em Estoque
                    break;
                case 3:
                    estoque.exibirEstoque(); // Esta linha chama o método em Estoque
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }
}