package com.cunoc.practicagit.juegos;

import com.cunoc.practicagit.juegocarta.dto.Baraja;
import com.cunoc.practicagit.juegocarta.dto.Carta;
import com.cunoc.practicagit.jugadores.JugadorCartas;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Casino extends Juego {

    @Override
    public void jugar() {

        baraja = Baraja.getBaraja();
        System.out.println("\n\nBIENVENIDO AL CASINO: " + NOMBRE_CASINO);

        datosJugador();
        opcionCasino();
    }

    private void opcionCasino() {
        int opcion = 4;
        boolean jugando = true;

        dineroJugador();

        System.out.println("\n1. APOSTAR"
                + "\n2. REGLAS DE JUEGO"
                + "\n3. VER DINERO JUGADOR"
                + "\n4. TODAS LAS CARTAS ABIERTAS"
                + "\n5. SALIR");
        System.out.print("\nINGRESE UNA OPCIÓN: ");

        try {
            opcion = Integer.parseInt(INPUT.nextLine());

            switch (opcion) {
                case 1:
                    abrirApuesta();
                    break;
                case 2:
                    verReglasDelJuego();
                    break;
                case 3:
                    dineroJugador();
                    break;
                case 4:
                    mostrarCartasRepartidas();
                    break;
                case 5:
                    jugando = false;
                    break;
                default:
                    throw new Exception();
            }
        } catch (Exception ex) {
            System.out.println("\n¡Ingrese una opción númerica válida!");
        }

        if (jugando) {
            opcionCasino();
        }
    }

    private void datosJugador() {

        boolean cont = true;
        try {
            System.out.println("\n\nIngrese sus datos");

            System.out.print("Ingrese su nombre: ");
            String nombre = INPUT.nextLine();

            if (nombre.length() <= 0) {
                throw new Exception();
            }

            System.out.print("Ingrese su dinero: ");
            BigDecimal dinero = new BigDecimal(INPUT.nextLine());

            if (dinero.compareTo(BigDecimal.ZERO) <= 0) {
                throw new Exception();
            }

            jugadorCartas = new JugadorCartas(dinero);
            jugadorCartas.setNombre(nombre);
        } catch (Exception ex) {
            cont = false;
        }

        if (!cont) {
            System.out.println("\n¡INGRESE CORRECTAMENTE A LOS DATOS!\n");
            datosJugador();
        }

    }

    private void abrirApuesta() {

        if (!comprobarDineroJugador()) {
            System.out.println("¡No tienes suficiente dinero!");
            return;
        }

        if (!comprobarDineroCasino()) {
            System.out.println("¡El casino se fue a la quiebra, ya no tienes decrecho a entrar, quedas vetado de por vida!");
            return;
        }

        dineroJugador();

        Carta carta1 = baraja.sacarCarta();
        Carta carta2 = baraja.sacarCarta();

        cartasAnterior[0] = carta1;
        cartasAnterior[1] = carta2;

        System.out.println("\nApuesta entre estas 2 cartas: \n" + Arrays.toString(cartasAnterior));

        System.out.print("\n\n¿Se arriesga a apostar a que salga una carta con valor entre los valores de las dos cartas presentadas anteriormente?"
                + "\nIngresa S (Si) o N (No): ");

        boolean apostar = validar();

        if (apostar) {

            BigDecimal apuestaActual = apuestaActual(INPUT, jugadorCartas, dineroCasino);

            jugadorCartas.setApuestaActual(apuestaActual);

            System.out.println("Apostando: " + apuestaActual);

            Carta carta3 = baraja.sacarCarta();
            cartaActual = carta3;

            System.out.println("\nCarta por quien se aposto: " + cartaActual);

            //System.out.println("\nCartas sacadas" + Arrays.toString(baraja.getCartasSacadas()));
            int apuesta = validarApuesta(cartasAnterior, carta3);

            if (apuesta == 1) {
                jugadorCartas.setDinero(jugadorCartas.getDinero().add(jugadorCartas.getApuestaActual()));
                dineroCasino = dineroCasino.subtract(jugadorCartas.getApuestaActual());
            }

            if (apuesta == -1) {
                jugadorCartas.setDinero(jugadorCartas.getDinero().subtract(jugadorCartas.getApuestaActual()));
                dineroCasino = dineroCasino.add(jugadorCartas.getApuestaActual());
            }
        }

        System.out.print("\n¿Le gustaría abrir otra apuesta?"
                + "\nIngresa S (Si) o N (No): ");

        boolean seguir = validar();

        if (!seguir) {
            System.out.println("\n\n¡GRACIAS POR PARTICIPAR!\n\n");
        }

        if (seguir) {
            abrirApuesta();
        }
    }

    private boolean comprobarDineroJugador() {
        return jugadorCartas.getDinero().compareTo(BigDecimal.ZERO) > 0;
    }

    private boolean comprobarDineroCasino() {
        return dineroCasino.compareTo(BigDecimal.ZERO) > 0;
    }

    private boolean validar() {
        char respuesta = Casino.obtenerRespuestaValida(INPUT);

        return respuesta == 'S' || respuesta == 's';
    }

    private static char obtenerRespuestaValida(Scanner scanner) {
        String s = scanner.nextLine().trim();

        if (s.length() == 1) {
            char respuesta = s.charAt(0);
            if (respuesta == 'S' || respuesta == 's' || respuesta == 'N' || respuesta == 'n') {
                return respuesta;
            } else {
                System.out.println("\nRespuesta inválida. Ingresa S (Si) o N (No):");
                return obtenerRespuestaValida(scanner);
            }
        } else {
            System.out.println("\nDebes ingresar solo un carácter. Ingresa S (Si) o N (No):");
            return obtenerRespuestaValida(scanner);
        }
    }

    private void verReglasDelJuego() {
        System.out.println("\n" + reglasDelJuego() + "\n");
    }

    private void dineroJugador() {
        try {
            BigDecimal dinero = jugadorCartas.getDinero();
            System.out.println("\nDinero del jugador: Q " + dinero);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public int validarApuesta(Carta[] cartasPresentadas, Carta siguienteCarta) {
        int valorCarta1 = cartasPresentadas[0].getValorCarta().getValorNombre().ordinal();
        int valorCarta2 = cartasPresentadas[1].getValorCarta().getValorNombre().ordinal();

        int valorSiguienteCarta = siguienteCarta.getValorCarta().getValorNombre().ordinal();

        int valorMinimo = Math.min(valorCarta1, valorCarta2);
        int valorMaximo = Math.max(valorCarta1, valorCarta2);

        if (valorSiguienteCarta > valorMinimo && valorSiguienteCarta < valorMaximo) {
            System.out.println("\nGanaste!!! La siguiente carta estaba entre las dos cartas presentadas.");
            return 1; // El jugador de cartas ganó la apuesta.
        } else if (valorSiguienteCarta == valorMinimo || valorSiguienteCarta == valorMaximo) {
            System.out.println("\nRecuperaste tu apuesta!!! La siguiente carta tenía el mismo valor que una de las cartas presentadas.");
            return 0; // El jugador de cartas recuperó su apuesta.
        } else {
            System.out.println("\nPerdiste!!!. La siguiente carta estaba fuera del rango de las cartas presentadas.");
            return -1; // El jugador de cartas perdió la apuesta.
        }
    }

    private static BigDecimal apuestaActual(Scanner INPUT, JugadorCartas jugadorCartas, BigDecimal dineroCasino) {
        System.out.print("Ingrese su apuesta: ");

        boolean cont = true;
        String msj = "";

        BigDecimal apuesta = new BigDecimal(0);

        try {
            apuesta = new BigDecimal(INPUT.nextLine());

            if (apuesta.compareTo(BigDecimal.ZERO) <= 0) {
                msj = "\n¡Ingrese un monto mayor que 0!";
                throw new Exception();
            }

            if (jugadorCartas.getDinero().compareTo(apuesta) < 0) {
                msj = "\n¡Ingrese un monto menor o igual a su dinero disponible!";
                throw new Exception();
            }

            if (dineroCasino.compareTo(apuesta) < 0) {
                msj = "\n¿¡Te parece que somos rico o que!?"
                        + "\nEl casino no puede cubrir ese monto, ingrese uno menor o igual a: " + dineroCasino;
                throw new Exception();
            }

        } catch (Exception ex) {
            cont = false;
        }

        if (!cont) {
            System.out.println(msj);
            return apuestaActual(INPUT, jugadorCartas, dineroCasino);
        }

        return apuesta;
    }

    private void mostrarCartasRepartidas() {
        for (int i = 0; i < baraja.getCartasSacadas().length; i++) {
            if (baraja.getCartasSacadas()[i] == null) {
                break;
            }
            System.out.println(i + ": " + baraja.getCartasSacadas()[i]);
        }
    }

    private Casino() {

    }

    public static Casino getCasino() {
        return (casino != null) ? casino : new Casino();
    }

    private String reglasDelJuego() {
        return "\n\"Los jugadores apuestan dinero en cada turno en función de las probabilidades de que el valor"
                + "\nde la próxima carta esté entre dos cartas presentadas por el casino, terminando cuando un"
                + "\njugador se queda sin dinero.\"\n";
    }

    private static Casino casino;
    private final Scanner INPUT = new Scanner(System.in);

    private final String NOMBRE_CASINO = "LAS VEGAS";
    private BigDecimal dineroCasino = new BigDecimal(1000);
    private Carta cartaActual;
    private final Carta[] cartasAnterior = new Carta[2];
    private Baraja baraja;
    private JugadorCartas jugadorCartas;
}
