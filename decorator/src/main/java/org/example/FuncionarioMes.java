package org.example;

public class FuncionarioMes extends SalarioDecorator {

    public FuncionarioMes(Salario salario) {
        super(salario);
    }

    public double getValorBeneficio() {
        return 350.0;
    }
}
