package org.example;

public class SalarioDecoratorFactory {

    private SalarioDecoratorFactory() {}

    private static class Holder {
        private static final SalarioDecoratorFactory INSTANCIA = new SalarioDecoratorFactory();
    }

    public static SalarioDecoratorFactory getInstancia() {
        return Holder.INSTANCIA;
    }

    public Salario obterDecorator(String decorator, Salario salario) {
        Class classe = null;
        Object objeto = null;

        try {
            classe = Class.forName("org.example." + decorator);
            objeto = classe.getDeclaredConstructor(Salario.class).newInstance(salario);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Decorator inexistente");
        }

        if (!(objeto instanceof SalarioDecorator)) {
            throw new IllegalArgumentException("Decorator inválido");
        }

        return (Salario) objeto;
    }
}
