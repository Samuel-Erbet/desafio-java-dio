package org.example;

public class ContaCorrente extends Conta{

    public ContaCorrente(int agencia, int numero, double saldo){
        super();
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }
}
