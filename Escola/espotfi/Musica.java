package Escola.espotfi;

/**
 * Classe que representa uma faixa de música com título, artista e duração.
 * Esta é a entidade básica usada pela Playlist.
 */
public class Musica {

    // --- Atributos ---
    private String titulo;
    private String artista;
    private int duracaoEmSegundos;

    /**
     * Construtor para inicializar um objeto Musica.
     *
     * @param titulo O título da música.
     * @param artista O artista da música.
     * @param duracaoEmSegundos A duração da música em segundos.
     */
    public Musica(String titulo, String artista, int duracaoEmSegundos) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracaoEmSegundos = duracaoEmSegundos;
    }

    // --- Getters ---
    // (Setters omitidos para imutabilidade, mas podem ser adicionados se necessário)
    
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
     * Retorna uma representação em String da música,
     * formatando a duração de segundos para "min:seg".
     *
     * @return String formatada da música.
     */
    @Override
    public String toString() {
        int minutos = duracaoEmSegundos / 60;
        int segundos = duracaoEmSegundos % 60;
        // Formata para "MM:SS"
        return String.format("%s - %s (%d:%02d)", this.artista, this.titulo, minutos, segundos);
    }
}