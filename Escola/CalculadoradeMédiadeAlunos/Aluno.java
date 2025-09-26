package Escola.CalculadoradeMédiadeAlunos;

// Arquivo: Aluno.java
public class Aluno {
    private String nome;
    private double somaNotasMatematica;
    private int numeroNotasMatematica;
    private double somaNotasHistoria;
    private int numeroNotasHistoria;

    public Aluno(String nome) {
        this.nome = nome;
        this.somaNotasMatematica = 0.0;
        this.numeroNotasMatematica = 0;
        this.somaNotasHistoria = 0.0;
        this.numeroNotasHistoria = 0;
    }

    public void adicionarNotaMatematica(double nota) {
        this.somaNotasMatematica += nota;
        this.numeroNotasMatematica++;
    }

    public void adicionarNotaHistoria(double nota) {
        this.somaNotasHistoria += nota;
        this.numeroNotasHistoria++;
    }

    public double calcularMediaMatematica() {
        if (numeroNotasMatematica == 0) {
            return 0.0;
        }
        return somaNotasMatematica / numeroNotasMatematica;
    }

    public double calcularMediaHistoria() {
        if (numeroNotasHistoria == 0) {
            return 0.0;
        }
        return somaNotasHistoria / numeroNotasHistoria;
    }

    public String getNome() {
        return this.nome;
    }
}