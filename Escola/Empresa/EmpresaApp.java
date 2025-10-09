package Escola.Empresa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmpresaApp {

    public static void main(String[] args) {
        // --- Listas para armazenar os objetos (simulando um banco de dados) ---
        List<Cliente> clientes = new ArrayList<>();
        List<Funcionario> funcionarios = new ArrayList<>();
        List<Produto> produtos = new ArrayList<>();

        System.out.println("========= DEMONSTRAÇÃO CRUD - ATIVIDADE EMPRESA =========\n");

        // ===============================================================
        // 1. CREATE (Criar)
        // ===============================================================
        System.out.println("--- 1. CRIANDO OBJETOS ---");
        Cliente cliente1 = new Cliente("Ana Silva", 30, "Feminino", LocalDate.of(1994, 5, 15), "111.222.333-44", "ana.silva@email.com", "Rua das Flores, 123", "9999-8888");
        Funcionario func1 = new Funcionario("Carlos Souza", 45, "Masculino", LocalDate.of(1979, 10, 20), 4500.00, "Casado", "10 anos", "Gerente de Vendas", "Vendas");
        Produto prod1 = new Produto("SKU-001", "Notebook Gamer", 6500.00, 50, 2.5, "15.6 polegadas", "Preto", LocalDate.of(2027, 12, 31));
        Produto prod2 = new Produto("SKU-002", "Mouse Sem Fio", 150.00, 200, 0.2, "Médio", "Branco", null);

        clientes.add(cliente1);
        funcionarios.add(func1);
        produtos.add(prod1);
        produtos.add(prod2);
        System.out.println("Clientes, funcionários e produtos foram criados e adicionados às listas.\n");

        // ===============================================================
        // 2. READ (Listar)
        // ===============================================================
        System.out.println("--- 2. LISTANDO OBJETOS ---");
        System.out.println("Clientes Cadastrados:");
        for (Cliente c : clientes) {
            System.out.println(" -> " + c);
        }
        System.out.println("\nFuncionários Cadastrados:");
        for (Funcionario f : funcionarios) {
            System.out.println(" -> " + f);
        }
        System.out.println("\nProdutos Cadastrados:");
        for (Produto p : produtos) {
            System.out.println(" -> " + p);
        }
        
        System.out.println("\n--- UTILIZAÇÃO DOS MÉTODOS ESPECÍFICOS ---");
        // Cliente fazendo ações
        cliente1.criarReclamacao(prod1, "A bateria não está durando o prometido.");
        cliente1.criarAvaliacao(prod1, 4); // Avaliação de 4 estrelas
        cliente1.criarAvaliacao(prod2, 5); // Avaliação de 5 estrelas
        
        System.out.println();
        
        // Gerenciando estoque do produto
        prod2.adicionarEstoque(30);
        prod2.diminuirEstoque(5);
        System.out.println();


        // ===============================================================
        // 3. UPDATE (Atualizar)
        // ===============================================================
        System.out.println("\n--- 3. ATUALIZANDO OBJETOS ---");
        System.out.println("Preço antigo do produto '" + prod1.getModelo() + "': R$" + prod1.getPreco());
        prod1.setPreco(6299.90); // Atualizando o preço
        System.out.println("Novo preço do produto '" + prod1.getModelo() + "': R$" + prod1.getPreco());
        
        System.out.println("\nCargo antigo do funcionário '" + func1.getNome() + "': " + func1.getCargo());
        func1.setCargo("Diretor de Vendas"); // Promovendo o funcionário
        System.out.println("Novo cargo do funcionário '" + func1.getNome() + "': " + func1.getCargo() + "\n");
        

        // ===============================================================
        // 4. DELETE (Deletar)
        // ===============================================================
        System.out.println("--- 4. DELETANDO OBJETOS ---");
        System.out.println("Quantidade de produtos antes da exclusão: " + produtos.size());
        produtos.remove(prod2); // Removendo o mouse da lista
        System.out.println("Produto '" + prod2.getModelo() + "' foi removido.");
        System.out.println("Quantidade de produtos após a exclusão: " + produtos.size() + "\n");

        // --- LISTAGEM FINAL ---
        System.out.println("--- LISTAGEM FINAL APÓS AS OPERAÇÕES ---");
        System.out.println("\nProdutos Finais:");
        for (Produto p : produtos) {
            System.out.println(" -> " + p);
        }
    }
}