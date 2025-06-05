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


    public static void main(String[] args) {
        Conta conta = new ContaCorrente(1984,12,1245.04);
        Cliente samuel = new Cliente("samuel", conta);
        Banco itau = new Banco("itau");

        Conta conta2 = new ContaCorrente(100,124,1235.00);
        Cliente claudio = new Cliente("claudio", conta2);

        conta.depositar(500);
        conta.sacar(100);
        conta.transferir(conta2,100);


    }
}
