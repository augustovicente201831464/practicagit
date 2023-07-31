package com.cunoc.practicagit.jugadores;

import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Basquetbolista extends Jugador {

    public static final int PROBABILIDAD_LANZAMIENTO_LARGO = 65;
    public static final int PROBABILIDAD_LANZAMIENTO_CORTO = 80;
    public static final int PROBABILIDAD_DEFENSA_CUERPO = 15;
    public static final int PROBABILIDAD_DEFENSA_FUERTE = 30;
    public static final int PROBABILIDAD_DEFENSA_CUERPO_FALTA = 35;
    public static final int PROBABILIDAD_DEFENSA_FUERTE_FALTA = 65;
    public static final int PROBABILIDAD_ANOTAR_LIBRE = 90;

    public static final int PUNTOS_LANZAMIENTO_LARGO = 3;
    public static final int PUNTOS_LANZAMIENTO_CORTO = 2;
    public static final int PUNTOS_TIRO_LIBRE = 2;

    private int puntosTotales;
    private int puntosLanzamiento;
    private int probabilidadLanzamiento;
    private int probabilidadFalta;

    public void aumentarPuntosLanzamiento() {
        puntosTotales = puntosTotales + puntosLanzamiento;
    }

    public void aumentarPuntosLibre() {
        puntosTotales = puntosTotales + PUNTOS_TIRO_LIBRE;
    }

    public void disminuirPunteria(int probabilidadDefensa) {
        probabilidadLanzamiento = probabilidadLanzamiento - probabilidadDefensa;
    }

    public void determinarFalta(int probabilidadDefemsaFalta) {
        probabilidadFalta = probabilidadDefemsaFalta;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public int getPuntosLanzamiento() {
        return puntosLanzamiento;
    }

    public int getProbabilidadLanzamiento() {
        return probabilidadLanzamiento;
    }

    public int getProbabilidadFalta() {
        return probabilidadFalta;
    }

    public void lanzarLargo() {
        probabilidadLanzamiento = PROBABILIDAD_LANZAMIENTO_LARGO;
        puntosLanzamiento = 3;
    }

    public void lanzarCorto() {
        probabilidadLanzamiento = PROBABILIDAD_LANZAMIENTO_CORTO;
        puntosLanzamiento = 2;
    }

    public void defenderCuerpoACuerpo(Basquetbolista atacante) {
        atacante.disminuirPunteria(PROBABILIDAD_DEFENSA_CUERPO);
        atacante.determinarFalta(PROBABILIDAD_DEFENSA_CUERPO_FALTA);
    }

    public void defenderFuerte(Basquetbolista atacante) {
        atacante.disminuirPunteria(PROBABILIDAD_DEFENSA_FUERTE);
        atacante.determinarFalta(PROBABILIDAD_DEFENSA_FUERTE_FALTA);
    }

    public void abandonarJuego(Basquetbolista rival) {
        System.out.println("\n---------------Juego Abandonado------------------");
        System.out.println("El jugador: " + getNombre() + " se ha retirado");
        System.out.println("Ganador: " + rival.getNombre());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Presione \"ENTER\" para continuar... ");
        scanner.nextLine();
    }

}
