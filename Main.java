

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Entrada: tempo (h) e velocidade média (km/h)
        int tempo = sc.nextInt();
        int velocidade = sc.nextInt();

        // Distância percorrida
        int distancia = tempo * velocidade;

        // Consumo do carro: 12 km/L
        double litros = (double) distancia / 12;

        // Saída formatada com 3 casas decimais
        System.out.printf("%.3f%n", litros);

        sc.close();
    }
}
