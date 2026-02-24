package CeV.Aula05;

import java.math.BigDecimal;

enum TipoConta {
    CC,
    CP
}

public class ContaBanco {
    private Integer numConta;
    private TipoConta tipo;
    private String dono;
    private BigDecimal saldo;
    private Boolean status;

    public ContaBanco(String dono, TipoConta tipo, Integer numConta) {
        this.dono = dono;
        this.tipo = tipo;
        this.numConta = numConta;
    }

    public void fecharConta() {
        if (this.saldo.equals(0)) {
            this.status = false;
        } else if (this.saldo.compareTo(BigDecimal.valueOf(0)) == 1) {
            System.out.println("Saque seu dinheiro!");
            System.out.println("Saldo: " + getSaldo());
        }else {
            System.out.println("Quite suas dividas!");
            System.out.println("Saldo: " + getSaldo());
        }
    }
    public void depositar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.valueOf(0)) == 1) {
            this.saldo.add(valor);
            System.out.println("Depósito realizado");
        } else{
            System.out.println("VALOR INVALIDO");
        }
    }

    public void sacar(BigDecimal valor) {
        if (valor.compareTo(this.saldo) == 1) {
            System.out.println("VOCE NAO TEM ESSE DINHEIRO");
        } else {
            this.saldo.subtract(valor);
            System.out.println("Sacando R$" + valor);
            System.out.println("Saldo restante: R$" + this.saldo);
        }
    }


    public Integer getNumConta() {
        return numConta;
    }

    public String getTipo() {
        return tipo.toString();
    }
    
    public String getDono() {
        return dono;
    }
    
    public BigDecimal getSaldo() {
        return saldo;
    }

    public Boolean getStatus() {
        return status;
    }

}
