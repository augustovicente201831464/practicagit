package com.cunoc.practicagit.jugadores;

/**
 *
 * @author usuario
 */
public class JugadorAhorcado extends Jugador {

    public JugadorAhorcado(int id) {
        this.id = id;
        vecesFallado = 0;
        vecesAdivinado = 0;
        intentosActuales = 0;
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

    public int getId() {
        return id;
    }

    public int getIntentosActuales() {
        return intentosActuales;
    }

    public void setIntentosActuales(int intentosActuales) {
        this.intentosActuales = intentosActuales;
    }

    @Override
    public String toString() {
        return "\nJugadorAhorcado{"
                + "id=" + id + ","
                + "\nvecesAdivinado=" + vecesAdivinado + ","
                + "\nvecesFallado=" + vecesFallado + '}';
    }

    public char[] getCaracteresAdivinados() {
        return caracteresAdivinados;
    }

    public void setCaracteresAdivinados(char[] caracteresAdivinados) {
        this.caracteresAdivinados = caracteresAdivinados;
    }

    private final int id;
    private char[] caracteresAdivinados;
    private int intentosActuales;
    private int vecesAdivinado;
    private int vecesFallado;
}
