package Escola.Empresa;

public class Avaliacao {
    private int estrelas; // 1 a 5

    public Avaliacao(int estrelas) {
        if (estrelas >= 1 && estrelas <= 5) {
            this.estrelas = estrelas;
        } else {
            throw new IllegalArgumentException("A avaliação deve ser entre 1 e 5 estrelas.");
        }
    }

    @Override
    public String toString() {
        return "Avaliação [" + estrelas + " estrela(s)]";
    }
}