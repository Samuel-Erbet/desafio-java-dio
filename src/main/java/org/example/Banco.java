package org.example;

import java.util.*;

public class Banco {
    private String nome;
    protected Map<Cliente, Conta> login;

    public Banco(String nome) {
        this.nome = nome;
        this.login = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<Cliente, Conta> getLogin() {
        return login;
    }

    public void setLogin(Map<Cliente, Conta> login) {
        this.login = login;
    }

    public void criarContaCorrente(Cliente cliente, int agencia, int numero, double saldo){
         ContaCorrente contaCorrente = new ContaCorrente(agencia, numero, saldo);

         this.login.put(cliente, contaCorrente);
    }

    public void criarContaPoupança(Cliente cliente,int agencia, int numero, double saldo){
        ContaPoupanca contaPoupanca = new ContaPoupanca(agencia, numero, saldo);

        this.login.put(cliente, contaPoupanca);
    }

    public static int mostrarMenu(Scanner sc) {
        System.out.println("===== MENU BANCO =====");
        System.out.println("1 - Criar Conta Corrente");
        System.out.println("2 - Criar Conta Poupança");
        System.out.println("3 - Depositar");
        System.out.println("4 - Sacar");
        System.out.println("5 - Transferir");
        System.out.println("6 - Mostrar Contas");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
        return sc.nextInt();
    }

    public static void main(String[] args) {
        /*
        Scanner sc = new Scanner(System.in);
        int repeticao = 0;

        while (repeticao == 0){
            Object opcao = mostrarMenu(sc);
            int agencia = 0;
            int numero = 0;
            double saldo = 0;
            String nome = "";

            switch (opcao){
                case 1:
                    System.out.println("inisra o seu nome");
                    nome = sc.next();

                    System.out.println("insira o numero da agencia");
                    agencia = sc.nextInt();

                    System.out.println("insira o numero");
                    numero = sc.nextInt();

                    System.out.println("insira o saldo");
                    saldo = sc.nextDouble();

                    Conta contaCorrente = new ContaCorrente(agencia,numero,saldo);

                case 2:
                    System.out.println("inisra o seu nome");
                    nome = sc.nextLine();

                    System.out.println("insira o numero da agencia");
                    agencia = sc.nextInt();

                    System.out.println("insira o numero");
                    numero = sc.nextInt();

                    System.out.println("insira o saldo");
                    saldo = sc.nextDouble();

                    Conta contaPoupanca = new ContaPoupanca(agencia, numero, saldo);

                case 3:
                    System.out.println("insira o nome de quem vai receber");
                    String nomeCliente = sc.nextLine();

                    System.out.println("insira o valor do deposito");
                    double deposito = sc.nextDouble();


            }
*/
        Cliente cleiton = new Cliente("cleiton", new Conta(1321,123,12513.34));
        Object res= cleiton.getConta().getSaldo();

        Cliente samuel = new Cliente("samuek", new Conta(1321,123,12513.34));
        samuel.getConta().depositar(123,cleiton);


        }
    }

