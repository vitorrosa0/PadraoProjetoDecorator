package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalarioTest {

    @Test
    void deveRetornarSalarioLiquidoComFuncionarioMes() {
        SalarioDecoratorFactory factory = SalarioDecoratorFactory.getInstancia();
        Salario salario = factory.obterDecorator("FuncionarioMes", new SalarioLiquido(3000.0));
        assertEquals(3350.0, salario.getSalarioLiquido());
    }

    @Test
    void deveRetornarSalarioLiquidoComMetasBatidas() {
        SalarioDecoratorFactory factory = SalarioDecoratorFactory.getInstancia();
        Salario salario = factory.obterDecorator("MetasBatidas", new SalarioLiquido(3000.0));
        assertEquals(3200.0, salario.getSalarioLiquido());
    }

    @Test
    void deveRetornarSalarioLiquidoComAdvertencia() {
        SalarioDecoratorFactory factory = SalarioDecoratorFactory.getInstancia();
        Salario salario = factory.obterDecorator("Advertencia", new SalarioLiquido(3000.0));
        assertEquals(2950.0, salario.getSalarioLiquido());
    }

    @Test
    void deveRetornarSalarioLiquidoComFuncionarioMesEMetasBatidas() {
        SalarioDecoratorFactory factory = SalarioDecoratorFactory.getInstancia();
        Salario salario = new SalarioLiquido(3000.0);
        salario = factory.obterDecorator("FuncionarioMes", salario);
        salario = factory.obterDecorator("MetasBatidas", salario);
        assertEquals(3550.0, salario.getSalarioLiquido());
    }

    @Test
    void deveRetornarSalarioLiquidoComFuncionarioMesEAdvertencia() {
        SalarioDecoratorFactory factory = SalarioDecoratorFactory.getInstancia();
        Salario salario = new SalarioLiquido(3000.0);
        salario = factory.obterDecorator("FuncionarioMes", salario);
        salario = factory.obterDecorator("Advertencia", salario);
        assertEquals(3300.0, salario.getSalarioLiquido());
    }

    @Test
    void deveRetornarSalarioLiquidoComMetasBatidasMesEAdvertencia() {
        SalarioDecoratorFactory factory = SalarioDecoratorFactory.getInstancia();
        Salario salario = new SalarioLiquido(3000.0);
        salario = factory.obterDecorator("MetasBatidas", salario);
        salario = factory.obterDecorator("Advertencia", salario);
        assertEquals(3150.0, salario.getSalarioLiquido());
    }

    @Test
    void deveRetornarSalarioLiquidoComFuncionarioMesEMetasBatidasMesEAdvertencia() {
        SalarioDecoratorFactory factory = SalarioDecoratorFactory.getInstancia();
        Salario salario = new SalarioLiquido(3000.0);
        salario = factory.obterDecorator("FuncionarioMes", salario);
        salario = factory.obterDecorator("MetasBatidas", salario);
        salario = factory.obterDecorator("Advertencia", salario);
        assertEquals(3500.0, salario.getSalarioLiquido());
    }

}