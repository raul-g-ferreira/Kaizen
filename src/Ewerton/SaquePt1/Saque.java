package Ewerton.SaquePt1;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.Scanner;

public class Saque {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        BigDecimal[] valores = {BigDecimal.valueOf(200), BigDecimal.valueOf(100), BigDecimal.valueOf(50), BigDecimal.valueOf(20), BigDecimal.valueOf(10), BigDecimal.valueOf(5), BigDecimal.valueOf(2), BigDecimal.valueOf(1), BigDecimal.valueOf(0.5), BigDecimal.valueOf(0.25), BigDecimal.valueOf(0.1), BigDecimal.valueOf(0.05), BigDecimal.valueOf(0.01)};
//        BigDecimal big = new BigDecimal(0.00);
//        big.divide(BigDecimal.valueOf(0),2, RoundingMode.HALF_EVEN);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Valor a ser sacado: R$");
        BigDecimal valorSaque = BigDecimal.valueOf(scanner.nextFloat());
        scanner.close();

        int index = 0;


        while(valorSaque.compareTo(BigDecimal.valueOf(0)) > 0 ) {
            valorSaque = valorSaque.round(new MathContext(2, RoundingMode.FLOOR)); // n funciona
            if (valorSaque.compareTo(valores[index]) > 0) {

                BigDecimal quant = valorSaque.divideAndRemainder(valores[index])[0];
                valorSaque = valorSaque.divideAndRemainder(valores[index])[1];
                System.out.println(quant.intValue() + (((valores[index].compareTo(BigDecimal.valueOf(1)) > 0) ? ((quant.equals(BigDecimal.valueOf(1)) ? " cédula " : " cédulas ")) : ((quant.intValue() == 1) ? " moeda " : " moedas ")) + "de $" + valores[index]));
            }
            index++;
        }


    }
}
