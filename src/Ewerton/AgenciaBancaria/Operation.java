package Ewerton.AgenciaBancaria;

import java.math.BigDecimal;
import java.util.Scanner;

public class Operation {

    public static void operar(int opCode) {
        switch (opCode){
            case 1:
                abrirConta(Menu.getInfo());
                break;
            case 2:
                fecharConta(Menu.selectConta());
                break;

            case 3:
                transferir(Menu.selectConta(),Menu.selectConta());
                break;

            case 4:
                sacar(Menu.selectConta());
                break;

            case 5:
                depositar(Menu.selectConta());
                break;

            case 6:
                mostrarSaldo(Menu.selectConta());
                break;

            case 7:
                listarContas();
                break;
            default:
                System.exit(1);
        }
        Menu.showMenu();
    }


    private static void listarContas() {
        if (Banco.contaBancariaList.isEmpty()) System.out.println("Lista vazia.");
        else Banco.contaBancariaList.forEach(System.out::println);
    }

    public static void abrirConta(ContaBancaria conta) {
        if (Banco.contaBancariaList.contains(conta)) {
            int i = Banco.contaBancariaList.indexOf(conta);
            Banco.contaBancariaList.get(i).setStatus(StatusConta.ABERTA);
        } else {
            Banco.contaBancariaList.add(conta);
        }
    }

    public static void fecharConta(ContaBancaria conta) {
        if (Banco.contaBancariaList.contains(conta)) {
            int i = Banco.contaBancariaList.indexOf(conta);
            Banco.contaBancariaList.get(i).setStatus(StatusConta.FECHADA);
        } else {
            throw new RuntimeException("Conta nao encontrada");
        }
    }

    public static void sacar(ContaBancaria contaBancaria) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o calor a ser transferido: ");
        BigDecimal valor = sc.nextBigDecimal();
        contaBancaria.sacar(valor);
    }

    public static void depositar(ContaBancaria contaBancaria){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o calor a ser transferido: ");
        BigDecimal valor = sc.nextBigDecimal();
        contaBancaria.depositar(valor);
    }

    public static void transferir(ContaBancaria mandante, ContaBancaria recebente) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o calor a ser transferido: ");
        BigDecimal valor = sc.nextBigDecimal();
        mandante.sacar(valor);
        recebente.depositar(valor);
    }

    public static void mostrarSaldo(ContaBancaria contaBancaria) {
        System.out.println("===========================");
        System.out.println("SALDO: " + contaBancaria.getSaldo().setScale(2));
        System.out.println("===========================");
    }

}
