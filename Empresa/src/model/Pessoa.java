package model;

public abstract class Pessoa {

    protected Integer id;
    protected String nome;
    protected String cpf;

    public Pessoa(){}

    public Pessoa(Integer id, String nome, String cpf){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }
    public Integer getId()              {return id;}
    public String getNome()             {return nome;}
    public String getCpf()              {return cpf;}
    public void setId(Integer id)       {this.id = id;}
    public void setNome(String nome)    {this.nome = nome;}
    public void setCpf(String cpf)      {this.cpf = cpf;}

    @Override
    public String toString(){
        return "PEssoa [id =" + id +", nome=" + nome + ", cpf=" + cpf + "]";
    }

}