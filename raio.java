package java;

import java.io.IOException;
import java.util.Scanner;

public class raio {
 
    public static void main(String[] args) throws IOException {
      Scanner sc = new Scanner(System.in);
      double n = 3.14159;
      
      System.out.print("Digite o raio: ");
      double raio = sc.nextDouble();
      System.out.println("A=" + (n * (raio * raio)));
 sc.close();

 
    }
 
}