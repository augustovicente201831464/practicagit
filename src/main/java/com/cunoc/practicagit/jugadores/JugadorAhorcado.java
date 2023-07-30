package com.cunoc.practicagit.jugadores;

/**
 *
 * @author usuario
 */
public class JugadorAhorcado extends Jugador {

    public JugadorAhorcado() {
    }

    public int getVecesAdivinado() {
        return vecesAdivinado;
    }

    public void setVecesAdivinado(int vecesAdivinado) {
        this.vecesAdivinado = vecesAdivinado;
    }

    public int getVecesFallado() {
        return vecesFallado;
    }

    public void setVecesFallado(int vecesFallado) {
        this.vecesFallado = vecesFallado;
    }

    @Override
    public String toString() {
        return "JugadorAhorcado{\n"
                + "\nnombre: " + getNombre() + ","
                + "\nvecesAdivinado=" + vecesAdivinado + ","
                + "\nvecesFallado=" + vecesFallado + '}';
    }

    public char[] getCaracteresAdivinados() {
        return caracteresAdivinados;
    }

    public void setCaracteresAdivinados(char[] caracteresAdivinados) {
        this.caracteresAdivinados = caracteresAdivinados;
    }

    private char[] caracteresAdivinados;
    private int vecesAdivinado;
    private int vecesFallado;
}
