package org.example;

public class Conta{
    protected int agencia;
    protected int numero;
    protected double saldo;

    public Conta(int agencia, int numero, double saldo){
        this.saldo = saldo;
        this.numero = numero;
        this.agencia = agencia;
    }

    public Conta(){}

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    public void sacar(double valor){

            if (valor > saldo) {
                System.out.println("erro, saldo insuficiente");
            } else {
                this.saldo = saldo - valor;
            }

    }


    public void depositar(double valor, Cliente cliente){

            this.saldo = saldo + valor;
    }

    public void transferir(Conta conta, double valor){

            if (valor > saldo) {

                System.out.println("erro, saldo insuficiente");

            } else {

                if (valor > 0) {
                    this.saldo = saldo - valor;
                    conta.setSaldo(conta.getSaldo() + valor);
                } else {
                    System.out.println("erro, valor inválido");
                }

            }

    }
}
