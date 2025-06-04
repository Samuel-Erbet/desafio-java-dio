package org.example;

public class ContaPoupanca extends Conta {

    private double taxa;

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public ContaPoupanca(int agencia, int numero, double saldo, double taxa) {
        this.taxa = taxa;
        this.saldo = saldo;
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
