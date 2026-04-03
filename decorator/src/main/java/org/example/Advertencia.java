package org.example;

public class Advertencia extends SalarioDecorator {

    public Advertencia(Salario salario) {
        super(salario);
    }

    public double getValorBeneficio() {
        return -50.0;
    }
}
