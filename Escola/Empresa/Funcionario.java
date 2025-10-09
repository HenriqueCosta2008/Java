package Escola.Empresa;

import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private double salario;
    private String estadoCivil;
    private String experiencia;
    private String cargo;
    private String setor;

    public Funcionario(String nome, int idade, String sexo, LocalDate dataNascimento, double salario, String estadoCivil, String experiencia, String cargo, String setor) {
        super(nome, idade, sexo, dataNascimento);
        this.salario = salario;
        this.estadoCivil = estadoCivil;
        this.experiencia = experiencia;
        this.cargo = cargo;
        this.setor = setor;
    }

    // Getters e Setters
    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }
    public String getEstadoCivil() { return estadoCivil; }
    public void setEstadoCivil(String estadoCivil) { this.estadoCivil = estadoCivil; }
    public String getExperiencia() { return experiencia; }
    public void setExperiencia(String experiencia) { this.experiencia = experiencia; }
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    public String getSetor() { return setor; }
    public void setSetor(String setor) { this.setor = setor; }

    @Override
    public String toString() {
        return "Funcionário [" + super.toString() + ", Cargo: " + cargo + ", Salário: R$" + salario + "]";
    }
}