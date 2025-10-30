package Escola.espotfi;

import java.util.List;

/**
 * Classe principal para testar o Gerenciador de Playlist.
 * Demonstra a implementação funcional da POO. [cite: 54]
 * * UC: Lógica de Programação
 * Situação de Aprendizagem 1
 */
public class GerenciadorPlaylistApp {

    public static void main(String[] args) {
        
        System.out.println("=== Iniciando Gerenciador de Playlist ===");

        // 1. Criando Músicas
        Musica m1 = new Musica("Bohemian Rhapsody", "Queen", 355);
        Musica m2 = new Musica("Smells Like Teen Spirit", "Nirvana", 301);
        Musica m3 = new Musica("Don't Stop Me Now", "Queen", 209);
        Musica m4 = new Musica("Come As You Are", "Nirvana", 219);
        Musica m5 = new Musica("Another One Bites the Dust", "Queen", 215);

        // 2. Criando e populando a Playlist 
        Playlist minhasFavoritas = new Playlist("Minhas Favoritas");
        minhasFavoritas.adicionarMusica(m1);
        minhasFavoritas.adicionarMusica(m2);
        minhasFavoritas.adicionarMusica(m3);
        minhasFavoritas.adicionarMusica(m5); // Adicionando a m5 antes da m4

        // 3. Testando a listagem 
        minhasFavoritas.listarMusicas();

        // 4. Testando a remoção 
        minhasFavoritas.removerMusica(m5);
        minhasFavoritas.adicionarMusica(m4); // Adicionando a m4 agora
        minhasFavoritas.listarMusicas();

        // 5. Testando a busca por artista 
        System.out.println("\nBuscando músicas da banda 'Queen'...");
        List<Musica> musicasQueen = minhasFavoritas.buscarPorArtista("Queen");
        for (Musica m : musicasQueen) {
            System.out.println("Encontrado: " + m.toString());
        }

        System.out.println("\nBuscando músicas da banda 'Led Zeppelin'...");
        List<Musica> musicasLed = minhasFavoritas.buscarPorArtista("Led Zeppelin");
        if (musicasLed.isEmpty()) {
            System.out.println("Nenhuma música encontrada para 'Led Zeppelin'.");
        }

        // 6. Testando o Player 
        System.out.println("\n--- Testando o Player ---");
        Player meuPlayer = new Player(minhasFavoritas);

        meuPlayer.tocar();   // "Tocando... Bohemian Rhapsody"
        meuPlayer.proxima(); // "Tocando... Smells Like Teen Spirit"
        meuPlayer.pausar();  // "Pausado em Smells Like Teen Spirit"
        meuPlayer.tocar();   // "Tocando... Smells Like Teen Spirit"
        meuPlayer.proxima(); // "Tocando... Don't Stop Me Now"
        meuPlayer.anterior(); // "Tocando... Smells Like Teen Spirit"
        meuPlayer.anterior(); // "Tocando... Bohemian Rhapsody"
        meuPlayer.anterior(); // "Tocando... Come As You Are" (dá a volta)

        System.out.println("\n=== Demonstração Concluída ===");
    }
}