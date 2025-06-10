package org.example;

public class ContaPoupanca extends Conta {

    private double taxa = 0.73;

    public double getTaxa() {
        return taxa;
    }


    public ContaPoupanca(int agencia, int numero, double saldo) {
        this.taxa = taxa;
        this.saldo = saldo * taxa;
        this.numero = numero;
        this.agencia = agencia;
    }




    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "taxa=" + taxa +
                ", agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }
}
