package Udemy.Aula44;

import java.util.Scanner;

public class Multiplos {
    public static void main(String[] args) {
        int A;
        int B;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o valor de  A: ");
        A = scanner.nextInt();

        System.out.print("Digite o valor de B: ");
        B = scanner.nextInt();
        scanner.close();

        if (A % B == 0 || B % A == 0) {
            System.out.println("====================================================");
            System.out.println("São multiplos");
            System.out.println("====================================================");
        } else {
            System.out.println("====================================================");
            System.out.println("não são multiplos");
            System.out.println("====================================================");
        }
    }
}
