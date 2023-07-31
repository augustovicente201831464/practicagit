package com.cunoc.practicagit.juegos;

import com.cunoc.practicagit.ahorcado.DibujoAhorcado;
import com.cunoc.practicagit.ahorcado.dto.Palabra;
import com.cunoc.practicagit.juegocarta.utilidades.Validaciones;
import com.cunoc.practicagit.jugadores.Jugador;
import com.cunoc.practicagit.jugadores.JugadorAhorcado;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Ahorcado extends Juego {

    @Override
    public void jugar() {
        //Mostrar menu
        iniciarAhorcado(INPUT);
    }

    private Ahorcado() {
        this.jugadoresAhorcado = new ArrayList<>();
        INPUT = new Scanner(System.in);
    }

    public static Ahorcado getAhorcado() {
        return (ahorcado != null) ? ahorcado : new Ahorcado();
    }

    private void iniciarAhorcado(Scanner INPUT) {

        System.out.println("\nBienvenido(a) al juego 1: Ahorcado");

        System.out.println("\n--- MENU AHORCADO ---"
                + "\n1. Nuevo juego"
                + "\n2. Ingresar jugador"
                + "\n3. Mostrar dato jugadores"
                + "\n4. Salir");

        int opcion = 4;
        boolean jugando = true;

        try {
            System.out.print("\nIngrese una opción: ");
            opcion = Integer.parseInt(INPUT.nextLine());

            switch (opcion) {
                case 1:
                    nuevoJuego();
                    break;
                case 2:
                    crearJugadores();
                    break;
                case 3:
                    mostrarDatosDeJugadores();
                    break;
                case 4:
                    jugando = false;
                    break;
                default:
                    throw new Exception();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("\n¡Ingrese un valor númerico válido!");
        }

        if (jugando) {
            iniciarAhorcado(INPUT);
        }

        /*

        System.out.println("\nIngrese una palabra que un jugador lo adivine: ");

        
        da.dibujarPersonaje();

        //Primera falla
        int intentoFallidos = 1;
        da.decretarFalla(intentoFallidos, da);
        da.dibujarAhorca();

        //Segunda falla
        intentoFallidos = 2;
        da.decretarFalla(intentoFallidos, da);
        da.dibujarAhorca();

        //Tercero falla
        intentoFallidos = 3;
        da.decretarFalla(intentoFallidos, da);
        da.dibujarAhorca();

        //Cuarta falla
        intentoFallidos = 4;
        da.decretarFalla(intentoFallidos, da);
        da.dibujarAhorca();

        //Quinta falla
        intentoFallidos = 5;
        da.decretarFalla(intentoFallidos, da);
        da.dibujarAhorca();

        //Sexta falla
        intentoFallidos = 6;
        da.decretarFalla(intentoFallidos, da);
        da.dibujarAhorca();

        //Septima falla
        intentoFallidos = 7;
        da.decretarFalla(intentoFallidos, da);
        da.dibujarAhorca();

        //Octava falla
        intentoFallidos = 8;
        da.decretarFalla(intentoFallidos, da);
        da.dibujarAhorca();
         */
    }

    private void nuevoJuego() {
        DibujoAhorcado dibujoAhorcado = DibujoAhorcado.getDibujoAhorcado();
        dibujoAhorcado.resetBase();

        boolean vacio = jugadoresAhorcado.isEmpty();
        boolean seleccionar = false;

        if (jugadoresAhorcado.size() > 1) {
            System.out.print("\nSeleccionar jugador"
                    + "\nIngrese S (Si) o N (Default): ");
            seleccionar = Validaciones.validar(INPUT);
        }

        if (!vacio && !seleccionar) {
            idJugadorActual = 1;
        }

        if (seleccionar) {
            idJugadorActual = seleccionarJugador(INPUT, jugadoresAhorcado);
        }

        if (vacio) {
            System.out.println("¡Para poder jugar debe registrarse primero!");
            crearJugadores();
            idJugadorActual = 1;
        }

        jugadorActual = jugadoresAhorcado.get(idJugadorActual - 1);
        jugadorActual.setIntentosActuales(0);

        //Adivinar palabra
        iniciarAdivinar(INPUT, jugadorActual, dibujoAhorcado);

        System.out.print("\nVolver a jugar"
                + "\nIngrese S (Si) o N (No): ");
        if (Validaciones.validar(INPUT)) {
            nuevoJuego();
        }

    }

    private void iniciarAdivinar(Scanner INPUT, JugadorAhorcado jugadorActual, DibujoAhorcado dibujoAhorcado) {

        System.out.println("\n¡Intentos segun este hombre ahorcado!\n");
        dibujoAhorcado.dibujarPersonaje();

        //Ingresar palabra a adivinar
        System.out.print("\nIngresar una palabra valida"
                + "\npara que el jugador lo adivine: ");
        Palabra palabra = new Palabra(palabraSinCaracteresEspeciales(INPUT));

        int tamanio = palabra.getValor().length();
        char[] carateresOcultos = new char[tamanio];

        for (int i = 0; i < tamanio; i++) {
            carateresOcultos[i] = '0';
        }

        jugadorActual.setCaracteresAdivinados(carateresOcultos);
        adivinar(palabra, jugadorActual, dibujoAhorcado);

        if (palabra.isAdivinado()) {
            System.out.println("¡Felicidades has adivinado a la palabra!");
            System.out.println("La palabra es: " + Arrays.toString(jugadorActual.getCaracteresAdivinados()));
        }

        if (!palabra.isAdivinado()) {
            jugadorActual.setVecesFallado(jugadorActual.getVecesFallado() + 1);
            System.out.println("¡Ohh mala suerte!"
                    + "Has perdido, la palabra era: " + Arrays.toString(palabra.getCaracteres()));
        }

    }

    private void adivinar(Palabra palabra, JugadorAhorcado jugadorActual, DibujoAhorcado dibujoAhorcado) {
        System.out.println("\n\nJugador en juego: " + jugadorActual.toString());
        boolean adivinado = palabra.isAdivinado();

        if (adivinado || jugadorActual.getIntentosActuales() >= dibujoAhorcado.getIntentosMaximos()) {
            return;
        }

        System.out.println("1. Adivinar palabra");
        System.out.println("2. Adivinar letra");

        int opc = opcionAdivinar(INPUT);

        if (opc == 1) {
            adivinarPalabra(INPUT, jugadorActual, palabra, dibujoAhorcado);
        }

        if (opc == 2) {
            adivinarLetra(INPUT, jugadorActual, palabra, dibujoAhorcado);
        }

        if (!adivinado && jugadorActual.getIntentosActuales() < dibujoAhorcado.getIntentosMaximos()) {
            adivinar(palabra, jugadorActual, dibujoAhorcado);
        }
    }

    private void adivinarPalabra(Scanner INPUT, JugadorAhorcado jugadorActual, Palabra palabra, DibujoAhorcado dibujoAhorcado) {
        System.out.print("Ingrese la palabra y pruebe su suerte: ");

        String ingresado = palabraSinCaracteresEspeciales(INPUT);

        boolean adivinado = ingresado.equals(palabra.getValor());

        if (adivinado) {
            jugadorActual.setCaracteresAdivinados(ingresado.toCharArray());
            jugadorActual.setVecesAdivinado(jugadorActual.getVecesAdivinado() + 1);

            System.out.println("" + Arrays.toString(jugadorActual.getCaracteresAdivinados()));

            palabra.setAdivinado(adivinado);
        }

        if (!adivinado) {
            jugadorActual.setIntentosActuales(jugadorActual.getIntentosActuales() + 1);
            dibujoAhorcado.decretarFalla(jugadorActual.getIntentosActuales(), dibujoAhorcado);
            System.out.println("¡Has fallado, sigue intentando!");
            dibujoAhorcado.dibujarAhorca();
        }
    }

    private void adivinarLetra(Scanner INPUT, JugadorAhorcado jugadorActual, Palabra palabra, DibujoAhorcado dibujoAhorcado) {
        System.out.print("Ingrese la letra y pruebe su suerte: ");

        char ingresado = getCharIngresado(INPUT);

        boolean adivinado = comprobarCaracter(ingresado, palabra);

        if (adivinado) {
            //Dibujar caracteres adivinados
            dibujarCaracteresAdivinados(ingresado, palabra, jugadorActual);

            System.out.println("Has adivinado una letra");

            System.out.println("" + Arrays.toString(jugadorActual.getCaracteresAdivinados()));

            //comprobar que la palabra fue adivinado por completo
            comprobarPalabraAdivinada(jugadorActual, palabra);
        }

        if (!adivinado) {
            jugadorActual.setIntentosActuales(jugadorActual.getIntentosActuales() + 1);
            dibujoAhorcado.decretarFalla(jugadorActual.getIntentosActuales(), dibujoAhorcado);

            System.out.println("¡Has fallado, sigue intentando!");

            dibujoAhorcado.dibujarAhorca();
        }
    }

    private void comprobarPalabraAdivinada(JugadorAhorcado jugadorActual, Palabra palabra) {
        for (int i = 0; i < jugadorActual.getCaracteresAdivinados().length; i++) {
            if (jugadorActual.getCaracteresAdivinados()[i] == '0') {
                return;
            }
        }

        jugadorActual.setVecesAdivinado(jugadorActual.getVecesAdivinado() + 1);
        palabra.setAdivinado(true);
    }

    private void dibujarCaracteresAdivinados(char ingresado, Palabra palabra, JugadorAhorcado jugadorActual) {

        for (int i = 0; i < palabra.getCaracteres().length; i++) {
            if (palabra.getCaracteres()[i] == ingresado) {
                jugadorActual.getCaracteresAdivinados()[i] = palabra.getCaracteres()[i];
            }
        }
    }

    private boolean comprobarCaracter(char ingresado, Palabra palabra) {

        for (char c : palabra.getCaracteres()) {
            if (c == ingresado) {
                return true;
            }
        }

        return false;
    }

    private char getCharIngresado(Scanner INPUT) {
        String c = INPUT.nextLine();

        if (c.length() != 1) {
            System.out.println("Debe ingresar solo un carácter.");
            return getCharIngresado(INPUT);
        }

        char caracter = c.charAt(0);

        if (Character.isLetter(caracter)) {
            return caracter;
        }

        return getCharIngresado(INPUT);
    }

    private static int opcionAdivinar(Scanner INPUT) {
        System.out.println("Ingrese una opcion: ");

        int opcion = 1;
        try {
            opcion = Integer.parseInt(INPUT.nextLine());

            if (opcion == 1 || opcion == 2) {
                return opcion;
            } else {
                throw new Exception();
            }

        } catch (Exception ex) {
            System.out.println("¡Ingrese 1 o 2!");
            return opcionAdivinar(INPUT);
        }
    }

    private static String palabraSinCaracteresEspeciales(Scanner INPUT) {

        String s = INPUT.nextLine();

        if (s.isBlank()) {
            System.out.println("\nNo se permite cadena vacia!");
            return palabraSinCaracteresEspeciales(INPUT);
        }

        for (char c : s.toCharArray()) {
            // Verificar si el carácter no es una letra del alfabeto (mayúscula o minúscula)
            if (!Character.isLetter(c)) {
                System.out.println("Ingrese un valor que contenga solo letras de la {Aa-Zz}");
                return palabraSinCaracteresEspeciales(INPUT);
            }
        }

        return s;
    }

    private static int seleccionarJugador(Scanner INPUT, List<JugadorAhorcado> jugadoresAhorcados) {
        getAhorcado().mostrarDatosDeJugadores();

        System.out.print("Ingrese el id del jugador: ");
        int id = 1;

        try {
            id = Integer.parseInt(INPUT.nextLine());

            if (id < 0 || id > jugadoresAhorcados.size()) {
                return seleccionarJugador(INPUT, jugadoresAhorcados);
            }

        } catch (NumberFormatException ex) {
            System.out.println("\n¡Seleccione un jugador valido!");
        }
        return id;
    }

    private void crearJugadores() {
        int id = jugadoresAhorcado.size() + 1;
        JugadorAhorcado ja = crearJugador(INPUT, id);
        jugadoresAhorcado.add(ja);

        System.out.println(jugadoresAhorcado.size() + "¡Jugador agregado exitosamente!"
                + ja.toString());
    }

    private static JugadorAhorcado crearJugador(Scanner INPUT, int id) {
        System.out.print("\nIngrese su nombre: ");
        String nombre = INPUT.nextLine();
        JugadorAhorcado ja = new JugadorAhorcado(id);
        ja.setNombre(nombre);
        return ja;
    }

    private void mostrarDatosDeJugadores() {
        for (JugadorAhorcado jugadoresAhorcado1 : jugadoresAhorcado) {
            System.out.println(jugadoresAhorcado1.toString());
        }
    }

    private static Ahorcado ahorcado;
    private static Scanner INPUT;

    private int idJugadorActual;
    private JugadorAhorcado jugadorActual;
    private final List<JugadorAhorcado> jugadoresAhorcado;
}
