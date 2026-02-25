package Ewerton.SaquePt2;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        LinkedHashMap<BigDecimal, BigDecimal> balance = new LinkedHashMap<>();
        balance.put(BigDecimal.valueOf(200), BigDecimal.valueOf(2));
        balance.put(BigDecimal.valueOf(100), BigDecimal.valueOf(2));
        balance.put(BigDecimal.valueOf(50), BigDecimal.valueOf(2));
        balance.put(BigDecimal.valueOf(20), BigDecimal.valueOf(2));
        balance.put(BigDecimal.valueOf(10), BigDecimal.valueOf(2));
        balance.put(BigDecimal.valueOf(5), BigDecimal.valueOf(2));
        balance.put(BigDecimal.valueOf(2), BigDecimal.valueOf(2));
        balance.put(BigDecimal.valueOf(1), BigDecimal.valueOf(2));
        balance.put(BigDecimal.valueOf(0.50), BigDecimal.valueOf(2));
        balance.put(BigDecimal.valueOf(0.25), BigDecimal.valueOf(2));
        balance.put(BigDecimal.valueOf(0.10), BigDecimal.valueOf(2));
        balance.put(BigDecimal.valueOf(0.05), BigDecimal.valueOf(2));
        balance.put(BigDecimal.valueOf(0.01), BigDecimal.valueOf(2));


        /*
        System.out.println(balance);

        System.out.println(caixa.getBalanco());

        System.out.println("==========================================================================");
        System.out.println(caixa.getSaldoTotal());
        System.out.println("==========================================================================");
        */

        Scanner sc = new Scanner(System.in);

        BigDecimal valorSaque = sc.nextBigDecimal();


        Caixa caixa = new Caixa(balance);
        caixa.mostrarSaque(caixa.sacar(valorSaque));
        sc.close();
    }
}
