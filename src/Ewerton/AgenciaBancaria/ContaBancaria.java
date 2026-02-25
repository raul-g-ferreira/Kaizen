package Ewerton.AgenciaBancaria;

import java.math.BigDecimal;
import java.util.Objects;

// conta deve ter número de agência, número da conta, nome do titular, saldo, status
public class ContaBancaria {
    private int numAgencia;
    private int numConta;
    private String nomeTitular;
    private BigDecimal saldo = BigDecimal.ZERO;
    private StatusConta status;


    public void sacar(BigDecimal valorSaque) {
        if (valorSaque.signum() == -1) throw new RuntimeException("VALORES NEGATIVOS NAO SAO ACEITOS");

        if (this.saldo.compareTo(valorSaque) >= 0) {
            this.saldo = this.saldo.subtract(valorSaque);
        }else {
            throw new RuntimeException("Saldo insuficiente para saque");
        }
    }

    public void depositar(BigDecimal valorDeposito) {
        if (valorDeposito.signum() == -1) throw new RuntimeException("VALORES NEGATIVOS NAO SAO ACEITOS");

        this.saldo = this.saldo.add(valorDeposito);
        System.out.println(valorDeposito + " depositado");
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ContaBancaria that = (ContaBancaria) o;
        return numAgencia == that.numAgencia && numConta == that.numConta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numAgencia, numConta);
    }

    public ContaBancaria(int numAgencia, int numConta, String nomeTitular) {
        this.numAgencia = numAgencia;
        this.numConta = numConta;
        this.nomeTitular = nomeTitular;
        this.status = StatusConta.ABERTA;
    }

    public void setStatus(StatusConta status) {
        this.status = status;
    }

    public int getNumAgencia() {
        return numAgencia;
    }

    public int getNumConta() {
        return numConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public StatusConta getStatus() {
        return status;
    }
}
