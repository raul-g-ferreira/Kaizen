package Ewerton.AgenciaBancaria;

import java.util.Optional;
import java.util.Scanner;

public class Menu {


    public static void showMenu() {
        System.out.println("================== BANCO TOP ====================");
        System.out.println("1 : Abrir Conta");
        System.out.println("2 : Fechar Conta");
        System.out.println("3 : Transferir");
        System.out.println("4 : Sacar");
        System.out.println("5 : Depositar");
        System.out.println("6 : Mostrar saldo");
        System.out.println("7 : Sair");
        System.out.print("Selecione a operação que deseja fazer:");


        Scanner sc = new Scanner(System.in);

        Operation.operar(sc.nextInt());
    }

    public static ContaBancaria selectConta() {
        Scanner sc = new Scanner(System.in);


        System.out.println("Numero da conta:");
        int numConta = sc.nextInt();
        System.out.println("numero da agencia:");
        int numAgencia = sc.nextInt();

        ContaBancaria conta = Banco.contaBancariaList.stream().filter(contaBancaria -> contaBancaria.getNumAgencia() == numAgencia && contaBancaria.getNumConta() == numConta).findFirst().orElse(null);

        if (conta == null) throw new RuntimeException("COnta não encontrada");
        return conta;
    }

    public static ContaBancaria getInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Numero da conta: ");
        int numConta = sc.nextInt();
        System.out.println("numero da agencia: ");
        int numAgencia = sc.nextInt();
        System.out.println("nome do titular: ");
        String nome = sc.next();

        ContaBancaria conta = new ContaBancaria(numAgencia, numConta, nome);
        return conta;
    }




}
