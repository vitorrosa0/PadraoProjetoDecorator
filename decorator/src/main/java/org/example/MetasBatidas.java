package org.example;

public class MetasBatidas extends SalarioDecorator {

    public MetasBatidas(Salario salario) {
        super(salario);
    }

    public double getValorBeneficio() {
        return 200.0;
    }
}
