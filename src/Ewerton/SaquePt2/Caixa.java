package Ewerton.SaquePt2;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Caixa {
    private LinkedHashMap<BigDecimal, BigDecimal> balanco;
    private BigDecimal saldoTotal = BigDecimal.valueOf(0);


    private boolean aprovaSaque(BigDecimal valorSaque) {
        return valorSaque.compareTo(saldoTotal) <= 0;
    }

    public LinkedHashMap<BigDecimal, BigDecimal> sacar(BigDecimal valorSaque) {
        LinkedHashMap<BigDecimal, BigDecimal> saque = new LinkedHashMap<>();
        saque.put(BigDecimal.valueOf(200), BigDecimal.valueOf(0));
        saque.put(BigDecimal.valueOf(100), BigDecimal.valueOf(0));
        saque.put(BigDecimal.valueOf(50), BigDecimal.valueOf(0));
        saque.put(BigDecimal.valueOf(20), BigDecimal.valueOf(0));
        saque.put(BigDecimal.valueOf(10), BigDecimal.valueOf(0));
        saque.put(BigDecimal.valueOf(5), BigDecimal.valueOf(0));
        saque.put(BigDecimal.valueOf(2), BigDecimal.valueOf(0));
        saque.put(BigDecimal.valueOf(1), BigDecimal.valueOf(0));
        saque.put(BigDecimal.valueOf(0.50), BigDecimal.valueOf(0));
        saque.put(BigDecimal.valueOf(0.25), BigDecimal.valueOf(0));
        saque.put(BigDecimal.valueOf(0.10), BigDecimal.valueOf(0));
        saque.put(BigDecimal.valueOf(0.05), BigDecimal.valueOf(0));
        saque.put(BigDecimal.valueOf(0.01), BigDecimal.valueOf(0));


        if (aprovaSaque(valorSaque)) {
            for (Map.Entry<BigDecimal, BigDecimal> entry : balanco.entrySet()) {
                while (entry.getValue().compareTo(BigDecimal.valueOf(0)) > 0) { // enquanto tiver cedulas
                   // System.out.println(valorSaque.compareTo(entry.getKey()));
                    if (valorSaque.compareTo(entry.getKey()) >= 0) {
                        saque.put(entry.getKey(), saque.get(entry.getKey()).add(BigDecimal.valueOf(1)));
                        balanco.put(entry.getKey(), entry.getValue().subtract(BigDecimal.valueOf(1)));
                        valorSaque = valorSaque.subtract(entry.getKey());
                    }else break;

                }
            }
        } else {
            System.out.println("SAQUE NÃO AUTORIZADO!");
        }
        return saque;
    }

    public void mostrarSaque(LinkedHashMap<BigDecimal, BigDecimal> saque) {
        for (Map.Entry<BigDecimal, BigDecimal> entry : saque.entrySet()){
            int aux = entry.getValue().compareTo(BigDecimal.valueOf(1));
            if (aux > 0){
                System.out.println(entry.getValue() + " Dinheiros de D$" + entry.getKey());
            } else if (aux == 0) {
                System.out.println(entry.getValue() + " Dinheiro de D$" + entry.getKey());
            }
        }
    }

    public Caixa(LinkedHashMap<BigDecimal, BigDecimal> balanco) {
        this.balanco = balanco;
        setSaldoTotal();
    }

    public BigDecimal getSaldoTotal() {
        return saldoTotal;
    }

    private void setSaldoTotal() {
        for (Map.Entry<BigDecimal, BigDecimal> entry : balanco.entrySet()) {
            saldoTotal = saldoTotal.add(entry.getKey().multiply(entry.getValue()));
        }
    }

    public LinkedHashMap<BigDecimal, BigDecimal> getBalanco() {
        return balanco;
    }

    public void setBalanco(Map<BigDecimal, BigDecimal> balanco) {
        this.balanco = (LinkedHashMap<BigDecimal, BigDecimal>) balanco;
    }
}
