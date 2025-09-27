package Escola.Agenda;

import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {
    private ArrayList<Reserva> listaDeReservas;
    private Scanner scanner;

    // Construtor: Prepara a lista e o scanner
    public Agenda() {
        this.listaDeReservas = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Método principal que executa o menu
    public void iniciar() {
        boolean executando = true;
        while (executando) {
            System.out.println("\n--- AGENDA DE RESERVAS ---");
            System.out.println("1. Incluir nova reserva");
            System.out.println("2. Alterar reserva");
            System.out.println("3. Excluir reserva");
            System.out.println("4. Consultar reserva");
            System.out.println("5. Listar todas as reservas");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // <<-- CORREÇÃO IMPORTANTE para limpar o buffer

            switch (opcao) {
                case 1: incluirNovaReserva(); break;
                case 2: alterarReserva(); break;
                case 3: excluirReserva(); break;
                case 4: consultarReserva(); break;
                case 5: listarTodasAsReservas(); break;
                case 6: executando = false; break;
                default: System.out.println("Opção inválida.");
            }
        }
        System.out.println("Programa encerrado.");
    }

    // --- MÉTODOS DE FUNCIONALIDADE ---

    public void incluirNovaReserva() {
        System.out.println("\n--- Incluir Nova Reserva ---");
        System.out.print("Nome da pessoa: ");
        String nome = scanner.nextLine();
        System.out.print("Data da reserva (dd/mm/aaaa): ");
        String data = scanner.nextLine();
        System.out.print("Hora da reserva (hh:mm): ");
        String hora = scanner.nextLine();
        Reserva novaReserva = new Reserva(nome, data, hora);
        listaDeReservas.add(novaReserva);
        System.out.println("Reserva incluída com sucesso!");
    }

    public void listarTodasAsReservas() {
        System.out.println("\n--- Todas as Reservas ---");
        if (listaDeReservas.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada.");
        } else {
            for (Reserva reserva : listaDeReservas) {
                System.out.println(reserva);
            }
        }
    }

    private Reserva encontrarReservaPorNome(String nomeBusca) {
        for (Reserva reserva : listaDeReservas) {
            if (reserva.getNomePessoa().equalsIgnoreCase(nomeBusca)) {
                return reserva;
            }
        }
        return null;
    }

    public void alterarReserva() {
        System.out.println("\n--- Alterar Reserva ---");
        System.out.print("Digite o nome da pessoa da reserva que deseja alterar: ");
        String nomeBusca = scanner.nextLine();
        Reserva reserva = encontrarReservaPorNome(nomeBusca);
        if (reserva != null) {
            System.out.print("Digite a nova data (dd/mm/aaaa): ");
            String novaData = scanner.nextLine();
            reserva.setDataReserva(novaData);
            System.out.print("Digite a nova hora (hh:mm): ");
            String novaHora = scanner.nextLine();
            reserva.setHoraReserva(novaHora);
            System.out.println("Reserva alterada com sucesso!");
        } else {
            System.out.println("Reserva não encontrada.");
        }
    }

    public void excluirReserva() {
        System.out.println("\n--- Excluir Reserva ---");
        System.out.print("Digite o nome da pessoa da reserva que deseja excluir: ");
        String nomeBusca = scanner.nextLine();
        Reserva reserva = encontrarReservaPorNome(nomeBusca);
        if (reserva != null) {
            listaDeReservas.remove(reserva);
            System.out.println("Reserva excluída com sucesso!");
        } else {
            System.out.println("Reserva não encontrada.");
        }
    }

    public void consultarReserva() {
        System.out.println("\n--- Consultar Reserva ---");
        System.out.print("Digite o nome da pessoa da reserva que deseja consultar: ");
        String nomeBusca = scanner.nextLine();
        Reserva reserva = encontrarReservaPorNome(nomeBusca);
        if (reserva != null) {
            System.out.println("Reserva encontrada:");
            System.out.println(reserva);
        } else {
            System.out.println("Reserva não encontrada.");
        }
    }
}
