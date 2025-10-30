package Escola.espotfi;

/**
 * Simula um Player de Músicas.
 * Controla a reprodução (tocar, pausar, pular) de uma Playlist. 
 */
public class Player {

    private Playlist playlistAtual;
    private int faixaAtualIndex;
    private boolean estaTocando;

    /**
     * Construtor do Player.
     * @param playlist A playlist que este player irá controlar.
     */
    public Player(Playlist playlist) {
        this.playlistAtual = playlist;
        this.faixaAtualIndex = 0; // Começa na primeira faixa
        this.estaTocando = false;
    }

    /**
     * Inicia ou retoma a reprodução da faixa atual. 
     */
    public void tocar() {
        if (playlistAtual.getMusicas().isEmpty()) {
            System.out.println("Player: Playlist está vazia. Nada a tocar.");
            return;
        }

        if (this.estaTocando) {
            System.out.println("Player: Já está tocando: " + getFaixaAtual().getTitulo());
        } else {
            this.estaTocando = true;
            System.out.println("Player: Tocando... " + getFaixaAtual().toString());
        }
    }

    /**
     * Pausa a reprodução. 
     */
    public void pausar() {
        if (this.estaTocando) {
            this.estaTocando = false;
            System.out.println("Player: Pausado em " + getFaixaAtual().getTitulo());
        } else {
            System.out.println("Player: Já está pausado.");
        }
    }

    /**
     * Pula para a próxima faixa da playlist. 
     * Se chegar ao fim, volta para o início.
     */
    public void proxima() {
        if (playlistAtual.getMusicas().isEmpty()) {
            System.out.println("Player: Playlist vazia.");
            return;
        }
        
        // Lógica de "pular"
        this.faixaAtualIndex = (this.faixaAtualIndex + 1) % playlistAtual.getMusicas().size();
        
        // Se estava tocando, continua tocando a próxima
        if (this.estaTocando) {
            tocar();
        } else {
            System.out.println("Player: Faixa pulada para " + getFaixaAtual().getTitulo() + " (Pausado)");
        }
    }

    /**
     * Volta para a faixa anterior da playlist. 
     * Se estiver na primeira, pula para a última.
     */
    public void anterior() {
        if (playlistAtual.getMusicas().isEmpty()) {
            System.out.println("Player: Playlist vazia.");
            return;
        }

        this.faixaAtualIndex--;
        if (this.faixaAtualIndex < 0) {
            // Se for menor que 0, vai para a última música
            this.faixaAtualIndex = playlistAtual.getMusicas().size() - 1;
        }

        if (this.estaTocando) {
            tocar();
        } else {
            System.out.println("Player: Faixa pulada para " + getFaixaAtual().getTitulo() + " (Pausado)");
        }
    }

    /**
     * Método auxiliar para obter a música que está no índice atual.
     */
    private Musica getFaixaAtual() {
        if (playlistAtual.getMusicas().isEmpty() || faixaAtualIndex < 0 || faixaAtualIndex >= playlistAtual.getMusicas().size()) {
            return null;
        }
        return playlistAtual.getMusicas().get(faixaAtualIndex);
    }
}