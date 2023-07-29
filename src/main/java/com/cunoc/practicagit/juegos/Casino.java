package com.cunoc.practicagit.juegos;

import com.cunoc.practicagit.juegocarta.dto.Baraja;
import com.cunoc.practicagit.juegocarta.dto.Carta;

/**
 *
 * @author usuario
 */
public class Casino extends Juego {

    @Override
    public void jugar() {
    }

    private Casino() {

    }

    public static Casino getCasino() {
        return (casino != null) ? casino : new Casino();
    }

    private static Casino casino;

    private String nombreCasino;
    private double dinero;
    private Carta[] cartasActual;
    private Carta[] cartasAnterior;
    private Baraja baraja;
}
