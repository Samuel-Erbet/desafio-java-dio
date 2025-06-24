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
         cliente.setConta(contaCorrente);
         this.login.put(cliente, contaCorrente);
    }

    public void criarContaPoupança(Cliente cliente,int agencia, int numero, double saldo){
        ContaPoupanca contaPoupanca = new ContaPoupanca(agencia, numero, saldo);
        cliente.setConta(contaPoupanca);
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

        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco("santander");
        int repeticao = 10;

        Cliente clienteLogado = null;


        while (repeticao != 0) {
            int opcao = mostrarMenu(sc);

            switch (opcao) {

                case 0:
                    repeticao = 0;
                    System.out.println("muito obrigado! tenha um otimo dia1");
                    break;

                case 1:
                    System.out.println("inisra o seu nome");
                    String nome = sc.next();

                    System.out.println("insira o numero da agencia");
                    int agencia = sc.nextInt();

                    System.out.println("insira o numero");
                    int numero = sc.nextInt();

                    System.out.println("insira o saldo");
                    double saldo = sc.nextDouble();

                    Cliente clienteCC = new Cliente(nome);
                    banco.criarContaCorrente(clienteCC, agencia, numero, saldo);
                    clienteLogado = clienteCC;
                    System.out.println("Conta Corrente criada!");
                    break;

                case 2:
                    System.out.println("insira o seu nome");
                    nome = sc.next();

                    System.out.println("insira o numero da agencia");
                    agencia = sc.nextInt();

                    System.out.println("insira o numero");
                    numero = sc.nextInt();

                    System.out.println("insira o saldo");
                    saldo = sc.nextDouble();

                    Cliente contaPoupanca = new Cliente(nome);
                    banco.criarContaPoupança(contaPoupanca, agencia, numero, saldo);
                    clienteLogado = contaPoupanca;
                    break;

                case 3:
                    System.out.println("insira o valor que quer inserir");
                    double valor = sc.nextDouble();

                    banco.getLogin().get(clienteLogado).depositar(valor,clienteLogado);
                    System.out.println("voce depositou "+valor+" reais");
                    break;

                case 4:
                    System.out.println("insira o valor que quer sacar");
                    valor = sc.nextDouble();

                    banco.getLogin().get(clienteLogado).sacar(valor);
                    System.out.println("você sacou "+valor+" reais");
                    break;

                case 5:
                    System.out.println("insira o nome de quem vai receber");
                    String nomeCliente = sc.next();

                    System.out.println("insira o valor do deposito");
                    double deposito = sc.nextDouble();

                    if (clienteLogado == null){
                        System.out.println("erro conta invalida");
                    } else {
                        for (Cliente i : banco.getLogin().keySet()){
                            if (i.getNome().equals(nomeCliente)){

                                Conta cOrigem = banco.getLogin().get(clienteLogado);
                                Conta cDestino = banco.getLogin().get(i);

                                cOrigem.transferir(cDestino, deposito);
                                System.out.println("transferencia concluida");
                                break;
                            }
                        }
                    }

                    break;

                case 6:
                    System.out.println(banco.getLogin().keySet());
                    break;

                }


            }
        sc.close();

        }
    }

