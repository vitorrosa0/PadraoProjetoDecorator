package org.example;

public abstract class SalarioDecorator implements Salario {

    private Salario salario;

    public SalarioDecorator(Salario salario) {
        this.salario = salario;
    }

    public Salario getSalario() {
        return salario;
    }

    public void setSalario(Salario salario) {
        this.salario = salario;
    }

    public abstract double getValorBeneficio();

    public double getSalarioLiquido() {
        return this.salario.getSalarioLiquido() + getValorBeneficio();
    }
}
