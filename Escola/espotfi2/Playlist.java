package Escola.espotfi2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Gerencia a coleção de músicas (adicionar, remover, listar, buscar).
 */
public class Playlist {

    private List<Musica> musicas;
    private String nome;

    public Playlist(String nome) {
        this.nome = nome;
        this.musicas = new ArrayList<>();
    }

    /**
     * Adiciona uma música à playlist.
     */
    public void adicionarMusica(Musica musica) {
        this.musicas.add(musica);
        System.out.println("'" + musica.getTitulo() + "' adicionada à playlist.");
    }

    /**
     * Remove uma música da playlist pelo índice (base 1).
     * @return A música que foi removida, ou null se o índice for inválido.
     */
    public Musica removerMusica(int indice) {
        int indexReal = indice - 1; // Converte de 1-based para 0-based
        if (indexReal >= 0 && indexReal < musicas.size()) {
            return this.musicas.remove(indexReal);
        }
        return null;
    }

    /**
     * Lista todas as músicas da playlist.
     */
    public void listarMusicas() {
        System.out.println("\n--- Playlist: " + this.nome + " ---");
        if (this.musicas.isEmpty()) {
            System.out.println("A playlist está vazia.");
        } else {
            int i = 1;
            for (Musica m : this.musicas) {
                System.out.println(i + ". " + m.toString());
                i++;
            }
        }
        System.out.println("---------------------------------");
    }

    /**
     * Busca músicas pelo nome do artista.
     */
    public List<Musica> buscarPorArtista(String artista) {
        return this.musicas.stream()
                .filter(m -> m.getArtista().equalsIgnoreCase(artista))
                .collect(Collectors.toList());
    }

    // Getters
    public List<Musica> getMusicas() {
        return this.musicas;
    }

    public String getNome() {
        return this.nome;
    }
}