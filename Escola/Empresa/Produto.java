package Escola.Empresa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Produto {
    private String sku;
    private String modelo;
    private double preco;
    private int quantidade; // Estoque
    private double peso;
    private String tamanho;
    private String cor;
    private LocalDate validade;
    private List<Reclamacao> reclamacoes;
    private List<Avaliacao> avaliacoes;

    public Produto(String sku, String modelo, double preco, int quantidade, double peso, String tamanho, String cor, LocalDate validade) {
        this.sku = sku;
        this.modelo = modelo;
        this.preco = preco;
        this.quantidade = quantidade;
        this.peso = peso;
        this.tamanho = tamanho;
        this.cor = cor;
        this.validade = validade;
        this.reclamacoes = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();
    }

    // Métodos para gerenciar estoque
    public void adicionarEstoque(int quantidadeAdicionar) {
        if (quantidadeAdicionar > 0) {
            this.quantidade += quantidadeAdicionar;
            System.out.println(quantidadeAdicionar + " unidades de '" + this.modelo + "' adicionadas. Estoque atual: " + this.quantidade);
        } else {
            System.out.println("A quantidade a ser adicionada deve ser positiva.");
        }
    }

    public void diminuirEstoque(int quantidadeRemover) {
        if (quantidadeRemover > 0 && this.quantidade >= quantidadeRemover) {
            this.quantidade -= quantidadeRemover;
            System.out.println(quantidadeRemover + " unidades de '" + this.modelo + "' removidas. Estoque atual: " + this.quantidade);
        } else if (quantidadeRemover <= 0) {
            System.out.println("A quantidade a ser removida deve ser positiva.");
        } else {
            System.out.println("Erro: Estoque insuficiente para remover " + quantidadeRemover + " unidades de '" + this.modelo + "'.");
        }
    }
    
    // Métodos para adicionar reclamações e avaliações
    public void adicionarReclamacao(Reclamacao reclamacao) {
        this.reclamacoes.add(reclamacao);
    }
    
    public void adicionarAvaliacao(Avaliacao avaliacao) {
        this.avaliacoes.add(avaliacao);
    }


    // Getters e Setters
    public String getSku() { return sku; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    public int getQuantidade() { return quantidade; }
    
    @Override
    public String toString() {
        return "Produto [SKU: " + sku + ", Modelo: " + modelo + ", Preço: R$" + preco + ", Estoque: " + quantidade + "]\n"
               + " -> Reclamações: " + reclamacoes + "\n"
               + " -> Avaliações: " + avaliacoes;
    }
}