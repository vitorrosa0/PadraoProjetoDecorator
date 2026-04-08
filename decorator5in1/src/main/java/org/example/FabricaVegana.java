package org.example;

public class FabricaVegana implements HamburgueriaFactory {

    public Hamburguer criarBase(ModoPreparo preparo) {
        return new HamburguerVegano(preparo);
    }
}
