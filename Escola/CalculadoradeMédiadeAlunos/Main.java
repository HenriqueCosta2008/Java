package Escola.CalculadoradeMédiadeAlunos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Aluno aluno = new Aluno("Bia");
        boolean executando = true;

        while (executando) {
            System.out.println("\n--- MENU DO ALUNO: " + aluno.getNome() + " ---");
            System.out.println("1. Adicionar notas de Matemática");
            System.out.println("2. Adicionar notas de História");
            System.out.println("3. Ver médias finais");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("--- Adicionar Notas de Matemática ---");
                    System.out.print("Digite uma nota (ou um número negativo para parar): ");
                    double notaMat = scanner.nextDouble();
                    
                    while (notaMat >= 0) {
                        aluno.adicionarNotaMatematica(notaMat);
                        System.out.print("Próxima nota: ");
                        notaMat = scanner.nextDouble();
                    }
                    System.out.println("Notas de Matemática inseridas.");
                    break;
                case 2:
                    System.out.println("--- Adicionar Notas de História ---");
                    System.out.print("Digite uma nota (ou um número negativo para parar): ");
                    double notaHist = scanner.nextDouble();

                    while (notaHist >= 0) {
                        aluno.adicionarNotaHistoria(notaHist);
                        System.out.print("Próxima nota: ");
                        notaHist = scanner.nextDouble();
                    }
                    System.out.println("Notas de História inseridas.");
                    break;
                case 3:
                    System.out.println("\n--- MÉDIAS FINAIS ---");
                    System.out.println("Média de Matemática: " + aluno.calcularMediaMatematica());
                    System.out.println("Média de História: " + aluno.calcularMediaHistoria());
                    break;
                case 4:
                    executando = false;
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        scanner.close();
    }
}
