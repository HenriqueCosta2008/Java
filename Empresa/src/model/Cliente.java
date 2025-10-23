package model;

public class Cliente extends Pessoa {
    private String email;

    public Cliente(){super();}
    public Cliente(Integer id, String nome, String cpf, String email){
        super(id, nome, cpf);
        this.email = email;
    }
    public String getEmail()            {return email;}
    public void setEmail(String email)  {this.email = email;

    
    }
    @Override
    public String toString() {
        return "Cliente [id= " + id + ", email=" + email + ", nome=" + nome + ", cpf= " + cpf +"]";
    }

    

}