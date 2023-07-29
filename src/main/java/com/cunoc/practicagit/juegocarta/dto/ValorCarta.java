package com.cunoc.practicagit.juegocarta.dto;

import com.cunoc.practicagit.juegocarta.enums.ValorNombre;

/**
 *
 * @author Augusto Vicente
 */
public class ValorCarta {

    public ValorCarta(ValorNombre valorNombre) {
        this.valorNombre = valorNombre;
        setValor();
    }

    private void setValor() {
        if (valorNombre == ValorNombre.DOS) {
            this.valor = VALORES[0];
        }

        if (valorNombre == ValorNombre.TRES) {
            this.valor = VALORES[1];
        }

        if (valorNombre == ValorNombre.CUATRO) {
            this.valor = VALORES[2];
        }
        if (valorNombre == ValorNombre.DOS) {
            this.valor = VALORES[0];
        }
        if (valorNombre == ValorNombre.DOS) {
            this.valor = VALORES[0];
        }
        if (valorNombre == ValorNombre.DOS) {
            this.valor = VALORES[0];
        }
        if (valorNombre == ValorNombre.DOS) {
            this.valor = VALORES[0];
        }
        if (valorNombre == ValorNombre.DOS) {
            this.valor = VALORES[0];
        }
        if (valorNombre == ValorNombre.DOS) {
            this.valor = VALORES[0];
        }
        if (valorNombre == ValorNombre.DOS) {
            this.valor = VALORES[0];
        }
        if (valorNombre == ValorNombre.DOS) {
            this.valor = VALORES[0];
        }
        if (valorNombre == ValorNombre.DOS) {
            this.valor = VALORES[0];
        }
    }

    public String getValor() {
        return valor;
    }

    private ValorNombre valorNombre;
    private String valor;

    public static String[] VALORES = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K", "AS"};
}
