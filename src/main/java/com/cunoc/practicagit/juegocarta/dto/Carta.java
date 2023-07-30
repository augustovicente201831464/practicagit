package com.cunoc.practicagit.juegocarta.dto;

public class Carta {

    public Carta(Palo palo, ValorCarta valorCarta) {
        this.palo = palo;
        this.valorCarta = valorCarta;
    }

    public Palo getPalo() {
        return palo;
    }

    public ValorCarta getValorCarta() {
        return valorCarta;
    }

    @Override
    public String toString() {
        return "Carta {palo=" + palo + ", valorCarta=" + valorCarta + "}\n";
    }

    private final Palo palo;
    private final ValorCarta valorCarta;
}
