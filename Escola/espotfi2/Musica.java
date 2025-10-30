package Escola.espotfi2;

/**
 * Classe que representa uma faixa de música (POJO).
 */
public class Musica {

    private String titulo;
    private String artista;
    private int duracaoEmSegundos;

    public Musica(String titulo, String artista, int duracaoEmSegundos) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracaoEmSegundos = duracaoEmSegundos;
    }

    // --- Getters ---
    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracaoEmSegundos() {
        return duracaoEmSegundos;
    }

    /**
     * Formata a música para exibição (ex: Artista - Título (MM:SS))
     */
    @Override
    public String toString() {
        int minutos = duracaoEmSegundos / 60;
        int segundos = duracaoEmSegundos % 60;
        return String.format("%s - %s (%d:%02d)", this.artista, this.titulo, minutos, segundos);
    }
}