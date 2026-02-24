package Ewerton;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Saque {
    public static void main(String[] args) {

        BigDecimal[] valores = {BigDecimal.valueOf(200), BigDecimal.valueOf(100), BigDecimal.valueOf(50), BigDecimal.valueOf(20), BigDecimal.valueOf(10), BigDecimal.valueOf(5), BigDecimal.valueOf(2), BigDecimal.valueOf(1), BigDecimal.valueOf(0.5), BigDecimal.valueOf(0.25), BigDecimal.valueOf(0.1), BigDecimal.valueOf(0.05), BigDecimal.valueOf(0.01)};
//        BigDecimal big = new BigDecimal(0.00);
//        big.divide(BigDecimal.valueOf(0),2, RoundingMode.HALF_EVEN);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Valor a ser sacado: R$");
        BigDecimal valorSaque = BigDecimal.valueOf(scanner.nextFloat());
        scanner.close();

        int index = 0;
        while(valorSaque.compareTo(BigDecimal.valueOf(0)) == 1) {

        }


    }
}
