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
        if (valorNombre == ValorNombre.NUEVE) {
            this.valor = VALORES[7];
        }
        if (valorNombre == ValorNombre.JOTA) {
            this.valor = VALORES[8];
        }
        if (valorNombre == ValorNombre.REINA) {
            this.valor = VALORES[9];
        }
        if (valorNombre == ValorNombre.REY) {
            this.valor = VALORES[10];
        }
        if (valorNombre == ValorNombre.AS) {
            this.valor = VALORES[11];
        }
    }

    public ValorNombre getValorNombre() {
        return valorNombre;
    }

    @Override
    public String toString() {
        return "ValorCarta{" + "valorNombre=" + valorNombre + ", valor=" + valor + '}';
    }

    private final ValorNombre valorNombre;
    private String valor;

    public static String[] VALORES = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K", "AS"};
}
