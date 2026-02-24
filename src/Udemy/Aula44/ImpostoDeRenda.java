package Udemy.Aula44;

import java.util.Locale;
import java.util.Scanner;

public class ImpostoDeRenda {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        double salario;
        double imposto;

        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Salario: ");
            salario = sc.nextDouble();
            sc.close();

            if (salario >= 0) {
                break;
            }

            System.out.println("VALOR INVALIDO");
        }

        if (salario <= 2000) {
            imposto = 0.0;
        } else if (salario <= 3000) {
            imposto = (salario - 2000) * 0.08;
            
        } else if (salario <= 4500) {
            imposto = (salario - 3000) * 0.18 + 1000 * 0.08;
        } else {
            imposto = (salario - 4500) * 0.28 + 1500 * 0.18 + 1000 * 0.08;
        }

        if (imposto == 0) {
            System.out.println("Isento de impostos");
        } else {
            System.out.printf("R$ %.2f%n", imposto);
        }


    }
}
