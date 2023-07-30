package com.cunoc.practicagit.jugadores;

import java.math.BigDecimal;

/**
 *
 * @author usuario
 */
public class JugadorCartas extends Jugador {
    
    public JugadorCartas(BigDecimal dinero) {
        this.dinero = dinero;
    }

    public BigDecimal getDinero() {
        return dinero;
    }

    public void setDinero(BigDecimal dinero) {
        this.dinero = dinero;
    }

    public BigDecimal getApuestaActual() {
        return apuestaActual;
    }

    public void setApuestaActual(BigDecimal apuestaActual) {
        this.apuestaActual = apuestaActual;
    }

    private BigDecimal dinero;
    private BigDecimal apuestaActual;
}
