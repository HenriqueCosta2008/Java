package Escola.espotfi2;

/**
 * Simula o Player (Tocar, Pausar, Próxima, Anterior, Escolher).
 */
public class Player {

    private Playlist playlistAtual;
    private int faixaAtualIndex;
    private boolean estaTocando;

    public Player(Playlist playlist) {
        this.playlistAtual = playlist;
        this.faixaAtualIndex = 0;
        this.estaTocando = false;
    }

    private Musica getFaixaAtual() {
        if (playlistAtual.getMusicas().isEmpty()) {
            return null;
        }
        return playlistAtual.getMusicas().get(faixaAtualIndex);
    }

    /**
     * Toca a música atual.
     */
    public void tocar() {
        Musica faixa = getFaixaAtual();
        if (faixa == null) {
            System.out.println("[PLAYER] Playlist vazia. Adicione músicas primeiro.");
            return;
        }
        this.estaTocando = true;
        System.out.println("[PLAYER] Tocando: " + faixa.toString());
    }

    /**
     * Toca uma música específica pelo seu número na lista (1-based).
     * (Implementação do "escolher a musica")
     */
    public void tocarMusica(int indice) {
        int indexReal = indice - 1; // Ajusta de 1-based para 0-based
        if (indexReal >= 0 && indexReal < playlistAtual.getMusicas().size()) {
            this.faixaAtualIndex = indexReal;
            tocar(); // Toca a música selecionada
        } else {
            System.out.println("[PLAYER] Índice de música inválido.");
        }
    }

    /**
     * Pausa a música.
     */
    public void pausar() {
        if (this.estaTocando) {
            this.estaTocando = false;
            System.out.println("[PLAYER] Pausado em: " + getFaixaAtual().toString());
        } else {
            System.out.println("[PLAYER] Já está pausado.");
        }
    }

    /**
     * Pula para a próxima música (next).
     */
    public void proxima() {
        if (playlistAtual.getMusicas().isEmpty()) {
            System.out.println("[PLAYER] Playlist vazia.");
            return;
        }
        this.faixaAtualIndex = (this.faixaAtualIndex + 1) % playlistAtual.getMusicas().size();
        System.out.println("[PLAYER] Próxima faixa: " + getFaixaAtual().toString());
        if (this.estaTocando) {
            tocar();
        }
    }

    /**
     * Volta para a música anterior (prev).
     */
    public void anterior() {
        if (playlistAtual.getMusicas().isEmpty()) {
            System.out.println("[PLAYER] Playlist vazia.");
            return;
        }
        this.faixaAtualIndex--;
        if (this.faixaAtualIndex < 0) {
            this.faixaAtualIndex = playlistAtual.getMusicas().size() - 1; // Volta para o fim
        }
        System.out.println("[PLAYER] Faixa anterior: " + getFaixaAtual().toString());
        if (this.estaTocando) {
            tocar();
        }
    }
}