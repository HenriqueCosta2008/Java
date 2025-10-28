package model;

public class Produto {
    private Integer id;
    private String nome;
    private double preco;
    private int estoque;
    private String cpf;

    public Integer getId()              {return id;}
    public String getNome()             {return nome;}
    public double getPreco()            {return preco;}
    public int getEstoque()             {return estoque;}
    public void setId(Integer id)       {this.id = id;}
    public void setNome(String nome)    {this.nome = nome;}
    public void setCpf(String cpf)      {this.cpf = cpf;}
    public void setEstoque(Integer estoque) {this.estoque = estoque;}


    @Override
    public String toString(){
        return "PEssoa [id =" + id +", nome=" + nome + ", cpf=" + cpf + ", estoque=" + estoque + ";]";

}
}