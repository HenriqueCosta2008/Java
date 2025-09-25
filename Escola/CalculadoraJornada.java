package Escola;

import java.time.LocalTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CalculadoraJornada {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter formatadorDeHora = DateTimeFormatter.ofPattern("HH:mm");

        try {
            System.out.println("--- Calculadora de Jornada de Trabalho ---");

            System.out.print("Digite a hora de entrada (formato HH:mm): ");
            String entradaStr = scanner.nextLine();
            LocalTime horaEntrada = LocalTime.parse(entradaStr, formatadorDeHora);

            System.out.print("Digite a hora de saída (formato HH:mm): ");
            String saidaStr = scanner.nextLine();
            LocalTime horaSaida = LocalTime.parse(saidaStr, formatadorDeHora);

            Duration duracao = Duration.between(horaEntrada, horaSaida);

            if (duracao.isNegative()) {
                System.out.println("\nErro: A hora de saída não pode ser anterior à hora de entrada.");
            } else {
                long totalHoras = duracao.toHours();

                long totalMinutos = duracao.minusHours(totalHoras).toMinutes();


                System.out.println("\n----------------------------------------------------");
                System.out.printf("Entrada: %s Saída: %s Total trabalhado: %d horas e %d minutos\n",
                        horaEntrada,
                        horaSaida,
                        totalHoras,
                        totalMinutos);
                System.out.println("----------------------------------------------------");
            }

        } catch (DateTimeParseException e) {
            System.out.println("\nErro! Formato de hora inválido. Por favor, use exatamente o formato HH:mm.");
        } finally {
            
            scanner.close();
        }
    }
}