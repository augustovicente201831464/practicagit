package com.cunoc.practicagit.juegocarta.dto;

import java.util.Random;

/*
 *
 * @author Augusto Vicente
 */
public class Baraja {

    //Patron singleton
    private Baraja() {
        //Crear a las 52 cartas
        
        barajar();
    }
    
    private void barajar(){
        
        Random random = new Random();
        
        
    }

    /*
    *
    * Si no se ha inicializado la baraja se crear uno y se retorna caso contrario solo se retorna lo creado
     */
    public static Baraja getBaraja() {
        return (baraja != null) ? baraja : new Baraja();
    }

    public Carta[] getCartasDisponibles() {
        return this.cartasDisponibles;
    }

    public void setCartasDisponibles(Carta[] cartasDisponibles) {
        this.cartasDisponibles = cartasDisponibles;
    }

    public Carta[] getCartasSacadas() {
        return cartasSacadas;
    }

    public void setCartasSacadas(Carta[] cartasSacadas) {
        this.cartasSacadas = cartasSacadas;
    }

    public int getNumeroCartas() {
        return this.numeroCartas;
    }

    public void setNumeroCartas(int numeroCartas) {
        this.numeroCartas = numeroCartas;
    }

    public int getCartasRestantes() {
        return this.cartasRestantes;
    }

    public void setCartasRestantes(int cartasRestantes) {
        this.cartasRestantes = cartasRestantes;
    }

    public int getCartasRepartidas() {
        return this.cartasRepartidas;
    }

    public void setCartasRepartidas(int cartasRepartidas) {
        this.cartasRepartidas = cartasRepartidas;
    }

    public boolean isMezclada() {
        return mezclada;
    }

    public void setMezclada(boolean mezclada) {
        this.mezclada = mezclada;
    }

    private static Baraja baraja;

    //
    private Carta[] cartasDisponibles;
    private Carta[] cartasSacadas;
    private int numeroCartas;
    private int cartasRestantes;
    private int cartasRepartidas;
    private boolean mezclada;
}
