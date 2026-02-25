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

    public LinkedHashMap<BigDecimal, Integer> sacar(BigDecimal valorSaque) {
        LinkedHashMap<BigDecimal, Integer> saque = new LinkedHashMap<>();
        LinkedHashMap<BigDecimal, Integer> saqueDefault = new LinkedHashMap<>();
        saqueDefault.put(BigDecimal.valueOf(200), 0);
        saqueDefault.put(BigDecimal.valueOf(100), 0);
        saqueDefault.put(BigDecimal.valueOf(50), 0);
        saqueDefault.put(BigDecimal.valueOf(20), 0);
        saqueDefault.put(BigDecimal.valueOf(10), 0);
        saqueDefault.put(BigDecimal.valueOf(5), 0);
        saqueDefault.put(BigDecimal.valueOf(2), 0);
        saqueDefault.put(BigDecimal.valueOf(1), 0);
        saqueDefault.put(BigDecimal.valueOf(0.50), 0);
        saqueDefault.put(BigDecimal.valueOf(0.25), 0);
        saqueDefault.put(BigDecimal.valueOf(0.10), 0);
        saqueDefault.put(BigDecimal.valueOf(0.05), 0);
        saqueDefault.put(BigDecimal.valueOf(0.01), 0);

        saque.putAll(saqueDefault);

        if (aprovaSaque(valorSaque)) {
            for (Map.Entry<BigDecimal, BigDecimal> entry : balanco.entrySet()) {
                while (entry.getValue().compareTo(BigDecimal.valueOf(0)) > 0) { // enquanto tiver cedulas
                   // System.out.println(valorSaque.compareTo(entry.getKey()));
                    if (valorSaque.compareTo(entry.getKey()) >= 0) {
                        saque.put(entry.getKey(), saque.get(entry.getKey()) + 1);
                        balanco.put(entry.getKey(), entry.getValue().subtract(BigDecimal.valueOf(1)));
                        valorSaque = valorSaque.subtract(entry.getKey());
                    }else break;

                }
            }

        } else {
            System.out.println("SAQUE NÃO AUTORIZADO!");
        }
        if (valorSaque.compareTo(BigDecimal.valueOf(0)) > 0) {
            saque.putAll(saqueDefault);
            System.out.println("NÃO TEMOS OS DINHEIROS SUFICIENTES PARA O SAQUE");
        }
        return saque;
    }

    public void mostrarSaque(LinkedHashMap<BigDecimal, Integer> saque) {
        for (Map.Entry<BigDecimal, Integer> entry : saque.entrySet()){
            int aux = entry.getValue();
            if (aux > 1){
                System.out.println(entry.getValue() + " Dinheiros de D$" + entry.getKey());
            } else if (aux == 1) {
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
