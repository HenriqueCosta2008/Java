package Escola.Empresa;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reclamacao {
    private String texto;
    private LocalDateTime dataHora;

    public Reclamacao(String texto) {
        this.texto = texto;
        this.dataHora = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return "Reclamação [Data/Hora: " + dataHora.format(formatter) + ", Texto: '" + texto + "']";
    }
}