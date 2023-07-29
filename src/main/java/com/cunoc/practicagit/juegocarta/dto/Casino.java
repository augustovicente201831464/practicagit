package com.cunoc.practicagit.juegocarta.dto;

public class Casino{

    //Singleton
    private Casino(){

    }


    /*
    *
    * Obtener casino, si no existe instancia lo crea y lo devuelve, caso contrario devuelve la instancia que existe
    */
    public static Casino getCasino(){
        return (casino!=null) ? casino: new Casino();
    }

    



    private static Casino casino;

    //Otros atributos
    private String nombreCasino;
    private double dineroCasino;
    private Carta[] cartasActual;
    private Carta[] cartaAnterior;
    private Baraja baraja;
}