package org.example;

public class HamburguerVegano extends HamburguerBase {


    public HamburguerVegano(ModoPreparo modoPreparo) {
        super("Integral", "Grão de Bico", modoPreparo);
    }

    public String hamburguer() {
        return "[Vegano] " + super.hamburguer();
    }
}
