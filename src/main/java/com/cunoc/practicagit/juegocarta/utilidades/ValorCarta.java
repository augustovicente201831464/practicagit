package com.cunoc.practicagit.juegocarta.utilidades;

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
        if (valorNombre == ValorNombre.CINCO) {
            this.valor = VALORES[3];
        }
        if (valorNombre == ValorNombre.SEIS) {
            this.valor = VALORES[4];
        }
        if (valorNombre == ValorNombre.SIETE) {
            this.valor = VALORES[5];
        }
        if (valorNombre == ValorNombre.OCHO) {
            this.valor = VALORES[6];
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
