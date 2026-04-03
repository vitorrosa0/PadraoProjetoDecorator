package org.example;

public class SalarioLiquido implements Salario {

    private double salario;

    public SalarioLiquido() {

    }

    public SalarioLiquido(double salario) {
        this.salario = salario;
    }

    public double getSalarioLiquido() {
        return salario;
    }
}
