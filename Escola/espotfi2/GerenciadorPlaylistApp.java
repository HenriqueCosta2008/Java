package Escola.espotfi2;

import java.util.List;
import java.util.Scanner;

/**
 * Classe principal INTERATIVA para o Gerenciador de Playlist.
 * Permite ao usuário controlar a playlist via console.
 */
public class GerenciadorPlaylistApp {

    // Scanner global para ler a entrada do usuário
    private static Scanner scanner = new Scanner(System.in);
    
    // Nossas classes de lógica
    private static Playlist playlist = new Playlist("Minha Playlist");
    private static Player player = new Player(playlist);

    public static void main(String[] args) {
        
        System.out.println("=== Bem-vindo ao Gerenciador de Playlist ===");
        
        // Loop principal do menu
        while (true) {
            exibirMenu();
            int escolha = lerInteiro("Escolha uma opção: ");

            // Limpa o buffer do scanner (necessário após nextInt())
            scanner.nextLine(); 

            switch (escolha) {
                case 1:
                    player.tocar();
                    break;
                case 2:
                    player.pausar();
                    break;
                case 3:
                    player.proxima();
                    break;
                case 4:
                    player.anterior();
                    break;
                case 5:
                    playlist.listarMusicas();
                    break;
                case 6:
                    // (Implementação do "escolher a musica")
                    escolherMusicaParaTocar();
                    break;
                case 7:
                    // (Implementação do "adicionar musicas")
                    adicionarMusicaUI();
                    break;
                case 8:
                    // (Implementação do "excluir musicas")
                    removerMusicaUI();
                    break;
                case 9:
                    // (Implementação do "buscar por artistas")
                    buscarPorArtistaUI();
                    break;
                case 0:
                    System.out.println("Obrigado por usar o sistema. Até logo!");
                    scanner.close();
                    System.exit(0); // Encerra o programa
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            System.out.println("\n(Pressione ENTER para continuar...)");
            scanner.nextLine(); // Pausa para o usuário ler a saída
        }
    }

    /**
     * Exibe o menu principal de opções.
     */
    private static void exibirMenu() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("--- Player ---");
        System.out.println("1. Tocar (Play)");
        System.out.println("2. Pausar (Pause)");
        System.out.println("3. Próxima Música (Next)");
        System.out.println("4. Música Anterior (Previous)");
        System.out.println("\n--- Playlist ---");
        System.out.println("5. Listar Músicas na Playlist");
        System.out.println("6. Tocar música específica (pelo nº)");
        System.out.println("7. Adicionar nova música");
        System.out.println("8. Remover música (pelo nº)");
        System.out.println("9. Buscar músicas por artista");
        System.out.println("\n0. Sair");
    }

    /**
     * Lógica (UI) para adicionar uma música.
     */
    private static void adicionarMusicaUI() {
        System.out.println("\n--- Adicionar Nova Música ---");
        System.out.print("Digite o Título: ");
        String titulo = scanner.nextLine();
        
        System.out.print("Digite o Artista: ");
        String artista = scanner.nextLine();
        
        int duracao = lerInteiro("Digite a Duração (em segundos): ");
        scanner.nextLine(); // Limpar buffer

        Musica novaMusica = new Musica(titulo, artista, duracao);
        playlist.adicionarMusica(novaMusica);
    }

    /**
     * Lógica (UI) para remover uma música.
     */
    private static void removerMusicaUI() {
        System.out.println("\n--- Remover Música ---");
        playlist.listarMusicas();
        if (playlist.getMusicas().isEmpty()) {
            return; // Sai se não houver músicas
        }
        
        int indice = lerInteiro("Digite o número da música para remover: ");
        scanner.nextLine(); // Limpar buffer
        
        Musica removida = playlist.removerMusica(indice);
        if (removida != null) {
            System.out.println("Música '" + removida.getTitulo() + "' removida com sucesso.");
        } else {
            System.out.println("Número inválido. Nenhuma música foi removida.");
        }
    }

    /**
     * Lógica (UI) para buscar por artista.
     */
    private static void buscarPorArtistaUI() {
        System.out.println("\n--- Buscar por Artista ---");
        System.out.print("Digite o nome do artista: ");
        String artista = scanner.nextLine();
        
        List<Musica> resultados = playlist.buscarPorArtista(artista);
        
        if (resultados.isEmpty()) {
            System.out.println("Nenhuma música encontrada para o artista: " + artista);
        } else {
            System.out.println("Músicas encontradas de " + artista + ":");
            for (Musica m : resultados) {
                System.out.println("-> " + m.toString());
            }
        }
    }

    /**
     * Lógica (UI) para escolher uma música da lista para tocar.
     */
    private static void escolherMusicaParaTocar() {
        System.out.println("\n--- Tocar Música Específica ---");
        playlist.listarMusicas();
        if (playlist.getMusicas().isEmpty()) {
            return;
        }
        
        int indice = lerInteiro("Digite o número da música para tocar: ");
        scanner.nextLine(); // Limpar buffer
        
        player.tocarMusica(indice);
    }

    /**
     * Função auxiliar para ler um inteiro de forma segura.
     */
    private static int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite apenas números.");
                scanner.nextLine(); // Limpa o buffer do scanner
            }
        }
    }
}