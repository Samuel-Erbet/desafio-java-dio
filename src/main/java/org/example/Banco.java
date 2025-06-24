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

        Scanner sc = new Scanner(System.in);
        int repeticao = 10;
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente = null;

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

                    cliente = new Cliente (nome, new ContaCorrente(agencia, numero, saldo));
                    clientes.add(cliente);
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

                    Cliente contaPoupanca = new Cliente(nome, new ContaPoupanca(agencia, numero, saldo));
                    clientes.add(contaPoupanca);
                    break;

                case 3:
                    System.out.println("insira o valor que quer inserir");
                    double valor = sc.nextDouble();

                    cliente.getConta().depositar(valor, cliente);
                    System.out.println("voce depositou "+valor+" reais");
                    break;

                case 4:
                    System.out.println("insira o valor que quer sacar");
                    valor = sc.nextDouble();

                    cliente.getConta().sacar(valor);
                    System.out.println("você sacou "+valor+" reais");
                    break;

                case 5:
                    System.out.println("insira o nome de quem vai receber");
                    String nomeCliente = sc.next();

                    System.out.println("insira o valor do deposito");
                    double deposito = sc.nextDouble();

                    if (cliente == null){
                        System.out.println("erro conta invalida");
                    } else {
                        for (Cliente i : clientes){
                            if (nomeCliente.equals(cliente.getNome())){
                                cliente.getConta().transferir(i.getConta(), deposito);
                                System.out.println("transferencia concluida");
                                break;
                            }
                        }
                    }

                    break;

                case 6:
                    System.out.println(clientes);
                    break;

                }


            }
        }
    }

