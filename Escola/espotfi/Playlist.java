package Escola.espotfi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Gerencia uma coleção (lista) de músicas.
 * Permite adicionar, remover, listar e buscar faixas. 
 * Utiliza ArrayList como estrutura de dados. 
 */
public class Playlist {

    private List<Musica> musicas;
    private String nome;

    /**
     * Construtor da Playlist.
     * @param nome O nome da playlist (ex: "Favoritas", "Rock").
     */
    public Playlist(String nome) {
        this.nome = nome;
        // Inicializa a estrutura de dados 
        this.musicas = new ArrayList<>();
    }

    /**
     * Adiciona uma música à playlist. 
     * @param musica O objeto Musica a ser adicionado.
     */
    public void adicionarMusica(Musica musica) {
        if (musica != null) {
            this.musicas.add(musica);
            System.out.println("'" + musica.getTitulo() + "' adicionada à playlist " + this.nome + ".");
        }
    }

    /**
     * Remove uma música da playlist. 
     * @param musica O objeto Musica a ser removido.
     */
    public void removerMusica(Musica musica) {
        if (musica != null && this.musicas.contains(musica)) {
            this.musicas.remove(musica);
            System.out.println("'" + musica.getTitulo() + "' removida da playlist " + this.nome + ".");
        } else {
            System.out.println("Música não encontrada na playlist.");
        }
    }

    /**
     * Lista todas as músicas presentes na playlist. 
     */
    public void listarMusicas() {
        System.out.println("\n--- Playlist: " + this.nome + " ---");
        if (this.musicas.isEmpty()) {
            System.out.println("A playlist está vazia.");
        } else {
            int i = 1;
            for (Musica m : this.musicas) {
                System.out.println(i + ". " + m.toString()); // Usa o toString() da Musica
                i++;
            }
        }
        System.out.println("---------------------------------");
    }

    /**
     * Busca e retorna uma lista de músicas de um artista específico. 
     * @param artista O nome do artista para buscar.
     * @return Uma nova lista (List<Musica>) contendo apenas as músicas do artista.
     */
    public List<Musica> buscarPorArtista(String artista) {
        // Implementação da busca 
        List<Musica> resultados = new ArrayList<>();
        for (Musica m : this.musicas) {
            if (m.getArtista().equalsIgnoreCase(artista)) {
                resultados.add(m);
            }
        }
        return resultados;

        /* * Solução alternativa com Streams (Java 8+)
         * return this.musicas.stream()
         * .filter(m -> m.getArtista().equalsIgnoreCase(artista))
         * .collect(Collectors.toList());
         */
    }

    // --- Getters ---
    public List<Musica> getMusicas() {
        return this.musicas;
    }

    public String getNome() {
        return this.nome;
    }
}