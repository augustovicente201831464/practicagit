package com.cunoc.practicagit.juegocarta.dto;

import java.util.Random;

import com.cunoc.practicagit.juegocarta.enums.PaloNombre;
import com.cunoc.practicagit.juegocarta.enums.ValorNombre;
import java.util.Arrays;

/*
 *
 * @author Augusto Vicente
 */
public class Baraja {

    // Patron singleton
    private Baraja() {
        // Crear a las 52 cartas
        apilarCartasBaraja();

        // Barajar a las cartas
        barajar();
    }

    public void barajar() {

        Random random = new Random();

        for (int i = 0; i < cartas.length; i++) {
            int randIdx = random.nextInt(cartas.length);
            Carta cartTmp = cartas[i];
            cartas[i] = cartas[randIdx];
            cartas[randIdx] = cartTmp;
        }

        posicionParteSuperior = 0;
    }

    private void apilarCartasBaraja() {
        cartas = new Carta[TAMANIO_BARAJA];
        cartaSacada = new Carta[TAMANIO_BARAJA];

        posicionParteSuperior = 0;

        int idx = 0;

        for (PaloNombre value : PaloNombre.values()) {
            for (int j = 0; j < ValorCarta.VALORES.length; j++) {
                Palo palo = new Palo(value);
                ValorCarta valorCarta = new ValorCarta(ValorNombre.values()[j]);
                cartas[idx] = new Carta(palo, valorCarta);
                idx++;
            }
        }

    }

    public Carta sacarCarta() {
        if (cartas.length > 0) {
            Carta carta = cartas[cartas.length - 1]; // Obtener la carta de la parte superior de la baraja
            cartas = Arrays.copyOf(cartas, cartas.length - 1); // Eliminar la carta de la baraja
            guardarCartaSacada(carta);
            return carta;
        } else {
            System.out.println("No hay más cartas en la baraja. Reapilando cartas...");
            System.out.println("¡Actualizando baraje!");

            apilarCartasBaraja(); // Volver a llenar el array cartas
            return sacarCarta(); // Llamar recursivamente a la función para sacar la carta solicitada
        }
    }

    private void guardarCartaSacada(Carta carta) {
        for (int i = 0; i < cartaSacada.length; i++) {
            if (cartaSacada[i] == null) {
                cartaSacada[i] = carta;
                break;
            }
        }
    }

    public void mostrarCartasSacadas() {
        System.out.println("Cartas sacadas de la baraja: ");
        for (Carta carta : cartaSacada) {
            if (carta != null) {
                System.out.println(carta);
            }
        }
    }

    public void resetBaraja() {
        posicionParteSuperior = 0;
    }

    public int getPosicionParteSuperior() {
        return posicionParteSuperior;
    }

    /*
     *
     * Si no se ha inicializado la baraja se crear uno y se retorna caso contrario
     * solo se retorna lo creado
     */
    public static Baraja getBaraja() {
        return (baraja != null) ? baraja : new Baraja();
    }

    public Carta[] getCartas() {
        return this.cartas;
    }

    public Carta[] getCartasSacadas() {
        return this.cartaSacada;
    }

    private static Baraja baraja;
    private int posicionParteSuperior;

    //
    private Carta[] cartas;
    private Carta[] cartaSacada;
    private static final int TAMANIO_BARAJA = 48;
}
