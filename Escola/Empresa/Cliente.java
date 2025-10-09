package Escola.Empresa;

import java.time.LocalDate;

public class Cliente extends Pessoa {
    private String cpf;
    private String email;
    private String endereco;
    private String telefone;

    public Cliente(String nome, int idade, String sexo, LocalDate dataNascimento, String cpf, String email, String endereco, String telefone) {
        super(nome, idade, sexo, dataNascimento);
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    // Métodos específicos do Cliente
    public void criarReclamacao(Produto produto, String textoReclamacao) {
        Reclamacao novaReclamacao = new Reclamacao(textoReclamacao);
        produto.adicionarReclamacao(novaReclamacao);
        System.out.println("Reclamação do cliente " + getNome() + " registrada para o produto " + produto.getModelo() + ".");
    }

    public void criarAvaliacao(Produto produto, int estrelas) {
        Avaliacao novaAvaliacao = new Avaliacao(estrelas);
        produto.adicionarAvaliacao(novaAvaliacao);
        System.out.println("Avaliação de " + estrelas + " estrela(s) do cliente " + getNome() + " registrada para o produto " + produto.getModelo() + ".");
    }

    // Getters e Setters
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    @Override
    public String toString() {
        return "Cliente [" + super.toString() + ", CPF: " + cpf + ", Email: " + email + "]";
    }
}