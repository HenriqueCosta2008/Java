package Escola.Gerenciamento_Básico_de_Conta_Bancária;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Representa uma conta bancária conforme os requisitos da avaliação. [cite: 26]
 * Gerencia titular, número da conta e saldo, com operações de depósito,
 * saque e exibição de saldo.
 * * UC: Lógica De Programação [cite: 9]
 * Docente: Marcio Schoenfelder [cite: 6]
 */
public class ContaBancaria {

    // --- ATRIBUTOS PRIVADOS --- [cite: 26]
    private String titular;     // [cite: 27]
    private int numeroConta;    // [cite: 28]
    private double saldo;       // [cite: 29]

    /**
     * Construtor com parâmetros para inicializar todos os atributos. [cite: 31]
     *
     * @param titular Nome do titular da conta.
     * @param numeroConta Número da conta.
     * @param saldo Saldo inicial (pode ser zero ou positivo).
     */
    public ContaBancaria(String titular, int numeroConta, double saldo) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    // --- MÉTODOS DE ACESSO (GETTERS E SETTERS) --- [cite: 32]

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    // O atributo 'saldo' não possui get/set públicos,
    // sendo acessado apenas por métodos específicos. [cite: 33]

    // --- MÉTODOS DE OPERAÇÃO --- [cite: 34]

    /**
     * Exibe o saldo atual da conta formatado em Reais (BRL).
     * Método sem parâmetros e sem retorno (void). [cite: 35]
     */
    public void exibirSaldo() {
        // Formata o valor para o padrão de moeda local (Brasil)
        Locale localeBR = new Locale("pt", "BR");
        NumberFormat formatadorMoeda = NumberFormat.getCurrencyInstance(localeBR);

        System.out.println("---------------------------------");
        System.out.println("Titular: " + this.titular);
        System.out.println("Saldo Atual: " + formatadorMoeda.format(this.saldo));
        System.out.println("---------------------------------");
    }

    /**
     * Adiciona um valor ao saldo da conta.
     * Método com parâmetro (valor) e sem retorno (void). [cite: 35]
     *
     * @param valor O valor a ser depositado (deve ser positivo).
     */
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito de " + formatarMoeda(valor) + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido. O valor deve ser positivo.");
        }
    }

    /**
     * Tenta subtrair um valor do saldo da conta.
     * Método com parâmetro (valor) e com retorno booleano. [cite: 36]
     *
     * @param valor O valor a ser sacado.
     * @return true se o saque foi realizado com sucesso, false se não há saldo suficiente. [cite: 36]
     */
    public boolean sacar(double valor) {
        // Verifica se há saldo suficiente [cite: 36]
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor; // Subtrai o valor [cite: 36]
            System.out.println("Saque de " + formatarMoeda(valor) + " realizado com sucesso.");
            return true; // Indica sucesso [cite: 36]
        } else if (valor <= 0) {
            System.out.println("Valor de saque inválido. O valor deve ser positivo.");
            return false; // Indica falha
        } else {
            System.out.println("Falha no saque. Saldo insuficiente.");
            return false; // Indica falha [cite: 36]
        }
    }
    
    /**
     * Método auxiliar privado para formatação de moeda.
     * Usado para melhorar a clareza nas mensagens de depósito e saque.
     */
    private String formatarMoeda(double valor) {
        Locale localeBR = new Locale("pt", "BR");
        return NumberFormat.getCurrencyInstance(localeBR).format(valor);
    }
}