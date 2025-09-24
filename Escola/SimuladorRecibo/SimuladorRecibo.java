package Escola.SimuladorRecibo;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class SimuladorRecibo {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Geração de Recibo de Compra ---");

        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Digite o nome do produto: ");
        String produtoComprado = scanner.nextLine();
        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();

        System.out.print("Digite o preço unitário (ex: 2.50): ");
        double precoUnitario = scanner.nextDouble();

        double valorTotal = quantidade * precoUnitario;

        LocalDateTime dataHoraEmissao = LocalDateTime.now();

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String dataHoraFormatada = dataHoraEmissao.format(formatador);

        System.out.println("\n========================================");
        System.out.println("        RECIBO DE COMPRA");
        System.out.println("========================================");


        System.out.println("Cliente: " + nomeCliente.toUpperCase());

        System.out.printf("Produto: %s Quantidade: %d Preço unitário: R$ %.2f Total: R$ %.2f\n",
                produtoComprado,
                quantidade,
                precoUnitario,
                valorTotal);

        System.out.println("\nEmitido em: " + dataHoraFormatada);
        System.out.println("========================================");

        scanner.close();
    }
}
