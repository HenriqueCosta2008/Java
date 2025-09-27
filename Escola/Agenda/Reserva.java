package Escola.Agenda;

public class Reserva {
    private String nomePessoa;
    private String dataReserva;
    private String horaReserva;

    // Construtor
    public Reserva(String nomePessoa, String dataReserva, String horaReserva) {
        this.nomePessoa = nomePessoa;
        this.dataReserva = dataReserva;
        this.horaReserva = horaReserva;
    }

    // Getters (para ler os dados)
    public String getNomePessoa() {
        return this.nomePessoa;
    }

    public String getDataReserva() {
        return this.dataReserva;
    }

    public String getHoraReserva() {
        return this.horaReserva;
    }

    // Setters (para alterar os dados)
    public void setNomePessoa(String novoNome) {
        this.nomePessoa = novoNome;
    }

    public void setDataReserva(String novaData) {
        this.dataReserva = novaData;
    }

    public void setHoraReserva(String novaHora) {
        this.horaReserva = novaHora;
    }

    // Método para exibir a reserva de forma amigável
    @Override
    public String toString() {
        return "Reserva de: " + nomePessoa + " em " + dataReserva + " às " + horaReserva;
    }
}