package Escola.Gerenciamento_Básico_de_Conta_Bancária;

/**
 * Classe principal (main) para instanciar e testar a classe ContaBancaria.
 * Demonstra a criação de objetos, depósitos, saques e exibição de saldo. 
 * * Atividade: Avaliação Prática NR 1 [cite: 4]
 * Curso: Técnico em Desenvolvimento de Sistemas [cite: 7]
 */
public class GerenciadorContasApp {

    public static void main(String[] args) {
        
        System.out.println("=== Iniciando Gerenciamento de Contas Bancárias ===");

        // 1. Instanciando dois objetos ContaBancaria 
        ContaBancaria conta1 = new ContaBancaria("Maria Oliveira", 1001, 800.00);
        ContaBancaria conta2 = new ContaBancaria("Joao Santos", 1002, 150.00);

        System.out.println("\n*** Contas criadas ***");
        System.out.println("Conta 1: " + conta1.getTitular() + " (Nº: " + conta1.getNumeroConta() + ")");
        System.out.println("Conta 2: " + conta2.getTitular() + " (Nº: " + conta2.getNumeroConta() + ")");

        // 2. Realizando operações na Conta 1 (Maria Oliveira) 
        System.out.println("\n--- Operações Conta 1 (Maria Oliveira) ---");
        
        // Exibição inicial de saldo
        conta1.exibirSaldo(); // [cite: 35]

        // Operação de depósito [cite: 35]
        conta1.depositar(350.50);
        
        // Exibição pós-depósito
        conta1.exibirSaldo();

        // Operação de saque (com sucesso) [cite: 36]
        boolean saque1 = conta1.sacar(200.00);
        System.out.println("Resultado da tentativa de saque 1: " + (saque1 ? "Sucesso" : "Falha"));

        // Operação de saque (com falha - saldo insuficiente) [cite: 36]
        boolean saque2 = conta1.sacar(1500.00);
        System.out.println("Resultado da tentativa de saque 2: " + (saque2 ? "Sucesso" : "Falha"));
        
        // Exibição final Conta 1
        conta1.exibirSaldo();


        // 3. Realizando operações na Conta 2 (Joao Santos) 
        System.out.println("\n--- Operações Conta 2 (Joao Santos) ---");
        
        // Exibição inicial de saldo
        conta2.exibirSaldo(); // [cite: 35]

        // Operação de saque (com falha - saldo insuficiente) [cite: 36]
        boolean saque3 = conta2.sacar(200.00);
        System.out.println("Resultado da tentativa de saque 3: " + (saque3 ? "Sucesso" : "Falha"));

        // Operação de depósito [cite: 35]
        conta2.depositar(900.00);

        // Operação de saque (com sucesso) [cite: 36]
        boolean saque4 = conta2.sacar(450.00);
        System.out.println("Resultado da tentativa de saque 4: " + (saque4 ? "Sucesso" : "Falha"));
        
        // Exibição final Conta 2
        conta2.exibirSaldo();
        
        System.out.println("\n=== Fim das Operações ===");
    }
}