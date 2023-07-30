package com.cunoc.practicagit.juegocarta.dto;

import com.cunoc.practicagit.juegocarta.enums.PaloNombre;

public class Palo {

    public Palo(PaloNombre paloNombre) {
        this.paloNombre = paloNombre;
        setSimbolo();
    }

    private void setSimbolo() {
        if (paloNombre == PaloNombre.CORAZONES) {
            simbolo = SIMBOLOS[0];
        }

        if (paloNombre == PaloNombre.TREBOLES) {
            simbolo = SIMBOLOS[1];
        }

        if (paloNombre == PaloNombre.PICAS) {
            simbolo = SIMBOLOS[2];
        }

        if (paloNombre == PaloNombre.DIAMANTES) {
            simbolo = SIMBOLOS[3];
        }
    }

    public char getSimbolo() {
        return this.simbolo;
    }

    @Override
    public String toString() {
        return "Palo{" + "paloNombre=" + paloNombre + ", simbolo=" + simbolo + '}';
    }

    private final PaloNombre paloNombre;
    private char simbolo;

    public static char[] SIMBOLOS = new char[]{'♥', '♣', '♠', '♦'};
}
