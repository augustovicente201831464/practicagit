package com.cunoc.practicagit.ahorcado.dto;

/**
 *
 * @author Augusto Vicente
 */
public class Palabra {

    public Palabra(String valor) {
        this.valor = valor;
        actualizarCaracteres(valor);
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
        actualizarCaracteres(valor);
    }

    private void actualizarCaracteres(String valor) {
        caracteres = valor.toCharArray();
    }

    public char[] getCaracteres() {
        return caracteres;
    }

    public boolean isAdivinado() {
        return adivinado;
    }

    public void setAdivinado(boolean adivinado) {
        this.adivinado = adivinado;
    }

    private boolean adivinado;
    private String valor;
    private char[] caracteres;
}
