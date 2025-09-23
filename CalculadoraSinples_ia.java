package java;

import java.util.Scanner;

public class CalculadoraSinples_ia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita os dois números inteiros
        System.out.print("Digite o primeiro número inteiro: ");
        int num1 = scanner.nextInt();

        System.out.print("Digite o segundo número inteiro: ");
        int num2 = scanner.nextInt();

        // Solicita a operação desejada
        System.out.print("Digite a operação desejada (+, -, *, /): ");
        char operacao = scanner.next().charAt(0);

        // Executa a operação com base no caractere informado
        switch (operacao) {
            case '+':
                System.out.println("Resultado: " + (num1 + num2));
                break;

            case '-':
                System.out.println("Resultado: " + (num1 - num2));
                break;

            case '*':
                System.out.println("Resultado: " + (num1 * num2));
                break;

            case '/':
                if (num2 == 0) {
                    System.out.println("Erro: Divisão por zero não é permitida.");
                } else {
                    System.out.println("Resultado: " + ((double) num1 / num2));
                }
                break;

            default:
                System.out.println("Erro: Operação inválida. Use apenas +, -, * ou /.");
        }

        scanner.close();
    }
}
