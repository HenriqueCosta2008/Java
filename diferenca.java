import java.util.Scanner; // Exemplo de import, se necessário

public class diferenca {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int DIFERENCA = a * b - c * d;
        System.out.println("Diferança = " + DIFERENCA);
        sc.close();
    }
}
